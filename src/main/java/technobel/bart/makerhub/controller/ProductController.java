package technobel.bart.makerhub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.ProductDTO;
import technobel.bart.makerhub.models.form.ProductForm;
import technobel.bart.makerhub.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService ProductService) {
        this.productService = ProductService;
    }

    @PostMapping("/new")
    public void newProduct(@RequestBody @Valid ProductForm form){
        productService.create(form);
    }

    @GetMapping("/all")
    public List<ProductDTO> displayAll(){
        List<ProductDTO> products = productService.getAll();
        return products;
    }

    @GetMapping("/{id:[0-9]+}")
    public ProductDTO displayProductDetails(@PathVariable long id) {
        return productService.getOne(id);
    }

    @PostMapping("/{id:[0-9]+}/update")
    public void updateProduct(@PathVariable long id, @RequestBody @Valid ProductForm form){
        productService.update(id,form);
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteProduct(@PathVariable long id){
        productService.delete(id);
        return "redirect:/product/all";
    }
}
