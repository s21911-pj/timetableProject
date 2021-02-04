package pl.pjatk.timetable.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.service.BusDriverService;

import java.util.List;

@RestController
@RequestMapping("/busDriver")
public class BusDriverController {

    private final BusDriverService busDriverService;

    public BusDriverController(BusDriverService busDriverService) {
        this.busDriverService = busDriverService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BusDriver>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(busDriverService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDriver> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(busDriverService.findById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<BusDriver> addNewDriver(@RequestBody BusDriver busDriver) {
        return ResponseEntity.status(HttpStatus.OK).body(busDriverService.addNewDriver(busDriver));
    }
}



