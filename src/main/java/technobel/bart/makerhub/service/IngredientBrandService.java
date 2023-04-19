package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.IngredientBrandDTO;
import technobel.bart.makerhub.models.form.IngredientExistingBrandForm;
import technobel.bart.makerhub.models.form.IngredientNewBrandForm;

import java.util.List;

public interface IngredientBrandService {
    void createWithExistingBrand(IngredientExistingBrandForm form);
    void createWithNewBrand(IngredientNewBrandForm form);

    List<IngredientBrandDTO> getAllOfOneIngredient(long id);

    void delete(long ingId, long brandId);
}
