package technobel.bart.makerhub.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.repository.UnitOfMeasureRepository;

import java.time.LocalDate;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final IngredientRepository classroomRepository;

    private final BrandRepository brandRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    public DataInit(IngredientRepository classroomRepository, BrandRepository brandRepository, UnitOfMeasureRepository unitOfMeasureRepository) {

        this.classroomRepository = classroomRepository;
        this.brandRepository = brandRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-- INITIALIZING DB DATA --");

        Brand b1 = new Brand();

        b1.setName("Delhaize");

        UnitOfMeasure kilo = new UnitOfMeasure();

        b1= brandRepository.save(b1);

        kilo.setName("Kilo");

        Ingredient i1 = new Ingredient();

        kilo = unitOfMeasureRepository.save(kilo);

        i1.setName("Sel");
        i1.setQuantity("100");
        i1.setPrice(10.01);
        i1.setExpiration(LocalDate.parse("2030-12-12"));
        i1.setUnitOfMeasure(kilo);
        i1.setBrand(b1);

        i1 = classroomRepository.save(i1);
    }

}