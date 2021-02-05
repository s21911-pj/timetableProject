package pl.pjatk.timetable.service;

import org.springframework.stereotype.Service;
import pl.pjatk.timetable.exception.TimetableExceptions;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.Road;
import pl.pjatk.timetable.repository.BusRepository;
import pl.pjatk.timetable.repository.RoadRepository;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.function.Supplier;


@Service
public class BusService {
    private final BusRepository busRepository;
    private final RoadService roadService;

    public BusService(BusRepository busRepository, RoadRepository roadRepository, RoadService roadService) {
        this.busRepository = busRepository;

        this.roadService = roadService;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus findById(Long id) {
        return busRepository.findById(id).orElseThrow(()->new TimetableExceptions(id));
    }

    public Bus addNewBus(Bus addBus) {

        return busRepository.save(addBus);
    }

//    public Bus changeBusName(Long id, Bus busToUpdate) {
//        Bus bus = busRepository.findById(id).orElseThrow(exception("bus",id));
//        updateBus(busToUpdate, bus);
//
//        return busRepository.save(bus);
//    }


    public Bus updateBus(Long id, Bus busToUpdate) {
        Bus bus = busRepository.findById(id).orElseThrow(()->new TimetableExceptions(id));
        if (busToUpdate.getName() != null) {
            bus.setName(busToUpdate.getName());
        }
        if (busToUpdate.getNumber() != null) {
            bus.setNumber(busToUpdate.getNumber());

        }
//        if (busToUpdate.getRoad() != null) {
//            bus.setRoad(bus.getRoad());
//        }
        return busRepository.save(bus);
    }

//    public Bus changeRoad(Long BusId, Long RoadId) {
//        Bus bus = findById(BusId);
//        Road road = roadService.findByRoadId(RoadId);
//        if (road != null) {
//            bus.setRoad(road);
//        }
//        return addNewBus(bus);
//    }


    public Bus brokenBus(Long id) {
        Bus brokenBus = busRepository.findById(id).orElseThrow(()->new TimetableExceptions(id));
        if (!brokenBus.isBusActive()) {
            busRepository.findById(id);
            brokenBus.setIsActive(true);
        }
        return busRepository.save(brokenBus);
    }




}
