package br.com.tiantenado.model;

public enum TipoUsuario {
	ALUNO("A","Aluno"),
	PROFESSOR("P","Professor"),
	ROOT("R","Root");
	
	private String cdTipoUsuario;
	private String dsTipoUsuario;
	
	
	TipoUsuario(String cdTipoUsuario,String dsTipoUsuario){
		this.cdTipoUsuario = cdTipoUsuario;
		this.dsTipoUsuario = dsTipoUsuario;
	}
	
	
}
