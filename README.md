> 说明：
>
> 1. 此项目作为日常积累小工具记载。将遇到的问题解决之后以简单的方式进行复现
> 2. Stone 石头，存储。Boom：爆炸。StoneBoom 可以理解为积累爆发（厚积薄发）更加强调积累的重要性

# Map 自定义排序

- TreeMap相较于HashMap，自己本身可以进行排序；但是默认是依据key进行升序排列

- 如需要对Map进行排序，需要先将Map转换为List集合。然后调用`Collections.sort()`方法进行排序。在排序时候，需要传入一个比较器
- 该比较器可以通过传入一个内部类，也可以通过传入一个lambda表达式实现。

传入内部类实现

```java
List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

// 通过在内部传递一个比较器
Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
    //升序排序
    @Override
    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
});
// 这里使用增强for循环进行遍历
for (Map.Entry<String, String> e : list) {
    System.out.println(e.getKey() + ":" + e.getValue());
}
```

传入lambda实现

```java
List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(countMap.entrySet());
// 传入一个车lambda表达式
Collections.sort(list, (o2, o1) -> {
    return o1.getValue().compareTo(o2.getValue());
});
// 获取到list的迭代器，方便后续进行遍历
Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
```

调试详细结果图



知识补充：

- Entry与Map的关系
