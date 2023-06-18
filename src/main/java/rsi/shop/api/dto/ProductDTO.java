package rsi.shop.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDTO {
    @Schema(description = "Product name", example = "Butter")
    private String name;
    @Schema(description = "Product price", example = "1.50")
    private double price;
    @Schema(description = "Product weight in grams", example = "150")
    private int weight;
    @Schema(description = "Product expiration date", example = "2023-07-01")
    private LocalDate expirationDate;

    public ProductDTO(String name, double price, int weight, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }
}
