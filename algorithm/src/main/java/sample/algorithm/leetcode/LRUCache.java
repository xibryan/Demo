package sample.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 实现 LRUCache 类：
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/lru-cache
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LRUCache {
    private Map<Integer, Node> keyMap = new HashMap<>();
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private int capacity = 0;

    private static class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
            this(0, 0);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = this.keyMap.get(key);
        if (node == null) {
            return -1;
        }

        if (node.prev != this.head) {
            this.remove(node);
            this.insertNodeAfter(node, this.head);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = this.keyMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            this.keyMap.put(key, node);
            this.insertNodeAfter(node, this.head);
            this.size++;
            if (this.size > this.capacity) {
                this.keyMap.remove(this.tail.prev.key);
                this.remove(this.tail.prev);
            }
        } else {
            node.value = value;
            if (node.prev != this.head) {
                this.remove(node);
                this.insertNodeAfter(node, this.head);
            }
        }
    }

    // 从链表中移除节点
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    // 在指定节点的后面增加一个节点
    private void insertNodeAfter(Node node, Node curPos) {
        node.prev = curPos;
        node.next = curPos.next;
        curPos.next.prev = node;
        curPos.next = node;
    }

    public void print() {
        Node cur = this.head.next;
        while (cur != this.tail) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
