package com.emreilgar.hibernatedemoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String description; //acıklama
    private String brand;        //marka
    private Boolean warranty;    //garanti

    @OneToOne(mappedBy = "productDetail",cascade = CascadeType.ALL,orphanRemoval = true)
    private Product product;
}
