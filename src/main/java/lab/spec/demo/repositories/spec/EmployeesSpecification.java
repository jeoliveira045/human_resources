package lab.spec.demo.repositories.spec;

import lab.spec.demo.entity.Employees;
import org.springframework.data.jpa.domain.Specification;

public class EmployeesSpecification {
    public static Specification<Employees> hasFirstNameLike(String firstName){
        return (root, cq, cb) ->
                cb.like(root.<String>get("firstName"), "%" + firstName + "%" );
    }

    public static Specification<Employees> hasFullName(String firstName, String lastName){
        return (root, cq, cb) ->
                cb.and(cb.equal(root.<String>get("firstName"), firstName),
                       cb.equal(root.<String>get("lastName"), lastName));
    }
}
