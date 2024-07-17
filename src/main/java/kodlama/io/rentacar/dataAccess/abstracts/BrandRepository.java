package kodlama.io.rentacar.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.rentacar.entities.concretes.Brand;

@Repository
public interface BrandRepository {
    
    List<Brand> getAllBrands();
}
