package pl.pjatk.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.timetable.model.Bus;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

//    @Query("select b from Bus b where b.road.name=:name")
//    Optional<Bus> findBusByRoadName(String name);

}
