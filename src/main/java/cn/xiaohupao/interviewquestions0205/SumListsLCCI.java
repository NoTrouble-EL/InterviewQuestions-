package cn.xiaohupao.interviewquestions0205;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/9/7 22:10
 */
public class SumListsLCCI {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int sum = 0;
        while(l1 != null || l2 != null || sum != 0){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            sum /= 10;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(6);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(2);
        l2.next = node3;
        node3.next = node4;

        ListNode res = addTwoNumbers(l1, l2);
    }
}
