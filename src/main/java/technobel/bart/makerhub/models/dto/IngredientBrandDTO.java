package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.IngredientBrand;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class IngredientBrandDTO {

    static class IngredientDTO {
        private Long id;
        private String name;
        private UnitOfMeasureDTO unitOfMeasure;

        public IngredientDTO(Long id, String name, UnitOfMeasureDTO unitOfMeasure) {
            this.id = id;
            this.name = name;
            this.unitOfMeasure = unitOfMeasure;
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

        public UnitOfMeasureDTO getUnitOfMeasure() {
            return unitOfMeasure;
        }

        public void setUnitOfMeasure(UnitOfMeasureDTO unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
        }
    }

    private IngredientDTO ingredient;
    private Brand brand;
    private double price;
    private double quantity;
    private LocalDate expiration;

    public static IngredientBrandDTO toDto(IngredientBrand entity){
        if(entity == null)
            return null;

        return new IngredientBrandDTO(
                new IngredientDTO(
                        entity.getIngredient().getId(),
                        entity.getIngredient().getName(),
                        new UnitOfMeasureDTO(entity.getIngredient().getUnitOfMeasure().getId(),
                                entity.getIngredient().getUnitOfMeasure().getName())),
                entity.getBrand(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getExpiration()
        );
    }

}
