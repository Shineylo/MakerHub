package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.IngredientBrandDTO;
import technobel.bart.makerhub.models.entity.IngredientBrand;
import technobel.bart.makerhub.models.form.IngredientBrandForm;

import java.util.List;

public interface IngredientBrandService {
    void create(IngredientBrandForm form);

    List<IngredientBrandDTO> getAllOfOneIngredient(long id);
}
