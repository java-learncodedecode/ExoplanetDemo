package com.example.exoplanet.dto;

public class PlanetSize {
	private int small;
	private int medium;
	private int large;
	

	public PlanetSize(int small, int medium, int large) {
		super();
		this.small = small;
		this.medium = medium;
		this.large = large;
	}

	public int getSmall() {
		return small;
	}

	public void setSmall(int small) {
		this.small = small;
	}

	public int getMedium() {
		return medium;
	}

	public void setMedium(int medium) {
		this.medium = medium;
	}

	public int getLarge() {
		return large;
	}

	public void setLarge(int large) {
		this.large = large;
	}

}
