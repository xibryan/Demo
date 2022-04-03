package sample.algorithm.leetcode;

/*
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/
25. K 个一组翻转链表

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0, head);
        ListNode preNode = preHead;
        ListNode start = head;
        ListNode nextNode = head;

        int num = 1;
        while (nextNode != null) {
            nextNode = nextNode.next;
            num++;
            if (num > k) {
                reverseK(preNode, start, nextNode);
                preNode = start;
                start = nextNode;
                num = 1;
            }
        }

        return preHead.next;
    }

    private void reverseK(ListNode preNode, ListNode start, ListNode nextNode) {
        ListNode pre = start, cur = start.next;
        for (; cur != nextNode; ) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        preNode.next = pre;
        start.next = cur;
    }

    public class ListNode {
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
}
