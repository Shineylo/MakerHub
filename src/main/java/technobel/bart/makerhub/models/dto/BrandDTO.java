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

    public static BrandDTO toDto(Brand entity){
        if( entity == null )
            return null;

        return new BrandDTO(
                entity.getId(),
                entity.getName()
        );
    }

}
