package com.jdk8;
//https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
