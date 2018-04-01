package br.com.carrinhodecompra.exception;

import br.com.carrinhodecompra.helper.ErrorEnum;

public class ApplicationException extends Exception{

	private static final long serialVersionUID = -1766433772578430898L;


	private int codigo;
	private String message;
	private Exception e;
	
	public ApplicationException(ErrorEnum cod, Exception e) {
		this(cod);
		setE(e);
	}

	public ApplicationException(ErrorEnum cod) {
		setCodigo(cod.getCodigo());
		setMessage(cod.getDescricao());
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("ERROR CODE [" + getCodigo() + "] ");
		msg.append("MESSAGE [" + getMessage() + "] ");
		if(this.e != null) {
			msg.append("EXCEPTION[" + e.getMessage() 
			+ "|" + e.getLocalizedMessage()  
			+ "|" + e.getCause()
			+"] ");
		}
		return msg.toString();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int i) {
		this.codigo = i;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}
}
