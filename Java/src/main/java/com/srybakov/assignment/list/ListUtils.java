package com.srybakov.assignment.list;


import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public final class ListUtils {

    private ListUtils() {}

    public static List<Integer> removeDuplicates(List<Integer> list, int appearance, boolean isDeleteInRow){
        if (list == null){
            throw new IllegalArgumentException("List cannot be null");
        } else if (appearance < 1){
            throw new IllegalArgumentException("Appearance number should be positive integer greater than 0");
        } else if (list.isEmpty()){
            return list;
        }

        if (isDeleteInRow){
            return removeDuplicatesInRow(list, appearance);
        } else {
            return removeDuplicatesDistributed(list, appearance);
        }
    }

    private static List<Integer> removeDuplicatesInRow(List<Integer> list, int appearance) {
        list = processSpecialCaseWithLastNulls(list, appearance);
        list.add(null);
        int numberOfShifted = shiftElements(list, appearance);
        return list.subList(0, list.size() - numberOfShifted - 1);
    }

    private static List<Integer> removeDuplicatesDistributed(List<Integer> list, int appearance){
        Map<Integer, MutableInt> appearanceMap = getAppearanceMap(list);
        removeDuplicatesExceedAppearance(list, appearanceMap, appearance);
        return list;
    }

    //Just because we add 'null' as a last element of collection, we should process special case if
    //collection contains 'appearance' number of nulls at the end of collection
    private static List<Integer> processSpecialCaseWithLastNulls(List<Integer> list, int appearance){
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        int count = 0;
        while (listIterator.hasPrevious()){
            if (listIterator.previous() == null){
                count++;
            } else {
                break;
            }
        }
        if (count >= appearance){
            return list.subList(0, list.size() - count);
        } else {
            return list;
        }
    }

    private static int shiftElements(List<Integer> list, int numberDuplicatesToRemove){
        Integer duplicate = 1;
        int shift = 0;
        Integer previous = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer current = list.get(i);
            if (Objects.equals(current, previous)){
                duplicate++;
            } else if (duplicate >= numberDuplicatesToRemove){
                shift += duplicate;
                duplicate = 1;
            } else {
                duplicate = 1;
            }

            previous = current;
            if (shift > 0){
                list.set(i - shift, current);
            }
        }
        return shift;
    }

    private static void removeDuplicatesExceedAppearance(List<Integer> list, Map<Integer, MutableInt> appearanceMap,
                                                         int appearance){
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            Integer element = listIterator.next();
            if (appearanceMap.get(element).getValue() >= appearance){
                listIterator.remove();
            }
        }
    }

    private static Map<Integer, MutableInt> getAppearanceMap(List<Integer> list){
        Map<Integer, MutableInt> appearanceMap = new HashMap<>();
        for (Integer element : list){
            MutableInt mutableInt = appearanceMap.get(element);
            if (mutableInt == null){
                appearanceMap.put(element, new MutableInt());
            } else {
                mutableInt.increment();
            }
        }
        return appearanceMap;
    }

    private static class MutableInt {

        private int value = 1;

        public void increment(){
            this.value++;
        }

        public int getValue(){
            return value;
        }
    }
}