package testes;

import javax.swing.JOptionPane;

import beans.Cliente;
import dao.ClienteDAO;

public class TesteGravarCliente {
	public static void main(String[] args){
		ClienteDAO dao = null;
		try{
			dao = new ClienteDAO();
			Cliente obj = new Cliente();
			obj.setNome(JOptionPane.showInputDialog("Nome"));
			obj.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Numero")));
			obj.setQtddeEstrelas(Integer.parseInt(JOptionPane.showInputDialog("Estrelas")));
			System.out.println(dao.gravar(obj));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				System.out.println(dao.fechar());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
