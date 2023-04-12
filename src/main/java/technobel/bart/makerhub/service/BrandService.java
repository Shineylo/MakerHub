package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.BrandDTO;
import technobel.bart.makerhub.models.dto.IngredientDTO;

import java.util.List;

public interface BrandService {
    List<BrandDTO> getAll();
}
