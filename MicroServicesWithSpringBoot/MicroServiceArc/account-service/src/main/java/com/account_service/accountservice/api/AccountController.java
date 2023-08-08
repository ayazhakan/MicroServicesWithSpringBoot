package com.account_service.accountservice.api;

import com.account_service.accountservice.dto.AccountDto;
import com.account_service.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import com.account_service.accountservice.entity.Account;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @GetMapping
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable){

        return ResponseEntity.ok(accountService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id){

            return ResponseEntity.ok(accountService.get(id));
    }


    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account){

        return ResponseEntity.ok(accountService.save(account));

    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto account){

        return ResponseEntity.ok(accountService.update(id,account));
    }


    @DeleteMapping
    public void delete(String id){
        accountService.delete(id);
        ResponseEntity.noContent();

    }


}
