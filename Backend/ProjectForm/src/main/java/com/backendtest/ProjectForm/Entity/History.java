package com.backendtest.ProjectForm.Entity;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class History {
	
	private String code;
	private String date;
    private double rate;
    private long volume;
    private long cap;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public long getCap() {
		return cap;
	}
	public void setCap(long cap) {
		this.cap = cap;
	}
	@Override
	public String toString() {
		return "History [code=" + code + ", date=" + date + ", rate=" + rate + ", volume=" + volume + ", cap=" + cap
				+ "]";
	}
	public History(String code, String date, double rate, long volume, long cap) {
		super();
		this.code = code;
		this.date = date;
		this.rate = rate;
		this.volume = volume;
		this.cap = cap;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	
    
    
}
