package beans;

public class Telefone {
	private String operadora;
	private String numero;
	private String ddd;
	

	public Telefone() {
		super();
	}
	public Telefone(String operadora, String numero, String ddd) {
		super();
		this.operadora = operadora;
		this.numero = numero;
		this.ddd = ddd;
	}
	
	public String getOperadora() {
		return operadora;
	}
	
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	
}
