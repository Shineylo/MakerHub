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

        b1= brandRepository.save(b1);

        UnitOfMeasure kilo = new UnitOfMeasure();

        kilo.setName("Kilo");

        kilo = unitOfMeasureRepository.save(kilo);

        UnitOfMeasure piece = new UnitOfMeasure();

        piece.setName("Pièce");

        piece = unitOfMeasureRepository.save(piece);

        UnitOfMeasure liter = new UnitOfMeasure();

        liter.setName("Litre");

        liter = unitOfMeasureRepository.save(liter);

        Ingredient i1 = new Ingredient();

        i1.setName("Sel");
        i1.setQuantity("100");
        i1.setPrice(2.35);
        i1.setExpiration(LocalDate.parse("2030-12-12"));
        i1.setUnitOfMeasure(kilo);
        i1.setBrand(b1);

        i1 = classroomRepository.save(i1);

        Ingredient i2 = new Ingredient();

        i2.setName("Farine");
        i2.setQuantity("5");
        i2.setPrice(.59);
        i2.setExpiration(LocalDate.parse("2030-11-12"));
        i2.setUnitOfMeasure(kilo);
        i2.setBrand(b1);

        i2 = classroomRepository.save(i2);

        Ingredient i3 = new Ingredient();

        i3.setName("Oeuf");
        i3.setQuantity("24");
        i3.setPrice(.40);
        i3.setExpiration(LocalDate.parse("2030-12-02"));
        i3.setUnitOfMeasure(piece);
        i3.setBrand(b1);

        i3 = classroomRepository.save(i3);

        Ingredient i4 = new Ingredient();

        i4.setName("Sucre");
        i4.setQuantity("6");
        i4.setPrice(1.15);
        i4.setExpiration(LocalDate.parse("2030-12-02"));
        i4.setUnitOfMeasure(kilo);
        i4.setBrand(b1);

        i4 = classroomRepository.save(i4);

        Ingredient i5 = new Ingredient();

        i5.setName("lait");
        i5.setQuantity("5");
        i5.setPrice(1.08);
        i5.setExpiration(LocalDate.parse("2023-08-02"));
        i5.setUnitOfMeasure(liter);
        i5.setBrand(b1);

        i5 = classroomRepository.save(i5);

        Ingredient i6 = new Ingredient();

        i6.setName("Oeuf");
        i6.setQuantity("5");
        i6.setPrice(1.01);
        i6.setExpiration(LocalDate.parse("2030-12-02"));
        i6.setUnitOfMeasure(kilo);
        i6.setBrand(b1);

        i6 = classroomRepository.save(i6);

        Ingredient i7 = new Ingredient();

        i7.setName("Oeuf");
        i7.setQuantity("5");
        i7.setPrice(1.01);
        i7.setExpiration(LocalDate.parse("2030-12-02"));
        i7.setUnitOfMeasure(kilo);
        i7.setBrand(b1);

        i7 = classroomRepository.save(i7);

        Ingredient i8 = new Ingredient();

        i8.setName("Oeuf");
        i8.setQuantity("5");
        i8.setPrice(1.01);
        i8.setExpiration(LocalDate.parse("2030-12-02"));
        i8.setUnitOfMeasure(kilo);
        i8.setBrand(b1);

        i8 = classroomRepository.save(i8);

        Ingredient i9 = new Ingredient();

        i9.setName("Oeuf");
        i9.setQuantity("5");
        i9.setPrice(1.01);
        i9.setExpiration(LocalDate.parse("2030-12-02"));
        i9.setUnitOfMeasure(kilo);
        i9.setBrand(b1);

        i9 = classroomRepository.save(i9);

        Ingredient i10 = new Ingredient();

        i10.setName("Oeuf");
        i10.setQuantity("5");
        i10.setPrice(1.01);
        i10.setExpiration(LocalDate.parse("2030-12-02"));
        i10.setUnitOfMeasure(kilo);
        i10.setBrand(b1);

        i10 = classroomRepository.save(i10);

        Ingredient i11 = new Ingredient();

        i11.setName("Oeuf");
        i11.setQuantity("5");
        i11.setPrice(1.01);
        i11.setExpiration(LocalDate.parse("2030-12-02"));
        i11.setUnitOfMeasure(kilo);
        i11.setBrand(b1);

        i11 = classroomRepository.save(i11);

        Ingredient i12 = new Ingredient();

        i12.setName("Oeuf");
        i12.setQuantity("5");
        i12.setPrice(1.01);
        i12.setExpiration(LocalDate.parse("2030-12-02"));
        i12.setUnitOfMeasure(kilo);
        i12.setBrand(b1);

        i12 = classroomRepository.save(i12);

        Ingredient i13 = new Ingredient();

        i13.setName("Oeuf");
        i13.setQuantity("5");
        i13.setPrice(1.01);
        i13.setExpiration(LocalDate.parse("2030-12-02"));
        i13.setUnitOfMeasure(kilo);
        i13.setBrand(b1);

        i13 = classroomRepository.save(i13);

        Ingredient i14 = new Ingredient();

        i14.setName("Oeuf");
        i14.setQuantity("5");
        i14.setPrice(1.01);
        i14.setExpiration(LocalDate.parse("2030-12-02"));
        i14.setUnitOfMeasure(kilo);
        i14.setBrand(b1);

        i14 = classroomRepository.save(i14);

        Ingredient i15 = new Ingredient();

        i15.setName("Oeuf");
        i15.setQuantity("5");
        i15.setPrice(1.01);
        i15.setExpiration(LocalDate.parse("2030-12-02"));
        i15.setUnitOfMeasure(kilo);
        i15.setBrand(b1);

        i15 = classroomRepository.save(i15);
    }

}