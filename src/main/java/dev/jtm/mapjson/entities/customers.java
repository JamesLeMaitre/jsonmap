package dev.jtm.mapjson.entities;

import java.io.IOException;
import java.util.Map;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private String customer_attribute_json;

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> customerAttributes;


    public void setCustomerAttributes(Map<String, Object> customerAttributes) {
        this.customerAttributes = customerAttributes;
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void serializeCustomerAttributes() throws JsonProcessingException {
        this.customer_attribute_json = objectMapper.writeValueAsString(customerAttributes);
    }

    public void deserializeCustomerAttributes() throws IOException {
        this.customerAttributes = objectMapper.readValue(customer_attribute_json, Map.class);
    }

}