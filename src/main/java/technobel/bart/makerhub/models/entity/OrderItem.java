package technobel.bart.makerhub.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class OrderItem {

    @EmbeddedId
    private Id id;

    @MapsId("orderId")
    @ManyToOne
    private Order order;

    @MapsId("productId")
    @ManyToOne
    private Product item;

    @Column(name = "product_quantity", nullable = false)
    private int quantity = 1;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "order_id")
        private Long orderId;
        @Column(name = "product_id")
        private Long productId;

    }
}
