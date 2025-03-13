package com.Integrador.integrador.IntegradorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;
import com.Integrador.integrador.IntegradorService.OrcamentoService;
import com.Integrador.integrador.IntegradorService.RelatorioService;

@RestController
@RequestMapping("orcamento")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	/*@Autowired
	private RelatorioService relatorioService;

    @Autowired
    public OrcamentoController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }*/

	@Autowired
	private OrcamentoRepository orcamentoRepository;

	@PostMapping
	public ResponseEntity<OrcamentoEntity> criarOrcamento(@RequestBody OrcamentoEntity orcamento) {
		OrcamentoEntity createdOrcamento = orcamentoService.criarOrcamento(orcamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrcamento);
	}

	@GetMapping("/somar")
	public ResponseEntity<Float> somar(@RequestParam float a, @RequestParam int b) {
		float resultado = a + b;
		return ResponseEntity.ok(resultado);
	}

	@PostMapping("/calcular")
	public ResponseEntity<Double> calcularTotalOrcamento(@RequestBody List<ProdutoServicoEntity> produtos) {
		Double total = orcamentoService.calcularOrcamento(produtos);
		return ResponseEntity.ok(total);
	}

	/*@GetMapping("/pdf/{id}")
	public ResponseEntity<byte[]> gerarOrcamentoPdf(@PathVariable Long id) {
		byte[] pdfBytes;
		try {
			pdfBytes = relatorioService.gerarPdf(id);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=orcamento_" + id + ".pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}*/

	@GetMapping
	public ResponseEntity<List<OrcamentoEntity>> listarOrcamentos() {
		List<OrcamentoEntity> orcamentos = orcamentoService.listarTodosOrcamentos();
		return ResponseEntity.ok(orcamentos);
	}

}
