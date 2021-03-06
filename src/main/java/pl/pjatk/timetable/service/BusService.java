package pl.pjatk.timetable.service;

import org.springframework.stereotype.Service;
import pl.pjatk.timetable.exception.BadException;
import pl.pjatk.timetable.exception.TimetableExceptions;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.model.Road;
import pl.pjatk.timetable.repository.BusDriverRepository;
import pl.pjatk.timetable.repository.BusRepository;
import pl.pjatk.timetable.repository.RoadRepository;

import java.util.List;


@Service
public class BusService {
    private final BusRepository busRepository;
    private final RoadRepository roadRepository;
    private final BusDriverRepository busDriverRepository;

    public BusService(BusRepository busRepository, RoadService roadService, BusDriverService busDriverService, RoadRepository roadRepository, BusDriverRepository busDriverRepository) {
        this.busRepository = busRepository;
        this.roadRepository = roadRepository;


        this.busDriverRepository = busDriverRepository;
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus findById(Long id) {
        return busRepository.findById(id).orElseThrow(() -> new TimetableExceptions(id));
    }

//    public Bus addNewBus(Bus addBus) {
//
//
//        return busRepository.save(addBus);
//    }

    public Bus addNewBus(Bus addBus) {
        if (addBus.getIsActive() == false) {
            throw new BadException("No way u can't give me broken bus");
        }

        return busRepository.save(addBus);
    }

//    public Bus changeBusName(Long id, Bus busToUpdate) {
//        Bus bus = busRepository.findById(id).orElseThrow(exception("bus",id));
//        updateBus(busToUpdate, bus);
//
//        return busRepository.save(bus);
//    }


    public Bus updateBus(Long id, Bus busToUpdate) {
        Bus bus = busRepository.findById(id).orElseThrow(() -> new TimetableExceptions(id));
        if (busToUpdate.getName() != null) {
            bus.setName(busToUpdate.getName());
        }
        if (busToUpdate.getNumber() != null) {
            bus.setNumber(busToUpdate.getNumber());

        }

        return busRepository.save(bus);
    }


    public Bus brokenBus(Long id) {
        Bus brokenBus = busRepository.findById(id).orElseThrow(() -> new TimetableExceptions(id));
        if (!brokenBus.isBusActive()) {
            busRepository.findById(id);
            brokenBus.setIsActive(true);
        }
        return busRepository.save(brokenBus);
    }

    public void deleteBusByID(Long id) {
        busRepository.deleteById(id);
    }

    public Bus addNewDriver(Long idBus, Long idDriver) {
        Bus bus = findById(idBus);
        BusDriver busDriver = busDriverRepository.findById(idDriver).orElseThrow(() -> new TimetableExceptions(idDriver));
        if (busDriver != null) {
            bus.setBusDriver(busDriver);
            bus.setIsActive(true);
        }
        return busRepository.save(bus);
    }


}
