package rk25finalexam.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rk25finalexam.demo.Entities.Account;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
