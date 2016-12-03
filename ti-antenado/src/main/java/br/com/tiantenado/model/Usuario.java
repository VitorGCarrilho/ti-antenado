package br.com.tiantenado.model;

import java.util.Date;

public class Usuario {
	private long cdUsuario;
	private String nmUsuario;
	private String nrFone;
	private String nrCel;
	private String dsEmail;
	private Date dtNascimento;
	private TipoUsuario tipoUsuario;
	
	
	
	public long getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getNrFone() {
		return nrFone;
	}
	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}
	public String getNrCel() {
		return nrCel;
	}
	public void setNrCel(String nrCel) {
		this.nrCel = nrCel;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
}
