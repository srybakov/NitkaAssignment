package com.srybakov.assignment.list;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public class InRowTest {

    private static final int APPEARANCE = 3;
    private static final boolean IS_DELETE_IN_ROW = true;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testNullArray(){
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("List cannot be null");
        ListUtils.removeDuplicates(null, APPEARANCE, IS_DELETE_IN_ROW);
    }

    @Test
    public void testIllegalAppearance(){
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Appearance number should be positive integer greater than 0");
        ListUtils.removeDuplicates(new ArrayList<>(), -100, IS_DELETE_IN_ROW);
    }

    @Test
    public void testEmptyArray(){
        List<Integer> result = ListUtils.removeDuplicates(new ArrayList<>(), APPEARANCE, IS_DELETE_IN_ROW);
        Assert.assertEquals(0, result.size());
    }

    /**
     * Test case 1:  Source [1], Expected: [1]
     * Test case 2:  Source [1, 1, 1], Expected: []
     * Test case 3:  Source [1, 1, 1, 2], Expected: [2]
     * Test case 4:  Source [2, 1, 1, 1], Expected: [2]
     * Test case 5:  Source [1, 2, 2, 2, 1], Expected: [1, 1]
     * Test case 6:  Source [1, 2, 1, 2, 1, 2], Expected: []
     * Test case 7:  Source [3, 1, 1, 1, 2, 1], Expected: [3, 2, 1]
     * Test case 8:  Source [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Test case 9:  Source [null, null, null], Expected: []
     * Test case 10:  Source [null, null, null, 1], Expected: [1]
     * Test case 11:  Source [1, null, null, null], Expected: [1]
     * Test case 12:  Source [1, null, null, null, 1], Expected: [1, 1]
     * Test case 13:  Source [1, null, 1, null, null, 1], Expected: [1, null, 1, null, null, 1]
     * Test case 14:  Source [1, null, 2, null, null, null, 1, null, null], Expected: [1, null, 2, 1, null, null]
     */

    @Test
    public void testCase1(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1)));
    }

    @Test
    public void testCase2(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, 1, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList()));
    }

    @Test
    public void testCase3(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, 1, 1, 2),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(2)));
    }

    @Test
    public void testCase4(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(2, 1, 1, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(2)));
    }

    @Test
    public void testCase5(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, 2, 2, 2, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, 1)));
    }

    @Test
    public void testCase6(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, 2, 1, 2, 1, 2),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, 2, 1, 2, 1, 2)));
    }

    @Test
    public void testCase7(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(3, 1, 1, 1, 2, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(3, 2, 1)));
    }

    @Test
    public void testCase8(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }
    @Test
    public void testCase9(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(null, null, null),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList()));
    }

    @Test
    public void testCase10(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(null, null, null, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1)));
    }

    @Test
    public void testCase11(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, null, null, null),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1)));
    }

    @Test
    public void testCase12(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, null, null, null, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, 1)));
    }

    @Test
    public void testCase13(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, null, 1, null, null, 1),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, null, 1, null, null, 1)));
    }


    @Test
    public void testCase14(){
        List<Integer> result = ListUtils.removeDuplicates(TestUtils.asList(1, null, 2, null, null, null, 1, null, null),
                APPEARANCE, IS_DELETE_IN_ROW);

        assertThat(result, CoreMatchers.is(TestUtils.asList(1, null, 2, 1, null, null)));
    }
}
