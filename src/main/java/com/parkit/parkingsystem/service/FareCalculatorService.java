package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {
	
	private TicketDAO ticket_dao = new TicketDAO();
    
	public FareCalculatorService(TicketDAO ticket_dao) {
		this.ticket_dao = ticket_dao;
	}
    public FareCalculatorService() {
	}
	public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime() <= ticket.getInTime()) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        double inHour = (double)ticket.getInTime() / 3600000;
        double outHour = (double)ticket.getOutTime() / 3600000;
       
        //DONE: Some tests are failing here. Need to check if this logic is correct
        double duration = outHour - inHour;
        double reduction = (this.ticket_dao
				        		.getNumberOccurence(ticket.getVehicleRegNumber())< Fare.NUBER_REDUCTION_FREQUENCY)
				        		                                                 ? 1 : Fare.VEHICLE_REDUCTION;
        
        if(duration > 0.5 ) {
		        switch (ticket.getParkingSpot().getParkingType()){
		            case CAR: {
		                ticket.setPrice((duration - 0.5) * Fare.CAR_RATE_PER_HOUR * reduction);
		                break;
		            }
		            case BIKE: {
		                ticket.setPrice((duration - 0.5) * Fare.BIKE_RATE_PER_HOUR * reduction);
		                break;
		            }
		            default: throw new IllegalArgumentException("Unkown Parking Type");
		       }
        }else {
		      ticket.setPrice(0);
		  }
        
    }
}