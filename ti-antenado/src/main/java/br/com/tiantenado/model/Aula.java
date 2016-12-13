package br.com.tiantenado.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "TB_AULA")
public class Aula {
	@Id
	@Column(name = "CD_AULA")
	private long cdAula;
	
	@Column(name="DT_AULA")
	private Date dtAula;
	
	@OneToOne
	@JoinColumn(name="CD_CURSO")
	private Curso curso;

	public long getCdAula() {
		return cdAula;
	}

	public void setCdAula(long cdAula) {
		this.cdAula = cdAula;
	}

	public Date getDtAula() {
		return dtAula;
	}

	public void setDtAula(Date dtAula) {
		this.dtAula = dtAula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
