package rk25finalexam.demo.Services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rk25finalexam.demo.Common.Constants;
import rk25finalexam.demo.Entities.Account;
import rk25finalexam.demo.Repositories.IAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getOne(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account)
            throws ChangeSetPersister.NotFoundException {
        getOne(id)
                .map(acc -> {
                    account.setId(id);
                    accountRepository.save(account);
                    return acc;
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return account;
    }

    @Override
    public Account delete(Integer id)
            throws ChangeSetPersister.NotFoundException {
        return getOne(id)
                .map(acc -> {
                    acc.setId(id);
                    acc.setIsDeleted(Constants.IS_DELETED.TRUE);
                    accountRepository.save(acc);
                    return acc;
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Page<Account> getAllFilter(Integer pagenumber, Integer pagesize) {
        Pageable pageable = PageRequest.of(pagenumber, pagesize);
        Page<Account> accountList = accountRepository.findAll(pageable);
        return accountList;
    }
}
