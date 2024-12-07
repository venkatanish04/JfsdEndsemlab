package com.klef.jfsd.exam.controller;


	import com.klef.jfsd.exam.model.Customer;
	import com.klef.jfsd.exam.service.CustomerService;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/api/customers")
	public class CustomerController {

	    @Autowired
	    private CustomerService customerService;

	    // Endpoint to update customer information
	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, 
	                                                   @RequestParam String name, 
	                                                   @RequestParam String address) {
	        Customer updatedCustomer = customerService.updateCustomer(id, name, address);
	        if (updatedCustomer != null) {
	            return ResponseEntity.ok(updatedCustomer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    // Endpoint to create a new customer
	    @PostMapping("/")
	    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.saveCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }
	}


