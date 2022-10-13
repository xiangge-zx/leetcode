package com.ti.huawei.od.string;

import java.util.*;
import java.util.stream.Collectors;

public class string4 {
    public void demo1() {
        Integer[] integers = {1, 3, 23, 63, 55, 33, 3, 1, 5, 23};
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : integers) {
            set.add(integer);//遍历数组，添加set集合去重
        }
        //Lambda表达式,升序
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        System.out.print("升序：");
        for (Integer order : collect) {
            System.out.print(order + " ");
        }
    }

   /* public void demo2() {
        ArrayList<Double> dAList = new ArrayList<>();
        int num = 3;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= num; i++) {
            System.out.println("请输入第" + i + "个数字，按回车确认");
            dAList.add(scanner.nextDouble());
        }
        System.out.print("您输入的数字依次是：" + dAList);
        System.out.println();

        System.out.println("去重后升序排列结果：");
        dAList.stream().distinct().sorted().forEach(System.out::println);
        System.out.println("去重后降序排列结果：");
        aList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }*/


}
