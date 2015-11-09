package com.srybakov.assignment.tree;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public class BTree <T extends Comparable<T>> implements Tree<T> {
    
    private Node<T> root;

    @Override
    public int height(Node<T> node) {
        int heightLeft = 0;
        int heightRight = 0;
        if (node == null){
            return 0;
        }
        if (node.getLeft() != null){
            heightLeft = height(node.getLeft());
        }
        if (node.getRight() != null){
            heightRight = height(node.getRight());
        }
        return max(heightLeft, heightRight) + 1;
    }

    @Override
    public boolean add(T element){
        if (element == null){
            throw new IllegalArgumentException("Null element is not supported");
        }
        Node<T> tmp = root;
        Node<T> current = null;
        while (tmp != null) {
            int cmpResult = element.compareTo(tmp.getElement());
            if (cmpResult == 0) {
                //Simplify our logic. Do not reflect in case if element already exists
                return false;
            } else {
                current = tmp;
                if (cmpResult < 0) {
                    tmp = tmp.getLeft();
                } else {
                    tmp = tmp.getRight();
                }
            }
        }
        Node<T> newNode = new Node<>(element);
        if (current == null) {
            root = newNode;
        } else {
            if (element.compareTo(current.getElement()) < 0) {
                current.setLeft(newNode);
            } else {
                current.setRight(newNode);
            }
        }
        return true;
    }

    public Node<T> getRoot() {
        return root;
    }

    private static int max(int a, int b){
        if (a == b){
            return a;
        } else if (a > b){
            return a;
        } else {
            return b;
        }
    }

}