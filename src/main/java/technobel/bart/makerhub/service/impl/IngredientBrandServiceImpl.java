package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.IngredientBrandDTO;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.IngredientBrand;
import technobel.bart.makerhub.models.form.IngredientExistingBrandForm;
import technobel.bart.makerhub.models.form.IngredientNewBrandForm;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.repository.IngredientBrandRepository;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.service.BrandService;
import technobel.bart.makerhub.service.IngredientBrandService;

import java.util.List;

@Service
public class IngredientBrandServiceImpl implements IngredientBrandService {

    private final IngredientBrandRepository ingredientBrandRepository;
    private final IngredientRepository ingredientRepository;
    private final BrandRepository brandRepository;
    private final BrandService brandService;

    public IngredientBrandServiceImpl(IngredientBrandRepository ingredientBrandRepository, IngredientRepository ingredientRepository, BrandRepository brandRepository, BrandService brandService) {
        this.ingredientBrandRepository = ingredientBrandRepository;
        this.ingredientRepository = ingredientRepository;
        this.brandRepository = brandRepository;
        this.brandService = brandService;
    }

    @Override
    public void createWithExistingBrand(IngredientExistingBrandForm form) {
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

    @Override
    public void createWithNewBrand(IngredientNewBrandForm form) {
        Brand brand = brandService.create(form.getBrandName());

        IngredientBrand ingredientBrand = form.toEntity();

        ingredientBrand.setBrand(brand);


        ingredientBrand.setIngredient(
                ingredientRepository.findById(form.getIngredientId())
                        .orElseThrow(() -> new RuntimeException("Ingredient not found"))
        );



        ingredientBrandRepository.save(ingredientBrand);
    }

    @Override
    public List<IngredientBrandDTO> getAllOfOneIngredient(long id){
        return ingredientBrandRepository.findAllByIngredientId(id).stream()
                .map(IngredientBrandDTO::toDto)
                .toList();
    }


    @Override
    public void delete(long ingId, long brandId) {
        if(!ingredientBrandRepository.existsByBrand_IdAndIngredient_Id(brandId,ingId))
            throw new RuntimeException("Ingredient not found");

        ingredientBrandRepository.deleteByBrand_IdAndIngredient_Id(brandId,ingId);
    }
}
