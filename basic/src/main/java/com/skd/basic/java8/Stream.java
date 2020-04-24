package com.skd.basic.java8;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/24 9:38
 */
public class Stream {

    public static List<Integer> list = Lists.newArrayList(1,2,3,4,5,5,5,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1);

    public static void main(String[] args) {

        // 遍历集合元素
        list.stream().forEach(i-> System.out.println(i));

        // 根据条件过滤集合中的数据
        List<Integer> filter = list.stream().filter(i -> i > 5).collect(Collectors.toList());
        System.out.println("集合中大于5的元素：" + Arrays.toString(filter.toArray()));

        // 集合中的元素去重
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println("集合去重后的元素：" + Arrays.toString(distinct.toArray()));

        // 集合中的所有元素是否满足某个条件
        boolean allMatch = list.stream().allMatch(i -> i > 0);
        System.out.println("所有元素都大于0：" + allMatch);
        allMatch = list.stream().allMatch(i -> i > 5);
        System.out.println("所有元素都大于5：" + allMatch);

        // 集合中的所有元素是否满足某个条件
        boolean anyMatch = list.stream().anyMatch(i -> i > 20);
        System.out.println("存在元素都大于20：" + anyMatch);

        anyMatch = list.stream().anyMatch(i -> i > 5);
        System.out.println("存在元素都大于5：" + anyMatch);


        // 将集合中的所有元素转为指定类型的对象
        String test = "1,2,3,4,5,6,7,8,9";
        List<Long> map =Arrays.stream(test.split(",")).map(Long::valueOf).collect(Collectors.toList());
        System.out.println("集合元素转换类型后：" + Arrays.toString(map.toArray()));

        map =Arrays.stream(test.split(",")).map(Long::valueOf).map(i->i*2).collect(Collectors.toList());
        System.out.println("集合元素转换为Long后乘以2：" + Arrays.toString(map.toArray()));

        IntStream stream = Arrays.stream(test.split(",")).mapToInt(Integer::valueOf);


//        test = "1,2,3,4,5,6,7,8,9,a";
//        collect =Arrays.stream(test.split(",")).map(Long::valueOf).collect(Collectors.toList());
//        System.out.println(Arrays.toString(collect.toArray()));

        // 截取集合中前N个元素
        List<Integer> limit = list.stream().limit(5).collect(Collectors.toList());
        System.out.println("" + Arrays.toString(limit.toArray()));

        List<Test> dd = new ArrayList<>();
        dd.add(new Test("A"));
        dd.add(new Test("B"));
        dd.add(new Test("C"));
        List<Test> collect1 = dd.stream().limit(2).collect(Collectors.toList());
        System.out.println("" + Arrays.toString(collect1.toArray()));

    }


}

@Data
@AllArgsConstructor
class Test{

    String ss;
}