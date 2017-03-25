package br.com.tiantenado.exception;

public class SenhaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733449498603829875L;
	
	
	public SenhaInvalidaException(){
		super("Senha esta invalida");
	}
	public SenhaInvalidaException(String mensagem) {
		super(mensagem);
	}
	
}
