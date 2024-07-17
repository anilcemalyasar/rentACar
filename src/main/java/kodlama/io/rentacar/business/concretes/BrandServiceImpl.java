package kodlama.io.rentacar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentacar.entities.concretes.Brand;


@Service
public class BrandServiceImpl implements BrandService {
    
    BrandRepository brandRepository;
    
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;    
    }


    @Override
    public List<GetAllBrandsResponse> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }
        
        return brandsResponse;
    }
    

}
