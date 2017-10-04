package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import dao.ClienteDAO;

public class TesteCliente {

	public static void main(String[] args) {
		ClienteDAO dao = null;
		try{
			dao = new ClienteDAO();
			Cliente cli = dao.getCliente(Integer.parseInt(JOptionPane.showInputDialog("Numero")));
			System.out.println("Nome: " + cli.getNome());
			System.out.println("Estrelas: " + cli.getQtddeEstrelas());
			System.out.println("Nome: " + cli.getNumero());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dao.fechar();
			}catch(Exception e){
				e.printStackTrace();
			
			}
		}	
	}

}
