package pl.pjatk.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.timetable.model.Road;

@Repository
public interface RoadRepository extends JpaRepository<Road,Long> {

}
