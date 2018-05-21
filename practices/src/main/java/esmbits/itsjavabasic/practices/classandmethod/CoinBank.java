package esmbits.itsjavabasic.practices.classandmethod;

import java.util.HashMap;
import java.util.Map;

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


    /** 硬貨 */
    enum Coin {

        ONE("1円玉", 1),
        FIVE("5円玉", 5),
        TEN("10円玉", 10),
        FIFITY("50円玉", 50),
        HUNDRED("100円玉", 100),
        FIVE_HUNDRED("500円玉", 500);

        private String name;
        private int type;

        Coin(String name, int type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public int getType() {
            return type;
        }

    }

    /** 貯金箱 */
    private Map<Integer, Integer> coin = new HashMap<>();

    /** 貯金箱に入る最大枚数 */
    private static final int MAX_COUNT = 100;

    /**
     * コンストラクタ
     */
    public CoinBank() {

    }

    /**
     * 硬貨の種類と枚数を指定して入れる.入った枚数を返す.
     *
     * @param type 硬貨の種類
     * @param count 硬貨の枚数
     * @return count 入った枚数
     */
    public int putCoins(int type, int count) {

        // 貯金箱に入っている硬貨の総枚数を取得する
        int totalCount = countCoins();

        // 貯金箱に硬貨を入れる
        // （もし、貯金箱に入る最大枚数を超えてしまう場合は、入る分だけ入れる）
        if (totalCount + count > MAX_COUNT) {
            System.out.println("貯金箱の硬貨枚数が" + MAX_COUNT + "枚を超えました");
            count = MAX_COUNT - totalCount;
        }

        coin.put(type, count);
        return count;

    }


    /**
     * 硬貨の種類と枚数を指定して取り出す.取り出した枚数を返す.
     *
     * @param type 硬貨の種類
     * @param count 硬貨の枚数
     * @return count 取り出した枚数
     */
    public int pickCoins(Integer type, int count) {

        // 貯金箱に入っている硬貨の総枚数を取得する
        int totalCount = countCoins();

        // 貯金箱から硬貨を取り出す
        // （もし、貯金箱が空になってしまう場合は、取り出せる分だけ取り出す）
        if (totalCount - count < 0) {
            System.out.println("貯金箱が空になりました");
            count = totalCount;
        } else if (countCoins(type) - count < 0) {
            System.out.println("貯金箱の" + type + "円硬貨がなくなりました");
            count = countCoins(type);
        }

        coin.put(type, count);
        return count;
    }

    /**
     * 指定した種類の硬貨が貯金箱に何枚入っているかを返す.
     *
     * @param type 硬貨の種類
     * @return count 硬貨の枚数
     *
     */
    public int countCoins(Integer type) {
        return coin.get(type);
    }

    /**
     * 硬貨が貯金箱に全部で何枚入っているかを返す.
     *
     * @return count 硬貨の枚数
     *
     */
    public int countCoins() {
        int totalCount = 0;
        for (int value : coin.values()) {
            totalCount += value;
        }
        return totalCount;
    }

    /**
     * 貯金箱全体の総額を返す.
     *
     * @return amount 総額
     */
    public int getAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : coin.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    /**
     * この貯金箱に入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致する場合にtrueを返す.
     *
     * @return 一致している場合は true 不一致の場合は false
     */
    public boolean isExactMatch(CoinBank anotherCoinBank) {
        return coin.equals(anotherCoinBank.coin);
    }


}
