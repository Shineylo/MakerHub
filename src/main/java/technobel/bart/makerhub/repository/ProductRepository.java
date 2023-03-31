package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
