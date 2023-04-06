package technobel.bart.makerhub.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
public class UnitOfMeasureDTO {

    private Long id;
    private String name;

    public static UnitOfMeasureDTO toDto(UnitOfMeasure entity){
        if( entity == null )
            return null;

        return new UnitOfMeasureDTO(
                entity.getId(),
                entity.getName()
        );
    }
}
