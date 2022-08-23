package com.wyq;

import java.util.*;

/**
 * TreeMap的自定义排序
 * https://www.jb51.net/article/197662.htm
 * Map集合按照值的大小进行比较
 * 法一
 * 将map集合转换为ArrayList集合，使用Collections的sort方法进行排序；
 * 可以选择传入一个Comparetor对象，也可以选择传入lambda表达式。比较完成以后对list进行遍历即可
 * 法二
 * 对map集合使用流的方法进行处理，然后完成比较（这个方法比较复杂）
 *
 * @author WangYQ
 */
public class TreeMapSort {
    /**
     * 自定义升序或者是降序
     */
    private void treeDesc() {
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>(); //默认的TreeMap升序排列
        TreeMap<Integer, Integer> map2 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            /*
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        map2.put(1, 2);
        map2.put(2, 4);
        map2.put(7, 1);
        map2.put(5, 2);
        System.out.println("Map2=" + map2);

        map1.put(1, 2);
        map1.put(2, 4);
        map1.put(7, 1);
        map1.put(5, 2);
        System.out.println("map1=" + map1);
    }

    /**
     * 以值的大小进行排序
     */
    private void sortByValue() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");
        // 将map集合转换为List集合
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        // 通过在内部传递一个比较器
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // 传入lambda表达式
        Collections.sort(list, (o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue());
        });

        for (Map.Entry<String, String> e : list) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}

