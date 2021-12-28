package top.gongyanhui.algorithm;

import java.util.HashMap;

/**
 * 缓存淘汰算法--LRU算法
 * LRU（Least recently used，最近最少使用）
 * 算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。
 */
public class LRUCache<K, V> {

    private int currentCacheSize;   //当前内存的大小
    private int CacheCapcity;       //内存大小
    private HashMap<K, CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    /**
     * 构造方法
     * @param size 内存大小
     */
    public LRUCache(int size) {
        currentCacheSize = 0;
        this.CacheCapcity = size;
        caches = new HashMap<K, CacheNode>(size);
    }

    /**
     * 向缓存中添加数据
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        CacheNode node = caches.get(key);
        if (node == null) { //如果内存中没有这条数据
            if (caches.size() >= CacheCapcity) {    //内存已满 移除最后一条数据
                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = key;
        }

        node.value = value;
        moveToFirst(node);
        caches.put(key, node);
    }

    /**
     * 获取指定数据
     * @param key 指定数据的key
     * @return
     */
    public Object get(K key) {
        CacheNode node = caches.get(key);
        if (node == null) {
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    /**
     * 移除指定的数据
     * @param key 指定数据的key
     * @return
     */
    public Object remove(K key) {
        CacheNode node = caches.get(key);
        if (node == null) {
            //不存在这条数据
            return null;
        }

        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node == first) {
            first = node.next;
        }
        if (node == last) {
            last = node.pre;
        }
        return caches.remove(key);
    }

    /**
     * 清空当前缓存中的所有数据
     */
    public void clear() {
        first = null;
        last = null;
        caches.clear();
    }

    /**
     * 将内存中的某个节点移到最前面
     * @param node 内存中的指定节点
     */
    private void moveToFirst(CacheNode node) {
        if (first == null) {
            return;
        }
        //准备移动当前节点 操作下当前节点的前后节点的连接
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node == last) {
            last = last.pre;
        }
        //如果内存中就没有数据存在的话
        if (first == null || last == null) {
            first = last = node;
            return;
        }

        //解决完node的前后关联问题就可以移动node到最前面了
        node.next = first;
        first = node;
        first.pre = null;
    }

    /**
     * 移除最后一个最少使用的数据
     */
    private void removeLast() {
        if (last == null) {
            return;
        }
        last = last.pre;    //尾部指针往前移
        if (last == null) {
            //说明只有一条数据
            first = null;
        } else {
            last.next = null;   //移除最后一条数据
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while (node != null) {
            sb.append(String.format("%s,%s", node.key, node.value));
            node = node.next;
        }
        return sb.toString();
    }

    /**
     * 双向链表的节点
     */
    class CacheNode {
        CacheNode pre;
        CacheNode next;
        Object key;
        Object value;
        public CacheNode() {}
    }
}