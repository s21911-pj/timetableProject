package pl.pjatk.timetable.service;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.repository.BusDriverRepository;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BusDriverServiceTest {
    @Mock
    BusDriverRepository busDriverRepository;

    @Test
    void addNewDriver() {
        BusDriver busDriver = new BusDriver(1L, "name", "surname");
        when(busDriverRepository.save(busDriver)).thenReturn(busDriver);
        busDriverRepository.save(busDriver);
        assertThat(busDriver.getId()).isPositive();
        assertThat(busDriver.getName()).isEqualTo("name");
        assertThat(busDriver.getSurname()).isEqualTo("surname");


    }
    @Test
    void findById() {
        when(busDriverRepository.findById(1L)).thenReturn(Optional.of(new BusDriver()));
        Optional<BusDriver> busDriver = busDriverRepository.findById(1L);
        assertThat(busDriver).isNotEmpty();
    }


}
