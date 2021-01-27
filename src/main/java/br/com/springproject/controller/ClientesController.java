package br.com.springproject.controller;

import br.com.springproject.config.MvcConfiguration;
import br.com.springproject.entities.Cliente;
import br.com.springproject.repositories.impl.ClienteRepository;
import br.com.springproject.repositories.interfaces.IClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientesController {

	@RequestMapping("/formularioCliente")
	public String formularioCliente() {
		// WEB-INF/views/clientes/formulario-cliente.jsp
		Cliente cliente = new Cliente();
		cliente.setNome("Luana");
		cliente.setEmail("luana@gmail.com");
		MvcConfiguration configuration = new MvcConfiguration();
		IClienteRepository repository = configuration.getClienteRepository();
		try {
			repository.create(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Gravado com sucesso!");
		return "clientes/formulario-cliente";
	}

	@RequestMapping("/listagemClientes")
	public String listagemClientes() {
		// WEB-INF/views/clientes/listagem-clientes.jsp
		return "clientes/listagem-clientes";
	}
}
