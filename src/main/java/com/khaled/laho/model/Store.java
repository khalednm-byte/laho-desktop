package com.khaled.laho.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private List<Game> storeGameLibrary = new ArrayList<>(); // Store Game Library
	private String licenseGenerator; // License Generator

	public List<Game> getStoreGameLibrary() {
		return storeGameLibrary;
	}

	public void setStoreGameLibrary(List<Game> storeGameLibrary) {
		this.storeGameLibrary = storeGameLibrary;
	}

	public String getLicenseGenerator() {
		return licenseGenerator;
	}

	public void setLicenseGenerator(String licenseGenerator) {
		this.licenseGenerator = licenseGenerator;
	}

}
