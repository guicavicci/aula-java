package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;
	
	public ClienteDAO() throws Exception{
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar() throws Exception{
		con.close();
		return "Conexao fechada";
	}
	
	public String gravar(Cliente cli) throws Exception{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("INSERT INTO cliente"
		+ "(id_cliente,nome_cliente,estrelas)VALUES"
		+ "(?,?,?)");
		estrutura.setInt(1, cli.getNumero() );
		estrutura.setString(2, cli.getNome() );
		estrutura.setInt(3, cli.getQtddeEstrelas());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";		
	}
	
	public Cliente getCliente(int n) throws Exception{
		Cliente cli = new Cliente();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT * FROM cliente WHERE id_cliente = ?");
		estrutura.setInt(1,n);
		ResultSet resultado = estrutura.executeQuery();
		
		if(resultado.next()){
			cli.setNome(resultado.getString("NM_CLIENTE"));
			cli.setNumero(resultado.getInt("NR_CLIENTE"));
			cli.setQtddeEstrelas(resultado.getInt("QT_ESTRELAS"));
		}
		
		resultado.close();
		estrutura.close();
		return cli;
	}
	
	public int delete(int num) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
				("DELETE FROM cliente WHERE id_cliente = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	
	public int uparNivel(int num)throws Exception{
		PreparedStatement estrutura = con.prepareStatement
				("UPDATE cliente SET estrelas = estrelas+1 WHERE id_cliente = ?");
		estrutura.setInt(1, num);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
	}
	
	public List <Cliente> listarPorNome(String n)throws Exception{
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente obj = new Cliente();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT * FROM cliente WHERE nome_cliente LIKE ?");
		estrutura.setString(1,n + "%");
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			obj = new Cliente();
			obj.setNome(resultado.getString("NM_CLIENTE"));
			obj.setNumero(resultado.getInt("NR_CLIENTE"));
			obj.setQtddeEstrelas(resultado.getInt("QT_ESTRELAS"));
			lista.add(obj);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
}
