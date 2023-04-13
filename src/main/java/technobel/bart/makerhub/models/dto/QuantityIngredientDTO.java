package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.Product;
import technobel.bart.makerhub.models.entity.QuantityIngredient;

@Builder
@Data
public class QuantityIngredientDTO {
    private Product product;
    private Ingredient ingredient;
    private int quantity = 1;

    public static QuantityIngredientDTO toDto(QuantityIngredient entity){
        if(entity == null)
            return null;

        return new QuantityIngredientDTO(
                entity.getProduct(),
                entity.getIngredient(),
                entity.getQuantity()
        );
    }

}
