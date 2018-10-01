package esmbits.itsjavabasic.practices.abstracts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Ignore;

import com.sun.tracing.dtrace.ArgsAttributes;
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

}
