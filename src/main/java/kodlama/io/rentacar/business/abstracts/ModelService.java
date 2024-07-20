package kodlama.io.rentacar.business.abstracts;

import java.util.List;

import kodlama.io.rentacar.business.requests.CreateModelRequest;
import kodlama.io.rentacar.business.responses.GetAllModelsResponse;
import kodlama.io.rentacar.business.responses.GetModelByIdResponse;

public interface ModelService {
    
    List<GetAllModelsResponse> getAllModels();
    GetModelByIdResponse getById(int id);
    void addModel(CreateModelRequest createModelRequest);
}
