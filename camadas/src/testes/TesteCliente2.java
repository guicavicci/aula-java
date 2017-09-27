package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import bo.ClienteBO;


public class TesteCliente2 {

	public static void main(String[] args) {
		try{
			Cliente cli = ClienteBO.consultarProCodigo(Integer.parseInt(JOptionPane.showInputDialog("Numero")));
			System.out.println("Nome: " + cli.getNome());
			System.out.println("Estrelas: " + cli.getQtddeEstrelas());
			System.out.println("Nome: " + cli.getNumero());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
