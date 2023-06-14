package com.example.exoplanet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exoplanets {

	private String PlanetIdentifier;
	private int TypeFlag;
	private double PlanetaryMassJpt;
	private double RadiusJpt;
	private double PeriodDays;
	private double SemiMajorAxisAU;
	private String Eccentricity;
	private String PeriastronDeg;
	private String LongitudeDeg;
	private String AscendingNodeDeg;
	private double InclinationDeg;
	private String SurfaceTempK;
	private String AgeGyr;
	private String DiscoveryMethod;
	private int DiscoveryYear;
	private String LastUpdated;
	private String RightAscension;
	private String Declination;
	private String DistFromSunParsec;
	private double HostStarMassSlrMass;
	private double HostStarRadiusSlrRad;
	private double HostStarMetallicity;
	private int HostStarTempK;
	private String HostStarAgeGyr;

	public String getPlanetIdentifier() {
		return PlanetIdentifier;
	}

	public void setPlanetIdentifier(String planetIdentifier) {
		this.PlanetIdentifier = planetIdentifier;
	}

	public int getTypeFlag() {
		return TypeFlag;
	}

	public void setTypeFlag(int typeFlag) {
		TypeFlag = typeFlag;
	}

	public double getPlanetaryMassJpt() {
		return PlanetaryMassJpt;
	}

	public void setPlanetaryMassJpt(double planetaryMassJpt) {
		PlanetaryMassJpt = planetaryMassJpt;
	}

	public double getRadiusJpt() {
		return RadiusJpt;
	}

	public void setRadiusJpt(double radiusJpt) {
		RadiusJpt = radiusJpt;
	}

	public double getPeriodDays() {
		return PeriodDays;
	}

	public void setPeriodDays(double periodDays) {
		PeriodDays = periodDays;
	}

	public double getSemiMajorAxisAU() {
		return SemiMajorAxisAU;
	}

	public void setSemiMajorAxisAU(double semiMajorAxisAU) {
		SemiMajorAxisAU = semiMajorAxisAU;
	}

	public String getEccentricity() {
		return Eccentricity;
	}

	public void setEccentricity(String eccentricity) {
		Eccentricity = eccentricity;
	}

	public String getPeriastronDeg() {
		return PeriastronDeg;
	}

	public void setPeriastronDeg(String periastronDeg) {
		PeriastronDeg = periastronDeg;
	}

	public String getLongitudeDeg() {
		return LongitudeDeg;
	}

	public void setLongitudeDeg(String longitudeDeg) {
		LongitudeDeg = longitudeDeg;
	}

	public String getAscendingNodeDeg() {
		return AscendingNodeDeg;
	}

	public void setAscendingNodeDeg(String ascendingNodeDeg) {
		AscendingNodeDeg = ascendingNodeDeg;
	}

	public double getInclinationDeg() {
		return InclinationDeg;
	}

	public void setInclinationDeg(double inclinationDeg) {
		InclinationDeg = inclinationDeg;
	}

	public String getSurfaceTempK() {
		return SurfaceTempK;
	}

	public void setSurfaceTempK(String surfaceTempK) {
		SurfaceTempK = surfaceTempK;
	}

	public String getAgeGyr() {
		return AgeGyr;
	}

	public void setAgeGyr(String ageGyr) {
		AgeGyr = ageGyr;
	}

	public String getDiscoveryMethod() {
		return DiscoveryMethod;
	}

	public void setDiscoveryMethod(String discoveryMethod) {
		DiscoveryMethod = discoveryMethod;
	}

	public int getDiscoveryYear() {
		return DiscoveryYear;
	}

	public void setDiscoveryYear(int discoveryYear) {
		DiscoveryYear = discoveryYear;
	}

	public String getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		LastUpdated = lastUpdated;
	}

	public String getRightAscension() {
		return RightAscension;
	}

	public void setRightAscension(String rightAscension) {
		RightAscension = rightAscension;
	}

	public String getDeclination() {
		return Declination;
	}

	public void setDeclination(String declination) {
		Declination = declination;
	}

	public String getDistFromSunParsec() {
		return DistFromSunParsec;
	}

	public void setDistFromSunParsec(String distFromSunParsec) {
		DistFromSunParsec = distFromSunParsec;
	}

	public double getHostStarMassSlrMass() {
		return HostStarMassSlrMass;
	}

	public void setHostStarMassSlrMass(double hostStarMassSlrMass) {
		HostStarMassSlrMass = hostStarMassSlrMass;
	}

	public double getHostStarRadiusSlrRad() {
		return HostStarRadiusSlrRad;
	}

	public void setHostStarRadiusSlrRad(double hostStarRadiusSlrRad) {
		HostStarRadiusSlrRad = hostStarRadiusSlrRad;
	}

	public double getHostStarMetallicity() {
		return HostStarMetallicity;
	}

	public void setHostStarMetallicity(double hostStarMetallicity) {
		HostStarMetallicity = hostStarMetallicity;
	}

	public int getHostStarTempK() {
		return HostStarTempK;
	}

	public void setHostStarTempK(int hostStarTempK) {
		HostStarTempK = hostStarTempK;
	}

	public String getHostStarAgeGyr() {
		return HostStarAgeGyr;
	}

	public void setHostStarAgeGyr(String hostStarAgeGyr) {
		HostStarAgeGyr = hostStarAgeGyr;
	}

}
