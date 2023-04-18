package technobel.bart.makerhub.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.bart.makerhub.models.entity.*;
import technobel.bart.makerhub.models.entity.users.Owner;
import technobel.bart.makerhub.repository.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final IngredientRepository classroomRepository;
    private final BrandRepository brandRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientBrandRepository ingredientBrandRepository;
    private final QuantityIngredientRepository quantityIngredientRepository;
    private final PasswordEncoder encoder;
    public DataInit(IngredientRepository classroomRepository, BrandRepository brandRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientBrandRepository ingredientBrandRepository, QuantityIngredientRepository quantityIngredientRepository,
                    ProductRepository productRepository, PasswordEncoder encoder,
                    UserRepository userRepository) {

        this.classroomRepository = classroomRepository;
        this.brandRepository = brandRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientBrandRepository = ingredientBrandRepository;
        this.quantityIngredientRepository = quantityIngredientRepository;
        this.productRepository = productRepository;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-- INITIALIZING DB DATA --");

        Owner o1 = new Owner();

        o1.setLogin("PaulineA");
        o1.setPassword(encoder.encode("test123"));

        o1 = userRepository.save(o1);

        Brand b1 = new Brand();

        b1.setName("Delhaize");

        UnitOfMeasure kilo = new UnitOfMeasure();

        b1= brandRepository.save(b1);

        kilo.setName("Kg");
        kilo = unitOfMeasureRepository.save(kilo);

        UnitOfMeasure piece = new UnitOfMeasure();
        piece.setName("Pièce");
        piece = unitOfMeasureRepository.save(piece);

        UnitOfMeasure liter = new UnitOfMeasure();
        liter.setName("L");
        liter = unitOfMeasureRepository.save(liter);

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

        IngredientBrand ib1 = new IngredientBrand();

        ib1.setBrand(b1);
        ib1.setIngredient(i1);
        ib1.setPrice(1.01);
        ib1.setQuantity(5.970);
        ib1.setExpiration(LocalDate.now());

        ib1 = ingredientBrandRepository.save(ib1);


        Product p1 = new Product();

        p1.setName("test");
        p1.setRecipe("Jeparle");
        Set<QuantityIngredient> set = new HashSet<>();
        p1 = productRepository.save(p1);

        QuantityIngredient qi1 = new QuantityIngredient();
        qi1.setQuantity(0.500);
        qi1.setIngredient(i1);
        qi1.setProduct(p1);

        qi1 = quantityIngredientRepository.save(qi1);

        set.add(qi1);
        p1.setIngredients(set);

        p1 = productRepository.save(p1);
    }

}