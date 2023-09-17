package Templates;

import java.util.HashMap;

class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

// 双向链表
class DoubleList {
    private Node head, tail; // 【虚拟的】头结点、尾结点
    private int size; // 链表元素的个数

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 向链表中添加一个结点（靠近尾部的结点是最近使用的）
    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    // 移除链表中的 node 结点
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 删除链表中的头结点
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity; // 最大容量

    // 将某个 key 提升为最近使用的
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node); // 先从链表中删除这个节点
        cache.addLast(node); // 再重新插入到队尾
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node); // 在 map 中添加映射
    }

    // 删除某个 key
    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    // 删除最近最久未使用的元素
    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        int key = node.key;
        map.remove(key);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }
}
