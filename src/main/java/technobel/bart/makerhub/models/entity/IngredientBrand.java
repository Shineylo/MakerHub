package technobel.bart.makerhub.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class IngredientBrand {

    @EmbeddedId
    private Id id;

    @MapsId("ingredientId")
    @ManyToOne
    private Ingredient ingredient;

    @MapsId("brandId")
    @ManyToOne
    private Brand brand;

    @Column(name = "ingredient_price",nullable = false)
    private double price;

    @Column(name = "stock_quantity",nullable = false)
    private String quantity;

    @Column(name = "ingredient_expiration",nullable = false)
    private LocalDate expiration;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "ingredient_id")
        private Long ingredientId;
        @Column(name = "brand_id")
        private Long brandId;

    }

}
