package technobel.bart.makerhub.controller;

import org.springframework.web.bind.annotation.*;
import technobel.bart.makerhub.models.dto.BrandDTO;
import technobel.bart.makerhub.service.BrandService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public List<BrandDTO> displayAll(){
        return brandService.getAll();
    }
}
