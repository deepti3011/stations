package com.restexample.stations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restexample.stations.domain.Station;
import com.restexample.stations.repositories.StationRepository;
import com.restexample.stations.services.StationService;

@Service
public class StationServiceImpl implements StationService{

	@Autowired
	private StationRepository stationRepository;

	@Override
	public Optional<List<Station>> findByHdEnabled(Boolean hdEnabled) {		
		return  stationRepository.findByHdEnabled(hdEnabled) ;
	}

	@Override
	public Optional<List<Station>> findByName(String name) {		
		return stationRepository.findByName(name);
	}

	@Override
	public List<Station> findAll() {
		return stationRepository.findAll();
	}

	@Override
	public Station save(Station station) {
		return stationRepository.save(station);
	}

	@Override
	public Optional<Station> findById(Long stationId) {
		return stationRepository.findById(stationId);
	}

	@Override
	public void delete(Station station) {
		 stationRepository.delete(station);
	}
	
}
