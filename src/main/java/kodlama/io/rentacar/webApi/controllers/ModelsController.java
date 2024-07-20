package kodlama.io.rentacar.webApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.requests.CreateModelRequest;
import kodlama.io.rentacar.business.responses.GetAllModelsResponse;
import kodlama.io.rentacar.business.responses.GetModelByIdResponse;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    
    private ModelService modelService;

    @GetMapping("")
    public List<GetAllModelsResponse> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public GetModelByIdResponse getModelById(@PathVariable int id) {
        return modelService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addModel(@RequestBody @Valid CreateModelRequest createModelRequest) {
        modelService.addModel(createModelRequest);
    }
    
    
    


}
