package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Cliente;
import beans.Telefone;
import conexao.ConexaoFactory;

public class TelefoneDAO {
	private PreparedStatement estrutura;
	private ResultSet rs;
	private Connection con;
	
	public TelefoneDAO() throws Exception{
		con = new ConexaoFactory().conectar();
	}
	public void fechar() throws Exception{
		con.close();
	}
	public String gravar(Cliente objeto) throws Exception{
		for (Telefone t : objeto.getFones()){
			estrutura = con.prepareStatement
					("INSERT INTO TB_TAP_TELEFONE "
					+ "(NR_TELEFONE, NM_OPERADORA, NR_DDD, NR_CLIENTE)"
					+ " VALUES (????)");
			estrutura.setString(1, t.getNumero());
			estrutura.setString(2, t.getOperadora());
			estrutura.setString(3, t.getDdd());
			estrutura.setInt(4, objeto.getNumero());
			estrutura.execute();
			
		}
		
		return "Cadastrado com sucesso";
	}
}
