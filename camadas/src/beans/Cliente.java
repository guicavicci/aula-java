package beans;

import java.util.List;

public class Cliente {
	private int numero;
	private String nome;
	private int qtddeEstrelas;
	private List<Telefone> fones;
			
	public Cliente() {
		super();
	}
	public Cliente(int numero, String nome, int qtddeEstrelas, List<Telefone> fones) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.qtddeEstrelas = qtddeEstrelas;
		this.fones = fones;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtddeEstrelas() {
		return qtddeEstrelas;
	}
	public void setQtddeEstrelas(int qtddeEstrelas) {
		this.qtddeEstrelas = qtddeEstrelas;
	}
	public List<Telefone> getFones() {
		return fones;
	}
	public void setFones(List<Telefone> fones) {
		this.fones = fones;
	}
		
	}
