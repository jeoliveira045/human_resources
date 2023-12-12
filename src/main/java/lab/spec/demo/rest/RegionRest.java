package lab.spec.demo.rest;

import lab.spec.demo.entity.Region;
import lab.spec.demo.repositories.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionRest {
    private RegionRepository repository;

    @GetMapping
    public ResponseEntity<List<Region>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
