package com.lld.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<k,v> {
    private int id;
    ConcurrentHashMap<k,Node<k,v>> map;
    int capacity;
    Node<k,v> head;
    Node<k,v> tail;
    private final ReentrantReadWriteLock lock;

    public Cache(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        map = new ConcurrentHashMap<>();
        head = null;
        tail = null;
        this.lock = new ReentrantReadWriteLock();
    }

    public void put(k key,v value) {
        lock.writeLock().lock();
        try{
        if (capacity == 1) {
            Node<k,v> node = new Node(key,value);
            if (map.containsKey(key))
                return;
            else {
                map.put(key, node);
                head = node;
                tail = node;
                capacity = 1;
            }
        }
        else if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node == head) {

            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = head;
                head.prev = node;
                head = node;
            }
        } else {
            Node<k,v> node = new Node<>(key, value);
            if (head == null) { // adding 1st element
                head = node;
                tail = node;
            } else if (capacity == map.size()) {
                // remove 1 element and add another element, when cache has reached its max capacity
                tail = tail.prev;
                Node temp = tail.next;
                map.remove(temp.id);
                tail.next = null;
                temp.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            } else { // add 1 element
                node.next = head;
                head.prev = node;
                head = node;
            }
            map.put(key, node);
        }}finally {
            lock.writeLock().unlock();
        }
    }

    public Node get(k id) {
        lock.writeLock().lock();
        try{
        if (!map.containsKey(id)) {
            return null;
        } else { //get that node and put it at the head of the dll
            Node<k,v> node = map.get(id);
            put(id,node.value);
            return node;
        }}finally {
            lock.writeLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return map.size();
        } finally {
            lock.readLock().unlock();
        }
    }
    public void print(){
        System.out.println("printing cache..");
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.id);
            temp=temp.next;
        }
    }
}
