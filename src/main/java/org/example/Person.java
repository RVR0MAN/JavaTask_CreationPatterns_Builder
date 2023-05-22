package org.example;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age != 0;

    }

    public boolean hasAddress() {
        return address != null;
    }


    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            OptionalInt age = OptionalInt.of(this.age);
            return age;
        } else {
            throw new NullPointerException("Данные о возрасте человека с именем " + this.surname + " " + this.name + " отсутствуют");
        }
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        } else {
            throw new NullPointerException("Данные о городе проживания человека с именем :" + this.surname + " " + this.name + " отсутствуют");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }


    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(getSurname()).setAddress(getAddress()).setAge(0);
    }


    @Override
    public String toString() {
        return surname + " " + name + " " + "место проживания :" + address;
    }


    @Override
    public int hashCode() {
        String result = (name + surname + age);
        return result.hashCode();
    }


}