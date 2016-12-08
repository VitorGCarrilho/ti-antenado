package br.com.tiantenado.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@Column(name="CD_USUARIO")
	private long cdUsuario;
	
	@Column(name="NM_USUARIO")
	private String nmUsuario;
	
	@Column(name="NR_FONE")
	private String nrFone;
	
	@Column(name="NR_CEL")
	private String nrCel;
	
	@Column(name="DS_ENDERECO")
	private String dsEndereco;
	
	@Column(name="DS_INSTITUICAO")
	private String dsInstituicao;
	
	@Column(name="DS_EMAIL")
	private String dsEmail;
	
	@Column(name="DT_NASCIMENTO")
	private Date dtNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ID_TIPO_USUARIO")
	private TipoUsuario tipoUsuario;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="CD_PROFESSOR")
	private List<Curso> cursos;
	
	
	
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public String getDsEndereco() {
		return dsEndereco;
	}
	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}
	public String getDsInstituicao() {
		return dsInstituicao;
	}
	public void setDsInstituicao(String instituicao) {
		this.dsInstituicao = instituicao;
	}
	public long getCdUsuario() {
		return cdUsuario;
	}
	public void setCdUsuario(long cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getNrFone() {
		return nrFone;
	}
	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}
	public String getNrCel() {
		return nrCel;
	}
	public void setNrCel(String nrCel) {
		this.nrCel = nrCel;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cdUsuario ^ (cdUsuario >>> 32));
		result = prime * result + ((dsEmail == null) ? 0 : dsEmail.hashCode());
		result = prime * result + ((dsEndereco == null) ? 0 : dsEndereco.hashCode());
		result = prime * result + ((dsInstituicao == null) ? 0 : dsInstituicao.hashCode());
		result = prime * result + ((dtNascimento == null) ? 0 : dtNascimento.hashCode());
		result = prime * result + ((nmUsuario == null) ? 0 : nmUsuario.hashCode());
		result = prime * result + ((nrCel == null) ? 0 : nrCel.hashCode());
		result = prime * result + ((nrFone == null) ? 0 : nrFone.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cdUsuario != other.cdUsuario)
			return false;
		if (dsEmail == null) {
			if (other.dsEmail != null)
				return false;
		} else if (!dsEmail.equals(other.dsEmail))
			return false;
		if (dsEndereco == null) {
			if (other.dsEndereco != null)
				return false;
		} else if (!dsEndereco.equals(other.dsEndereco))
			return false;
		if (dsInstituicao == null) {
			if (other.dsInstituicao != null)
				return false;
		} else if (!dsInstituicao.equals(other.dsInstituicao))
			return false;
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		if (nmUsuario == null) {
			if (other.nmUsuario != null)
				return false;
		} else if (!nmUsuario.equals(other.nmUsuario))
			return false;
		if (nrCel == null) {
			if (other.nrCel != null)
				return false;
		} else if (!nrCel.equals(other.nrCel))
			return false;
		if (nrFone == null) {
			if (other.nrFone != null)
				return false;
		} else if (!nrFone.equals(other.nrFone))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}
	
	
	
}
