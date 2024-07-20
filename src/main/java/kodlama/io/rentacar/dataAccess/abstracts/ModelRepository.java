package kodlama.io.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentacar.entities.concretes.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    
}
