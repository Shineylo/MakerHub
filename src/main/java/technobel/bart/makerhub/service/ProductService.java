package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.ProductDTO;
import technobel.bart.makerhub.models.form.ProductForm;

import java.util.List;

public interface ProductService {
    void create(ProductForm form);

    void delete(long productId);

    void update(long id, ProductForm form);

    List<ProductDTO> getAll();

    ProductDTO getOne(long productId);
}
