package com.lld.cache;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Node<k,v> {
    public k id;
    public v value;
    public Node next;
    public Node prev;

    public Node(k key, v value) {
        this.id = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
