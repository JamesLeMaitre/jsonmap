package dev.jtm.mapjson.services;

import dev.jtm.mapjson.entities.customers;

import java.io.IOException;

public interface CustomerService {
   customers saveCustomer() throws IOException;
}
