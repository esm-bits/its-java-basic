package esmbits.itsjavabasic.practices.brainteaser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TrainingTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_getMinimumDecomposableNumber() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("分解数は2以上でなければいけません。");

        int result;

        // 分解数2以上
        result = Training.getMinimumDecomposableNumber(5);
        assertThat(result, is(15));

        result = Training.getMinimumDecomposableNumber(4);
        assertThat(result, is(10));

        result = Training.getMinimumDecomposableNumber(3);
        assertThat(result, is(6));

        result = Training.getMinimumDecomposableNumber(2);
        assertThat(result, is(3));

        // 分解数2未満
        result = Training.getMinimumDecomposableNumber(1);
    }

    @Test
    public void test_isDecomposable() {

        boolean result;

        // 分解数0
        result = Training.isDecomposable(9, 0);
        assertFalse(result);

        // 分解不可
        result = Training.isDecomposable(9, 4);
        assertFalse(result);

        // 分解不可
        result = Training.isDecomposable(0, 2);
        assertFalse(result);

        // 分解可能
        result = Training.isDecomposable(9, 2);
        assertTrue(result);

        // 分解可能
        result = Training.isDecomposable(9, 3);
        assertTrue(result);
    }

    @Test
    public void test_getContinuousNaturalNumbersList() {

        List<Integer> result;

        // 分解数0
        result = Training.getContinuousNaturalNumbersList(9, 0);
        assertNull(result);

        // 分解不可
        result = Training.getContinuousNaturalNumbersList(9, 4);
        assertNull(result);

        // 分解不可
        result = Training.getContinuousNaturalNumbersList(0, 2);
        assertNull(result);

        // 分解可能
        result = Training.getContinuousNaturalNumbersList(9, 2);
        assertThat(result, is(Arrays.asList(new Integer[] { 4, 5 })));

        // 分解可能
        result = Training.getContinuousNaturalNumbersList(9, 3);
        assertThat(result, is(Arrays.asList(new Integer[] { 2, 3, 4 })));
    }

    @Test
    public void test_getContinuousNaturalNumbersSumOf() {
        Set<List<Integer>> result;

        // 対象数 0 ～ 10 で検証
        result = Training.getContinuousNaturalNumbersSumOf(0);
        assertThat(result.size(), is(0));

        result = Training.getContinuousNaturalNumbersSumOf(1);
        assertThat(result.size(), is(0));

        result = Training.getContinuousNaturalNumbersSumOf(2);
        assertThat(result.size(), is(0));

        result = Training.getContinuousNaturalNumbersSumOf(3);
        assertThat(result.size(), is(1));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 1, 2 })));

        result = Training.getContinuousNaturalNumbersSumOf(4);
        assertThat(result.size(), is(0));

        result = Training.getContinuousNaturalNumbersSumOf(5);
        assertThat(result.size(), is(1));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 2, 3 })));

        result = Training.getContinuousNaturalNumbersSumOf(6);
        assertThat(result.size(), is(1));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 1, 2, 3 })));

        result = Training.getContinuousNaturalNumbersSumOf(7);
        assertThat(result.size(), is(1));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 3, 4 })));

        result = Training.getContinuousNaturalNumbersSumOf(8);
        assertThat(result.size(), is(0));

        result = Training.getContinuousNaturalNumbersSumOf(9);
        assertThat(result.size(), is(2));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 4, 5 })));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 2, 3, 4 })));

        result = Training.getContinuousNaturalNumbersSumOf(10);
        assertThat(result.size(), is(1));
        assertTrue(result.contains(Arrays.asList(new Integer[] { 1, 2, 3, 4 })));
    }
}
