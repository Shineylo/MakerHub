package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.util.Collection;
import java.util.Optional;

public interface IngredientBrandRepository extends JpaRepository<IngredientBrand,Long> {
    Optional<IngredientBrand[]> findByIngredientId(long id);
}
