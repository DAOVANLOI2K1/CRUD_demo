package rk25finalexam.demo.Services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import rk25finalexam.demo.Entities.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> getAll();

    Optional<Account> getOne(Integer id);

    Account create(Account account);

    Account update(Integer id, Account account) throws ChangeSetPersister.NotFoundException;

    Account delete(Integer id) throws ChangeSetPersister.NotFoundException;

    Page<Account> getAllFilter(Integer pagenumber, Integer pagesize);
}
