package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Client;
import technobel.bart.makerhub.models.entity.Order;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class OrderDTO {

    private Long id;
    private LocalDateTime dateOfOrder;
    private LocalDateTime dateOfDelivery;
    private Set<OrderItemDTO> items = new LinkedHashSet<>();
    private Client client;

    public static OrderDTO toDto(Order entity){
        if( entity == null )
            return null;

        return new OrderDTO(
                entity.getId(),
                entity.getDateOfOrder(),
                entity.getDateOfDelivery(),
                entity.getItems().stream()
                        .map(OrderItemDTO::toDto)
                        .collect(Collectors.toSet()),
                entity.getClient()
        );
    }
}
