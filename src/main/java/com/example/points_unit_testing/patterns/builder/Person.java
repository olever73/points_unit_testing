package com.example.points_unit_testing.patterns.builder;

import lombok.Builder;

@Builder
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    static PersonBuilder builder() {
//        return new PersonBuilder();
//    }
//
//    static class PersonBuilder {
//        private String name;
//        private int age;
//
//        public PersonBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public PersonBuilder age(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public Person build() {
//            return new Person(this.name, this.age);
//        }
//
//    }

}

class Main {

    public static void main(String[] args) {
        Person person = Person.builder()
                .age(54)
                .name("John")
                .build();
    }
}