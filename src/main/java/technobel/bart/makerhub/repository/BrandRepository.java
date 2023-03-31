package technobel.bart.makerhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.bart.makerhub.models.entity.Brand;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Long> {

    Optional<Brand> findByName(String brand);
}
