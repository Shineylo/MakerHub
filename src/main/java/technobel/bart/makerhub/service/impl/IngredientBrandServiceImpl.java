package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.entity.IngredientBrand;
import technobel.bart.makerhub.models.form.IngredientBrandForm;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.repository.IngredientBrandRepository;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.service.IngredientBrandService;

@Service
public class IngredientBrandServiceImpl implements IngredientBrandService {

    private final IngredientBrandRepository ingredientBrandRepository;
    private final IngredientRepository ingredientRepository;
    private final BrandRepository brandRepository;

    public IngredientBrandServiceImpl(IngredientBrandRepository ingredientBrandRepository, IngredientRepository ingredientRepository, BrandRepository brandRepository) {
        this.ingredientBrandRepository = ingredientBrandRepository;
        this.ingredientRepository = ingredientRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void create(IngredientBrandForm form) {
        IngredientBrand ingredientBrand = form.toEntity();

        ingredientBrand.setIngredient(
                ingredientRepository.findById(form.getIngredientId())
                        .orElseThrow(() -> new RuntimeException("Ingredient not found"))
        );

        ingredientBrand.setBrand(
                brandRepository.findById(form.getBrandId())
                        .orElseThrow(() -> new RuntimeException("Brand not found"))
        );

        ingredientBrandRepository.save(ingredientBrand);
    }
}
