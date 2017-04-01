package br.com.tiantenado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name="TB_MATRICULA")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_MATRICULA")
	private long cdMatricula;
	
	@ManyToOne
	@JoinColumn(name="CD_ALUNO")
	private Usuario aluno;
	
	@ManyToOne
	@JoinColumn(name="CD_CURSO")
	private Curso curso;
	
	public long getCdMatricula() {
		return cdMatricula;
	}
	public void setCdMatricula(long cdMatricula) {
		this.cdMatricula = cdMatricula;
	}
	public Usuario getAluno() {
		return aluno;
	}
	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
