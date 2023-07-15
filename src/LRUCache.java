import java.util.HashMap;

/**
 * LRUCache(Least Recently Used,最近最少使用)
 * 这个 LRUCache 缓存的Java实现主要通过 HashMap 和双向链表来完成,其原理和逻辑可以归纳为:
 *
 * HashMap存储键值对 - 提供快速查找
 * 利用 HashMap 的 O(1) 时间复杂度快速查找节点。 key 为键,value 为链表节点。
 *
 * 双向链表维护节点顺序 - 实现 LRUCache 顺序
 * 新访问的节点移到头部,尾节点是最久未使用的。
 *
 * get操作 - 访问则移动到头部
 * 如果 key 存在,找到节点移到头部并返回值。
 *
 * put操作 - 添加则移动到头部
 * 如果 key 存在,更新值并移到头部;如果不存在,在头部添加并检查容量。
 *
 * 容量满了删除尾节点 - 删除最久未使用
 * 尾节点是最久未使用的,删除它以维持容量。
 *
 * 数据移动通过链表操作 - 简化代码
 * 封装好的链表操作方法实现节点移除和插入。
 *
 * 总结:
 *
 * HashMap 提供快速查找
 *
 * 双向链表维护LRU顺序
 *
 * get/put 通过移到头部实现LRU
 *
 * 满了则删除尾节点(最久未使用)
 *
 * 这样既利用了 HashMap 的快查,也用链表实现了 LRUCache 淘汰机制。核心思路就是这两点。
 */
public class LRUCache {

    class  Node{
        String key;
        String val;
        Node prev;
        Node next;
    }
    //缓存容量
    private int capacity;

    private HashMap<String,Node> cache;

    private Node head;

    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public String get(String key){
        //如果存在key将key的值加到头部
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            removeFromList(node);
            addHeader(node);
            return  node.val;
        }
        return "-1";
    }

    public void put(String key ,String value){
        if (cache.containsKey(key)){
            Node node  = cache.get(key);
            node.val = value;
            removeFromList(node);
            addHeader(node);
        }else {
            if (cache.size()==capacity){
                System.out.printf(tail.prev.key+"被删除");
                cache.remove(tail.prev.key);
                removeFromList(tail.prev);
            }
            System.out.printf(key+"被创建");
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            cache.put(key,newNode);
            addHeader(newNode);
        }
    }

    public void removeFromList(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addHeader(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache  = new LRUCache(3);
        lruCache.put("hlf","1");
        lruCache.put("hlf","2");
        lruCache.put("hlf2","3");
        System.out.println("size"+lruCache.cache.size());
        lruCache.put("hlf3","3");
        System.out.println("size"+lruCache.cache.size());
        lruCache.put("hlf4","4");
        System.out.println("hlf"+lruCache.get("hlf"));
    }
}
