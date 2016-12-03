package br.com.tiantenado.model;

public class Matricula {
	private long cdMatricula;
	private Usuario aluno;
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
