package lab.spec.demo.rest;

import lab.spec.demo.entity.Employees;
import lab.spec.demo.repositories.EmployeesRepository;
import lab.spec.demo.repositories.spec.EmployeesSpecification;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeesRest {
    private EmployeesRepository repository;

    @GetMapping
    public ResponseEntity<List<Employees>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<List<Employees>> findByFirstName(@PathVariable String firstName){
        return ResponseEntity.ok(repository.findAll(EmployeesSpecification.hasFirstNameLike(firstName)));
    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<List<Employees>> findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return ResponseEntity.ok(repository.findAll(EmployeesSpecification.hasFullName(firstName, lastName)));
    }
}
