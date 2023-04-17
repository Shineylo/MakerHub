package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.util.List;

public interface IngredientBrandRepository extends JpaRepository<IngredientBrand,Long> {
    List<IngredientBrand> findAllByIngredientId(long id);
    boolean existsByBrand_IdAndIngredient_Id(long brand_id, long id);

    void deleteByBrand_IdAndIngredient_Id(long brand_id, long id);
}
