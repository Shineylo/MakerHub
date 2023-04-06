package technobel.bart.makerhub.models.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Client;
import technobel.bart.makerhub.models.entity.Order;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderForm {
    @NotBlank
    private LocalDateTime dateOfOrder;

    private LocalDateTime dateOfDelivery;

    @NotBlank
    private Set<ProductForm> items;

    @NotBlank
    private Client client;
    //TODO Id not the object

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
