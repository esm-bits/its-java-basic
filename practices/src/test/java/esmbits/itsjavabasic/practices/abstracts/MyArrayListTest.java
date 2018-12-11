package esmbits.itsjavabasic.practices.abstracts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyArrayListTest {

    /**
     * Rule.
     */
    public ExpectedException thrown = ExpectedException.none();

    /**
     * add()のテスト.
     */
	@Test
	public void test_add_インデクスが配列要素より小さい() {
		//MyListを作成
	    MyList myList = new MyArrayList();
		myList.add("test1");
		myList.add("test2");
		myList.add("test3");
		myList.add("test4");

		//要素が５個入っているか確認
		assertThat(myList.size(), is(4));

		//３つ目の要素を取得
		 assertThat(myList.get(2), is("test3"));
	}

    /**
     * add()のテスト.
     */
    @Test
    public void test_add_インデクスが配列要素より大きい() {

        // MyListを作成
        MyList myList = new MyArrayList();
        myList.add("test1");
        myList.add("test2");
        myList.add("test3");
        myList.add("test4");
        myList.add("test5");
        myList.add("test6");

        assertThat(myList.size(), is(6));
        assertThat(myList.get(5), is("test6"));
    }

    /**
     * add()のテスト.
     */
    @Test
    public void test_add_配列に設定していない場合はエラーにする() {
        //MyListを作成
        MyList myList = new MyArrayList();
        myList.add("test1");

        //要素が５個入っているか確認
        assertThat(myList.size(), is(1));

        //３つ目の要素を取得
        try {
            myList.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {

        } catch (Exception e) {
            fail();
        }
    }

    /**
     * size()のテスト.
     */
    @Test
    public void test_size_サイズがゼロ() {
        //MyListを作成
        MyList myList = new MyArrayList();

        //要素が0個入っているか確認
        assertThat(myList.size(), is(0));
    }

    /**
     * TODO：get()のテスト
     */
    @Test
    public void test_get_リストの要素を取得できる() {
        // TODO 自動生成されたメソッド・スタブ
        MyList myList = new MyArrayList();

        myList.add("test01");
        myList.add("test02");
        myList.add("test03");
        myList.add("test04");

        assertThat(myList.get(0), is("test01"));
        assertThat(myList.get(1), is("test02"));
        assertThat(myList.get(2), is("test03"));
        assertThat(myList.get(3), is("test04"));

    }

    @Test
    public void test_get_要素ゼロ() {
        MyList myList = new MyArrayList();
        try {
            myList.get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test_get_要素がない番地を参照() {
        // TODO 自動生成されたメソッド・スタブ
        MyList myList = new MyArrayList();

        myList.add("test01");
        myList.add("test02");
        myList.add("test03");
        myList.add("test04");

        try {
            myList.get(4);
            fail();
        } catch (IndexOutOfBoundsException e) {

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test_get_引数がマイナス値の場合() {

        MyList myList = new MyArrayList();

        myList.add("test01");
        myList.add("test02");
        myList.add("test03");
        myList.add("test04");

        try {
            myList.get(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("引数の値がマイナス値です。"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test_remove_指定したインデックスの要素を削除() {

    	// TODO 引数の境界値確認（要素数が5個以下の場合、または6個以上の場合）
    	// TODO 引数の境界値確認（numberがマイナス値、または要素数より大きい値の場合）
    	// TODO リストのサイズが0のときに削除した場合、例外が発生すること
        MyList myList = new MyArrayList();

        myList.add("test01");
        myList.add("test02");
        myList.add("test03");
        myList.add("test04");
        myList.add("test05");
        myList.add("test06");
        myList.add("test07");

        assertThat(myList.size(), is(7));
        
        String removed = myList.remove(1);
        assertThat(removed, is("test02"));

        assertThat(myList.size(), is(6));
        assertThat(myList.get(0), is("test01"));
        assertThat(myList.get(1), is("test03"));
        assertThat(myList.get(2), is("test04"));
        assertThat(myList.get(3), is("test05"));
        assertThat(myList.get(4), is("test06"));
        assertThat(myList.get(5), is("test07"));
    }

}
