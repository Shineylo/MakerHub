package technobel.bart.makerhub.models.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Ingredient;

import java.time.LocalDate;

@Data
public class IngredientForm {

    @NotBlank
    private String name;
    @Positive
    @Digits(integer = 2, fraction = 2)
    private double price;
    @NotBlank
    private String quantity;
    @NotBlank
    private LocalDate expiration;
    @NotBlank
    private String unitOfMeasure;
    @NotBlank
    private String brand;

    public Ingredient toEntity(){
        Ingredient ingredient = new Ingredient();

        ingredient.setName(this.name);
        ingredient.setPrice(this.price);
        ingredient.setExpiration(this.expiration);
        ingredient.setQuantity(this.quantity);

        return ingredient;
    }
}
