package com.Day11;

import java.util.Objects;

public class Contact {
    private String name;
    private String email;
    private String mobile;
    private String department;


    public Contact(String email, String name, String mobile, String department) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(department, contact.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, mobile, department);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
