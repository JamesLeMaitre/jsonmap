package dev.jtm.mapjson.servicesimpl;

import dev.jtm.mapjson.entities.customers;
import dev.jtm.mapjson.services.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Override
    public customers saveCustomer() throws IOException {
        customers customer = new customers();
        customer.setFirst_name("first name");
        customer.setLast_name("last name");

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("address", "123 Main Street");
        attributes.put("zipcode", 12345);

        customer.setCustomerAttributes(attributes);

        customer.serializeCustomerAttributes();
        return customer ;

        /*String serialized = customer.getCustomerAttributeJSON();

        customer.setCustomerAttributeJSON(serialized);
        customer.deserializeCustomerAttributes();

        Map<String, Object> deserialized = customer.getCustomerAttributes();

        assertEquals("123 Main Street", deserialized.get("address"));*/
    }
}
