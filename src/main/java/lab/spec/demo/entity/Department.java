package lab.spec.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lab.spec.demo.entity.databind.EmployeesDatabind;
import lab.spec.demo.entity.databind.LocationDatabind;
import lombok.Data;

@Entity
@Table(name = "DEPARTMENTS")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DEPARTMENTS_SEQ")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "DEPARTMENTS_SEQ")
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "MANAGER_ID")
    @JsonSerialize(using = EmployeesDatabind.IdSerializer.class)
    @JsonDeserialize(using = EmployeesDatabind.IdDeserializer.class)
    private Employees managerId;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    @JsonSerialize(using = LocationDatabind.IdSerializer.class)
    @JsonDeserialize(using = LocationDatabind.IdDeserializer.class)
    private Location locationId;
}
