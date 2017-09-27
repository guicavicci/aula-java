package beans;

public class Telefone {
	private int id;
	private String operadora;
	private String numero;
	private String ddd;
	
	public String getAll () {
		
		return id + "\n" + operadora + "\n" + numero + "\n" + ddd;
		
	}
	
	public void setAll (int i, String o, String n, String d) {
		id =i;
		operadora =o;
		numero =n;
		ddd=d;		
		
	}
	
	
	public Telefone() {
		super();
	}
	public Telefone(int id, String operadora, String numero, String ddd) {
		super();
		this.id = id;
		this.operadora = operadora;
		this.numero = numero;
		this.ddd = ddd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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