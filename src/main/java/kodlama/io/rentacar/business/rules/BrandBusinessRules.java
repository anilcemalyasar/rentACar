package kodlama.io.rentacar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentacar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if(brandRepository.existsByName(name)) {
            throw new BusinessException("Brand already exists");
        }
    }

}
