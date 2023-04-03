package technobel.bart.makerhub.models.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Product;
import java.util.Set;

@Data
public class ProductForm {

    @NotBlank
    private String name;
    @NotBlank
    private String recipe;
    private Set<IngredientForm> ingredients;

    public Product toEntity(){
        Product product = new Product();

        product.setName(name);
        product.setRecipe(recipe);

        return product;
    }

    @Data
    public static class IngredientForm {
        private Long id;
        private int quantity;
    }
}
