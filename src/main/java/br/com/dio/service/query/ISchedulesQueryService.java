package br.com.dio.service.query;

import br.com.dio.entidades.ScheduleEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

public interface ISchedulesQueryService {

    ScheduleEntity findById(final long id);

    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);

}