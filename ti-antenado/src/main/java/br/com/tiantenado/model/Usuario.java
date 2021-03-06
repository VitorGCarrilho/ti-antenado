package br.com.tiantenado.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_USUARIO")
	private long cdUsuario;
	
	@Column(name="NM_USUARIO")
	@NotNull
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
	@NotNull
	private String dsEmail;
	
	@Column(name="DT_NASCIMENTO")
	private Date dtNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ID_TIPO_USUARIO")
	private TipoUsuario tipoUsuario;
	
	@Column(name="DS_IMAGEM")
	private String dsImagem;
	
	@Column(name="DS_LINKEDIN")
	private String dsLinkedin;
	
	@Column(name="DS_CARGO")
	private String dsCargo;
	
	@Column(name="DS_EMPRESA")
	private String dsEmpresa;
	
	@OneToMany
	@JoinColumn(name="CD_PROFESSOR")
	@JsonIgnore
	private List<Curso> cursos;
	
	@Column(name="DS_FORMACAO")
	private String dsFormacao;
	
	@Column(name="DS_FACEBOOK")
	private String dsFacebook;
	
	@Column(name="DS_SENHA")
	@NotNull
	@JsonIgnore
	private String dsSenha;
	
	@OneToMany
	@JoinColumn(name="CD_ALUNO")
	private List<Matricula> matriculas;
	
	@Transient
	@NotNull
	private String dsConfirmacaoSenha;
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public boolean isValidPassword(){
		return !this.dsSenha.isEmpty() ? this.dsSenha.equals(this.dsConfirmacaoSenha) : false;
	}
	
	public String getDsConfirmacaoSenha() {
		return dsConfirmacaoSenha;
	}
	public void setDsConfirmacaoSenha(String dsConfirmacaoSenha) {
		this.dsConfirmacaoSenha = dsConfirmacaoSenha;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}
	public String getDsImagem() {
		return dsImagem;
	}
	public void setDsImagem(String dsImagem) {
		this.dsImagem = dsImagem;
	}
	public String getDsLinkedin() {
		return dsLinkedin;
	}
	public void setDsLinkedin(String dsLinkedin) {
		this.dsLinkedin = dsLinkedin;
	}
	public String getDsCargo() {
		return dsCargo;
	}
	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}
	public String getDsEmpresa() {
		return dsEmpresa;
	}
	public void setDsEmpresa(String dsEmpresa) {
		this.dsEmpresa = dsEmpresa;
	}
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
	public String getDsFormacao() {
		return dsFormacao;
	}
	public void setDsFormacao(String dsFormacao) {
		this.dsFormacao = dsFormacao;
	}
	public String getDsFacebook() {
		return dsFacebook;
	}
	public void setDsFacebook(String dsFacebook) {
		this.dsFacebook = dsFacebook;
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
