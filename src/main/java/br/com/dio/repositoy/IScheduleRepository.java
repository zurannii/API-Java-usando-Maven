package br.com.dio.repositoy;


import br.com.dio.entidades.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long>{

    list<ScheduleEntity> FindByStartAtGreaterThanEqualAndEndAtLessThenEqualOrderByStartAtEndAt(
            final OffsetDateTime startAt,
            final OffsetDateTime endAt);

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt,
                                    final OffsetDateTime endAt);

    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(
            OffsetDateTime startAt,
            OffsetDateTime endAt);
}
