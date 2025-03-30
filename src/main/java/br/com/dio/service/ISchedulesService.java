package br.com.dio.service;

import br.com.dio.entidades.ScheduleEntity;

import java.time.OffsetDateTime;

public interface ISchedulesService {

    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);

}