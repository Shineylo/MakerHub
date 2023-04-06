package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.Brand;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
public class BrandDTO {

    private Long id;
    private String name;
    private Set<IngredientDTO> ingredients = new LinkedHashSet<>();

    public static BrandDTO toDto(Brand entity){
        if( entity == null )
            return null;

        return new BrandDTO(
                entity.getId(),
                entity.getName(),
                entity.getIngredients().stream()
                        .map(IngredientDTO::toDto)
                        .collect(Collectors.toSet())
        );
    }
}
