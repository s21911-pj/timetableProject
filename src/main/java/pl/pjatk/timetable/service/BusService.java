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

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus findById(Long id) {
        return exception(id, "Bus with id ", "doesn't eksist");
    }

    public Bus addNewBus(Bus addBus) {

        return busRepository.save(addBus);
    }

    public Bus changeBusName(Long id, Bus busToUpdate) {
        Bus bus = exception(id, "Bus with id ", "doesn't eksist");
        updateBus(busToUpdate, bus);

        return busRepository.save(bus);
    }

    private Bus exception(Long id, String s, String s2) {
        return busRepository.findById(id).orElseThrow(() -> new EntityExistsException(s + id + s2));
    }

    private void updateBus(Bus busToUpdate, Bus bus) {
        if (busToUpdate.getName() != null) {
            bus.setName(bus.getName());
        }
        if (busToUpdate.getNumber() != null) {
            bus.setNumber(bus.getNumber());

        }
        if (busToUpdate.getRoad() != null) {
            bus.setRoad(bus.getRoad());
        }
    }

    public Bus changeRoad(Long id, Bus roadToChange) {
        Bus bus = exception(id, "Bus with id", "doesn't exist");
        if (roadToChange.getName() != null) {
            bus.setRoad(bus.getRoad());
        }
        return busRepository.save(bus);
    }

    public List<Bus> findBusByRoadName(String name) {
        return busRepository.findBusByRoadName(name);
    }

    public Bus brokenBus(Long id, Bus bus) {
        Bus brokenBus = exception(id, "Bus with id", "doesn't exist");
        if (!brokenBus.isBusActive()) {
            bus.setRoad(brokenBus.getRoad());
        }
        return bus;
    }


}
