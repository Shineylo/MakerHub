package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.QuantityIngredient;

public interface QuantityIngredientRepository extends JpaRepository<QuantityIngredient,Long> {
}
