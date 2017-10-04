package excecao;

import java.sql.SQLException;

public class Excecao extends Exception{
	public static String tratarExcecao(Exception e){
		if(e instanceof NumberFormatException){
			return "Número inválido";
		}else if (e instanceof SQLException){
			if(e.getMessage().indexOf("invalid username")>=0){
				return "Usuário ou senha inválido";
			}else if(e.getMessage().indexOf("tabela ou view")>=0){
				return "Problema na tabela";
			}
			return "Erro ao conectar no banco de dados";
		}else{
			return "Ocorreu um erro inesperado";
		}
	}
}
