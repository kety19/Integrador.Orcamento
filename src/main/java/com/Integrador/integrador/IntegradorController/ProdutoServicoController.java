package com.Integrador.integrador.IntegradorController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorService.ProdutoServicoService;

import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping("/produtos-servicos")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@PermitAll
@PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
public class ProdutoServicoController {

	@Autowired
	private ProdutoServicoService produtoServicoService;

	@PostMapping("/produtos")
	public ResponseEntity<ProdutoServicoEntity> criarProdutoServico(@RequestBody ProdutoServicoEntity novoProduto) {
		ProdutoServicoEntity produtoCriado = produtoServicoService.criarProdutoServico(novoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
	}
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
	@GetMapping("/listarProdutos")
	public ResponseEntity<List<ProdutoServicoEntity>> listarProdutosServicos() {
		List<ProdutoServicoEntity> produtosServicos = produtoServicoService.listarTodos();
		return ResponseEntity.ok(produtosServicos);
	}

	@GetMapping("/produtos/{id}")
	public Optional<ProdutoServicoEntity> buscarPorId(@PathVariable Long id) {
		return produtoServicoService.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public ProdutoServicoEntity atualizarProdutoServico(@PathVariable Long id,
			@RequestBody ProdutoServicoEntity produtoServico) {
		return produtoServicoService.atualizarProdutoServico(id, produtoServico);
	}

	@DeleteMapping("/{id}")
	public void deletarProdutoServico(@PathVariable Long id) {
		produtoServicoService.deletarProdutoServico(id);
	}
}
