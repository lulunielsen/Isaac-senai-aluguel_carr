package com.LuisaLocacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.LuisaLocacao.models.Agencia;
import com.LuisaLocacao.models.Carro;
import com.LuisaLocacao.models.Cliente;
import com.LuisaLocacao.models.Locacao;
import com.LuisaLocacao.models.Moto;
import com.LuisaLocacao.models.view.LocacaoView;
import com.LuisaLocacao.repository.AgenciaRepository;
import com.LuisaLocacao.repository.CarroRepository;
import com.LuisaLocacao.repository.ClienteRepository;
import com.LuisaLocacao.repository.LocacaoRepository;
import com.LuisaLocacao.repository.MotoRepository;

@Controller
public class LocacaoController {
	
	@Autowired
	private LocacaoRepository lr;
	@Autowired
	private CarroRepository cr;
	@Autowired
	private ClienteRepository clr;
	@Autowired
	private MotoRepository mr;
	@Autowired
	private AgenciaRepository ar;

	
	@RequestMapping(value = "/cadastrarLocacao", method = RequestMethod.GET)
	public ModelAndView cadastrarLocacao() {
		//ModelAndView mv = new ModelAndView("locacao/locacoes");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/locacao/formCadastrarLocacao");
		Iterable<Carro> carros = cr.findAll();
		mv.addObject("carros", carros);
		Iterable<Cliente> clientes = clr.findAll();
		mv.addObject("clientes", clientes);	
		Iterable<Moto> motos = mr.findAll();
		mv.addObject("motos", motos);	
		Iterable<Agencia> agencias = ar.findAll();
		mv.addObject("agencias", agencias);
		return mv;
	}
	
	@RequestMapping(value = "/cadastrarLocacao", method = RequestMethod.POST)
	public String cadastrarLocacao(LocacaoView locacao) {
		
		Moto moto = null;
		if (locacao.getMoto() != null) {
			moto = mr.findByCodigo(Long.parseLong(locacao.getMoto()));
		}
		
		Carro carro = null;
		if (locacao.getCarro() != null) {
			carro = cr.findByCodigo(Long.parseLong(locacao.getCarro()));
		}
		
		Agencia agencia = null;
		if (locacao.getAgencia() != null) {
			agencia = ar.findByCodigo(Long.parseLong(locacao.getAgencia()));			
		}

		Cliente cliente = null;
		if (locacao.getCliente() != null) {
			cliente = clr.findByCodigo(Long.parseLong(locacao.getCliente()));			
		}						
		Locacao l = new Locacao();
						
		if (moto != null) {
			l.setMoto(moto);
		}
		
		if (carro != null) {
			l.setCarro(carro);
		}
		
		if (agencia != null) {
			l.setAgencia(agencia);
		}
		
		if (cliente != null) {
			l.setCliente(cliente);
		}
		
		
		
		l.setData(locacao.getData());
		l.setSeguro(locacao.getSeguro());
		
		lr.save(l);
		return "redirect:/locacoes";
	}
	
	@RequestMapping("/locacoes")
	public ModelAndView listaLocacoes() {
		ModelAndView mv = new ModelAndView("locacao/locacoes");
		Iterable<Locacao> locacoes = lr.findAll();
		mv.addObject("locacoes", locacoes);
		return mv;
	}
	
	
	
	
	
	
	
//	@RequestMapping(value = "/editarCarro", method = RequestMethod.GET)
//	public ModelAndView editarCarro(@ModelAttribute("codigo") long codigo) {
//		Carro carro = cr.findByCodigo(codigo);		
//		ModelAndView m = new ModelAndView();
//		m.setViewName("/carro/formEditarCarro");
//		m.addObject("carro", carro);
//		return m;	
//	}

}
