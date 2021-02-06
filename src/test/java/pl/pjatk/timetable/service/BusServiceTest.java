package pl.pjatk.timetable.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.timetable.model.Bus;
import pl.pjatk.timetable.repository.BusRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BusServiceTest {
    @Mock
    BusRepository busRepository;

    @Test
    void addNewBus() {
        Bus bus = new Bus(1L, "name", 12, true);
        when(busRepository.save(bus)).thenReturn(bus);
        busRepository.save(bus);
        assertThat(bus.getId()).isPositive();
        assertThat(bus.getName()).isEqualTo("name");
        assertThat(bus.getNumber()).isEqualTo(12);
        assertThat(bus.isBusActive()).isEqualTo(true);


    }

    @Test
    void findById() {
        when(busRepository.findById(1L)).thenReturn(Optional.of(new Bus()));
        Optional<Bus> bus = busRepository.findById(1L);
        assertThat(bus).isNotEmpty();
    }

    @Test
    void findAll() {
        when(busRepository.findAll()).thenReturn(List.of(
                new Bus(1L, "Starachowice", 12, true),
                new Bus(2L, "Pieklo", 66, true),
                new Bus(3L, "HateJava", 999999, false),
                new Bus(4L, "ReallyHateJava", 999, false),
                new Bus(5L, "PleaseGaveme3", 3, true),
                new Bus(6L, "Only3", 333333, true)
        ));
        List<Bus> busList = busRepository.findAll();
        assertThat(busList).hasSize(6);
    }

}



