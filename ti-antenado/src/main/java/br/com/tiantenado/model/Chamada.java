package br.com.tiantenado.model;

public class Chamada {
	private Matricula matricula;
	private StatusPresenca idPresente;
	
	
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public StatusPresenca getIdPresente() {
		return idPresente;
	}
	public void setIdPresente(StatusPresenca idPresente) {
		this.idPresente = idPresente;
	}
	
	
}
