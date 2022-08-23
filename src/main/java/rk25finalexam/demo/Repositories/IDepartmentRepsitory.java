package rk25finalexam.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rk25finalexam.demo.Entities.Department;

@Repository
public interface IDepartmentRepsitory extends JpaRepository<Department, Integer> {
}
