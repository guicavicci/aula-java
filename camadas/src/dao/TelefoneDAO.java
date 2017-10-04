package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
					("INSERT INTO telefone "
					+ "(id_telefone, numero_telefone, operadora, ddd, id_cliente)"
					+ " VALUES (????)");
			estrutura.setInt(1, t.getId());
			estrutura.setString(2, t.getNumero());
			estrutura.setString(3, t.getOperadora());
			estrutura.setString(4, t.getDdd());
			estrutura.setInt(5, objeto.getNumero());
			estrutura.execute();
			estrutura.close();
						
			
		}
			
			return "Cadastrado com sucesso";
			
		}
	
	
	public List<Telefone> consultarPorCliente (int nc) throws Exception{
		List<Telefone> lista = new ArrayList <>();
		estrutura= con.prepareStatement
				("SELECT * FROM telefone where id_cliente = ?");
		estrutura.setInt(1, nc);
		rs= estrutura.executeQuery();
		while(rs.next()) {
			lista.add(new Telefone
					(
					rs.getInt("id_telefone"),
					rs.getString("operadora"),
					rs.getString("numero"),
					rs.getString("ddd")));
		
			
		
			
		}
		
		return lista;
		
		
	}
	
	public String deletarPorCliente (int numeroCliente) throws Exception {
		estrutura = con.prepareStatement("DELETE FROM telefone WHERE id_cliente = ?");
		estrutura.setInt(1, numeroCliente);
		estrutura.executeUpdate();
		
		return "Deletado com sucesso!";
	}
		
		
	
	}
	

