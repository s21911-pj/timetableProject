package pl.pjatk.timetable.service;


import org.springframework.stereotype.Service;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.repository.BusDriverRepository;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


@Service
public class BusDriverService {


    private final BusDriverRepository busDriverRepository;

    public BusDriverService(BusDriverRepository busDriverRepository) {
        this.busDriverRepository = busDriverRepository;
    }

    public List findAll(){return busDriverRepository.findAll();}

    private BusDriver exception(Long id, String s, String s2) {
        return busDriverRepository.findById(id).orElseThrow(() -> new EntityExistsException(s + id + s2));
    }

    public BusDriver findById(Long id){
        return exception( id,"BusDriver with id ", "doesn't eksist");

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

    public Bus getDriver(Bus bus, BusDriver busDriver){
        if (busDriver == null){

        }
        return ;
    }

}


