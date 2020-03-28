package br.com.cavaliers.tabacaria.model;

import java.util.Date;
public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private String contatoEmail;
	private int contatoTelefone;
	private Date dataInicio;
	private Date dataFim;
	private int status;
	
	public Fornecedor () {
		
	}

	public Fornecedor(int idFornecedor, String nomeFornecedor, String contatoEmail, int contatoTelefone,
			Date dataInicio, Date dataFim, int status) {
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.contatoEmail = contatoEmail;
		this.contatoTelefone = contatoTelefone;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getContatoEmail() {
		return contatoEmail;
	}

	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}

	public int getContatoTelefone() {
		return contatoTelefone;
	}

	public void setContatoTelefone(int contatoTelefone) {
		this.contatoTelefone = contatoTelefone;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", contatoEmail="
				+ contatoEmail + ", contatoTelefone=" + contatoTelefone + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + ", status=" + status + "]";
	}
	
	
}
