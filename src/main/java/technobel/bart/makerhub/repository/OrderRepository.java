package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
