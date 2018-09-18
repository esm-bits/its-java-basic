package esmbits.itsjavabasic.practices.abstracts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.Test;

public class MyArrayListTest {

    /**
     * Rule.
     */
    public ExpectedException thrown = ExpectedException.none();

    /**
     * add()のテスト.
     */
	@Test
	public void test() {
		//MyListを作成
	    MyList myList = new MyArrayList();
		myList.add("test1");
		myList.add("test2");
		myList.add("test3");
		myList.add("test4");
		myList.add("test5");

		//要素が５個入っているか確認
		assertThat(myList.size(), is(5));

		//３つ目の要素を取得
		// assertThat(myList.get(2), is("test3"));
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
        thrown.expect(IndexOutOfBoundsException.class);
        myList.get(6);
    }

}
