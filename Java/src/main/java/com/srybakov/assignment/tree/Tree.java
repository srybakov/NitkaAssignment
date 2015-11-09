package com.srybakov.assignment.tree;

/**
 * @author Sergey Rybakov : mail-to sarybako@gmail.com
 */
public interface Tree<T extends Comparable<T>> {

    boolean add(T element);

    int height(Node<T> node);

    Node<T> getRoot();
}
