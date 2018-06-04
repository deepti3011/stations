package com.restexample.stations.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restexample.stations.domain.Station;
import com.restexample.stations.exceptions.ResourceNotFoundException;
import com.restexample.stations.services.StationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "stations", description = "Rest API for stations operations", tags = "Stations API")
public class StationController {

	/*@Autowired
	StationRepository stationRepository;*/
	
	@Autowired
	private StationService stationService;
	
	@ApiOperation(value = "List all Stations",response = Station.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	)
	@GetMapping("/stations")
	public List<Station> getAllStations() {
		return stationService.findAll();
	}

	@ApiOperation(value = "Create a station",response = Station.class)
	@PostMapping("/stations")
	public Station createStation(@Valid @RequestBody Station station) {
		return stationService.save(station);
	}

	@ApiOperation(value = "Search a station with an ID",response = Station.class)
	@GetMapping("/stations/{id}")
	public Station getStationById(@PathVariable(value = "id") Long stationId) {
		return stationService.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("Station", "id", stationId));
	}
	
	@ApiOperation(value = "Search a station with a name",response = Station.class)	
	@GetMapping("/stations/name={name}")
	public List<Station> getStationByName(@PathVariable(value = "name") String name) {
		return stationService.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Station", "name", name));
	}
	
	@ApiOperation(value = "List all HD enabled stations",response = Station.class)
	@GetMapping("/stations/hdEnabled")
	public List<Station> getStationByHdEnabled() {
		return stationService.findByHdEnabled(new Boolean(true)).orElseThrow(() -> new ResourceNotFoundException("Station", "HD", "Enabled"));
	}
	
	@ApiOperation(value = "List all stations which are not HD enabled",response = Station.class)
	@GetMapping("/stations/hdDisabled")
	public List<Station> getStationByHdDisabled() {
		return stationService.findByHdEnabled(new Boolean(false)).orElseThrow(() -> new ResourceNotFoundException("Station", "HD", "Disabled"));
	}

	@ApiOperation(value = "Update a station with an ID",response = Station.class)
	@PutMapping("/stations/{id}")
	public Station updateStation(@PathVariable(value = "id") Long stationId, @Valid @RequestBody Station stationDetails) {

		Station station = stationService.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("Station", "id", stationId));

		station.setName(stationDetails.getName());
		station.setCallSign(stationDetails.getCallSign());
		station.setHdEnabled(stationDetails.getHdEnabled());

		Station updatedStation = stationService.save(station);
		return updatedStation;
	}

	@ApiOperation(value = "Delete a station with an ID",response = Station.class)
	@DeleteMapping("/stations/{id}")
	public ResponseEntity<?> deleteStation(@PathVariable(value = "id") Long stationId) {
		
		Station station = stationService.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("Station", "id", stationId));

		stationService.delete(station);

		return ResponseEntity.ok().build();
	}
}
