package com.osama.mvcandhibernate.controller;

import com.osama.mvcandhibernate.dao.CustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import com.osama.mvcandhibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;


    /*
     * Injecting the Customer-DAO class
     * Using Constructor Injection */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    /*
    * GET:
    * Returns all customers */
    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

}
