package net.medina.tp3;

import net.medina.tp3.entities.Product;
import net.medina.tp3.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Tp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("Chaussure").price(35).quantity(5).build());
            productRepository.save(Product.builder().name("Chemise").price(100).quantity(6).build());
            productRepository.save(Product.builder().name("T-Shirt").price(80).quantity(2).build());

            List<Product> products=productRepository.findAll();
            products.forEach(prod->{
                System.out.println("Produit numero "+prod.getId()+" - "+ prod.getName());
            });
        };
    }

}
