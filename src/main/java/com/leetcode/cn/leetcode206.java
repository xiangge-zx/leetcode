package com.leetcode.cn;

import java.util.Arrays;
import java.util.List;

public class leetcode206 {
    public static void main(String[] args) {
        leetcode206 leetcode206 = new leetcode206();
        ListNode node = leetcode206.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode res = leetcode206.reverseList(node);
        leetcode206.printList(res);

    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 创建链表
    public ListNode createLinkedList(List<Integer> list){
        ListNode headNode = new ListNode(list.get(0));
        ListNode tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.setListNode(tempNode);
        return headNode;
    }

    // 打印链表
    public void printList(ListNode node){
        while (node != null){
            System.out.print(node.getVal());
            System.out.print(" ");
            node = node.getNext();
        }
        System.out.println();
    }

}

