package technobel.bart.makerhub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.IngredientBrandDTO;
import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.form.IngredientForm;
import technobel.bart.makerhub.service.IngredientBrandService;
import technobel.bart.makerhub.service.IngredientService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientBrandService ingredientBrandService;

    public IngredientController(IngredientService ingredientService, IngredientBrandService ingredientBrandService) {
        this.ingredientService = ingredientService;
        this.ingredientBrandService = ingredientBrandService;
    }

    @PostMapping("/new")
    public void newIngredient(@RequestBody @Valid IngredientForm form){
        ingredientService.create(form);
    }

    @GetMapping("/all")
    public List<IngredientDTO> displayAll(){
        return ingredientService.getAll();
    }

    @GetMapping("/{id:[0-9]+}")
    public List<IngredientBrandDTO> displayAllOfIngredient(@PathVariable long id) {
        return ingredientBrandService.getAllOfOneIngredient(id);
    }


    @PostMapping("/{id:[0-9]+}/delete")
    public void deleteIngredient(@PathVariable long id){
        ingredientService.delete(id);
    }

}
