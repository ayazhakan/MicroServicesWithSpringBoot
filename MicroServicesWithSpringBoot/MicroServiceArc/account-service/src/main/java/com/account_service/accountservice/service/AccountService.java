package com.account_service.accountservice.service;

import com.account_service.accountservice.dto.AccountDto;
import com.account_service.accountservice.entity.Account;
import com.account_service.accountservice.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AccountService {


            private final AccountRepository accountRepository;
            private final ModelMapper modelMapper;


    @Transactional
    public Slice<AccountDto> getAll(Pageable pageable) {
        Slice<Account> accounts = accountRepository.findAll(pageable);
        return null;
    }

    @Transactional
    public AccountDto get(String id){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException());
       return modelMapper.map(account, AccountDto.class);

    }
    @Transactional
    public AccountDto save(AccountDto accountDto){
        Account account=modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Transactional
    public AccountDto update(String id,AccountDto accountDto){
        Assert.isNull(id, "ID is null.");
        Optional<Account> account= accountRepository.findById(id);
        Account accountToUpdate = account.map(it -> {
            it.setBirthDate(accountDto.getBirthDate());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Transactional
    public void delete(String id){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException());
        accountRepository.delete(account);

    }



}
