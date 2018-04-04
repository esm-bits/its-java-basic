package esmbits.itsjavabasic.practices.brainteaser;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Training {

    // 和が value となるような連続する 2 つ以上の正の整数の組み合わせを出力する.
    // (例) value が 9 の場合は 2+3+4 と 4+5 の二通りがある.

    /**
     * 対象の分解数で分解可能な最小値を返す.
     *
     * @param decomposeNum 分解数
     * @return 対象の分解数で分解可能な最小値
     */
    public static int getMinimumDecomposableNumber(int decomposeNum) {

        // 分解不可の場合は例外
        if (decomposeNum < 2) throw new IllegalArgumentException("分解数は2以上でなければいけません。");

        // 1から分解数までの和が最小値
        return IntStream.rangeClosed(1, decomposeNum).sum();
    }

    /**
     * 連続する2つ以上の正の整数に分解可能かどうかを返す.
     *
     * @param value 検証する数
     * @param decomposeNum 分解数
     * @return 分解可能な場合 true
     */
    public static boolean isDecomposable(int value, int decomposeNum) {

        // 分解数が正しい → 分解数が2以上
        if (decomposeNum < 2) { return false; }

        // 分解可能最小値
        int minimumDecomposableNumber = getMinimumDecomposableNumber(decomposeNum);

        // 対象数が分解数で分解可能
        // → 分解可能最小値以上 かつ 対象数と分解数の剰余が分解可能最小値と分解数との剰余と一致
        return value >= minimumDecomposableNumber
                && value % decomposeNum == minimumDecomposableNumber % decomposeNum;
    }

    /**
     * 対象の分解数で分解した数のリストを返す.
     *
     * @param value 分解する数
     * @param decomposeNum 分解数
     * @return 分解した数のリスト
     */
    public static List<Integer> getContinuousNaturalNumbersList(int value, int decomposeNum) {

        // 入力チェック
        if (!isDecomposable(value, decomposeNum)) return null;

        // 計算用
        BigDecimal dValue = new BigDecimal(value);
        BigDecimal dDecomposeNum = new BigDecimal(decomposeNum);
        BigDecimal dOne = new BigDecimal(1);
        BigDecimal dTwo = new BigDecimal(2);

        // 最小の整数と最大の整数から数列を作成
        return IntStream.rangeClosed(
                dValue.divide(dDecomposeNum).subtract(dDecomposeNum.subtract(dOne).divide(dTwo)).toBigInteger()
                        .intValueExact(),
                dValue.divide(dDecomposeNum).add(dDecomposeNum.subtract(dOne).divide(dTwo)).toBigInteger()
                        .intValueExact())
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 連続する2つ以上の正の整数で分解した数のセットを返す.
     *
     * @param value 分解する数
     * @return 分解された数のセット
     */
    public static Set<List<Integer>> getContinuousNaturalNumbersSumOf(int value) {

        // 最大分解数を導出
        int checkNum = 2;
        for (int i = 2; getMinimumDecomposableNumber(i) <= value; i++) {
            checkNum = i;
        }

        // 各分解数で分解可能なものを計算
        return IntStream.rangeClosed(2, checkNum)
                .mapToObj(i -> getContinuousNaturalNumbersList(value, i))
                .filter(o -> o != null)
                .collect(Collectors.toSet());
    }
}
