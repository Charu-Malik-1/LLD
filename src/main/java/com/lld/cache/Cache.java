package com.lld.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private int id;
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public Cache(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public void put(User user) {
        if (capacity == 1) {
            Node node = new Node(user.id, user);
            if (map.containsKey(user.id))
                return;
            else {
                map.put(user.id, node);
                head = node;
                tail = node;
                capacity = 1;
            }
        }
        else if (map.containsKey(user.id)) {
            Node node = map.get(user.id);
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
            Node node = new Node(user.id, user);
            if (head == null) { // adding 1st element
                head = node;
                tail = node;
                //  capacity++;
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
                //   capacity++;
            }
            map.put(user.id, node);
        }
    }

    public User get(int id) {
        if (!map.containsKey(id)) {
            return null;
        } else { //get that node and put it at the head of the dll
            Node node = map.get(id);
            put(node.value);
            return node.value;
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
