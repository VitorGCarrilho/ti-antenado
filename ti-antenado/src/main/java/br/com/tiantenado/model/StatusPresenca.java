package br.com.tiantenado.model;

public enum StatusPresenca {
	PRESENTE("P","Presente"),
	AUSENTE("A","Ausente");
	
	private String cdStatus;
	private String dsStatus;
	
	StatusPresenca(String cdStatus, String dsStatus){
		this.cdStatus = cdStatus;
		this.dsStatus = dsStatus;
	}
	
}
