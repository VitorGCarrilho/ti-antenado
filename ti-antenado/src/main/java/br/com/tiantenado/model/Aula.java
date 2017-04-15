package br.com.tiantenado.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "TB_AULA")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_AULA")
	private long cdAula;
	
	@Column(name="DT_AULA")
	private Date dtAula;
	
	@OneToOne
	@JoinColumn(name="CD_AULA")
	private Curso curso;
	
	public List<Chamada> getChamadas() {
		return chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}

	@OneToMany
	@JoinColumn(name="CD_AULA")
	private List<Chamada> chamadas;

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
