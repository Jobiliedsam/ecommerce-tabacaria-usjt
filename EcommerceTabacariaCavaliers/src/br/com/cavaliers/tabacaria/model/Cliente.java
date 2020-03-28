package br.com.cavaliers.tabacaria.model;

import java.util.Date;

public class Cliente {
	
	private int idCliente;
	private Date dataDeNascimento;
	private String nomeCompleto;
	private String telefone;
	private String celular;
	private String cpfCnpj;
	private String genero;
	private String tipo;
	private String email;
				
	public Cliente() {
		
	}
	
	public Cliente(int idCliente, String nomeCompleto, Date dataDeNascimento, String telefone, String celular, String cpfCnpj, 
			String genero, String tipo,String email) 
	{
		this.celular = celular;
		this.cpfCnpj = cpfCnpj;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
		this.genero =  genero;
		this.idCliente = idCliente;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.tipo =  tipo;									
		
	}											
							
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dataDeNascimento=" + dataDeNascimento + ", nomeCompleto="
				+ nomeCompleto + ", telefone=" + telefone + ", celular=" + celular + ", cpfCnpj=" + cpfCnpj
				+ ", genero=" + genero + ", tipo=" + tipo + ", email=" + email + "]";
	}
	
}
