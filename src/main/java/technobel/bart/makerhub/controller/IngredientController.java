package technobel.bart.makerhub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.IngredientDTO;
import technobel.bart.makerhub.models.form.IngredientForm;
import technobel.bart.makerhub.service.IngredientService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
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
    public IngredientDTO displayIngredientDetails(@PathVariable long id) {
        return ingredientService.getOne(id);
    }

    @PostMapping("/{id:[0-9]+}/update")
    public void updateIngredient(@PathVariable long id, @RequestBody @Valid IngredientForm form){
        ingredientService.update(id,form);
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteIngredient(@PathVariable long id){
        ingredientService.delete(id);
        return "redirect:/ingredient/all";
    }

}
