package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
