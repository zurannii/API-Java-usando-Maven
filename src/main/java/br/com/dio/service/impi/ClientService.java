package br.com.dio.service.impi;
import br.com.dio.entidades.ClientEntity;
import br.com.dio.repositoy.IClientRepository;
import br.com.dio.service.IClientService;
import br.com.dio.service.query.IClientQueryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private final IClientQueryService queryService;


    // Construtor que será usado pelo Spring para injetar as dependências
    @Autowired
    public ClientService(IClientRepository repository, IClientQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }


    public IClientRepository getRepository() {
        return repository;
    }

    public IClientQueryService getQueryService() {
        return queryService;
    }

    @Override
    public ClientEntity save(ClientEntity entity) {
        queryService.verifyEmail(entity.getEmail());
        queryService.verifyPhone(entity.getPhone());

        return repository.save(entity);
    }

    @Override
    public ClientEntity update(ClientEntity entity) {
        queryService.verifyEmail(entity.getId(), entity.getEmail());
        queryService.verifyPhone(entity.getId(), entity.getPhone());

        var stored = queryService.findById(entity.getId());
        stored.setName(entity.getName());
        stored.setPhone(entity.getPhone());
        stored.setEmail(entity.getEmail());
        return repository.save(stored);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
