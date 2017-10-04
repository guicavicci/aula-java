package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String adicionarNovoCliente(Cliente cli) throws Exception{
		if(cli.getNome().length()>40){
			return "Excedeu a qtde de caracteres";
		}
		if(cli.getQtddeEstrelas()<1 || cli.getQtddeEstrelas()>7){
			return "Qtde Estrelas invalida";
		}
		ClienteDAO dao = new ClienteDAO();
		if(dao.getCliente(cli.getNumero()).getNumero()>0){
			dao.fechar();
			return "Este número já existe";
		}
		String x  = dao.gravar(cli);
		dao.fechar();
		return x;
	}
	
	public static Cliente consultarProCodigo(int pNumeroCliente) throws Exception{
		if(pNumeroCliente < 1 ){
			return new Cliente();
		}
		ClienteDAO dao = new ClienteDAO();
		Cliente objeto = dao.getCliente(pNumeroCliente);
		dao.fechar();
		return objeto;
	}
	
	public static int deletarCliente(int pNumeroCliente) throws Exception{
		if(pNumeroCliente < 1){
			return 0;
		}
		ClienteDAO dao = new ClienteDAO();
		int x = dao.delete(pNumeroCliente);
		dao.fechar();
		return x;
	}
} 
