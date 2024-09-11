package IntegradorController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import IntegradorEntites.EmissorEntity;
import IntegradorService.EmissorService;

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

