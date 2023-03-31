package technobel.bart.makerhub.service;

import technobel.bart.makerhub.models.dto.productDTO;
import technobel.bart.makerhub.models.form.productForm;

import java.util.List;

public interface ProductService {

    void create(ProductForm form);

    void delete(long productId);

    void update(long id, ProductForm form);

    List<ProductDTO> getAll();

    ProductDTO getOne(long productId);
}
