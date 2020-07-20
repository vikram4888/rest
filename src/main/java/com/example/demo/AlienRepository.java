package com.example.demo;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlienRepository extends CrudRepository<Master, Integer> {
	@Modifying
	@Transactional	
	@Query(value="INSERT INTO master(app_id, start_date, end_date, curr_status, Request_id) values(:app_id, :start_date, :end_date, :curr_status, :Request_id)", nativeQuery=true)
	public void insertClientData2Master(
			@Param("app_id") int app_id, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date,
			@Param("curr_status") String curr_status, 
			@Param("Request_id") int Request_id); 
	
	@Query(value="SELECT rec_seg_id FROM rec_segment WHERE start_date >= :start_date and end_date <= :end_date and app_id=:app_id", nativeQuery=true)
	public ArrayList<Integer> getfromSegment(
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date, 
			@Param("app_id") int app_id);

	@Modifying
	@Transactional
	@Query(value="INSERT INTO child(reqId, RecSegId, status) values(:reqId, :RecSegId, :status)", nativeQuery=true)
	public void insertData2Chield(
			@Param("reqId") int reqId, 
			@Param("RecSegId") int RecSegId, 
			@Param("status") String status);
}
