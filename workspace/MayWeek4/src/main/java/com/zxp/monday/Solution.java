package com.zxp.monday;

class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Solution {

    public Node reverseLinkedList(Node head){
        Node prev = null;
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
