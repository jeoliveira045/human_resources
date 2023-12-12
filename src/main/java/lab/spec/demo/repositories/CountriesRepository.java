package lab.spec.demo.repositories;

import lab.spec.demo.entity.Countries;
import lab.spec.demo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long>, JpaSpecificationExecutor<Countries> {
}
