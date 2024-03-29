package com.realestate.demo.bl.service;

import com.realestate.demo.bl.repositories.CustomerRepository;
import com.realestate.demo.model.Customer;
import com.realestate.demo.model.CustomerModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    EntityManager entityManager;

    public Customer createCustomer(final Customer customer) {

        CustomerModel customerModel = new CustomerModel();
        BeanUtils.copyProperties(customer, customerModel);
        customerModel = customerRepository.save(customerModel);
        Customer customerData = new Customer();
        BeanUtils.copyProperties(customerModel, customerData);

        return customerData;
    }

    public List getCustomers() {
        List customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        List customerList = new ArrayList<>();
        for (Object customerModel : customers) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerModel, customer);
            customerList.add(customer);
        }

        return customerList;
    }

    public Customer getCustomer(Long id) {

        Optional customer = customerRepository.findById(id);
        Customer customerData = new Customer();
        BeanUtils.copyProperties(customer.get(), customerData);
        return customerData;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
