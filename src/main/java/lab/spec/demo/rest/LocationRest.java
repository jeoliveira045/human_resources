package lab.spec.demo.rest;

import lab.spec.demo.entity.Location;
import lab.spec.demo.repositories.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
@AllArgsConstructor
public class LocationRest {
    private LocationRepository repository;

    @GetMapping
    public ResponseEntity<List<Location>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
