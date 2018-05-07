package esmbits.itsjavabasic.practices.classandmethod.example;

import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN1;
import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN10;
import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN100;
import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN5;
import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN50;
import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.YEN500;

import java.util.HashMap;
import java.util.Map;

/**
 * 貯金箱.
 */
public class CoinBank {

    /**
     * 現時点の硬貨の枚数を保持するコンテナー.
     * 
     * キーに硬貨の種類を、値にその枚数を保持する
     */
    private Map<Coin, Integer> coins = null;

    /** 入れられる硬貨の上限枚数. */
    private static final int LIMIT = 100;

    /**
     * コンストラクター.
     */
    public CoinBank() {
        this.coins = new HashMap<>();
        for (Coin coin : Coin.values()) {
            this.coins.put(coin, 0);
        }
    }

    /**
     * 硬貨を入れる.
     * @param coin 入れる硬貨
     * @param number 枚数
     * @return 入った枚数
     */
    public int putCoins(Coin coin, int number) {
        if (number <= 0) return 0;
        int current = countCoins();
        int result = 0;
        if (current >= LIMIT) {
            // 上限まで入っている
            result = 0;
        } else {
            if (current + number >= LIMIT) {
                // 今回で上限に到達する
                result = LIMIT - current;
            } else {
                // まだ上限に到達しない
                result = number;
            }

            // 硬貨の枚数を更新
            int _number = this.coins.get(coin);
            _number += result;
            this.coins.put(coin, _number);
        }
        return result;
    }

    /**
     * 硬貨を取り出す.
     * @param coin 取り出す硬貨
     * @param number 枚数
     * @return 取り出した枚数
     */
    public int pickCoins(Coin coin, int number) {
        if (number <= 0) return 0;
        int current = countCoins(coin);
        int result = 0;
        if (current >= number) {
            // 指定した枚数以上に入っている
            result = number;
        } else {
            // 指定した枚数が入っていない
            result = current;
        }

        // 硬貨の枚数を更新
        int _number = this.coins.get(coin);
        _number -= result;
        this.coins.put(coin, _number);

        return result;
    }

    /**
     * 指定した硬貨の入っている枚数を返す.
     * @param coin 硬貨
     * @return 硬貨の枚数
     */
    public int countCoins(Coin coin) {
        return this.coins.get(coin);
    }

    /**
     * 入っている硬貨全体の枚数を返す.
     * @return 硬貨の枚数
     */
    public int countCoins() {
        /*
        return this.coins.values().stream()
            .reduce((f, s) -> f + s)
            .orElse(0);
        */
        return
            countCoins(YEN1) +
            countCoins(YEN5) +
            countCoins(YEN10) +
            countCoins(YEN50) +
            countCoins(YEN100) +
            countCoins(YEN500);
    }

    /**
     * 入っている総額を返す.
     * @return 総額
     */
    public int getAmount() {
        /*
        return Arrays.stream(Coin.values())
            .mapToInt(c -> c.getAmount() * countCoins(c))
            .sum();
        */
        int total = 0;
        for (Coin coin : Coin.values()) {
            total += coin.getAmount() * countCoins(coin);
        }
        return total;
    }

    /**
     * 入っている各々の硬貨の枚数と、指定した貯金箱のそれが完全に一致するかを返す.
     * @param other 貯金箱
     * @return 完全に一致する場合は{@code true}、そうでない場合は{@code false}
     */
    public boolean isExactMatch(CoinBank other) {
        /*
        return Arrays.stream(Coin.values())
            .allMatch(c ->  countCoins(c) == other.countCoins(c));
        */
        return
            countCoins(YEN1) == other.countCoins(YEN1) &&
            countCoins(YEN5) == other.countCoins(YEN5) &&
            countCoins(YEN10) == other.countCoins(YEN10) &&
            countCoins(YEN50) == other.countCoins(YEN50) &&
            countCoins(YEN100) == other.countCoins(YEN100) &&
            countCoins(YEN500) == other.countCoins(YEN500);
    }
}

/**
 * 硬貨の種類を表す列挙型.
 */
enum Coin {
    /** 1円硬貨. */
    YEN1(1),
    /** 5円硬貨. */
    YEN5(5),
    /** 10円硬貨. */
    YEN10(10),
    /** 50円硬貨. */
    YEN50(50),
    /** 100円硬貨. */
    YEN100(100),
    /** 500円硬貨. */
    YEN500(500);

    /** 金額. */
    private int amount;

    /**
     * コンストラクター.
     * @param amount 金額
     */
    private Coin(int amount) {
        this.amount = amount;
    }

    /**
     * 金額を返す.
     * @return 金額
     */
    public int getAmount() {
        return this.amount;
    }
}
