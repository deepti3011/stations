package com.restexample.stations.services;

import java.util.List;
import java.util.Optional;

import com.restexample.stations.domain.Station;

public interface StationService {
	public List<Station> findAll();
	public Station save(Station station) ;
	public Optional<Station> findById(Long stationId);
	public Optional<List<Station>> findByName(String name);
	public Optional<List<Station>> findByHdEnabled(Boolean hdEnabled);
	public void delete(Station station);
}