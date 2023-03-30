package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.form.IngredientForm;

import java.util.List;

public interface IngredientService {

    void create(IngredientForm form);

    void delete(long ingredientId);

    void update(long ingredientId);

    List<IngredientDTO> getAll();

    IngredientDTO getOne(long ingredientId);
}
