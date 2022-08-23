package rk25finalexam.demo.Services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import rk25finalexam.demo.Common.Constants;
import rk25finalexam.demo.Entities.Department;
import rk25finalexam.demo.Repositories.IDepartmentRepsitory;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService{
    final IDepartmentRepsitory departmentRepsitory;

    public DepartmentService(IDepartmentRepsitory departmentRepsitory) {
        this.departmentRepsitory = departmentRepsitory;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepsitory.findAll();
    }

    @Override
    public Optional<Department> getOne(Integer id) {
        return departmentRepsitory.findById(id);
    }

    @Override
    public Department create(Department department) {
        return departmentRepsitory.save(department);
    }

    @Override
    public Department update(Integer id, Department department)
            throws ChangeSetPersister.NotFoundException {
        getOne(id)
                .map(dep -> {
                    department.setId(id);
                    departmentRepsitory.save(department);
                    return dep;
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return department;
    }

    @Override
    public Department delete(Integer id)
            throws ChangeSetPersister.NotFoundException {
        return getOne(id)
                .map(dep -> {
                    dep.setIsDeleted(Constants.IS_DELETED.TRUE);
                    departmentRepsitory.save(dep);
                    return dep;
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
