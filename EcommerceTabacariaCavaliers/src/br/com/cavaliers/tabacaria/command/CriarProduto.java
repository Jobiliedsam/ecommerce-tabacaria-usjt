package br.com.cavaliers.tabacaria.command;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.cavaliers.tabacaria.model.Produto;
import br.com.cavaliers.tabacaria.service.ProdutoService;



public class CriarProduto implements Command
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int numeroFoto = 0;
		String pNome = request.getParameter("nomeP");
		String pCategoria = request.getParameter("categoria");
		String pFornecedor = request.getParameter("fornecedor");
		String pStatus = request.getParameter("status");
		String pDescricao = request.getParameter("descricao");
		// Tratando o dado de preço, substituindo o valor em virgula para ponto
		double pPreco = Double.parseDouble(request.getParameter("precoF").replace(",", "."));
		int pQuantidade = Integer.parseInt(request.getParameter("quantidade"));
		


		
		// Capturando a lista de fotos
		List<Part> fileParts = request.getParts().stream()
				.filter(part -> "fotos".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		
		// Salvando cada foto em um local especifico	
		for(Part filePart : fileParts)
		{
			
			String fileName = pNome + "_" + numeroFoto + ".jpg";
					//Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			InputStream fileContent = filePart.getInputStream();
			
			System.out.println("Iamgem inserida com sucesso 3");
			File file = new File(
					"C:\\Users\\jobil\\OneDrive\\Prog\\Git\\EcommerceTabacaria_SJ\\EcommerceTabacariaCavaliers\\WebContent\\imagens\\produtos\\" + fileName);
			
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			numeroFoto++;
			
		}
		

		Produto produto = new Produto();
		produto.setNomeP(pNome);
		produto.setPrecoF(pPreco);
		produto.setCategoria(pCategoria);
		produto.setFornecedor(pFornecedor);
		produto.setStatus(pStatus);
		produto.setDescricao(pDescricao);
		produto.setQuantidade(pQuantidade);
		
		ProdutoService ps = new ProdutoService();
		ps.criar(produto);

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		ArrayList<Produto> lista = new ArrayList<>();
		lista.add(produto);
		session.setAttribute("listaProduto", lista);
		view = request.getRequestDispatcher("ListarProduto.jsp");
		
		view.forward(request, response);
		
	}

}
