package rsi.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Product identifier", example = "1")
    private long id;
    @Schema(description = "Product name", example = "Butter")
    private String name;
    @Schema(description = "Product price", example = "1.50")
    private double price;
    @Schema(description = "Product weight in grams", example = "150")
    private int weight;
    @Schema(description = "Product expiration date", example = "2023-07-01")
    private LocalDate expirationDate;
}
