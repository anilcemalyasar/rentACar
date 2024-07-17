package kodlama.io.rentacar.webApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    
    @GetMapping("")
    public List<GetAllBrandsResponse> getAllBrands() {
        return brandService.getAllBrands();
    }
    
    

}
