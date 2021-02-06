package pl.pjatk.timetable.service;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;


import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.timetable.model.BusDriver;
import pl.pjatk.timetable.repository.BusDriverRepository;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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

    @Test
    void findAll() {
        when(busDriverRepository.findAll()).thenReturn(List.of(
                new BusDriver(1L,"Piotr","Pioter"),
                new BusDriver(1L,"Jak","Jave"),
                new BusDriver(1L,"Uwielbiam","Tak"),
                new BusDriver(1L,"Bardzo","Ja"),
                new BusDriver(1L,"Uwielbiam","TajaveDajMI3333333")

        ));
        List<BusDriver> busList = busDriverRepository.findAll();
        assertThat(busList).hasSize(5);
    }


}
