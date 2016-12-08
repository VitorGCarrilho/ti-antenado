package br.com.tiantenado.model;

public enum StatusPresenca {
	P("Presente"),
	A("Ausente");
	
	
	private String dsStatus;
	
	StatusPresenca(String dsStatus){
		this.dsStatus = dsStatus;
	}
	
	public String getDsStatus(){
		return this.dsStatus;
	}
	
}
