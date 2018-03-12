package esmbits.itsjavabasic.practices.classandmethod;

import static org.junit.Assert.*;

import org.junit.Rule;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import esmbits.itsjavabasic.practices.classandmethod.CoinBank.Coin;

public class CoinBankTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_putCoins() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("枚数は0以上でなければいけません。");

        CoinBank coinBank = new CoinBank();

        assertThat(coinBank.putCoins(Coin.One, 1),is(1));
        assertThat(coinBank.putCoins(Coin.Five, 5),is(5));
        assertThat(coinBank.putCoins(Coin.Ten, 10),is(10));
        assertThat(coinBank.putCoins(Coin.Fifty, 50),is(50));
        assertThat(coinBank.putCoins(Coin.Hundred, 100),is(34));
        assertThat(coinBank.putCoins(Coin.FiveHundred, 500),is(0));
        coinBank.putCoins(Coin.One, -1);
    }

    @Test
    public void test_pickCoins() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("枚数は0以上でなければいけません。");

        CoinBank coinBank = new CoinBank();

        assertThat(coinBank.pickCoins(Coin.One, 100),is(0));
        
        coinBank.putCoins(Coin.One, 1);
        coinBank.putCoins(Coin.Five, 5);
        coinBank.putCoins(Coin.Ten, 10);
        coinBank.putCoins(Coin.Fifty, 50);
        coinBank.putCoins(Coin.Hundred, 100);
        coinBank.putCoins(Coin.FiveHundred, 500);

        assertThat(coinBank.pickCoins(Coin.One, 0),is(0));
        assertThat(coinBank.pickCoins(Coin.Five, 5),is(5));
        assertThat(coinBank.pickCoins(Coin.Ten, 11),is(10));
        assertThat(coinBank.pickCoins(Coin.Fifty, 49),is(49));
        assertThat(coinBank.pickCoins(Coin.Hundred, 34),is(34));
        assertThat(coinBank.pickCoins(Coin.FiveHundred, 500),is(0));
        coinBank.pickCoins(Coin.Five, -1);
    }

    @Test
    public void test_countCoins() {

        thrown = ExpectedException.none();

        CoinBank coinBank = new CoinBank();

        assertThat(coinBank.countCoins(),is(0));
        coinBank.putCoins(Coin.One, 1);
        assertThat(coinBank.countCoins(),is(1));
        coinBank.putCoins(Coin.Five, 5);
        assertThat(coinBank.countCoins(),is(6));
        coinBank.putCoins(Coin.Ten, 10);
        assertThat(coinBank.countCoins(),is(16));
        coinBank.putCoins(Coin.Fifty, 50);
        assertThat(coinBank.countCoins(),is(66));
        coinBank.putCoins(Coin.Hundred, 100);
        assertThat(coinBank.countCoins(),is(100));
        coinBank.putCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.countCoins(),is(100));
        coinBank.pickCoins(Coin.One, 0);
        assertThat(coinBank.countCoins(),is(100));
        coinBank.pickCoins(Coin.Five, 5);
        assertThat(coinBank.countCoins(),is(95));
        coinBank.pickCoins(Coin.Ten, 11);
        assertThat(coinBank.countCoins(),is(85));
        coinBank.pickCoins(Coin.Fifty, 49);
        assertThat(coinBank.countCoins(),is(36));
        coinBank.pickCoins(Coin.Hundred, 34);
        assertThat(coinBank.countCoins(),is(2));
        coinBank.pickCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.countCoins(),is(2));
    }

    @Test
    public void test_countTheCoins() {

        thrown = ExpectedException.none();

        CoinBank coinBank = new CoinBank();

        assertThat(coinBank.countCoins(Coin.One),is(0));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(0));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.One, 1);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(0));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.Five, 5);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(0));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.Ten, 10);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(0));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.Fifty, 50);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.Hundred, 100);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.putCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.One, 0);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(5));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.Five, 5);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(10));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.Ten, 11);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(50));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.Fifty, 49);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(1));
        assertThat(coinBank.countCoins(Coin.Hundred),is(34));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.Hundred, 34);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(1));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
        coinBank.pickCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.countCoins(Coin.One),is(1));
        assertThat(coinBank.countCoins(Coin.Five),is(0));
        assertThat(coinBank.countCoins(Coin.Ten),is(0));
        assertThat(coinBank.countCoins(Coin.Fifty),is(1));
        assertThat(coinBank.countCoins(Coin.Hundred),is(0));
        assertThat(coinBank.countCoins(Coin.FiveHundred),is(0));
    }

    @Test
    public void test_getAmount() {

        thrown = ExpectedException.none();

        CoinBank coinBank = new CoinBank();

        assertThat(coinBank.getAmount(),is(0));
        coinBank.putCoins(Coin.One, 1);
        assertThat(coinBank.getAmount(),is(1));
        coinBank.putCoins(Coin.Five, 5);
        assertThat(coinBank.getAmount(),is(26));
        coinBank.putCoins(Coin.Ten, 10);
        assertThat(coinBank.getAmount(),is(126));
        coinBank.putCoins(Coin.Fifty, 50);
        assertThat(coinBank.getAmount(),is(2626));
        coinBank.putCoins(Coin.Hundred, 100);
        assertThat(coinBank.getAmount(),is(6026));
        coinBank.putCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.getAmount(),is(6026));
        coinBank.pickCoins(Coin.One, 0);
        assertThat(coinBank.getAmount(),is(6026));
        coinBank.pickCoins(Coin.Five, 5);
        assertThat(coinBank.getAmount(),is(6001));
        coinBank.pickCoins(Coin.Ten, 11);
        assertThat(coinBank.getAmount(),is(5901));
        coinBank.pickCoins(Coin.Fifty, 49);
        assertThat(coinBank.getAmount(),is(3451));
        coinBank.pickCoins(Coin.Hundred, 34);
        assertThat(coinBank.getAmount(),is(51));
        coinBank.pickCoins(Coin.FiveHundred, 500);
        assertThat(coinBank.getAmount(),is(51));
    }

    @Test
    public void test_isExactMatch() {

        thrown = ExpectedException.none();

        CoinBank coinBank1 = new CoinBank();
        CoinBank coinBank2 = new CoinBank();

        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.One, 1);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.putCoins(Coin.One, 1);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.Five, 5);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.putCoins(Coin.Five, 5);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.Ten, 10);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.putCoins(Coin.Ten, 10);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.Fifty, 50);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.putCoins(Coin.Fifty, 50);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.Hundred, 100);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.putCoins(Coin.Hundred, 100);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.putCoins(Coin.FiveHundred, 500);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank2.putCoins(Coin.FiveHundred, 500);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.One, 0);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank2.pickCoins(Coin.One, 0);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.Five, 5);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.pickCoins(Coin.Five, 5);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.Ten, 11);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.pickCoins(Coin.Ten, 11);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.Fifty, 49);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.pickCoins(Coin.Fifty, 49);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.Hundred, 34);
        assertThat(coinBank1.isExactMatch(coinBank2),is(false));
        assertThat(coinBank2.isExactMatch(coinBank1),is(false));
        coinBank2.pickCoins(Coin.Hundred, 34);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank1.pickCoins(Coin.FiveHundred, 500);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
        coinBank2.pickCoins(Coin.FiveHundred, 500);
        assertThat(coinBank1.isExactMatch(coinBank2),is(true));
        assertThat(coinBank2.isExactMatch(coinBank1),is(true));
    }
}
