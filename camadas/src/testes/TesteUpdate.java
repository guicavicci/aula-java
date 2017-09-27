package testes;

import javax.swing.JOptionPane;

import dao.ClienteDAO;

public class TesteUpdate {

	public static void main(String[] args) {
		ClienteDAO dao = null;
		try{
			dao = new ClienteDAO();
			int x = dao.uparNivel
					(Integer.parseInt(JOptionPane.showInputDialog("Digite um numero")));
			System.out.println( x + "cadastro atualizado");
			
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
