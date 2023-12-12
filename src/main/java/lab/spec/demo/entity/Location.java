package lab.spec.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lab.spec.demo.entity.databind.CountriesDatabind;
import lombok.Data;

@Entity
@Table(name = "LOCATIONS")
@Data
public class Location {
    @Id
    private Long locationId;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    @JsonSerialize(using = CountriesDatabind.IdSerializer.class)
    @JsonDeserialize(using = CountriesDatabind.IdDeserializer.class)
    private Countries countryId;

}
