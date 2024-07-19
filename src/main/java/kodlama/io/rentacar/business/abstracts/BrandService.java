package kodlama.io.rentacar.business.abstracts;

import java.util.List;

import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.business.responses.GetBrandByIdResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAllBrands();
    GetBrandByIdResponse getById(int id);
    void addBrand(CreateBrandRequest createBrandRequest);
    void updateBrand(UpdateBrandRequest updateBrandRequest);
    void deleteBrand(int id);
}
