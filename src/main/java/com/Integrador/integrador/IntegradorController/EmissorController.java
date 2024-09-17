package com.Integrador.integrador.IntegradorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorService.EmissorService;

@RestController
@RequestMapping("/api/emissor")
public class EmissorController {

	    @Autowired
	    private EmissorService emissorService;

	    @PostMapping
	    public ResponseEntity<EmissorEntity> criarEmissor(@RequestBody EmissorEntity emissor) {
	        EmissorEntity emissorSalvo = emissorService.salvarEmissor(emissor);
	        return ResponseEntity.ok(emissorSalvo);
	    }

	    // Outros endpoints...
	}

