package com.restexample.stations.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import com.restexample.stations.domain.Station;
import com.restexample.stations.repositories.StationRepository;

public class StationMockTest {

	@Mock
	private StationRepository stationRepository;

	@Mock
	private Station station;

	/*   @Test
    public void shouldReturnStation_whenGetStationByIdIsCalled() throws Exception {
        // Arrange
        when(stationRepository.findById(5L).thenReturn(station);
        // Act
        Optional<Station> retrievedStation = stationRepository.findById(5L);
        // Assert
        assertThat(retrievedStation, is(equalTo(station)));

    }*/

	@Test
	public void shouldReturnStation_whenCreateStationIsCalled() throws Exception {
		/*// Arrange
		when(stationRepository.save(station)).thenReturn(station);
		// Act
		Station savedStation = stationRepository.save(station);
		// Assert
		assertThat(savedStation, is(equalTo(station)));*/
	}

	/*    

    @Test
    public void shouldCallDeleteMethodOfStationRepository_whenDeleteStationIsCalled() throws Exception {
        // Arrange
        doNothing().when(stationRepository).delete(5L);
        StationRepository my = Mockito.mock(stationRepository.class);

        // Act
        stationRepository.delete(stationRepository.findById(5L));
        // Assert
        verify(stationRepository, times(1)).deleteById(5);
    }
	 */
}