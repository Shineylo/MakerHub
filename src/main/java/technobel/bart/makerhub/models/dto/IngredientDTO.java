package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;
    private double price;
    private String quantity;
    private LocalDate expiration;
    private UnitOfMeasureDTO unitOfMeasure;
    private BrandDTO brand;



    public static IngredientDTO toDto(Ingredient entity){

        if(entity == null)
            return null;

        return new IngredientDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getExpiration(),
                UnitOfMeasureDTO.toDto(entity.getUnitOfMeasure()),
                BrandDTO.toDto(entity.getBrand())
        );
    }

    @Data
    @Builder
    private static class BrandDTO{
        private Long id;
        private String name;

        public static BrandDTO toDto(Brand entity){
            if( entity == null )
                return null;

            return new BrandDTO(
                    entity.getId(),
                    entity.getName()
            );
        }
    }
}
