package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.BrandDTO;
import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.entity.Brand;

import java.util.List;

public interface BrandService {

    Brand create(String name);

    List<BrandDTO> getAll();
}
