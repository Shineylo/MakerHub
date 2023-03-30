package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;
    private double price;
    private String quantity;
    private UnitOfMeasure unitOfMeasure;
    private Brand brand;

    public static IngredientDTO toDto(Ingredient entity){
        if(entity == null)
            return null;

        return new IngredientDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getUnitOfMeasure(),
                entity.getBrand()
        );
    }
}
