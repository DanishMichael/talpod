package com.example.danishtalpod;

public class BoardingCard {

	private String source;
	private String destination;
	private String seatNo;
	private String transportNo;
	private String transportMethod;
	private String details;
	
	public BoardingCard(String source, String destination, String transportMethod, String transportNo, String seatNo, String details)
	{
		this.source = source;
		this.destination = destination;
		this.transportMethod = transportMethod;
		this.transportNo = transportNo;
		this.seatNo  = seatNo;
		this.details = details;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public String getTransportMethod() {
		return transportMethod;
	}

	public void setTransportMethod(String transportMethod) {
		this.transportMethod = transportMethod;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
