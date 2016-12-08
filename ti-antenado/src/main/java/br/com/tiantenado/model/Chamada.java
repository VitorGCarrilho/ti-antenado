package br.com.tiantenado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="TB_CHAMADA")
public class Chamada {
	@Id
	@Column(name="CD_CHAMADA")
	private Long cdChamada;
	
	@OneToOne
	@JoinColumn(name="CD_MATRICULA")
	private Matricula matricula;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ID_PRESENTE")
	private StatusPresenca idPresente;
	
	
	public Long getCdChamada() {
		return cdChamada;
	}
	public void setCdChamada(Long cdChamada) {
		this.cdChamada = cdChamada;
	}
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
