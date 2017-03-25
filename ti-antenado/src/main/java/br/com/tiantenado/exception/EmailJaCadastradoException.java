package br.com.tiantenado.exception;

public class EmailJaCadastradoException extends Exception {
	
	private static final long serialVersionUID = 7976507552133111545L;
	
	public EmailJaCadastradoException (){
		super("O Email já está cadastrado!");
	}
	public EmailJaCadastradoException (String mensagem){
		super(mensagem);
	}
}
