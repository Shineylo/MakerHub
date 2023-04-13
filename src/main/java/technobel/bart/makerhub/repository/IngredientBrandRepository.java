package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.IngredientBrand;

public interface IngredientBrandRepository extends JpaRepository<IngredientBrand,Long> {
}
