package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;
import technobel.bart.makerhub.models.form.IngredientForm;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.repository.UnitOfMeasureRepository;
import technobel.bart.makerhub.service.IngredientService;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,  IngredientRepository ingredientRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void create(IngredientForm form) {
        Ingredient ingredient = form.toEntity();

        ingredient.setUnitOfMeasure(
                unitOfMeasureRepository.findById(form.getUnitOfMeasureId())
                        .orElseThrow(() -> new RuntimeException("Unit of Measure not found"))
        );


        ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(long id) {
        if(!ingredientRepository.existsById(id))
            throw new RuntimeException("Ingredient not found");

        ingredientRepository.deleteById(id);
    }

    @Override
    public void update(long id, IngredientForm form) {
        Ingredient toUpdate = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        toUpdate = form.toEntity();

        toUpdate.setUnitOfMeasure(
                unitOfMeasureRepository.findById(form.getUnitOfMeasureId())
                        .orElseThrow(() -> new RuntimeException("Unit of Measure not found"))
        );


        ingredientRepository.save(toUpdate);
    }

    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(IngredientDTO::toDto)
                .toList();
    }

    @Override
    public IngredientDTO getOne(long id) {
        return ingredientRepository.findById(id)
                .map(IngredientDTO::toDto)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

}
