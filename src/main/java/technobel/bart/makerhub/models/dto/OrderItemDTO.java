package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.Order;
import technobel.bart.makerhub.models.entity.OrderItem;
import technobel.bart.makerhub.models.entity.Product;

@Data
@Builder
public class OrderItemDTO {
    private Order order;
    private Product item;
    private int qtt;

    public static OrderItemDTO toDto(OrderItem entity){
        if(entity == null)
            return null;

        return new OrderItemDTO(
                entity.getOrder(),
                entity.getItem(),
                entity.getQuantity()
        );
    }
}
