package com.account_service.accountservice.service;

import com.account_service.accountservice.entity.Account;
import com.account_service.accountservice.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

@Autowired
private AccountRepository accountRepository;




    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
    }

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account update(String id,Account account){
        Assert.isNull(id, "ID is null.");
        return accountRepository.save(account);
    }

    public void delete(String id){

    }



}
