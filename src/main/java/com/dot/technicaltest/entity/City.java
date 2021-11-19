package com.dot.technicaltest.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "city")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_id", length = 50, nullable = false, unique = true)
    private Long cityId;

    @Column(name = "province_id", length = 50, nullable = false)
    private String provinceId;

    @Column(name = "province", length = 50, nullable = false)
    private String province;

    @Column(name = "type", length = 50, nullable = false)
    private String type;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    @Column(name = "postal_code", length = 50, nullable = false)
    private Long postalCode;
}
