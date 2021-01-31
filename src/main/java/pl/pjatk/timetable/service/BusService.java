package pl.pjatk.timetable.service;

import org.springframework.stereotype.Service;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.repository.BusRepository;

import javax.persistence.EntityExistsException;
import java.util.List;


@Service
public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    public List<Bus> findAll(){
        return busRepository.findAll();
    }
    public Bus findById(Long id){
        return busRepository.findById(id).orElseThrow(() -> new EntityExistsException("Bus with id " + id + "doesn't eksist"));
    }
    public Bus addNewBus(Bus addBus){
        Bus bus = new Bus();
        bus.setName(addBus.getName());
        bus.setNumber(addBus.getNumber());
        bus.setRoad(addBus.getRoad());
        bus.setBusActive(true);
        return busRepository.save(bus);
    }
    public Bus changeBusName(Long id,Bus busToUpdate){
        Bus bus = busRepository.findById(id).orElseThrow(() -> new EntityExistsException("Bus with id " + id + "doesn't eksist"));
        if(busToUpdate.getName()!= null){
            bus.setName(bus.getName());
            if(busToUpdate.getNumber() != null){
                bus.setNumber(bus.getNumber());

            }if(busToUpdate.getRoad()!= null){
                bus.setRoad(bus.getRoad());
       }
        }
   return busRepository.save(bus);
    }
    public Bus changeRoad(Long id,Bus roadToChange){
        Bus bus = busRepository.findById(id).orElseThrow(() -> new EntityExistsException("Bus with id" + id + "doesn't exist"));
        if(roadToChange.getName()!= null){
            bus.setRoad(bus.getRoad());
        }
        return busRepository.save(bus);
    }
    public List<Bus> findBusByRoadName (String name){
        return busRepository.findBusByRoadName(name);
    }
    public Bus brokenBus(Long id,Bus bus){
        Bus brokenBus = busRepository.findById(id).orElseThrow(() -> new EntityExistsException("Bus with id" + id + "doesn't exist"));
        if (!brokenBus.isBusActive()){
            bus.setRoad(brokenBus.getRoad());
        }
        return bus;
    }
}
