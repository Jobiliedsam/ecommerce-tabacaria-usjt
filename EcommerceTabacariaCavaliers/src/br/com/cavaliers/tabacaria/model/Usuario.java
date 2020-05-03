package br.com.cavaliers.tabacaria.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String password;
	private String email;
	private String tipo;
	
	public Usuario () {
		
	}

	public Usuario(int id, String password, String email, String tipo) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [tipo= " + tipo + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
