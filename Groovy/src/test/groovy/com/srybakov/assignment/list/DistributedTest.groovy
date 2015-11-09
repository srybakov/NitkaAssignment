package com.srybakov.assignment.list

import org.junit.Test

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
class DistributedTest extends GroovyTestCase {

    private static final int APPEARANCE = 3
    private static final boolean IS_DELETE_IN_ROW = false

    @Test
    public void testNullArray(){
        def message = shouldFail(IllegalArgumentException){
            ListUtils.removeDuplicates(null, APPEARANCE, IS_DELETE_IN_ROW)
        }
        assert message == "List cannot be null"
    }

    @Test
    public void testIllegalAppearance(){
        def message = shouldFail(IllegalArgumentException){
            ListUtils.removeDuplicates([], -100, IS_DELETE_IN_ROW)
        }
        assert message == "Appearance number should be positive integer greater than 0"
    }

    @Test
    public void testEmptyArray(){
        def result = ListUtils.removeDuplicates([], APPEARANCE, IS_DELETE_IN_ROW)
        assert 0 == result.size()
    }

    /**
     * Test case 1:  Source [1], Expected: [1]
     * Test case 2:  Source [1, 1, 1], Expected: []
     * Test case 3:  Source [1, 1, 1, 2], Expected: [2]
     * Test case 4:  Source [2, 1, 1, 1], Expected: [2]
     * Test case 5:  Source [1, 2, 1, 2, 1], Expected: [2, 2]
     * Test case 6:  Source [1, 2, 1, 2, 1, 2], Expected: []
     * Test case 7:  Source [3, 1, 1, 1, 2, 1], Expected: [3, 2]
     * Test case 8:  Source [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Test case 9:  Source [null, null, null], Expected: []
     * Test case 10:  Source [null, null, null, 1], Expected: [1]
     * Test case 11:  Source [1, null, null, null], Expected: [1]
     * Test case 12:  Source [1, null, null, null, 1], Expected: [1, 1]
     * Test case 13:  Source [1, null, 1, null, null, 1], Expected: []
     * Test case 14:  Source [1, null, 2, null, null, 1], Expected: [1, 2, 1]
     */

    @Test
    public void testCase1(){
        def result = ListUtils.removeDuplicates([1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1]
    }

    @Test
    public void testCase2(){
        def result = ListUtils.removeDuplicates([1, 1, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == []
    }

    @Test
    public void testCase3(){
        def result = ListUtils.removeDuplicates([1, 1, 1, 2],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [2]
    }

    @Test
    public void testCase4(){
        def result = ListUtils.removeDuplicates([2, 1, 1, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [2]
    }

    @Test
    public void testCase5(){
        def result = ListUtils.removeDuplicates([1, 2, 1, 2, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [2, 2]
    }

    @Test
    public void testCase6(){
        def result = ListUtils.removeDuplicates([1, 2, 1, 2, 1, 2],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == []
    }

    @Test
    public void testCase7(){
        def result = ListUtils.removeDuplicates([3, 1, 1, 1, 2, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [3, 2]
    }

    @Test
    public void testCase8(){
        def result = ListUtils.removeDuplicates([1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }


    @Test
    public void testCase9(){
        def result = ListUtils.removeDuplicates([null, null, null],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == []
    }

    @Test
    public void testCase10(){
        def result = ListUtils.removeDuplicates([null, null, null, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1]
    }

    @Test
    public void testCase11(){
        def result = ListUtils.removeDuplicates([1, null, null, null],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1]
    }

    @Test
    public void testCase12(){
        def result = ListUtils.removeDuplicates([1, null, null, null, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1, 1]
    }

    @Test
    public void testCase13(){
        def result = ListUtils.removeDuplicates([1, null, 1, null, null, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == []
    }


    @Test
    public void testCase14(){
        def result = ListUtils.removeDuplicates([1, null, 2, null, null, 1],
                APPEARANCE, IS_DELETE_IN_ROW)
        assert result == [1, 2, 1]
    }
}
