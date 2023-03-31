package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure,Long> {
    Optional<UnitOfMeasure> findByName(String unitOfMeasure);
}
