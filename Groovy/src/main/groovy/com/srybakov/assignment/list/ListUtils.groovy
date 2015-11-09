package com.srybakov.assignment.list

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
class ListUtils {

    static removeDuplicates(list, appearance, isDeleteInRow){
        if (list == null){
            throw new IllegalArgumentException("List cannot be null")
        } else if (appearance < 1){
            throw new IllegalArgumentException("Appearance number should be positive integer greater than 0")
        } else if (list.size() == 0){
            return list
        }

        if (isDeleteInRow){
            removeDuplicatesInRow(list, appearance)
        } else {
            removeDuplicatesDistributed(list, appearance)
        }
    }

    private static removeDuplicatesInRow(list, appearance) {
        list = processSpecialCaseWithLastNulls(list, appearance)
        list.push(null)
        int numberOfShifted = shiftElements(list, appearance)
        list.pop()
        list.subList(0, list.size() - numberOfShifted)
    }

    private static removeDuplicatesDistributed(list, appearance){
        def appearanceMap = getAppearanceMap(list)
        removeDuplicatesExceedAppearance(list, appearanceMap, appearance)
    }

    //Just because we add 'null' as a last element of collection, we should process special case if
    //collection contains 'appearance' number of nulls at the end of collection
    private static processSpecialCaseWithLastNulls(list, appearance){
        int count = 0
        def listIterator = list.listIterator(list.size())
        while (listIterator.hasPrevious()){
            if (listIterator.previous() == null){
                count++
            } else {
                break
            }
        }
        if (count >= appearance){
            list.subList(0, list.size() - count)
        } else {
            list
        }
    }

    private static shiftElements(list, numberDuplicatesToRemove){
        def duplicate = 1
        int shift = 0
        def previous = list[0]
        list.eachWithIndex{ elem, index ->
            if (index == 0){
                return
            }
            if (Objects.equals(elem, previous)){
                duplicate++
            } else if (duplicate >= numberDuplicatesToRemove){
                shift += duplicate
                duplicate = 1
            } else {
                duplicate = 1
            }
            previous = elem
            if (shift > 0){
                list[index - shift] = elem
            }
        }
        shift
    }

    private static removeDuplicatesExceedAppearance(list, appearanceMap, appearance){
        list.findAll{
            appearanceMap.get(it) < appearance
        }
    }

    private static getAppearanceMap(list){
        def appearanceMap = [:]
        list.each { element ->
            def counter = appearanceMap.get(element)
            if (counter == null){
                appearanceMap[element] = 1
            } else {
                appearanceMap[element] = appearanceMap[element] + 1
            }
        }
        return appearanceMap
    }
}
