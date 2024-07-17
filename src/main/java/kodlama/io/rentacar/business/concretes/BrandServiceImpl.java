package kodlama.io.rentacar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentacar.entities.concretes.Brand;


@Service
public class BrandServiceImpl implements BrandService {
    
    BrandRepository brandRepository;
    
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;    
    }


    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.getAllBrands();
    }
    

}
