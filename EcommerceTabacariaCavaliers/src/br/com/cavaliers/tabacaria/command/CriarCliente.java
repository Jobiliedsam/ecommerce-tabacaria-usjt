package br.com.cavaliers.tabacaria.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.cavaliers.tabacaria.model.Cliente;
import br.com.cavaliers.tabacaria.model.Endereco;
import br.com.cavaliers.tabacaria.model.Usuario;
import br.com.cavaliers.tabacaria.service.ClienteService;
import br.com.cavaliers.tabacaria.service.EnderecoService;
import br.com.cavaliers.tabacaria.service.UsuarioService;

public class CriarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Usuario usuario = new Usuario();

		ClienteService clienteService = new ClienteService();
		EnderecoService enderecoService = new EnderecoService();

		UsuarioService us = new UsuarioService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
	
	
		SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy"); 
		SimpleDateFormat formatoA = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date dataFormatada = new Date() ;
		
		String pData = request.getParameter("data");
		try {
			dataFormatada = formato.parse(pData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str1 = formatoA.format(dataFormatada);
		
		cliente.setCelular(request.getParameter("celularCliente"));
		cliente.setNomeCompleto(request.getParameter("nomeCliente"));
		cliente.setTelefone(request.getParameter("telefoneCliente"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setGenero(request.getParameter("generoCliente"));
		cliente.setCpfCnpj(request.getParameter("cpfCliente"));
		cliente.setTipo("F�sica");

		//cliente.setDataDeNascimento(request.getParameter("data"));
		cliente.setDataDeNascimento(str1);
		//cliente.setRg(request.getParameter("rg"));

		cliente.setIdCliente(clienteService.criar(cliente));

		endereco.setIdCliente(cliente.getIdCliente());
		endereco.setEnderecoP(request.getParameter("enderecoPrincipal"));
		endereco.setCep(request.getParameter("cep"));
		endereco.setEnderecoS(request.getParameter("bairro"));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setEstado(request.getParameter("estado"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setEndereco(enderecoService.criar(endereco));

		
		usuario.setId(cliente.getIdCliente());

		usuario.setEmail(request.getParameter("email"));
		usuario.setPassword(request.getParameter("password"));
		usuario.setTipo(request.getParameter("tipo"));
		us.criar(usuario);

		ArrayList<Cliente> lista = new ArrayList<>();
		lista.add(cliente);
		session.setAttribute("listaCliente", lista);
		view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

	}

}
