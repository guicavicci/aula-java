package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	
	public Connection conectar()throws Exception{
		return DriverManager.getConnection
		("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM73865", "301086");
		//("jdbc:mysql:dbname=tb_tap_cliente;host=localhost", "root", "" );		
	}
}
