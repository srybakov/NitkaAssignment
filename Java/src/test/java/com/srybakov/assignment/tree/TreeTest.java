package com.srybakov.assignment.tree;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public class TreeTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testCase(){
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Null element is not supported");
        Tree<Integer> tree = new BTree<>();
        tree.add(null);
    }

    @Test
    public void testCase1(){
        Tree<Integer> tree = new BTree<>();
        Assert.assertEquals(0, tree.height(tree.getRoot()));
    }

    @Test
    public void testCase2(){
        Tree<Integer> tree = new BTree<>();
        tree.add(100);
        Assert.assertEquals(1, tree.height(tree.getRoot()));
    }

    /**
     * Tree:
     *              1000
     *              /
     *            900
     *           /
     *         800
     *         /
     *       700
     *       /
     *     600
     *     /
     *   500
     *
     * Height:6
     */
    @Test
    public void testCase3(){
        Tree<Integer> tree = new BTree<>();
        tree.add(1000);
        tree.add(900);
        tree.add(800);
        tree.add(700);
        tree.add(600);
        tree.add(500);
        Assert.assertEquals(6, tree.height(tree.getRoot()));
    }

    /**
     * Tree:
     *      100
     *        \
     *        200
     *          \
     *          300
     *            \
     *            400
     *              \
     *              500
     *
     * Height:5
     */
    @Test
    public void testCase4(){
        Tree<Integer> tree = new BTree<>();
        tree.add(100);
        tree.add(200);
        tree.add(300);
        tree.add(400);
        tree.add(500);
        Assert.assertEquals(5, tree.height(tree.getRoot()));
    }

    /**
     * Tree:
     *        500
     *        /  \
     *      100   1000
     *     /  \     / \
     *   50  400  900  1100
     *
     * Height:3
     */
    @Test
    public void testCase5(){
        Tree<Integer> tree = new BTree<>();
        tree.add(500);
        tree.add(100);
        tree.add(1000);
        tree.add(900);
        tree.add(1100);
        tree.add(50);
        tree.add(400);
        Assert.assertEquals(3, tree.height(tree.getRoot()));
    }


    /**
     * Tree:
     *        500
     *        /  \
     *      100   1000
     *     /  \     / \
     *   50  400  900  1100
     *                 /
     *               1050
     *               /
     *             1030
     *
     * Height:5
     */
    @Test
    public void testCase6(){
        Tree<Integer> tree = new BTree<>();
        tree.add(500);
        tree.add(100);
        tree.add(1000);
        tree.add(900);
        tree.add(1100);
        tree.add(50);
        tree.add(1050);
        tree.add(1030);
        Assert.assertEquals(5, tree.height(tree.getRoot()));
    }

    /**
     * Tree:
     *        500
     *        /  \
     *      100   1000   <----- height of this sub-tree
     *     /  \     / \
     *   50  400  900  1100
     *                 /
     *               1050
     *               /
     *             1030
     *
     * Height:4
     */
    @Test
    public void testCase7(){
        Tree<Integer> tree = new BTree<>();
        tree.add(500);
        tree.add(100);
        tree.add(1000);
        tree.add(900);
        tree.add(1100);
        tree.add(50);
        tree.add(1050);
        tree.add(1030);
        Assert.assertEquals(4, tree.height(tree.getRoot().getRight()));
    }

    /**
     * Tree:
     *                                    500
     *                                    /  \
     *                                  100   1000
     *                                 /  \     / \
     * Height of this sub-tree ----> 50  400  900  1100
     *                                             /
     *                                           1050
     *                                           /
     *                                         1030
     *
     * Height:1
     */
    @Test
    public void testCase8(){
        Tree<Integer> tree = new BTree<>();
        tree.add(500);
        tree.add(100);
        tree.add(1000);
        tree.add(900);
        tree.add(1100);
        tree.add(50);
        tree.add(1050);
        tree.add(1030);
        Assert.assertEquals(1, tree.height(tree.getRoot().getLeft().getLeft()));
    }

}
