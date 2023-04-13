package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.IngredientBrand;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;
    private Set<IngredientBrandDTO> ingredients;
    private UnitOfMeasureDTO unitOfMeasure;

    public static IngredientDTO toDto(Ingredient entity){

        if(entity == null)
            return null;

        return new IngredientDTO(
                entity.getId(),
                entity.getName(),
                entity.getIngredients().stream()
                        .map(IngredientBrandDTO::toDto)
                        .collect(Collectors.toSet()),
                UnitOfMeasureDTO.toDto(entity.getUnitOfMeasure())
        );
    }
}
