package br.com.dio.service.impi;

import  br.com.dio.entidades.ScheduleEntity;
import br.com.dio.repositoy.IScheduleRepository;
import br.com.dio.service.ISchedulesService;
import br.com.dio.service.query.ISchedulesQueryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service

public class ScheduleService implements ISchedulesService {

    private final IScheduleRepository repository;
    private final ISchedulesQueryService queryService;

    // Construtor que o Spring usará para injetar as dependências
    @Autowired
    public ScheduleService(IScheduleRepository repository, ISchedulesQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());
        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);

    }

}
