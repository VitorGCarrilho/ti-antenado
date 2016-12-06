package br.com.tiantenado.model;

import java.util.Date;

public class Curso {
	private long cdCurso;
	private String nmCurso;
	private String dsCurso;
	private Date dtCurso;
	private Usuario professor;
	private int cdModulo;
	
	
	public int getCdModulo() {
		return cdModulo;
	}
	public void setCdModulo(int cdModulo) {
		this.cdModulo = cdModulo;
	}
	public long getCdCurso() {
		return cdCurso;
	}
	public void setCdCurso(long cdCurso) {
		this.cdCurso = cdCurso;
	}
	public String getNmCurso() {
		return nmCurso;
	}
	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}
	public String getDsCurso() {
		return dsCurso;
	}
	public void setDsCurso(String dsCurso) {
		this.dsCurso = dsCurso;
	}
	public Date getDtCurso() {
		return dtCurso;
	}
	public void setDtCurso(Date dtCurso) {
		this.dtCurso = dtCurso;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	
	
	
}
