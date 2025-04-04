package com.book.junitinaction.chapter02.tags;

import java.util.ArrayList;
import java.util.List;

class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public boolean contains(String name) {
        return customers.stream().anyMatch(customer -> customer.getName().equals(name));
    }

    public void persist(Customer customer) {
        customers.add(customer);
    }
}
