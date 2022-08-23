package rk25finalexam.demo.Services;

import org.springframework.data.crossstore.ChangeSetPersister;
import rk25finalexam.demo.Entities.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {
    List<Department> getAll();
    Optional<Department> getOne(Integer id);
    Department create(Department department);
    Department update(Integer id, Department department) throws ChangeSetPersister.NotFoundException;
    Department delete(Integer id) throws ChangeSetPersister.NotFoundException;
}
