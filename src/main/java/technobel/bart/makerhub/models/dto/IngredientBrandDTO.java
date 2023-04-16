package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.time.LocalDate;

@Builder
@Data
public class IngredientBrandDTO {
    private Ingredient ingredient;
    private Brand brand;
    private double price;
    private int quantity;
    private LocalDate expiration;

    public static IngredientBrandDTO toDto(IngredientBrand entity){
        if(entity == null)
            return null;

        return new IngredientBrandDTO(
                entity.getIngredient(),
                entity.getBrand(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getExpiration()
        );
    }

}
