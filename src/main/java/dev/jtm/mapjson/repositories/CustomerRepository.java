package dev.jtm.mapjson.repositories;

import dev.jtm.mapjson.entities.customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customers,Long> {
}
