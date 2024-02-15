package com.emreilgar.hibernatedemoproject;

import com.emreilgar.hibernatedemoproject.entity.Category;
import com.emreilgar.hibernatedemoproject.entity.Product;
import com.emreilgar.hibernatedemoproject.entity.ProductDetail;
import com.emreilgar.hibernatedemoproject.entity.Tag;
import com.emreilgar.hibernatedemoproject.repository.CategoryRepository;
import com.emreilgar.hibernatedemoproject.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateDemoProjectApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Category category= categoryRepository.findById(1).orElseThrow(()-> new RuntimeException("Category has not been found"));
            ProductDetail productDetail= ProductDetail.builder()
                    .brand("Excalibur")
                    .description("GAME LAPTOP")
                    .warranty(true).build();

            Set<Tag> tags= new HashSet<>();
            tags.add(Tag.builder().name("GeForce").build());
            tags.add(Tag.builder().name("Gamer laptop").build());
            tags.add(Tag.builder().name("High Performance").build());
            Product product= Product.builder()
                    .name("RTX")
                    .quantity(15)
                    .category(category)
                    .productDetail(productDetail)
                    .tagSet(tags)
                    .build();
            productRepository.save(product);

        };
    }
}
