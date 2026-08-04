package com.khaled.laho.model;

import java.util.*;

public class Customer {
		
	private UUID id;
	// Account Username
	private String customerAccountUsername;
	// Account nickname
	private String customerNickname;
	// Account Experience (To Qualify User for discounts)
	private int customerAccountExperience;
	// User Game Library
	private List<Game> userGameLibrary = new ArrayList<>();
	// Customer Account Bio
	private String customerAccountBio = "";
		
		// w-i-p...
	public Customer(String username, String nickname, int accountExperience) {
		this.id = UUID.randomUUID();
		this.customerAccountUsername = username;
		this.customerNickname = nickname;
		this.customerAccountExperience = accountExperience;
	}

}
