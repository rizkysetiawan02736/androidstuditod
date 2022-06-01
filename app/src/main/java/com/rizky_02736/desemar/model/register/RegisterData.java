package com.rizky_02736.desemar.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

	@SerializedName("nama")
	private String nama;

	@SerializedName("username")
	private String username;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}