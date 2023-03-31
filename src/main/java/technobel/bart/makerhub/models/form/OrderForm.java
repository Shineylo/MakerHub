package technobel.bart.makerhub.models.form;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Client;
import technobel.bart.makerhub.models.entity.Order;
import technobel.bart.makerhub.models.entity.OrderItem;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class OrderForm {
    @NotBlank
    private LocalDateTime dateOfOrder;

    private LocalDateTime dateOfDelivery;

    @NotBlank
    private Set<OrderItem> items;

    @NotBlank
    private Client client;

    public Order toEntity(){
        Order order = new Order();

        order.setDateOfOrder(dateOfOrder);
        order.setDateOfDelivery(dateOfDelivery);

        return order;
    }

    @Data
    public static class ProductForm {
        private Long id;
        private int quantity;
    }
}
