package esmbits.itsjavabasic.practices.classandmethod.example;

import static esmbits.itsjavabasic.practices.classandmethod.example.Coin.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CoinBankTest {

    @Test
    public void test_インスタンス生成直後() {

        CoinBank bank = new CoinBank();

        // 1枚も入ってない
        assertThat(bank.countCoins(), is(0));
        assertThat(bank.countCoins(YEN1), is(0));
        assertThat(bank.countCoins(YEN5), is(0));
        assertThat(bank.countCoins(YEN10), is(0));
        assertThat(bank.countCoins(YEN50), is(0));
        assertThat(bank.countCoins(YEN100), is(0));
        assertThat(bank.countCoins(YEN500), is(0));

        // 0円である
        assertThat(bank.getAmount(), is(0));

        // 取り出せない
        assertThat(bank.pickCoins(YEN1, 1), is(0));
        assertThat(bank.pickCoins(YEN5, 1), is(0));
        assertThat(bank.pickCoins(YEN10, 1), is(0));
        assertThat(bank.pickCoins(YEN50, 1), is(0));
        assertThat(bank.pickCoins(YEN100, 1), is(0));
        assertThat(bank.pickCoins(YEN500, 1), is(0));

        // 0円である
        assertThat(bank.getAmount(), is(0));
    }

    @Test
    public void test_1円を10枚入れた後() {

        // 1円を10枚入れる
        CoinBank bank = new CoinBank();
        assertThat(bank.putCoins(YEN1, 10), is(10));
        assertThat(bank.putCoins(YEN5, 0), is(0));  // 入れるフリ
        assertThat(bank.putCoins(YEN5, -5), is(0));  // 入れるフリその2

        // 1円だけ10枚ある
        assertThat(bank.countCoins(), is(10));
        assertThat(bank.countCoins(YEN1), is(10));
        assertThat(bank.countCoins(YEN5), is(0));
        assertThat(bank.countCoins(YEN10), is(0));
        assertThat(bank.countCoins(YEN50), is(0));
        assertThat(bank.countCoins(YEN100), is(0));
        assertThat(bank.countCoins(YEN500), is(0));

        // 10円である
        assertThat(bank.getAmount(), is(10));

        // 1円だけ取り出せる
        assertThat(bank.pickCoins(YEN1, 1), is(1));
        assertThat(bank.pickCoins(YEN1, 0), is(0)); // 取り出すフリ
        assertThat(bank.pickCoins(YEN1, -10), is(0)); // 取り出すフリその2
        assertThat(bank.pickCoins(YEN5, 1), is(0));
        assertThat(bank.pickCoins(YEN10, 1), is(0));
        assertThat(bank.pickCoins(YEN50, 1), is(0));
        assertThat(bank.pickCoins(YEN100, 1), is(0));
        assertThat(bank.pickCoins(YEN500, 1), is(0));

        // 10-1=9円である
        assertThat(bank.getAmount(), is(9));
    }

    @Test
    public void test_全種類を15枚ずつ入れた後() {

        // 全種類を15枚ずつ入れる
        CoinBank bank = new CoinBank();
        assertThat(bank.putCoins(YEN1, 15), is(15));
        assertThat(bank.putCoins(YEN5, 15), is(15));
        assertThat(bank.putCoins(YEN10, 15), is(15));
        assertThat(bank.putCoins(YEN50, 15), is(15));
        assertThat(bank.putCoins(YEN100, 15), is(15));
        assertThat(bank.putCoins(YEN500, 15), is(15));

        // 全種類15枚ずつある
        assertThat(bank.countCoins(YEN1), is(15));
        assertThat(bank.countCoins(YEN5), is(15));
        assertThat(bank.countCoins(YEN10), is(15));
        assertThat(bank.countCoins(YEN50), is(15));
        assertThat(bank.countCoins(YEN100), is(15));
        assertThat(bank.countCoins(YEN500), is(15));
        assertThat(bank.countCoins(), is(90));

        // 9990円である
        assertThat(bank.getAmount(), is(1*15 + 5*15 + 10*15 + 50*15 + 100*15 + 500*15));

        // 全種類ともに10枚は取り出せる
        assertThat(bank.pickCoins(YEN1, 10), is(10));
        assertThat(bank.pickCoins(YEN5, 10), is(10));
        assertThat(bank.pickCoins(YEN10, 10), is(10));
        assertThat(bank.pickCoins(YEN50, 10), is(10));
        assertThat(bank.pickCoins(YEN100, 10), is(10));
        assertThat(bank.pickCoins(YEN500, 10), is(10));

        // 9990-6660=3330円である
        assertThat(bank.getAmount(), is(1*5 + 5*5 + 10*5 + 50*5 + 100*5 + 500*5));

        // 10円を6枚出そうとする → 5枚しか残ってないから5枚しか出てこない
        assertThat(bank.pickCoins(YEN10, 6), is(5));

        // 3330-50=3280円である
        assertThat(bank.getAmount(), is(1*5 + 5*5 + 10*0 + 50*5 + 100*5 + 500*5));
    }

    @Test
    public void test_上限枚数以上出し入れする() {

        CoinBank bank = new CoinBank();

        // 全種類上限以上の枚数を入れる
        assertThat(bank.putCoins(YEN1, 101), is(100));
        assertThat(bank.putCoins(YEN5, 101), is(0));
        assertThat(bank.putCoins(YEN10, 101), is(0));
        assertThat(bank.putCoins(YEN50, 101), is(0));
        assertThat(bank.putCoins(YEN100, 101), is(0));
        assertThat(bank.putCoins(YEN500, 101), is(0));

        // 1円だけ100枚ある
        assertThat(bank.countCoins(), is(100));
        assertThat(bank.countCoins(YEN1), is(100));
        assertThat(bank.countCoins(YEN5), is(0));
        assertThat(bank.countCoins(YEN10), is(0));
        assertThat(bank.countCoins(YEN50), is(0));
        assertThat(bank.countCoins(YEN100), is(0));
        assertThat(bank.countCoins(YEN500), is(0));

        // 100円である
        assertThat(bank.getAmount(), is(1*100 + 5*0 + 10*0 + 50*0 + 100*0 + 500*0));

        // 取り出す
        assertThat(bank.pickCoins(YEN1, 101), is(100));
        assertThat(bank.pickCoins(YEN5, 1), is(0));
        assertThat(bank.pickCoins(YEN10, 1), is(0));
        assertThat(bank.pickCoins(YEN50, 1), is(0));
        assertThat(bank.pickCoins(YEN100, 1), is(0));
        assertThat(bank.pickCoins(YEN500, 1), is(0));

        // 0円である
        assertThat(bank.getAmount(), is(0));
    }

    @Test
    public void test_中身が一致するか確認する() {

        // 空っぽどうし
        // 0,0,0,0,0,0 : 0,0,0,0,0,0
        CoinBank bank0 = new CoinBank();
        CoinBank bank1 = new CoinBank();
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,0,0,0,0,0 : 0,0,0,0,0,0
        bank0.putCoins(YEN1, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,0,0,0,0,0 : 1,0,0,0,0,0
        bank1.putCoins(YEN1, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,1,0,0,0,0 : 1,0,0,0,0,0
        bank0.putCoins(YEN5, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,1,0,0,0,0 : 1,1,0,0,0,0
        bank1.putCoins(YEN5, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,1,1,0,0,0 : 1,1,0,0,0,0
        bank0.putCoins(YEN10, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,1,1,0,0,0 : 1,1,1,0,0,0
        bank1.putCoins(YEN10, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,1,1,1,0,0 : 1,1,1,0,0,0
        bank0.putCoins(YEN50, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,1,1,1,0,0 : 1,1,1,1,0,0
        bank1.putCoins(YEN50, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,1,1,1,1,0 : 1,1,1,1,0,0
        bank0.putCoins(YEN100, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,1,1,1,1,0 : 1,1,1,1,1,0
        bank1.putCoins(YEN100, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));

        // 1,1,1,1,1,1 : 1,1,1,1,1,0
        bank0.putCoins(YEN500, 1);
        assertThat(bank0.isExactMatch(bank1), is(false));

        // 1,1,1,1,1,1 : 1,1,1,1,1,1
        bank1.putCoins(YEN500, 1);
        assertThat(bank0.isExactMatch(bank1), is(true));
    }
}
