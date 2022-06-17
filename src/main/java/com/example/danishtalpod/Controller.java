package com.example.danishtalpod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class Controller {

	@Autowired ItineraryService itinService;
	
	@PostMapping("/createItinerary")
	public String createItinerary(@RequestBody List<BoardingCard> input)
	{
		Gson gson = new Gson();
		return gson.toJson(itinService.createItinerary(input));
	}
}
