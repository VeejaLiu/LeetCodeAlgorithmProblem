package com.veeja.leetCode;

/**
 * @Author veeja
 */
public class Q0002 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        printListNode(listNode);
    }

    private static void printListNode(ListNode listNode) {
        System.out.print(listNode.val);
        if (listNode.next != null) {
            printListNode(listNode.next);
        }
    }


}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int save = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 2  4  3
        // 5  6  4
        // 7  0  8
        ListNode listNode = new ListNode(0, null);
        ListNode result = listNode;
        // 进位，初始化为0
        sumThisTwoNumber(l1, l2, listNode);


        return result;
    }

    public void sumThisTwoNumber(ListNode l1, ListNode l2, ListNode listNode) {
        if (l1 == null && l2 == null && save == 0) {
            return;
        }
        int value1 = (l1 == null) ? 0 : l1.val;
        int value2 = (l2 == null) ? 0 : l2.val;
        int sums = value1 + value2 + save;

        int digits = sums % 10;
        save = sums / 10;
        listNode.val = digits;
        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || save != 0) {
            ListNode newListcode = new ListNode(0, null);
            listNode.next = newListcode;
            listNode = newListcode;
        }
        sumThisTwoNumber(l1 == null ? null : l1.next, l2 == null ? null : l2.next, listNode);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
