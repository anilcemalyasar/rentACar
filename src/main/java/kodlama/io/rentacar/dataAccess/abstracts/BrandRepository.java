package kodlama.io.rentacar.dataAccess.abstracts;

import java.util.List;

import kodlama.io.rentacar.entities.concretes.Brand;

public interface BrandRepository {
    
    List<Brand> getAllBrands();
}
