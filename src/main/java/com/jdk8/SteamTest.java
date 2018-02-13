package com.jdk8;
//https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.jupiter.api.Test;

import javax.jnlp.PersistenceService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SteamTest {
    @Test
    void s1() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(2, "name" + 2, 21));
        persons.add(new Person(3, "name" + 3, 34));
        persons.add(new Person(4, "name" + 4, 6));
        persons.add(new Person(5, "name" + 5, 55));
        boolean isAllAdult = persons.stream().
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = persons.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
        //
        Optional.ofNullable(persons)
                .map((List<Person> list) ->
                        list.stream()
                                .map(p -> p.getAge() + 3)
                                .reduce(999, Integer::min))
                .orElse(999);

    }

    @Data
    private class Person {
        private Integer no;
        private String name;
        private int age;

        Person() {
        }

        Person(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }
    }

    @Test
    public void testSB() throws Exception {
        StringBuilder couponHintSB = new StringBuilder();
        couponHintSB.append("减100 - 10、");
        couponHintSB.append("减200 - 20、");
        couponHintSB.append("减300 - 30、");
        couponHintSB.substring(0, couponHintSB.lastIndexOf("、"));
        System.out.println(couponHintSB.toString());
    }

    @Test
    public void testStreamSB() throws Exception {

        String str = Stream.of("a", "b", "c")
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(","), x -> x + "d"));
        System.out.println(str);
    }

    @Test
    public void testRef() {
//        HashMap<Object, Object> map = new HashMap<>();
//        ArrayList<Object> list = new ArrayList<>();
//        map.put("list", list);
//        list.add(111);
//        list.add(222);
//        list.add(333);
//        System.out.println(map);
//        System.out.println(map.get("list").equals(list));

        List<Person> personsList = new ArrayList<>();
        Person p1 = new Person(1, "name" + 1, 10);
        Person p2 = new Person(2, "name" + 2, 21);
        personsList.add(p1);
        personsList.add(p2);
        List<Person> glbList = new ArrayList<>();
        glbList.addAll(personsList);
        Person _p1 = glbList.get(0);
        _p1.setAge(22); // 引用相同,改变存放了引用的对象的属性
        System.out.println(p1); //查看原对象的数值,已经被改变
        System.out.println("------------------");
        // 测试 streamAPI 的 引用是否
        List<Person> sList = personsList.stream().filter(p -> p.getName() != null).collect(Collectors.toList());
        Person _s1 = sList.get(0);
        _s1.setAge(99); // 引用相同,改变存放了引用的对象的属性
        System.out.println(p1);

        System.out.println("----------stream API 是否返回空--------");
        List<Person> test = personsList.stream().filter(p -> p.getAge() < -1).collect(Collectors.toList());
        System.out.println(test);

        System.out.println("------------------");
        p2.setAge(223);
        System.out.println("personsList=" + personsList + " sList=" + sList);

    }

    @Test
    public void testSort() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        list.sort(Comparator.reverseOrder());
        System.out.println(list.get(0));
    }

    @Test
    public void testMax() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(
                "/Users/darkhaze/IdeaProjects/prac/src/main/java/com/jdk8/SteamTest.java"));
        int longest = br.lines().
                mapToInt(String::length).
                max().
                getAsInt();
        br.close();
        System.out.println(longest);
        System.out.println("------------peek------------");

        //peek
        System.out.println(Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()));
    }

    @Test
    public void testForEach() throws Exception {
        List<String> list = Stream.of("one", "two", "three", "four").collect(Collectors.toList());
        list.forEach(System.out::println);
        list.forEach(e -> System.out.println(e + "--"));
        System.out.println("--------错误实例--------");
        Stream<String> stream = list.stream();

        stream.forEach(System.out::println);
        stream.forEach(e -> System.out.println(e + "--"));
    }

    @Test
    public void testFlatMap() {
//        flatMap
        Student s1 = new Student();
        s1.setName("mkyong");
        s1.addBook("Java 8 in Action");
        s1.addBook("Spring Boot in Action");
        s1.addBook("Effective Java (2nd Edition)");
        s1.addSports("st1");
        s1.addSports("st2");

        Student s2 = new Student();
        s2.setName("zilap");
        s2.addBook("Learning Python, 5th Edition");
        s2.addBook("Effective Java (2nd Edition)");
        s2.addSports("st3");
        s2.addSports("st4");
        s2.addSports("st5");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        /*
            学生对象的Set<Book>
            List<Student>
         */
        List<String> collect =
                list.stream()
                        //Stream<Set<String>>
                        .map(x -> x.getBook())
                        //Stream<String> :将结构打平
                        .flatMap(x -> x.stream())
//                        .distinct() --去重
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
        System.out.println("-------------------");
        list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    @Test
    public void testfield() throws Exception {
        Person p = new Person();
        System.out.println(p.getNo() == 2);
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
}
