package com.jdk8;
//https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/

import lombok.Data;
import org.junit.jupiter.api.Test;

import javax.jnlp.PersistenceService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    @Data
    private class Person {
        private int no;
        private String name;
        private int age;

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

    }
}
