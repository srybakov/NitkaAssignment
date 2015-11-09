package com.srybakov.assignment.tree;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public class Node<T extends Comparable<T>> {

    private T element;
    private Node<T> left;
    private Node<T> right;

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}
