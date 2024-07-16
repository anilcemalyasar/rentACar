package kodlama.io.rentacar.business.abstracts;

import java.util.List;

import kodlama.io.rentacar.entities.concretes.Brand;

public interface BrandService {
    List<Brand> getAllBrands();
}
