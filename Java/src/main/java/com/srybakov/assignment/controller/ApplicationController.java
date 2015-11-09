package com.srybakov.assignment.controller;

import com.srybakov.assignment.list.ListUtils;
import com.srybakov.assignment.tree.BTree;
import com.srybakov.assignment.tree.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
@Controller
public class ApplicationController {

    private static final String INDEX_PAGE = "index";
    private static final String COMMA = ",";
    private static final int DEFAULT_APPEARANCE = 3;

    @RequestMapping("/")
    public String welcome() {
        return INDEX_PAGE;
    }

    @RequestMapping(value = "/removeFromList", method = RequestMethod.GET)
    @ResponseBody
    public String removeElementsFromList(@RequestParam String array, @RequestParam String appearance,
                                         @RequestParam boolean isDeleteInRow) {
        try {
            int appearanceAsNumber = DEFAULT_APPEARANCE;
            if (appearance.length() != 0){
                appearanceAsNumber = Integer.parseInt(appearance);
            }
            List<Integer> converted = convertInput(array);
            return ListUtils.removeDuplicates(converted, appearanceAsNumber, isDeleteInRow).toString();
        } catch (NumberFormatException nfe){
            return "Invalid input";
        }
    }

    @RequestMapping(value = "/calculateTreeHeight", method = RequestMethod.GET)
    @ResponseBody
    public String calculateTreeHeight(@RequestParam String array) {
        try {
            List<Integer> converted = convertInput(array);
            Tree<Integer> tree = createTree(converted);
            return String.valueOf(tree.height(tree.getRoot()));
        } catch (NumberFormatException nfe){
            return "Invalid input";
        }
    }

    private Tree<Integer> createTree(List<Integer> source){
        Tree<Integer> tree = new BTree<>();
        for (Integer integer : source){
            tree.add(integer);
        }
        return tree;
    }

    private List<Integer> convertInput(String source){
        String[] splitted = source.split(COMMA);
        List<Integer> result = new ArrayList<>();
        for (String str : splitted){
            result.add(Integer.parseInt(str.trim()));
        }
        return result;
    }

}