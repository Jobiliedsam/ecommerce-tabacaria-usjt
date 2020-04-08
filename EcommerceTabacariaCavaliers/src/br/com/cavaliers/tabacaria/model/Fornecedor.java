package br.com.cavaliers.tabacaria.model;

import java.util.Date;
public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private String cnpj;
	private String contatoEmail;
	private String contatoTelefone;
	private Date dataInicio;
	private Date dataFim;
	private int status;
	private String descricao;
	
	public Fornecedor () {
		
	}

	public Fornecedor(int idFornecedor, String nomeFornecedor, String cnpj, String contatoEmail, String contatoTelefone,
			Date dataInicio, Date dataFim, int status, String descricao) {
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.cnpj = cnpj;
		this.contatoEmail = contatoEmail;
		this.contatoTelefone = contatoTelefone;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
		this.descricao = descricao;
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

	public String getContatoTelefone() {
		return contatoTelefone;
	}

	public void setContatoTelefone(String contatoTelefone) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", cnpj="+ cnpj + ", contatoEmail="
				+ contatoEmail + ", contatoTelefone=" + contatoTelefone + ", dataInicio=" + dataInicio + ", dataFim="
				+ dataFim + ", status=" + status + ", descricao" + descricao + "]";
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
