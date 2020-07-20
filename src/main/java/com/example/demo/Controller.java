package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	AlienRepository repo;

	@GetMapping("aliens")
	public List<Master> getAlien() {
		List<Master> aliens = (List<Master>) repo.findAll();
		return aliens;
	}

	@PostMapping("aliens")
	public Master addAliens(@RequestBody Master alien) {

		Random rand = new Random();

		int ran = rand.nextInt(2000);
		repo.insertClientData2Master(alien.getApp_id(), alien.getStart_date(), alien.getEnd_date(), "Pending", ran);

		ArrayList<Integer> rec_seg_id_list = repo.getfromSegment(alien.getStart_date(), alien.getEnd_date(),
				alien.getApp_id());

		for (int i : rec_seg_id_list) {
			repo.insertData2Chield(ran, i, "Inprogress");
		}
		
		return alien;
	}

}
