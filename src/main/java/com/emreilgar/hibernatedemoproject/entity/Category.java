package com.emreilgar.hibernatedemoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="name",nullable = false,unique = true)
    private String name;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Product> products;
}
