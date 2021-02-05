package pl.pjatk.timetable.service;


import org.springframework.stereotype.Service;
import pl.pjatk.timetable.exception.TimetableExceptions;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.repository.BusDriverRepository;


import java.util.List;


@Service
public class BusDriverService {


    private final BusDriverRepository busDriverRepository;

    public BusDriverService(BusDriverRepository busDriverRepository) {
        this.busDriverRepository = busDriverRepository;
    }

    public List<BusDriver> findAll(){return busDriverRepository.findAll();}


    public BusDriver findById(Long id){
        return busDriverRepository.findById(id).orElseThrow(()->new TimetableExceptions(id));

    }
    public BusDriver addNewDriver(BusDriver busDriver ) {

        return busDriverRepository.save(busDriver);
    }

    public boolean checkDriver(Bus bus, BusDriver busDriver){
        if (busDriver == null){
            return bus.isBusActive();
        }
        return false;
    }

//    public Bus getDriver(Bus bus, BusDriver busDriver){
//        if (busDriver == null){
//
//        }
//        return ;
//    }

}


