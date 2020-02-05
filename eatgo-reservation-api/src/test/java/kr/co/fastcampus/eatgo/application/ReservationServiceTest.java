package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class ReservationServiceTest {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    public void list() {
        List<Reservation> mockReservations = new ArrayList<>();
        mockReservations.add(Reservation.builder().name("choidongsun").build());
        given(reservationRepository.findAllByRestaurantId(1004L)).willReturn(mockReservations);

        List<Reservation> reservations = reservationService.getReservations(1004L);

        Reservation reservation = reservations.get(0);
        assertThat(reservation.getName(), is("choidongsun"));
    }

}