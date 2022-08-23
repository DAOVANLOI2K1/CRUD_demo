package rk25finalexam.demo.Controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rk25finalexam.demo.Entities.Account;
import rk25finalexam.demo.Services.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<Page<Account>> getAllOrFilter(@RequestParam(required = false) Integer pagenumber, @RequestParam(required = false) Integer pagesize) {
        pagenumber = (pagenumber == null) ? 0 : pagenumber;
        pagesize = (pagesize == null) ? Integer.MAX_VALUE : pagesize;
        Page<Account> accountList = accountService.getAllFilter(pagenumber, pagesize);
        return ResponseEntity.ok().body(accountList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getOne(@PathVariable Integer id) {
        Optional<Account> account = accountService.getOne(id);
        return ResponseEntity.ok().body(account);

    }

    @PostMapping()
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account responseAccount = accountService.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Integer id, @RequestBody Account account)
            throws ChangeSetPersister.NotFoundException {
        Account responseAccount = accountService.update(id, account);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        Account responseAccount = accountService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseAccount);
    }
}
