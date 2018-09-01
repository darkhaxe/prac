package com.jdk8;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 空指针处理
 *
 * @author haze
 * @date created at 2018/2/1 下午3:11
 */
public class OptionalTest {

    @Test
    public void testOptional2() {
        //测试map()转换为空值,是否会执行orElse
        System.out.println(
                Optional.ofNullable(Arrays.asList("1"))
                        .map(num -> null)
                        .orElse("default"));
    }

    @Test
    public void testOptional() {
        Optional.ofNullable(null).ifPresent(x -> System.out.println(x));
        Optional.empty().ifPresent(x -> System.out.println(x));
        //测试空值的影响
        System.out.println("1." +
                Optional.ofNullable(Arrays.asList(null, new Student()))
                        .map(list -> list.get(0))
                        .map((Student s) -> s.getName())
                        .orElse("default"));


        //
        List<Student> nullObj = null;
        System.out.println("3." +
                Optional.ofNullable(nullObj)
                        .map(list -> list.get(0))
                        .map(Student::getName)
                        .orElse("test null"));
        //todo flatmap
        Optional.ofNullable(Collections.emptyList())
                .filter(innerList -> !innerList.isEmpty())
                .ifPresent(innerList -> System.out.println("present->" + innerList));
//
        Person spike = new Person(1, "spike", 26);

        Optional.ofNullable(getNull())
                .ifPresent(spike::setName);
        System.out.println(spike);

    }

    private String getNull() {
        return null;
    }

    @Test
    public void testExceptionCase() {
        //todo !!这种写法将会出现数组越界异常
        System.out.println("2." +
                Optional.ofNullable(Arrays.asList(new Student()))
                        .map(list -> list.get(1))
                        .map((Student s) -> s.getName())
                        .orElse("test ArrayOutOfBoundException"));
        //包含空值的话需要异常处理
        System.out.println(
                Optional.ofNullable(
                        Arrays.asList(null,
                                new Person(1, "a", 22),
                                new Person(2, "b", 23)))
                        .map(list -> list.stream()
                                .collect(Collectors.groupingBy(Person::getName)))
                        .orElse(Collections.emptyMap()));
    }


    @Data
    public class Student {
        private String name;
        private Set<String> book;
        private List<String> sports;

        public void addBook(String book) {
            if (this.book == null) {
                this.book = new HashSet<>();
            }
            this.book.add(book);
        }

        public void addSports(String sport) {
            if (this.sports == null) {
                this.sports = new ArrayList<>();
            }
            this.sports.add(sport);
        }
    }

    @Data
    private class Person {

        private Integer no;
        private String name;
        private int age;

        Person(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }
    }

}
