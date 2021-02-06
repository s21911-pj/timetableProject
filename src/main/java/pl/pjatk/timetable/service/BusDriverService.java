package pl.pjatk.timetable.service;


import org.springframework.stereotype.Service;
import pl.pjatk.timetable.exception.BadException;
import pl.pjatk.timetable.exception.TimetableExceptions;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.repository.BusDriverRepository;
import pl.pjatk.timetable.repository.BusRepository;


import java.util.List;


@Service
public class BusDriverService {


    private final BusDriverRepository busDriverRepository;
    private final BusRepository busRepository;

    public BusDriverService(BusDriverRepository busDriverRepository, BusRepository busRepository) {
        this.busDriverRepository = busDriverRepository;
        this.busRepository = busRepository;
    }

    public List<BusDriver> findAll() {
        return busDriverRepository.findAll();
    }


    public BusDriver findById(Long id) {
        return busDriverRepository.findById(id).orElseThrow(() -> new TimetableExceptions(id));

    }

    public BusDriver addNewDriver(BusDriver busDriver) {
        if (busDriver.getName()==null){
            throw new BadException(" Man with no name? are u serious?");
        }
        if(busDriver.getSurname()==null){
            throw new BadException("yea sure hiding ninja ...");
        }

        return busDriverRepository.save(busDriver);
    }

    public Bus checkDriver(Long id) {

        Bus bus = busRepository.findById(id).orElseThrow(()-> new TimetableExceptions( id));
        if (bus.getBusDriver() == null) {
            bus.setBusActive(false);
        }
        return busRepository.save(bus) ;
    }



    public void deleteByID(Long id) {
        busDriverRepository.deleteById(id);
    }

//    public Bus isThereDriver(Bus bus, BusDriver busDriver){
//        if (busDriver.getId() == null){
//
//        }
//        return ;
//    }

}


