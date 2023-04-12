package technobel.bart.makerhub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technobel.bart.makerhub.models.dto.UnitOfMeasureDTO;
import technobel.bart.makerhub.service.UnitOfMeasureService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/unitofmeasure")
public class UnitOfMeasureController {
    private final UnitOfMeasureService unitOfMeasureService;

    public UnitOfMeasureController(UnitOfMeasureService unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/all")
    public List<UnitOfMeasureDTO> displayAll(){
        return unitOfMeasureService.getAll();
    }
}
