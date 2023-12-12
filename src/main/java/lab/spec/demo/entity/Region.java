package lab.spec.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "REGIONS")
@Data
public class Region {
    @Id
    private Long regionId;

    @Column(name = "REGION_NAME")
    private String regionName;


}
