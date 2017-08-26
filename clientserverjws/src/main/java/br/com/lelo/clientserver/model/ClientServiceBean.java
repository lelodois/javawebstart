package br.com.lelo.clientserver.model;

import java.util.Date;

public class ClientServiceBean {

	private String nome;
	private String version;
	private Date lastDateOnline;
	private ClientServiceImpressaoBean clientImpressao;

	public ClientServiceBean(String nome) {
		super();
		this.nome = nome;
		this.setLastDateOnline(new Date());
		this.clientImpressao = new ClientServiceImpressaoBean();
	}

	public ClientServiceBean setLastDateOnline(Date lastDateOnline) {
		this.lastDateOnline = lastDateOnline;
		return this;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public Date getLastDateOnline() {
		return lastDateOnline;
	}

	public String getNome() {
		return nome;
	}

	public ClientServiceImpressaoBean getClientImpressao() {
		return clientImpressao;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder();
		toString.append("Name: ").append(getNome());
		return toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof ClientServiceBean) {
			return this.getNome().equalsIgnoreCase(((ClientServiceBean) obj).getNome());
		}
		return false;
	}

}
