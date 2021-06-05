package com.parkit.parkingsystem.model;

import java.util.Calendar;
import java.util.Date;

public class Ticket {
    private int id;
	private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Long inTime;
    private Long outTime;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}
	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getInTime() {
		return inTime;
	}
	public void setInTime(Long inTime) {
		this.inTime = inTime;
	}
	public Long getOutTime() {
		return outTime;
	}
	public void setOutTime(Long outTime) {
		this.outTime = outTime;
	}

    
   }
