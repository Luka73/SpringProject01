package br.com.springproject.controller;

import br.com.springproject.entities.Cliente;
import br.com.springproject.repositories.interfaces.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	@Autowired
	private IClienteRepository clienteRepository;

	@RequestMapping("/formulario-cliente")
	public ModelAndView formularioCliente() {
		// WEB-INF/views/clientes/formulario-cliente.jsp
		ModelAndView modelAndView = new ModelAndView("clientes/formulario-cliente");
		modelAndView.addObject("cliente", new Cliente());
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar-cliente", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente(Cliente cliente, ModelMap map) {
		try{
			if(clienteRepository.findByEmail(cliente.getEmail()) != null) {
				throw new Exception("O email " + cliente.getEmail()
						+ ", já encontra-se cadastrado. Tente outro.");
			}
			clienteRepository.create(cliente);
			map.addAttribute("mensagem_sucesso", "Cliente "
					+ cliente.getNome() + " cadastrado com sucesso!");
		} catch (Exception e) {
			map.addAttribute("mensagem_erro", e.getMessage());
		}

		ModelAndView modelAndView = new ModelAndView("clientes/formulario-cliente", map);
		modelAndView.addObject("cliente", new Cliente());
		return modelAndView;
	}

	@RequestMapping("/listagem-clientes")
	public ModelAndView listagemClientes(ModelMap map) {

		// WEB-INF/views/clientes/listagem-clientes.jsp
		ModelAndView modelAndView = new ModelAndView("clientes/listagem-clientes");

		try{
			modelAndView.addObject("clientes", clienteRepository.findAll());
		} catch (Exception e) {
			map.addAttribute("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping("/excluir-cliente")
	public ModelAndView excluirCliente(Integer id, ModelMap map) {
		ModelAndView modelAndView = new ModelAndView("clientes/listagem-clientes");

		try{
			Cliente cliente = clienteRepository.findById(id);

			if(cliente != null) {
				clienteRepository.delete(id);
				map.addAttribute("mensagem_sucesso", "Cliente "  + cliente.getNome() + " excluído com sucesso!");
			} else {
				map.addAttribute("mensagem_erro", "Cliente não encontrado");
			}
			modelAndView.addObject("clientes", clienteRepository.findAll());
		}catch(Exception e) {
			map.addAttribute("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping("/edicao-cliente")
	public ModelAndView edicaoCliente(Integer id, ModelMap map) {
		ModelAndView modelAndView = new ModelAndView("clientes/edicao-cliente");

		try{
			Cliente cliente = clienteRepository.findById(id);

			if(cliente != null) {
				modelAndView.addObject("cliente", cliente);
			} else {
				map.addAttribute("mensagem_erro", "Cliente não encontrado");
				modelAndView.setViewName("clientes/listagem-clientes");
				modelAndView.addObject("clientes", clienteRepository.findAll());
			}
		} catch (Exception e) {
			map.addAttribute("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "atualizar-cliente", method= RequestMethod.POST)
	public ModelAndView atualizarCliente(Cliente cliente, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView("clientes/edicao-cliente");
		try {
			Cliente clienteByEmail = clienteRepository.findByEmail(cliente.getEmail());
			if(clienteByEmail != null && !clienteByEmail.equals(cliente)) {
				map.addAttribute("mensagem_erro", "O email informado já está cadastrado para outro cliente");
			} else {
				clienteRepository.update(cliente);
				map.addAttribute("mensagem_sucesso", "Cliente atualizado com sucesso");
			}
			modelAndView.addObject("cliente", cliente);
		}catch (Exception e) {
			map.addAttribute("mensagem_erro", e.getMessage());
		}
		return modelAndView;
	}
}
