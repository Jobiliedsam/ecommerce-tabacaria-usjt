package model;

public class Endereco 
{
	
	private int idEndereco;
	private int idCliente;
	private String cep;
	private String enderecoP;
	private String enderecoS;
	private String cidade;
	private String estado;
	private String complemento;
	
	public Endereco () 
	{
		
	}

	public Endereco(String enderecoP, String enderecoS, int endereco, String cep, String cidade, String estado,
			String complemento, int idCliente) 
	{
		this.enderecoP = enderecoP;
		this.enderecoS = enderecoS;
		this.idEndereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.idCliente = idCliente;
	}

	public String getEnderecoP() {
		return enderecoP;
	}

	public void setEnderecoP(String enderecoP) {
		this.enderecoP = enderecoP;
	}

	public String getEnderecoS() {
		return enderecoS;
	}

	public void setEnderecoS(String enderecoS) {
		this.enderecoS = enderecoS;
	}

	public int getEndereco() {
		return idEndereco;
	}

	public void setEndereco(int endereco) {
		this.idEndereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereço) {
		this.idEndereco = idEndereço;
	}
}
