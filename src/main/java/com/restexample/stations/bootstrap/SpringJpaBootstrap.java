package com.restexample.stations.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.restexample.stations.domain.Station;
import com.restexample.stations.repositories.StationRepository;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private StationRepository stationRepository;
	private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

	@Autowired
	public void setStationRepository(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadStations();
	}

	private void loadStations() {
		Station station = new Station();
		station.setName("PBS");
		station.setCallSign("PBS CallSign");
		station.setHdEnabled(new Boolean(true));
		stationRepository.save(station);

		Station station2 = new Station();
		station2.setName("HBO");
		station2.setCallSign("HBO CallSign");
		station2.setHdEnabled(new Boolean(false));
		stationRepository.save(station2);
		
		
		log.info("Saved "+ stationRepository.findAll());
	}


}



