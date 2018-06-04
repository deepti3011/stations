package com.restexample.stations.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restexample.stations.bootstrap.SpringJpaBootstrap;
import com.restexample.stations.configuration.RepositoryConfiguration;
import com.restexample.stations.domain.Station;
import com.restexample.stations.services.StationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
@DataJpaTest
public class StationRepositoryTest {
	@Autowired
	private StationRepository stationRepository;
	
/*	@Autowired
	private StationService stationService;
	*/
	private Logger log = LogManager.getLogger(StationRepositoryTest.class);
    @Test
    public void testSaveStation(){
        //Setup Station
        Station station = new Station();
        station.setName("HBO");
        station.setCallSign("HBO Call Sign");
        station.setHdEnabled(new Boolean (true));;
        
        //Create a Station, verify has ID value after save --
        assertNull(station.getId()); //null before save
        stationRepository.save(station);
        log.info("Saved "+ station);
        assertNotNull(station.getId()); //not null after save
        //--------------------------End of POST--------------------------------------
        //Fetch from DB
        Station fetchedStation = stationRepository.findById(station.getId()).orElse(null);
        
        //Should not be null
        assertNotNull(fetchedStation);
        
        //---------------------------End of GET Using ID--------------------------------------
        //Fetch from DB
        List<Station> fetchedStationByName =  stationRepository.findByName(station.getName()).orElse(null);
        
        //Should not be null
        assertNotNull(fetchedStationByName);
        
        //-----------------------End of GET using name---------------------------------------
        
        Optional<List<Station>> hdStations = stationRepository.findByHdEnabled(true);
        assertEquals(hdStations.get().size(), 1);
        
        //----------------------End of GET to retrieve HdEnabled station----------------------
        
        Optional<List<Station>> notHDStations = stationRepository.findByHdEnabled(false);
        assertTrue(notHDStations.empty() != null);
        
        //-------------------- End of GET to retrieve not HD stations-------------------------
        
        //Should equal
        assertEquals(station.getId(), fetchedStation.getId());
        assertEquals(station.getCallSign(), fetchedStation.getCallSign());
        assertEquals(station.getName(), fetchedStation.getName());
        assertEquals(station.getHdEnabled(), fetchedStation.getHdEnabled());
        
        //Update callsign, name and hdenabled
        fetchedStation.setCallSign("Updated Callsign");
        fetchedStation.setName("Updated Name");
        fetchedStation.setHdEnabled(!fetchedStation.getHdEnabled());
        
        stationRepository.save(fetchedStation);
        
        //Get from DB, should be updated - PUT
        Station fetchedUpdatedStation = stationRepository.findById(fetchedStation.getId()).orElse(null);
        assertEquals(fetchedStation.getCallSign(), fetchedUpdatedStation.getCallSign());
        assertEquals(fetchedStation.getName(), fetchedUpdatedStation.getName());
        assertEquals(fetchedStation.getHdEnabled(), fetchedUpdatedStation.getHdEnabled());
        
        //---------------------------End of PUT----------------------------
        
        //Verify count of stations in DB
        long stationCount = stationRepository.count();
        assertEquals(stationCount, 1);
        
        //Get all stations, list should only have one
        Iterable<Station> stations = stationRepository.findAll();
    
        int count = 0;
        for(Station p : stations){
            count++;
        }
        assertEquals(count, 1);
        //----------------------------End of GET All----------------------------
    }
}
