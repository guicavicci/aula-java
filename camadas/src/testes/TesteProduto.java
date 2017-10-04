package testes;

import java.util.List;
import javax.swing.JOptionPane;
import beans.Produto;
import dao.ProdutoDAO;

public class TesteProduto {

	public static void main(String[] args) {
		ProdutoDAO dao = null;
		try{
			dao = new ProdutoDAO();
			do{
				char op =JOptionPane.showInputDialog
				("Escolha uma op��o:\n "
					+ "<G> - Gravar\n "
					+ "<C> - Consultar\n "
					+ "<L> - Listar\n "
					+ "<A> - Aumentar").toUpperCase().charAt(0);
				if (op=='G'){
					// c�digo para executar gravar()
					Produto obj = new Produto();
					obj.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Codigo")));
					obj.setDescricao(JOptionPane.showInputDialog("Descri��o"));
					obj.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor")));
					System.out.println(dao.gravar(obj));
				}else if (op=='C'){
					// c�digo para executar getProduto()
					Produto prod = dao.getProduto(Integer.parseInt(JOptionPane.showInputDialog("Codigo")));
					System.out.println("Codigo: " + prod.getCodigo());
					System.out.println("Descricao: " + prod.getDescricao());
					System.out.println("Valor: " + prod.getValor());
				}else if (op=='L'){
					// c�digo para executar listar()
					List<Produto> lista = dao.listarPorValor
					(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto")));
					
					for(Produto p : lista){
						System.out.print(" " + p.getCodigo());
						System.out.print(" " + p.getDescricao());
						System.out.println(" " + p.getValor());
					}
				}else if (op=='A'){
					// c�digo para executar aumentar()
					double x = dao.aumentar(Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de aumento")));
					System.out.println(x + "Produtos atualizados");
				}else{
					System.out.println("Op��o inv�lida!!!");
				}
			}while(JOptionPane.showConfirmDialog
					(null, "Continuar?", "ProdutoDAO",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE)==0);
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
