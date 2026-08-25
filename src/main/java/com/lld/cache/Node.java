package com.lld.cache;

public class Node {
    int id;
    User value;
    Node next;
    Node prev;

    public Node(int key, User value) {
        this.id = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
