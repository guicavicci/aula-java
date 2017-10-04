package testes;

import java.sql.Connection;

import conexao.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) {
		Connection c = null;
		try{
			c = new ConexaoFactory().conectar();
			System.out.println("Conectado");
			
		}catch(Exception e){
			//System.out.println("Ocorreu um erro fatal");
			e.printStackTrace();
		}finally{
			try{
				c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
