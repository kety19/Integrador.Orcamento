package com.Integrador.integrador.IntegradorController;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Integrador.integrador.IntegradorService.RelatorioService;
@RestController
@RequestMapping("/relatorios")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping(value = "/orcamento/{id}/pdf", produces = "application/pdf")
    public ResponseEntity<byte[]> gerarPdf(@PathVariable Long id) {
        byte[] pdfBytes = relatorioService.gerarPdf(id); // Chamando o serviço

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.setContentDispositionFormData("filename", "orcamento_" + id + ".pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK); // Retornando o PDF gerado
    }
}