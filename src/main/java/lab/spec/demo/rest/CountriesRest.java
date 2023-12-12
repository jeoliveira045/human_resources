package lab.spec.demo.rest;

import lab.spec.demo.entity.Countries;
import lab.spec.demo.repositories.CountriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountriesRest {
    private CountriesRepository repository;

    @GetMapping
    public ResponseEntity<List<Countries>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
