package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.AccountDto;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Accounts;
import com.easybytes.accounts.entity.Customer;

public class CustomerMapper {

 public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {

  customerDto.setName(customer.getName());
  customerDto.setEmail(customer.getEmail());
  customerDto.setMobileNumber(customer.getMobileNumber());
  return customerDto;
 }

 public static Customer mapToCustomer(Customer customer, CustomerDto customerDto) {

  customer.setName(customerDto.getName());
  customer.setEmail(customerDto.getEmail());
  customer.setMobileNumber(customerDto.getMobileNumber());
  return customer;
 }

}
