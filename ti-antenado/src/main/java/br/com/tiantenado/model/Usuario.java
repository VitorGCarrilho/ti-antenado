package br.com.tiantenado.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	
}
