package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Master {
	
	@Id
	//from client
	private int app_id;
	private String start_date;
	private String end_date;
	//locally inserted
	private int Request_id;
	private String curr_status;
	private int seq;
	
    protected Master() {
    }
    
    @Override
	public String toString() {
		return "Master [seq=" + seq + ", app_id=" + app_id + ", Request_id=" + Request_id + ", curr_status="
				+ curr_status + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

	protected Master(int x, String item, int y, int z) {
        this.seq = x;
        this.curr_status = item;
        this.app_id = y;
        this.Request_id = z;
    }
    
	public int getSeq() {
		return seq;
	}
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public int getRequest_id() {
		return Request_id;
	}
	public void setRequest_id(int request_id) {
		Request_id = request_id;
	}
	public String getCurr_status() {
		return curr_status;
	}
	public void setCurr_status(String curr_status) {
		this.curr_status = curr_status;
	}

}
