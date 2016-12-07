package br.com.tiantenado.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_CURSO")
public class Curso {
	
	@Id
	@Column(name="CD_CURSO")
	private long cdCurso;
	
	@Column(name="NM_CURSO")
	private String nmCurso;
	
	@Column(name="DS_CURSO")
	private String dsCurso;
	
	@Column(name="DT_CURSO")
	private Date dtCurso;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn 
	private Usuario professor;
	
	@Column(name="CD_MODULO")
	private long cdModulo;
	
	
	public long getCdModulo() {
		return cdModulo;
	}
	public void setCdModulo(long cdModulo) {
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
