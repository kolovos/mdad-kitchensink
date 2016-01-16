package com.kitchensink.mondial;

public class Country {
	
	protected String name;
	protected int id;
	protected int population;
	protected double totalGdp;
	protected double totalArea;
	
	public Country() {}

	public Country(int id, String name, int population, double totalGdp, double totalArea) {
		super();
		this.name = name;
		this.id = id;
		this.population = population;
		this.totalGdp = totalGdp;
		this.totalArea = totalArea;
	}

	public double getTotalArea() {
		return totalArea;
	}
	
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	
	public double getTotalGdp() {
		return totalGdp;
	}
	
	public void setTotalGdp(double totalGdp) {
		this.totalGdp = totalGdp;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
