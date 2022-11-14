package dev.jtm.mapjson.servicesimpl;

import dev.jtm.mapjson.entities.DataRequest;
import dev.jtm.mapjson.entities.customers;
import dev.jtm.mapjson.repositories.CustomerRepository;
import dev.jtm.mapjson.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public customers saveCustomer() throws IOException {
        customers customer = new customers();
        customer.setFirst_name("first name");
        customer.setLast_name("last name");

        Map<String, Object[]> attributes = new HashMap<>();
        DataRequest[] tab = new DataRequest[2];
        for(int i=0; i<tab.length; i++){
            tab[i] = new DataRequest(customer.getFirst_name(),"address "+ i);
        }

        attributes.put("libelle",tab);
       /* attributes.put("description", "description");
        attributes.put("comment","comment");*/

        customer.setCustomerAttributes(attributes);

        customer.serializeCustomerAttributes();
        return customerRepository.save(customer) ;

        /*String serialized = customer.getCustomerAttributeJSON();

        customer.setCustomerAttributeJSON(serialized);
        customer.deserializeCustomerAttributes();

        Map<String, Object> deserialized = customer.getCustomerAttributes();

        assertEquals("123 Main Street", deserialized.get("address"));*/
    }


}
