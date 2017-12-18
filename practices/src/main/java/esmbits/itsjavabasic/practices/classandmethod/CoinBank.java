package esmbits.itsjavabasic.practices.classandmethod;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 貯金箱.
 */
public class CoinBank {

    // 貯金箱クラス(CoinBank)、そのテストクラス(CoinBankTest)を作る.
    // ・種類問わず全部で100枚まで入る

    // メソッド一覧
    // ・putCoins 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
    // ・pickCoins 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
    // ・countCoins 2種類作る.
    //   1.硬貨の種類を指定する版: その硬貨が何枚入っているかを返す.
    //   2.硬貨の種類を指定しない版: 全体で何枚入っているかを返す.
    // ・getAmount 貯金箱全体の総額を返す.
    // ・isExactMatch この貯金箱に入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致する場合にtrueを返す.

    /**
     * 硬貨
     */
    public enum Coin{
        One(1),
        Five(5),
        Ten(10),
        Fifty(50),
        Hundred(100),
        FiveHundred(500);

        /** 硬貨の価値 */
        private int value;

        /**
         * @param value 硬貨の価値
         */
        private Coin(int value) {
            this.value = value;
        }

        /**
         * 硬貨の価値を返す
         * @return 硬貨の価値
         */
        public int getValue() {
            return value;
        }
    }

    /** カウンター */
    private Map<Coin,Integer> counter = new HashMap<CoinBank.Coin, Integer>();

    /** 最大容量 */
    private final int CAPACITY = 100;

    /**
     * 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
     * @param coin 硬貨の種類
     * @param num 硬貨の枚数
     * @return 入った枚数
     */
    public int putCoins(Coin coin,int num) {

        //投入枚数
        int count = num;

        //入力チェック
        if(count < 0) throw new IllegalArgumentException("枚数は0以上でなければいけません。");

        //投入後枚数が最大容量を超える場合、投入枚数を調整
        if(CAPACITY < this.countCoins() + count) count = CAPACITY - this.countCoins();

        //枚数更新
        counter.put(coin, this.countCoins(coin) + count);

        //値返却
        return count;
    }

    /**
     * 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
     * @param coin 硬貨の種類
     * @param num 硬貨の枚数
     * @return 取り出した枚数
     */
    public int pickCoins(Coin coin,int num) {

        //取出枚数
        int count = num;

        //入力チェック
        if(count < 0) throw new IllegalArgumentException("枚数は0以上でなければいけません。");

        //取出後枚数が0枚未満になる場合、取出枚数を調整
        if(this.countCoins(coin) < count) count = this.countCoins(coin);

        //枚数更新
        counter.put(coin, this.countCoins(coin) - count);

        //値返却
        return count;
    }

    /**
     * 硬貨が何枚入っているかを返す.
     * @return 硬貨の枚数(種類問わず)
     */
    public int countCoins() {

        return
                //硬貨のストリーム作成
                Stream.of(Coin.values())
                    //硬貨毎の枚数に変換
                    .mapToInt(coin -> this.countCoins(coin))
                    //合計を返却
                    .sum();
    }

    /**
     * 硬貨が何枚入っているかを返す.
     * @param coin 硬貨の種類
     * @return 硬貨の枚数
     */
    public int countCoins(Coin coin) {return counter.getOrDefault(coin, 0);}

    /**
     * 硬貨の総額を返す.
     * @return 硬貨の総額(種類問わず)
     */
    public int getAmount() {

        return
                //硬貨のストリーム作成
                Stream.of(Coin.values())
                    //硬貨毎の総額に変換
                    .mapToInt(coin -> this.getAmount(coin))
                    //合計を返却
                    .sum();
    }

    /**
     * 硬貨の総額を返す.
     * @param coin 硬貨の種類
     * @return 硬貨の総額
     */
    private int getAmount(Coin coin) {return this.countCoins(coin) * coin.getValue();}

    /**
     * 硬貨枚数が指定した貯金箱と一致するかを検証する
     * @param coinBank 比較対象の貯金箱
     * @return 効果枚数が全て一致する場合{@code true}
     */
    public boolean isExactMatch(CoinBank coinBank) {
        return
                //硬貨のストリーム作成
                Stream.of(Coin.values())
                    //硬貨毎の総額に変換
                    .allMatch(coin -> this.isExactMatch(coinBank, coin));
    }

    /**
     * 硬貨枚数が指定した貯金箱と一致するかを検証する
     * @param coinBank 比較対象の貯金箱
     * @param coin 比較対象の硬貨種類
     * @return 効果枚数が一致する場合{@code true}
     */
    private boolean isExactMatch(CoinBank coinBank, Coin coin) {return this.countCoins(coin) == coinBank.countCoins(coin);}
}
