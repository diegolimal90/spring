package com.diegolima.cursomc;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegolima.cursomc.domain.Categoria;
import com.diegolima.cursomc.domain.Cidade;
import com.diegolima.cursomc.domain.Cliente;
import com.diegolima.cursomc.domain.Endereco;
import com.diegolima.cursomc.domain.Estado;
import com.diegolima.cursomc.domain.Pagamento;
import com.diegolima.cursomc.domain.PagamentoComBoleto;
import com.diegolima.cursomc.domain.PagamentoComCartao;
import com.diegolima.cursomc.domain.Pedido;
import com.diegolima.cursomc.domain.Produto;
import com.diegolima.cursomc.domain.enums.EstadoPagamento;
import com.diegolima.cursomc.domain.enums.TipoCliente;
import com.diegolima.cursomc.repositories.CategoriaRepository;
import com.diegolima.cursomc.repositories.CidadeRepository;
import com.diegolima.cursomc.repositories.ClienteRepository;
import com.diegolima.cursomc.repositories.EnderecoRepository;
import com.diegolima.cursomc.repositories.EstadoRepository;
import com.diegolima.cursomc.repositories.PagamentoRepository;
import com.diegolima.cursomc.repositories.PedidoRepository;
import com.diegolima.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args){
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com.br", "33366699911", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("13988887777", "13988887777"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 230", "Jardim", "11300900", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Capim", "303", "Sala 230", "Centro", "11300000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
	}
	
	
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
>>>>>>> branch 'master' of https://github.com/diegolimal90/spring.git
}
