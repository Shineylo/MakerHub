package technobel.bart.makerhub.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.util.List;

public interface IngredientBrandRepository extends JpaRepository<IngredientBrand,Long> {
    List<IngredientBrand> findAllByIngredientId(long id);
    boolean existsByBrand_IdAndIngredient_Id(long brand_id, long id);

    @Transactional
    @Modifying
    void deleteByBrand_IdAndIngredient_Id(long brand_id, long id);
}
