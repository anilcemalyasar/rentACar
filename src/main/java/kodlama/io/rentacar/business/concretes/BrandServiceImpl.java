package kodlama.io.rentacar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;

import org.springframework.stereotype.Service;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.business.responses.GetBrandByIdResponse;
import kodlama.io.rentacar.business.rules.BrandBusinessRules;
import kodlama.io.rentacar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    
    BrandRepository brandRepository;
    ModelMapperService modelMapperService;
    BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                                                        .map(brand -> this.modelMapperService.forResponse()
                                                        .map(brand, GetAllBrandsResponse.class))
                                                        .collect(Collectors.toList());
        
        return brandsResponse;
    }

    @Override
    public void addBrand(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest()
                                            .map(createBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public GetBrandByIdResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        return this.modelMapperService
                .forResponse()
                .map(brand, GetBrandByIdResponse.class);
    }

    @Override
    public void updateBrand(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }


}
