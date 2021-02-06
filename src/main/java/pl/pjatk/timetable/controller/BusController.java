package pl.pjatk.timetable.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.service.BusService;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;


    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Bus>> findAllBuses() {
        return ResponseEntity.status(HttpStatus.OK).body(busService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(busService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Bus> addNewBus(@RequestBody Bus bus) {
        return ResponseEntity.ok(busService.addNewBus(bus));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Bus> changeBusName(@PathVariable Long id, @RequestBody Bus bus) {
        return ResponseEntity.status(HttpStatus.OK).body(busService.updateBus(id, bus));
    }

//    @PutMapping("/changeRoad/{busId}/{roadId}")
//    public ResponseEntity<Bus> changeRoad(@PathVariable Long busId, @PathVariable Long roadId ) {
//        return ResponseEntity.status(HttpStatus.OK).body(busService.changeRoad(busId, roadId));
//    }


    @PutMapping("/brokenBus/{id}")
    public ResponseEntity<Bus> sendNewBus(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(busService.brokenBus(id));
    }

    @DeleteMapping("/deleteBusById/{id}")
    public ResponseEntity<?> deleteBusById(@PathVariable Long id){
        busService.deleteBusByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

