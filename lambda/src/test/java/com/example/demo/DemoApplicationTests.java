package com.example.demo;

import com.example.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 左侧：lambda   表达式的参数列表
 * 右侧：lambda   表达式中所需执行的功能 即lambda表达体
 * 语法格式一： 无参数,无返回值
 *          () -> System.out.println("Hello Lambda")
 *
 * 语法格式二： 有一个参数,无返回值
 *       (x) -> System.out.println(x)
 *
 * 语法格式三： 若只有一个参数,小括号可以不写
 *       x -> System.out.println(x)
 *
 *  语法格式四： 有两个参数以上，有返回值,并且 lambda 体中有多条语句用 大括号
 *   Comparator<Integer> com = (x,y)->{
 *             System.out.println("函数式接口");
 *             return Integer.compare(x,y);
 *         };
 *
 *    filter 排除某些元素
 *    Limit  使其元素不超过给定数量
 *    skip   跳过元素  与 Limit互补
 *    distinct  通过流所生成的元素的hashCode()和equals()去重
 */
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Runnable runnable =  () -> System.out.println("11111");
        runnable.run();

        Comparator<Integer> com = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",30,1000.00),
            new Employee("王五",10,9000.00),
            new Employee("赵六",40,10000.00),
            new Employee("田七",50,2000.00)
    );
    @Test
    void test(){
        Stream<Employee> stream = employees.stream()
                .filter((e) -> e.getMoney() >= 2000)
                .limit(2);
        stream.forEach(System.out::println);
    }

    @Test //方法引用
    void test1(){
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    void test2(){
        employees.stream().forEach(employee -> {
            System.out.println(employee.getName());
        });
    }
}
