package rk25finalexam.demo.Controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rk25finalexam.demo.Entities.Department;
import rk25finalexam.demo.Services.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departmentList = departmentService.getAll();
        return ResponseEntity.ok().body(departmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> getOne(@PathVariable Integer id) {
        Optional<Department> department = departmentService.getOne(id);
        return ResponseEntity.ok().body(department);
    }

    @PostMapping()
    public ResponseEntity<Department> create(@RequestBody Department department) {
        Department reponsedepartment = departmentService.create(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(reponsedepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Integer id, @RequestBody Department department)
            throws ChangeSetPersister.NotFoundException {
        Department resonsedepartment = departmentService.update(id, department);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> delete(@PathVariable Integer id)
            throws ChangeSetPersister.NotFoundException {
        Department department = departmentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(department);
    }
}
