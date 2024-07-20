package kodlama.io.rentacar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.requests.CreateModelRequest;
import kodlama.io.rentacar.business.responses.GetAllModelsResponse;
import kodlama.io.rentacar.business.responses.GetModelByIdResponse;
import kodlama.io.rentacar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentacar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService mapperService;

    @Override
    public List<GetAllModelsResponse> getAllModels() {
        return modelRepository.findAll()
                .stream()
                .map(model -> mapperService.forResponse().map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetModelByIdResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        return mapperService.forResponse().map(model, GetModelByIdResponse.class);
    }

    @Override
    public void addModel(CreateModelRequest createModelRequest) {
        Model model = mapperService.forRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }
    
}
