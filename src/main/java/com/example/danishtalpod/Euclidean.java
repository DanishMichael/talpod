package com.example.danishtalpod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Euclidean {

	int startLocationCode;
	int endLocationCode;
	boolean isEuclidean;
	
	public Euclidean(int startLocationCode, int endLocationCode, boolean isEuclidean) {
		this.startLocationCode = startLocationCode;
		this.endLocationCode = endLocationCode;
		this.isEuclidean = isEuclidean;
	}

	public int getStartLocationCode() {
		return startLocationCode;
	}

	public void setStartLocationCode(int startLocationCode) {
		this.startLocationCode = startLocationCode;
	}

	public int getEndLocationCode() {
		return endLocationCode;
	}

	public void setEndLocationCode(int endLocationCode) {
		this.endLocationCode = endLocationCode;
	}

	public boolean isEuclidean() {
		return isEuclidean;
	}

	public void setEuclidean(boolean isEuclidean) {
		this.isEuclidean = isEuclidean;
	}
	
	
	
	
}
