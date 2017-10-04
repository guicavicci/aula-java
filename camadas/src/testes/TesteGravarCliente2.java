package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import bo.ClienteBO;
import excecao.Excecao;

public class TesteGravarCliente2 {
	public static void main(String[] args){
		
		try{
			Cliente obj = new Cliente();
			obj.setNome(JOptionPane.showInputDialog("Nome"));
			obj.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Numero")));
			obj.setQtddeEstrelas(Integer.parseInt(JOptionPane.showInputDialog("Estrelas")));
			System.out.println(ClienteBO.adicionarNovoCliente(obj));
		}catch(Exception e){
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
