package com.apo;

import com.apo.PatronBuilder.dto.Employee;

public class App {
    public static void main(String[] args) {
        // Uso del patron builder

        Employee emp = new Employee.EmployeeBuilder()
                .setName("Juan Jesus Esquives Zapata")
                .setGender("Male")
                .setAge(20)
                .setAddress("Comas", "Lima", "Peru", "000001")
                .addContacts("Manolo Perez", "123456789", "123", "Casa")
                .addPhones("987654321", null, "Celular")
                .build();
        System.out.println(emp);
    }
}
