package lab.spec.demo.rest;

import lab.spec.demo.entity.Department;
import lab.spec.demo.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentRest {
    private DepartmentRepository repository;

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
