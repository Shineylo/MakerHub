package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Product;
import technobel.bart.makerhub.models.entity.QuantityIngredient;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String Recipe;
    private Set<QuantityIngredientDTO> ingredients;

    public static ProductDTO toDto(Product entity){
        if(entity == null)
            return null;

        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getRecipe(),
                entity.getIngredients().stream()
                        .map(QuantityIngredientDTO::toDto)
                        .collect(Collectors.toSet())
        );
    }
}
