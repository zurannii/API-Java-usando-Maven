package br.com.dio.repositoy;


import br.com.dio.entidades.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface ISchedulesRepository {

    list<ScheduleEntity> FindByStartAtGreaterThanEqualAndEndAtLessThenEqualOrderByStartAtEndAt(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt);

    boolean existsStartAtAndEndAt(final OffsetDateTime startAt,
                                  final OffsetDateTime endAt);

    <T> ScopedValue<T> findById(long id);
}
