package com.account_service.accountservice.api;

import com.account_service.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.account_service.accountservice.entity.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {



    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService =accountService;
    }


    @GetMapping
    public ResponseEntity<List<Account>> getAll(){

        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable String id){

            return ResponseEntity.ok(accountService.get(id));
    }


    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){

        return ResponseEntity.ok(accountService.save(account));

    }

    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody Account account){

        return ResponseEntity.ok(accountService.update(id,account));
    }


    @DeleteMapping
    public void delete(String id){
        accountService.delete(id);
        ResponseEntity.noContent();

    }


}
