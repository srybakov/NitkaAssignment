package com.srybakov.assignment.tree

import org.junit.Test

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
class TreeTest extends GroovyTestCase {
    
    @Test
    public void testCase(){
        def message = shouldFail(IllegalArgumentException){
            Tree<Integer> tree = new BTree<>()
            tree.add(null)
        }
        assert message == "Null element is not supported"
    }

    @Test
    public void testCase1(){
        Tree<Integer> tree = new BTree<>()
        assert 0 == tree.height(tree.getRoot())
    }

    @Test
    public void testCase2(){
        Tree<Integer> tree = new BTree<>()
        tree.add(100)
        assert 1 == tree.height(tree.getRoot())
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
        Tree<Integer> tree = new BTree<>()
        tree.add(1000)
        tree.add(900)
        tree.add(800)
        tree.add(700)
        tree.add(600)
        tree.add(500)
        assert 6 == tree.height(tree.getRoot())
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
        Tree<Integer> tree = new BTree<>()
        tree.add(100)
        tree.add(200)
        tree.add(300)
        tree.add(400)
        tree.add(500)
        assert 5 == tree.height(tree.getRoot())
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
        Tree<Integer> tree = new BTree<>()
        tree.add(500)
        tree.add(100)
        tree.add(1000)
        tree.add(900)
        tree.add(1100)
        tree.add(50)
        tree.add(400)
        assert 3 == tree.height(tree.getRoot())
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
        Tree<Integer> tree = new BTree<>()
        tree.add(500)
        tree.add(100)
        tree.add(1000)
        tree.add(900)
        tree.add(1100)
        tree.add(50)
        tree.add(1050)
        tree.add(1030)
        assert 5 == tree.height(tree.getRoot())
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
        assert 4 == tree.height(tree.getRoot().getRight())
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
        assert 1 == tree.height(tree.getRoot().getLeft().getLeft())
    }

}
