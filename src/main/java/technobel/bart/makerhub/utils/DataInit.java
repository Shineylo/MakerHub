package technobel.bart.makerhub.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.IngredientBrand;
import technobel.bart.makerhub.models.entity.UnitOfMeasure;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.repository.IngredientBrandRepository;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.repository.UnitOfMeasureRepository;

import java.time.LocalDate;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final IngredientRepository classroomRepository;
    private final BrandRepository brandRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientBrandRepository ingredientBrandRepository;
    public DataInit(IngredientRepository classroomRepository, BrandRepository brandRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientBrandRepository ingredientBrandRepository) {

        this.classroomRepository = classroomRepository;
        this.brandRepository = brandRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientBrandRepository = ingredientBrandRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-- INITIALIZING DB DATA --");

        Brand b1 = new Brand();

        b1.setName("Delhaize");

        UnitOfMeasure kilo = new UnitOfMeasure();

        b1= brandRepository.save(b1);

        kilo.setName("Kilo");
        kilo = unitOfMeasureRepository.save(kilo);

        UnitOfMeasure piece = new UnitOfMeasure();
        piece.setName("Pièce");
        piece = unitOfMeasureRepository.save(piece);

        Ingredient i1 = new Ingredient();

        i1.setName("Sel");
        i1.setUnitOfMeasure(kilo);

        i1 = classroomRepository.save(i1);

        Ingredient i2 = new Ingredient();

        i2.setName("Farine");
        i2.setUnitOfMeasure(kilo);

        i2 = classroomRepository.save(i2);

        Ingredient i3 = new Ingredient();

        i3.setName("Oeuf");
        i3.setUnitOfMeasure(piece);

        i3 = classroomRepository.save(i3);

        /*IngredientBrand ib1 = new IngredientBrand();

        ib1.setBrand(b1);
        ib1.setIngredient(i1);
        ib1.setPrice(1.01);
        ib1.setQuantity(5);
        ib1.setExpiration(LocalDate.now());

        ib1 = ingredientBrandRepository.save(ib1);*/

    }

}