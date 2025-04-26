package com.easybytes.accounts.service.Impl;

import com.easybytes.accounts.constants.AccountsContstants;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Accounts;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.mapper.CustomerMapper;
import com.easybytes.accounts.repository.AccountsRepository;
import com.easybytes.accounts.repository.CustomerRespository;
import com.easybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {

   private AccountsRepository accountsRepository;
   private CustomerRespository customerRespository;


    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> optionCustomer = customerRespository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists"+customerDto.getMobileNumber());
        }
        customerRespository.save(customer);
    }



    private Accounts createNewAccount(Customer customer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        Long randomNumber =  1000000000L + new Random().nextInt( 900000000);
        newAccounts.setAccountNumber(randomNumber);
        newAccounts.setAccountType(AccountsContstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsContstants.ADDRESS);
        return newAccounts;
    }

}
