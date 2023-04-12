package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.UnitOfMeasureDTO;
import technobel.bart.makerhub.repository.UnitOfMeasureRepository;
import technobel.bart.makerhub.service.UnitOfMeasureService;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public List<UnitOfMeasureDTO> getAll() {
        return unitOfMeasureRepository.findAll().stream()
                .map(UnitOfMeasureDTO::toDto)
                .toList();
    }
}
