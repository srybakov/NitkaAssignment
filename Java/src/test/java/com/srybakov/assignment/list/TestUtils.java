package com.srybakov.assignment.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public final class TestUtils {

    private TestUtils(){}

    public static List<Integer> asList(Integer... elements){
        return new ArrayList<>(Arrays.asList(elements));
    }
}
