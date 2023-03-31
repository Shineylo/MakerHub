package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
