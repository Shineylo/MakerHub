package technobel.bart.makerhub.models.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.time.LocalDate;

@Data
public class IngredientNewBrandForm {

    @NotNull
    @Digits(integer = 2, fraction = 2)
    private double price;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDate expiration;
    @NotNull
    private Long ingredientId;
    @NotBlank
    private String brandName;

    public IngredientBrand toEntity(){
        IngredientBrand ingredientBrand = new IngredientBrand();

        ingredientBrand.setPrice(this.price);
        ingredientBrand.setQuantity(this.quantity);
        ingredientBrand.setExpiration(this.expiration);

        return ingredientBrand;
    }
}
