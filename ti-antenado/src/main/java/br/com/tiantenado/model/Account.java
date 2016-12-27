package br.com.tiantenado.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Account.TABLE_NAME)
public class Account implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "TB_ACCOUNT";

	public static final String FIELD_ID_ACCOUNT =  "ID_ACCOUNT";

	public static final String FIELD_CREATION_DATE = "CREATION_DATE";

	public static final String FIELD_LAST_UPDATE = "LAST_UPDATE";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = Account.FIELD_ID_ACCOUNT, nullable=false, unique=true)
	private Long idAccount;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, optional= false)
	@JoinColumn
	private Usuario usuario;
	
	@Column(name = Account.FIELD_CREATION_DATE, nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name = Account.FIELD_LAST_UPDATE, nullable = false)
	private LocalDateTime lastUpdate;

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((idAccount == null) ? 0 : idAccount.hashCode());
		result = prime * result
				+ ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Account other = (Account) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (idAccount == null) {
			if (other.idAccount != null)
				return false;
		} else if (!idAccount.equals(other.idAccount))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
