package lab.spec.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lab.spec.demo.entity.databind.EmployeesDatabind;
import lab.spec.demo.entity.databind.DepartmentDatabind;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEES")
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EMPLOYEES_SEQ")
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "EMPLOYEES_SEQ")
    private Long employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;


    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private Long salary;

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    @JsonSerialize(using = EmployeesDatabind.IdSerializer.class)
    @JsonDeserialize(using = EmployeesDatabind.IdDeserializer.class)
    private Employees managerId;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    @JsonSerialize(using = DepartmentDatabind.IdSerializer.class)
    @JsonDeserialize(using = DepartmentDatabind.IdDeserializer.class)
    private Department departmentId;

}
