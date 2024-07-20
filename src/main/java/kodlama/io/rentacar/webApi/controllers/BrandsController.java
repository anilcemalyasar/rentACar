package kodlama.io.rentacar.webApi.controllers;

import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;

import org.springframework.web.bind.annotation.*;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.business.responses.GetBrandByIdResponse;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    
    private BrandService brandService;
    
    @GetMapping("")
    public List<GetAllBrandsResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest) {
        brandService.addBrand(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getById(@PathVariable("id") int id) {
        return brandService.getById(id);
    }
    
    @PutMapping("")
    public void updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest) {
        brandService.updateBrand(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
    }
    

}
