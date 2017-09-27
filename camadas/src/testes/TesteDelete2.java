package testes;

import javax.swing.JOptionPane;

import bo.ClienteBO;

public class TesteDelete2 {

	public static void main(String[] args) {
		
		try{
		    int x = ClienteBO.deletarCliente
					(Integer.parseInt
					(JOptionPane.showInputDialog("Digite um numero")));
			System.out.println(x + "cliente(s) foi(ram) excluidos(s)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
