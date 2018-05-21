package esmbits.itsjavabasic.practices.classandmethod;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CoinBankTest {

    /*
     * putCoins のテスト
     */

    @Test
    public void test_putCoins_入った枚数が正しいこと() {

        // 貯金箱に硬貨を入れて検証
        CoinBank coinBank = new CoinBank();
        assertThat(coinBank.putCoins(CoinBank.Coin.ONE.getType(), 0), is(0));
        assertThat(coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 5), is(5));
        assertThat(coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10), is(10));
        assertThat(coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 15), is(15));
        assertThat(coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20), is(20));
        assertThat(coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 25), is(25));
    }

    @Test
    public void test_putCoins_貯金箱の硬貨枚数が最大枚数オーバー() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 貯金箱に硬貨を入れて検証
        CoinBank coinBank = new CoinBank();
        assertThat(coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 30), is(30));
        assertThat(coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 40), is(40));
        assertThat(coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 50), is(30));
        assertThat(out.toString(), is("貯金箱の硬貨枚数が100枚を超えました" + System.lineSeparator()));
    }


    /*
     * pickCoins のテスト
     */

    @Test
    public void test_pickCoins_取り出した枚数が正しいこと() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 貯金箱から硬貨を取り出して検証
        assertThat(coinBank.pickCoins(CoinBank.Coin.ONE.getType(), 0), is(0));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIVE.getType(), 5), is(5));
        assertThat(coinBank.pickCoins(CoinBank.Coin.TEN.getType(), 10), is(10));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIFITY.getType(), 5), is(5));
        assertThat(coinBank.pickCoins(CoinBank.Coin.HUNDRED.getType(), 10), is(10));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 25), is(25));
    }

    @Test
    public void test_pickCoins_貯金箱の該当硬貨が不足() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 貯金箱から硬貨を取り出して検証
        assertThat(coinBank.pickCoins(CoinBank.Coin.ONE.getType(), 11), is(10));
        assertThat(out.toString(), is("貯金箱の1円硬貨がなくなりました" + System.lineSeparator()));

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIVE.getType(), 15), is(10));
        assertThat(out.toString(), is("貯金箱の5円硬貨がなくなりました" + System.lineSeparator()));

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(coinBank.pickCoins(CoinBank.Coin.TEN.getType(), 20), is(10));
        assertThat(out.toString(), is("貯金箱の10円硬貨がなくなりました" + System.lineSeparator()));

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIFITY.getType(), 25), is(20));
        assertThat(out.toString(), is("貯金箱の50円硬貨がなくなりました" + System.lineSeparator()));

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(coinBank.pickCoins(CoinBank.Coin.HUNDRED.getType(), 30), is(20));
        assertThat(out.toString(), is("貯金箱の100円硬貨がなくなりました" + System.lineSeparator()));

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThat(coinBank.pickCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 40), is(30));
        assertThat(out.toString(), is("貯金箱の500円硬貨がなくなりました" + System.lineSeparator()));
    }

    @Test
    public void test_pickCoins_貯金箱が空() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 100);

        // 貯金箱から硬貨を取り出して検証
        assertThat(coinBank.pickCoins(CoinBank.Coin.TEN.getType(), 101), is(100));
        assertThat(out.toString(), is("貯金箱が空になりました" + System.lineSeparator()));
    }

    /*
     * countCoins（硬貨種類ごとの枚数）のテスト
     */

    @Test
    public void test_countCoins_硬貨種類ごとの枚数が正しいこと() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 貯金箱の硬貨種類ごとの枚数を取得し検証
        assertThat(coinBank.countCoins(CoinBank.Coin.ONE.getType()), is(10));
        assertThat(coinBank.countCoins(CoinBank.Coin.FIVE.getType()), is(10));
        assertThat(coinBank.countCoins(CoinBank.Coin.TEN.getType()), is(10));
        assertThat(coinBank.countCoins(CoinBank.Coin.FIFITY.getType()), is(20));
        assertThat(coinBank.countCoins(CoinBank.Coin.HUNDRED.getType()), is(20));
        assertThat(coinBank.countCoins(CoinBank.Coin.FIVE_HUNDRED.getType()), is(30));
    }

    /*
     * countCoins（総枚数） のテスト
     */

    @Test
    public void test_countCoins_総枚数が正しいこと() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 貯金箱の総枚数を取得し検証
        assertThat(coinBank.countCoins(), is(100));
    }

    /*
     * getAmount のテスト
     */

    @Test
    public void test_getAmount_総額が正しいこと() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 貯金箱の総額を取得し検証
        assertThat(coinBank.getAmount(), is(
                CoinBank.Coin.ONE.getType() * 10 +
                CoinBank.Coin.FIVE.getType() * 10 +
                CoinBank.Coin.TEN.getType() * 10 +
                CoinBank.Coin.FIFITY.getType() * 20 +
                CoinBank.Coin.HUNDRED.getType() * 20 +
                CoinBank.Coin.FIVE_HUNDRED.getType() * 30
                ));
    }

    /*
     * isExactMatch のテスト
     */

    @Test
    public void test_isExactMatch_貯金箱に入っている各々の硬貨の枚数と指定した貯金箱のそれが完全に一致する() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 新しい貯金箱を用意する
        CoinBank anotherCoinBank = new CoinBank();
        anotherCoinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        anotherCoinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        anotherCoinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);


        // 貯金箱に入っている各々の硬貨の枚数と指定した貯金箱のそれが完全に一致するか検証
        assertThat(coinBank.isExactMatch(anotherCoinBank), is(true));
    }

    @Test
    public void test_isExactMatch_貯金箱に入っている各々の硬貨の枚数と指定した貯金箱のそれが一致しない() {

        // 事前に貯金箱に硬貨を入れておく
        CoinBank coinBank = new CoinBank();
        coinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        coinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        coinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 30);

        // 新しい貯金箱を用意する
        CoinBank anotherCoinBank = new CoinBank();
        anotherCoinBank.putCoins(CoinBank.Coin.ONE.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.FIVE.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.TEN.getType(), 10);
        anotherCoinBank.putCoins(CoinBank.Coin.FIFITY.getType(), 20);
        anotherCoinBank.putCoins(CoinBank.Coin.HUNDRED.getType(), 20);
        anotherCoinBank.putCoins(CoinBank.Coin.FIVE_HUNDRED.getType(), 0);  // 不一致


        // 貯金箱に入っている各々の硬貨の枚数と指定した貯金箱のそれが完全に一致するか検証
        assertThat(coinBank.isExactMatch(anotherCoinBank), is(false));
    }

}
