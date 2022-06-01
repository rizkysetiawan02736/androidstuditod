package com.rizky_02736.desemar.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("username")
	private String username;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}