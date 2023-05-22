package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст указан некорректно:возраст не может быть меньше или равен 0");
        } else if (this.age == 0) {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Фамилия и имя человека не указаны");
        }
        if (this.age != 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (this.address != null) {
            person.setAddress(this.address);
        }
        return person;
    }


}
