package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.QuantityIngredient;

import java.util.stream.Collectors;

@Builder
@Data
public class QuantityIngredientDTO {





    static class ProductDTO{
        private Long id;
        private String name;
        private String Recipe;

        public ProductDTO(Long id, String name, String recipe) {
            this.id = id;
            this.name = name;
            Recipe = recipe;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecipe() {
            return Recipe;
        }

        public void setRecipe(String recipe) {
            Recipe = recipe;
        }
    }

    private ProductDTO product;
    private IngredientDTO ingredient;
    private double quantity ;

    public static QuantityIngredientDTO toDto(QuantityIngredient entity){
        if(entity == null)
            return null;

        return new QuantityIngredientDTO(
                new ProductDTO(
                        entity.getProduct().getId(),
                        entity.getProduct().getName(),
                        entity.getProduct().getRecipe()
                ),
                new IngredientDTO(
                        entity.getIngredient().getId(),
                        entity.getIngredient().getName(),
                        entity.getIngredient().getIngredients().stream()
                                .map(IngredientBrandDTO::toDto)
                                .collect(Collectors.toSet()),
                        UnitOfMeasureDTO.toDto(entity.getIngredient().getUnitOfMeasure())
                ),
                entity.getQuantity()
        );
    }

}
