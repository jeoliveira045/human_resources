package lab.spec.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lab.spec.demo.entity.databind.RegionDatabind;
import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@Data
public class Countries {
    @Id
    private String countryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    @JsonSerialize(using = RegionDatabind.IdSerializer.class)
    @JsonDeserialize(using = RegionDatabind.IdDeserializer.class)
    private Region regionId;

}
