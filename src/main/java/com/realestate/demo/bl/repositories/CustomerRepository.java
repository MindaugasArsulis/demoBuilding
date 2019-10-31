package com.realestate.demo.bl.repositories;

import com.realestate.demo.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel,Long> {
}
