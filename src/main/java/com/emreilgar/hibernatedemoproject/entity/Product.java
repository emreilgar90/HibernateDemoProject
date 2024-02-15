package com.emreilgar.hibernatedemoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer quantity; //miktar

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detal_id",referencedColumnName = "ID")
    private ProductDetail productDetail;

    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "ID")  //Bir category birden fazla product olabilir
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUCT_TAG_REL",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="tag_id",referencedColumnName = "ID"))
    private Set<Tag> tagSet;
}
