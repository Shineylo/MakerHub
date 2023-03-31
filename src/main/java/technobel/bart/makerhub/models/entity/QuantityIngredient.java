package technobel.bart.makerhub.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class QuantityIngredient {

    @EmbeddedId
    private Id id;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    @MapsId("ingredientId")
    @ManyToOne
    private Ingredient ingredient;

    @Column(name = "ingredient_qtt", nullable = false)
    private int qtt = 1;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "product_id")
        private Long productId;
        @Column(name = "ingredient_id")
        private Long ingredientId;

    }
}
