package br.com.tiantenado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CHAMADA")
public class Chamada {
	
	@Id
	@Column(name="CD_CHAMADA")
	private long cdChamada;
	
	@OneToOne
	@JoinColumn(name="CD_AULA")
	private Aula aula;
	
	
	@OneToOne
	@JoinColumn(name="CD_USUARIO")
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ID_PRESENTE")
	private StatusPresenca idPresente;
	
	
	
	public long getCdChamada() {
		return cdChamada;
	}
	public void setCdChamada(long cdChamada) {
		this.cdChamada = cdChamada;
	}
	public StatusPresenca getIdPresente() {
		return idPresente;
	}
	public void setIdPresente(StatusPresenca idPresente) {
		this.idPresente = idPresente;
	}
	public Aula getAula() {
		return aula;
	}
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
