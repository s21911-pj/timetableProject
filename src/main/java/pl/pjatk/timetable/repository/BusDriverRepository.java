package pl.pjatk.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.timetable.model.BusDriver;

@Repository
public interface BusDriverRepository extends JpaRepository<BusDriver,Long> {
}
