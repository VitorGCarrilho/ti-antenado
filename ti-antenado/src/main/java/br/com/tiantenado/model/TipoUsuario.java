package br.com.tiantenado.model;

public enum TipoUsuario {
	A("Aluno"),
	P("Professor"),
	R("Root");
	
	
	private String dsTipoUsuario;
	
	
	TipoUsuario(String dsTipoUsuario){
		this.dsTipoUsuario = dsTipoUsuario;
	}
	
	
}
