package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Produto;
import conexao.ConexaoFactory;

public class ProdutoDAO {
	private Connection con;
	
	public ProdutoDAO() throws Exception{
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar() throws Exception{
		con.close();
		return "Fechado com sucesso";
	}
	
	public String gravar(Produto prod) throws Exception{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("INSERT INTO produto"
		+ "(id_prod,nome_prod,valor_prod)VALUES"
		+ "(?,?,?)");
		estrutura.setInt(1,prod.getCodigo() );
		estrutura.setString(2, prod.getDescricao() );
		estrutura.setDouble(3, prod.getValor());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";	
	}
	
	public Produto getProduto(int n) throws Exception{
		Produto prod = new Produto();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT id_prod, nome_prod, valor_prod FROM produto WHERE id_prod = ?");
		estrutura.setInt(1,n);
		ResultSet resultado = estrutura.executeQuery();
		
		if(resultado.next()){
			prod.setCodigo(resultado.getInt("codigo"));
			prod.setDescricao(resultado.getString("descricao"));
			prod.setValor(resultado.getDouble("valor"));
		}
		
		resultado.close();
		estrutura.close();
		return prod;
	}
	
	public double aumentar(double num) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
				("UPDATE produto SET valor_prod = valor_prod + (valor_prod* ?)");
		estrutura.setDouble(1, num/100);
		double x = estrutura.executeUpdate();
		estrutura.close();
		return x;
	}
	
	public List <Produto> listarPorValor(Double n)throws Exception{
		List<Produto> lista = new ArrayList<Produto>();
		Produto obj = new Produto();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT id_prod, nome_prod, valor_prod FROM produto WHERE valor_prod = ?");
		estrutura.setDouble(1,n);
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			obj = new Produto();
			obj.setCodigo(resultado.getInt("codigo"));
			obj.setDescricao(resultado.getString("descricao"));
			obj.setValor(resultado.getDouble("valor"));
			lista.add(obj);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
}
