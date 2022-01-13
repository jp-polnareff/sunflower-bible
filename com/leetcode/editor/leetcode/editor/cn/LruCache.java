package com.leetcode.editor.leetcode.editor.cn;//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1838 👎 0


import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {

//        Solution solution = new LruCache().new Solution();
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        System.out.println(lruCache);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache {

        class DListNode {
            private Integer key;
            private Integer value;
            private DListNode pre;
            private DListNode next;

            DListNode() {
            }

            DListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private DListNode head;
        private DListNode tail;
        private Map<Integer, DListNode> map;
        private int size;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DListNode();
            tail = new DListNode();
            map = new HashMap<>(capacity);

            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DListNode listNode = map.get(key);
            if (listNode == null) {
                return -1;
            }
            // 把listNode 移动到链表头节点
            removeNode(listNode);
            addHead(listNode);
            return listNode.value;
        }

        public void put(int key, int value) {
            // 1 key存在的情况
            DListNode listNode1 = map.get(key);
            if (listNode1 != null) {
                listNode1.value = value;
                map.put(key, listNode1);
                removeNode(listNode1);
                addHead(listNode1);
            } else {
                // 2 不存在的情况
                // 溢出了 移除tail前一个node
                if (size >= capacity) {
                    DListNode pre = tail.pre;
                    map.remove(pre.key);
                    removeNode(pre);
                    size--;
                }
                // 像map添加元素
                DListNode newListNode = new DListNode(key, value);
                map.put(key, newListNode);
                //
                addHead(newListNode);
                size++;
            }
        }

        private void removeNode(DListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addHead(DListNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}