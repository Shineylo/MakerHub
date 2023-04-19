package technobel.bart.makerhub.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.makerhub.models.dto.BrandDTO;
import technobel.bart.makerhub.models.entity.Brand;
import technobel.bart.makerhub.repository.BrandRepository;
import technobel.bart.makerhub.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(String name) {
        Brand brand = new Brand();

        brand.setName(name);

        return brandRepository.save(brand);
    }

    @Override
    public List<BrandDTO> getAll() {
        return brandRepository.findAll().stream()
                .map(BrandDTO::toDto)
                .toList();
    }
}
