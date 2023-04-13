package technobel.bart.makerhub.models.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Ingredient;

import java.time.LocalDate;

@Data
public class IngredientForm {

    @NotBlank
    private String name;
    @NotNull
    private Long unitOfMeasureId;


    public Ingredient toEntity(){
        Ingredient ingredient = new Ingredient();

        ingredient.setName(this.name);

        return ingredient;
    }
}
