package testes;

import javax.swing.JOptionPane;

import dao.ClienteDAO;

public class TesteDelete {

	public static void main(String[] args) {
		ClienteDAO dao = null;
		try{
		    dao = new ClienteDAO();
			int x = dao.delete
					(Integer.parseInt
					(JOptionPane.showInputDialog("Digite um numero")));
			System.out.println(x + "cliente(s) foi(ram) excluidos(s)");
		}catch(Exception e) {
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
