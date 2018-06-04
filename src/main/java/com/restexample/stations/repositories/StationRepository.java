package com.restexample.stations.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restexample.stations.domain.Station;
import com.restexample.stations.exceptions.ResourceNotFoundException;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

	@Query("SELECT s FROM Station s where s.name = :name") 
	Optional<List<Station>> findByName(@Param("name")String name) throws ResourceNotFoundException;
	
	@Query("SELECT s FROM Station s where s.hdEnabled = :hdEnabled") 
	Optional<List<Station>> findByHdEnabled(@Param("hdEnabled")Boolean hdEnabled) throws ResourceNotFoundException;
}
