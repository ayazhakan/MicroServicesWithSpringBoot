package com.account_service.accountservice.service;

import com.account_service.accountservice.entity.Account;
import com.account_service.accountservice.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


@RequiredArgsConstructor
@Service
public class AccountService {


private AccountRepository accountRepository;

    @Autowired // Setter Injection
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public Account get(String id){
        return accountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());
    }
    @Transactional
    public Account save(Account account){
        return accountRepository.save(account);
    }

    @Transactional
    public Account update(String id,Account account){
        Assert.isNull(id, "ID is null.");
        return accountRepository.save(account);
    }

    @Transactional
    public void delete(String id){

    }



}
