package testes;

import java.util.List;

import javax.swing.JOptionPane;

import beans.Cliente;
import dao.ClienteDAO;

public class TesteLista {

	public static void main(String[] args) {
			ClienteDAO dao = null;
		try{
			dao = new ClienteDAO();
			List<Cliente> lista = dao.listarPorNome
					(JOptionPane.showInputDialog("Digite o nome"));
			for(Cliente c : lista){
				System.out.print(" " + c.getNome());
				System.out.print(" " + c.getQtddeEstrelas());
				System.out.println(" " + c.getNumero());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
