package com.santhosh.OOP;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    //Default constructor you have to add since you added a non default one
    public Person(){

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        int compareResults = this.lastName.compareTo(other.lastName);
        if (compareResults == 0) {
            return this.firstName.compareTo(other.firstName);
        } else {
            return compareResults;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person other = (Person) o;
        return this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstName(), this.getLastName());
    }
}
