package kodlama.io.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentacar.entities.concretes.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    
}
