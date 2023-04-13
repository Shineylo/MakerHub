package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.dto.ProductDTO;
import technobel.bart.makerhub.models.entity.Ingredient;
import technobel.bart.makerhub.models.entity.Product;
import technobel.bart.makerhub.models.entity.QuantityIngredient;
import technobel.bart.makerhub.models.form.ProductForm;
import technobel.bart.makerhub.repository.IngredientRepository;
import technobel.bart.makerhub.repository.ProductRepository;
import technobel.bart.makerhub.repository.QuantityIngredientRepository;
import technobel.bart.makerhub.service.ProductService;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final IngredientRepository ingredientRepository;
    private final ProductRepository productRepository;
    private final QuantityIngredientRepository quantityIngredientRepository;

    public ProductServiceImpl(IngredientRepository ingredientRepository, ProductRepository productRepository,
                              QuantityIngredientRepository quantityIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.productRepository = productRepository;
        this.quantityIngredientRepository = quantityIngredientRepository;
    }

    @Override
    public void create(ProductForm form) {
        Product product = form.toEntity();

        product = productRepository.save(product);

        Set<ProductForm.IngredientForm> ingForms = form.getIngredients();

        for (ProductForm.IngredientForm ingredient : ingForms ) {
            QuantityIngredient qttIng = new QuantityIngredient();

            Ingredient ing = ingredientRepository.findById( ingredient.getId() ).orElseThrow();

            qttIng.setQuantity(ingredient.getQuantity());
            qttIng.setProduct(product);
            qttIng.setIngredient(ing);

            product.getIngredients().add(qttIng);
        }

        quantityIngredientRepository.saveAll(product.getIngredients());

    }

    @Override
    public void delete(long id) {
        if(!productRepository.existsById(id))
            throw new RuntimeException("Product not found");

        productRepository.deleteById(id);
    }

    @Override
    public void update(long id, ProductForm form) {
        Product toUpdate = form.toEntity();

        toUpdate = productRepository.save(toUpdate);

        Set<ProductForm.IngredientForm> ingForms = form.getIngredients();

        for (ProductForm.IngredientForm ingredient : ingForms ) {
            QuantityIngredient qttIng = new QuantityIngredient();

            Ingredient ing = ingredientRepository.findById( ingredient.getId() ).orElseThrow();

            qttIng.setQuantity(ingredient.getQuantity());
            qttIng.setProduct(toUpdate);
            qttIng.setIngredient(ing);

            toUpdate.getIngredients().add(qttIng);
            quantityIngredientRepository.save(qttIng);
        }

        quantityIngredientRepository.saveAll(toUpdate.getIngredients());
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(ProductDTO::toDto)
                .toList();
    }

    @Override
    public ProductDTO getOne(long id) {
        return productRepository.findById(id)
                .map(ProductDTO::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
