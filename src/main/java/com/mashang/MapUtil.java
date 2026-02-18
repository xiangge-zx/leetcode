package com.mashang;

import java.util.*;

/**
 * Map工具类 - 用于创建有序的Map
 * 使用Java现有的TreeMap、LinkedHashMap等类实现
 */
public class MapUtil {

    /**
     * 创建一个按Key自然顺序排序的TreeMap
     * Key必须实现Comparable接口
     * 
     * @param <K> Key类型，必须实现Comparable接口
     * @param <V> Value类型
     * @return 一个新的TreeMap实例
     */
    public static <K extends Comparable<K>, V> TreeMap<K, V> createSortedMap() {
        return new TreeMap<>();
    }

    /**
     * 创建一个按Key自然顺序排序的TreeMap，并初始化数据
     * 
     * @param entries 键值对数组，格式：key1, value1, key2, value2, ...
     * @param <K> Key类型，必须实现Comparable接口
     * @param <V> Value类型
     * @return 包含初始数据的TreeMap
     */
    @SuppressWarnings("unchecked")
    public static <K extends Comparable<K>, V> TreeMap<K, V> createSortedMap(Object... entries) {
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("参数数量必须是偶数（键值对）");
        }
        TreeMap<K, V> map = new TreeMap<>();
        for (int i = 0; i < entries.length; i += 2) {
            map.put((K) entries[i], (V) entries[i + 1]);
        }
        return map;
    }

    /**
     * 创建一个按Key自定义排序的TreeMap
     * 
     * @param comparator Key的比较器
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 一个新的TreeMap实例
     */
    public static <K, V> TreeMap<K, V> createSortedMap(Comparator<K> comparator) {
        return new TreeMap<>(comparator);
    }

    /**
     * 创建一个按Key倒序排序的TreeMap
     * 
     * @param <K> Key类型，必须实现Comparable接口
     * @param <V> Value类型
     * @return 一个新的TreeMap实例（Key倒序）
     */
    public static <K extends Comparable<K>, V> TreeMap<K, V> createDescendingMap() {
        return new TreeMap<>(Collections.reverseOrder());
    }

    /**
     * 将现有的Map转换为按Key排序的TreeMap
     * 
     * @param map 原始Map
     * @param <K> Key类型，必须实现Comparable接口
     * @param <V> Value类型
     * @return 新的TreeMap，包含原Map的所有数据并按Key排序
     */
    public static <K extends Comparable<K>, V> TreeMap<K, V> toSortedMap(Map<K, V> map) {
        return new TreeMap<>(map);
    }

    /**
     * 将现有的Map转换为按Key自定义排序的TreeMap
     * 
     * @param map 原始Map
     * @param comparator Key的比较器
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 新的TreeMap，包含原Map的所有数据并按指定规则排序
     */
    public static <K, V> TreeMap<K, V> toSortedMap(Map<K, V> map, Comparator<K> comparator) {
        TreeMap<K, V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        return sortedMap;
    }

    /**
     * 创建一个保持插入顺序的LinkedHashMap
     * 
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 一个新的LinkedHashMap实例
     */
    public static <K, V> LinkedHashMap<K, V> createInsertionOrderMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 创建一个按访问顺序排序的LinkedHashMap（LRU缓存）
     * 
     * @param initialCapacity 初始容量
     * @param loadFactor 负载因子
     * @param accessOrder true表示按访问顺序排序，false表示按插入顺序排序
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 一个新的LinkedHashMap实例
     */
    public static <K, V> LinkedHashMap<K, V> createAccessOrderMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        return new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * 创建一个按访问顺序排序的LinkedHashMap（LRU缓存），默认参数
     * 
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 一个新的LinkedHashMap实例（按访问顺序）
     */
    public static <K, V> LinkedHashMap<K, V> createLRUMap() {
        return new LinkedHashMap<>(16, 0.75f, true);
    }

    /**
     * 打印Map内容（按Key顺序）
     * 
     * @param map 要打印的Map
     * @param <K> Key类型
     * @param <V> Value类型
     */
    public static <K, V> void printMap(Map<K, V> map) {
        System.out.println("Map内容：");
        map.forEach((key, value) -> System.out.print("[" + key + "=" + value + "] "));
        System.out.println();
    }

    /**
     * 打印Map内容（按Key顺序），带标题
     * 
     * @param title 标题
     * @param map 要打印的Map
     * @param <K> Key类型
     * @param <V> Value类型
     */
    public static <K, V> void printMap(String title, Map<K, V> map) {
        System.out.println(title + "：");
        map.forEach((key, value) -> System.out.print("[" + key + "=" + value + "] "));
        System.out.println();
    }

    /**
     * 获取Map的所有Key（按顺序）
     * 
     * @param map 源Map
     * @param <K> Key类型
     * @return Key的List（保持Map的顺序）
     */
    public static <K> List<K> getKeys(Map<K, ?> map) {
        return new ArrayList<>(map.keySet());
    }

    /**
     * 获取Map的所有Value（按Key顺序）
     * 
     * @param map 源Map
     * @param <V> Value类型
     * @return Value的List（保持Map的顺序）
     */
    public static <V> List<V> getValues(Map<?, V> map) {
        return new ArrayList<>(map.values());
    }

    /**
     * 测试主方法
     */
    public static void main(String[] args) {
        System.out.println("=== 测试1：创建自然顺序排序的TreeMap ===");
        TreeMap<Integer, String> map1 = MapUtil.createSortedMap();
        map1.put(5, "五");
        map1.put(2, "二");
        map1.put(8, "八");
        map1.put(1, "一");
        map1.put(3, "三");
        MapUtil.printMap("自然顺序排序", map1);
        System.out.println("所有Key: " + MapUtil.getKeys(map1));
        System.out.println("所有Value: " + MapUtil.getValues(map1));

        System.out.println("\n=== 测试2：创建倒序排序的TreeMap ===");
        TreeMap<Integer, String> map2 = MapUtil.createDescendingMap();
        map2.put(5, "五");
        map2.put(2, "二");
        map2.put(8, "八");
        map2.put(1, "一");
        MapUtil.printMap("倒序排序", map2);

        System.out.println("\n=== 测试3：使用自定义比较器创建TreeMap ===");
        TreeMap<String, Integer> map3 = MapUtil.createSortedMap(
            (s1, s2) -> s2.length() - s1.length() // 按字符串长度倒序
        );
        map3.put("apple", 5);
        map3.put("banana", 3);
        map3.put("cherry", 8);
        map3.put("date", 1);
        MapUtil.printMap("按字符串长度倒序", map3);

        System.out.println("\n=== 测试4：将HashMap转换为TreeMap ===");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(5, "五");
        hashMap.put(2, "二");
        hashMap.put(8, "八");
        hashMap.put(1, "一");
        hashMap.put(3, "三");
        System.out.println("原始HashMap（无序）: " + hashMap);
        TreeMap<Integer, String> sortedMap = MapUtil.toSortedMap(hashMap);
        MapUtil.printMap("转换后的TreeMap（有序）", sortedMap);

        System.out.println("\n=== 测试5：创建保持插入顺序的LinkedHashMap ===");
        LinkedHashMap<Integer, String> linkedMap = MapUtil.createInsertionOrderMap();
        linkedMap.put(5, "五");
        linkedMap.put(2, "二");
        linkedMap.put(8, "八");
        linkedMap.put(1, "一");
        MapUtil.printMap("插入顺序", linkedMap);

        System.out.println("\n=== 测试6：创建按访问顺序的LinkedHashMap（LRU） ===");
        LinkedHashMap<Integer, String> lruMap = MapUtil.createLRUMap();
        lruMap.put(1, "一");
        lruMap.put(2, "二");
        lruMap.put(3, "三");
        System.out.println("初始状态:");
        MapUtil.printMap(lruMap);
        lruMap.get(1); // 访问key=1
        System.out.println("访问key=1后:");
        MapUtil.printMap(lruMap);
        lruMap.put(4, "四");
        System.out.println("添加key=4后:");
        MapUtil.printMap(lruMap);

        System.out.println("\n=== 测试7：使用初始化数据创建TreeMap ===");
        TreeMap<Integer, String> map7 = MapUtil.createSortedMap(
            5, "五",
            2, "二",
            8, "八",
            1, "一",
            3, "三"
        );
        MapUtil.printMap("初始化数据", map7);
    }
}
