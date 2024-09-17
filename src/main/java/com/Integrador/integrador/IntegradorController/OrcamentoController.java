package com.Integrador.integrador.IntegradorController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorService.OrcamentoService;


@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {


	    @Autowired
	    private OrcamentoService orcamentoService;

	    @PostMapping ("/save")
	    public ResponseEntity<OrcamentoEntity> criarOrcamento(@RequestBody OrcamentoEntity orcamento) {
	        OrcamentoEntity novoOrcamento = orcamentoService.criarOrcamento(orcamento);
	        return new ResponseEntity<>(novoOrcamento, HttpStatus.CREATED);
	    }
	    
	    
	    @GetMapping("/somar")
	    public ResponseEntity<Float> somar(@RequestParam float a, @RequestParam int b) {
	        float resultado = a + b;
	        return ResponseEntity.ok(resultado);
	    }

	    @GetMapping("/{id}/pdf")
	    public ResponseEntity<byte[]> gerarPdf(@PathVariable Long id) {
			return null;
	        // Implementar a geração de PDF aqui
	    }
		public OrcamentoService getOrcamentoService() {
			return orcamentoService;
		}
		public void setOrcamentoService(OrcamentoService orcamentoService) {
			this.orcamentoService = orcamentoService;
		}

}
