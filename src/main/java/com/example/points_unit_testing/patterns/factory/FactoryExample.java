package com.example.points_unit_testing.patterns.factory;

public class FactoryExample {
}

class Main {


    public Employee factoryMethod(String parameter) {
        if (parameter.equals("manager")) {
            return new Manager();
        } else {
            return new Worker();
        }
    }
}



class Employee {
}

class Manager extends Employee {
}
class Worker extends Employee {
}