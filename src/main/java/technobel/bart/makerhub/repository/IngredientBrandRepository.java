package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IngredientBrandRepository extends JpaRepository<IngredientBrand,Long> {
    List<IngredientBrand> findAllByIngredientId(long id);
}
