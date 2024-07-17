package kodlama.io.rentacar.business.abstracts;

import java.util.List;

import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAllBrands();
}
