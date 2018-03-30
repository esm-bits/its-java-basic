package esmbits.itsjavabasic.practices.classandmethod;

import static org.junit.Assert.*;

import org.junit.Test;


public class CoinBankTest {

    CoinBank coinThis = new CoinBank();
    CoinBank coinThat = new CoinBank();

    @Test
    public void test_putCoins() {
       /* 貯金箱１の操作 */
       // 100円玉を1枚入れる
       assertEquals(1, coinThis.putCoins("100",1));
       // 50円玉を2枚入れる
       assertEquals(2, coinThis.putCoins("50",2));
       // 50円玉を1枚取り出す
       assertEquals(1, coinThis.pickCoins("50",1));
       // 1円玉を100枚入れる  2枚入っているので、98枚しか入らない
       assertEquals(98, coinThis.putCoins("1",100));
       // 50円玉の枚数計算
       assertEquals(1, coinThis.countCoins("50"));
       // 全部の枚数計算
       assertEquals(100, coinThis.countCoins());
       // 全部の金額計算  100*1 + 50*1 + 1*98 = 248
       assertEquals(248, coinThis.getAmount());

       /* 貯金箱２の操作 */
       // 100円玉を1枚入れる
       assertEquals(1, coinThat.putCoins("100",1));
       // 50円玉を2枚入れる
       assertEquals(2, coinThat.putCoins("50",2));
       // 50円玉を1枚取り出す
       assertEquals(1, coinThat.pickCoins("50",1));
       // 1円玉を100枚入れる  2枚入っているので、98枚しか入らない
       assertEquals(98, coinThat.putCoins("1",100));
       // 500円玉を1枚入れる
       //assertEquals(0, coinThat.putCoins("500",1));
       // 50円玉の枚数計算
       assertEquals(1, coinThat.countCoins("50"));
       // 全部の枚数計算
       assertEquals(100, coinThat.countCoins());
       // 全部の金額計算  100*1 + 50*1 + 1*98 = 248
       assertEquals(248, coinThat.getAmount());

       /* 貯金箱１と貯金箱２の比較 */
       assertEquals(true, coinThis.isExactMatch(coinThat));

       /* 貯金箱１の操作 */
       // 1円玉を100枚取り出す
       assertEquals(98, coinThis.pickCoins("1",100));

       // 30円玉を10枚取り出す(エラーケース)
       assertEquals(-1, coinThis.pickCoins("30",10));

       // 30円玉を10枚入れる(エラーケース)
       assertEquals(-1, coinThat.putCoins("30",10));

       // 30円玉の枚数計算(エラーケース)
       assertEquals(-1, coinThat.countCoins("30"));

       /* 貯金箱１と貯金箱２の比較 */
       assertEquals(false, coinThis.isExactMatch(coinThat));
    }

}
