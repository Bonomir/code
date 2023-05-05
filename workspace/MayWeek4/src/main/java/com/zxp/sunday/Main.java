package com.zxp.sunday;

import java.util.LinkedList;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Main {
    public ListNode mergeKListsTest(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        // 将所有链表添加进堆中
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            cur.next = next;
            cur = next;
            // 将此链表的下一个节点开始的链表添加进堆中
            if (next.next != null) {
                minHeap.offer(next.next);
            }
        }

        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        ListNode head1 = mergeKLists(lists, start, mid);
        ListNode head2 = mergeKLists(lists, mid, end);
        return merge(head1,head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
