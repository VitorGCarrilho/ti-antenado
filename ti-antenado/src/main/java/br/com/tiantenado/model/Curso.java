package br.com.tiantenado.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author vitor
 *
 */
@Entity
@Table(name="TB_CURSO")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_CURSO")
	private long cdCurso;
	
	@Column(name="NM_CURSO")
	private String nmCurso;
	
	@Column(name="DS_CURSO")
	private String dsCurso;
	
	@Column(name="DT_INICIO")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
		
	@ManyToOne
	@JoinColumn(name="CD_PROFESSOR")
	private Usuario professor;
	
	@Column(name="CD_MODULO")
	private long cdModulo;
	
	@Column(name="DS_IMAGEM")
	private String dsImagem;
	
	@OneToMany
	@JoinColumn(name="CD_AULA")
	@JsonIgnore
	private List<Aula> aulas;
	
	
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
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtCurso) {
		this.dtInicio = dtCurso;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}	
	public String getDsImagem() {
		return dsImagem;
	}
	public void setDsImagem(String dsImagem) {
		this.dsImagem = dsImagem;
	}
	
	
	
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdCurso ^ (cdCurso >>> 32));
		result = prime * result + (int) (cdModulo ^ (cdModulo >>> 32));
		result = prime * result + ((dsCurso == null) ? 0 : dsCurso.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((nmCurso == null) ? 0 : nmCurso.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (cdCurso != other.cdCurso)
			return false;
		if (cdModulo != other.cdModulo)
			return false;
		if (dsCurso == null) {
			if (other.dsCurso != null)
				return false;
		} else if (!dsCurso.equals(other.dsCurso))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (nmCurso == null) {
			if (other.nmCurso != null)
				return false;
		} else if (!nmCurso.equals(other.nmCurso))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}
	
	
}
