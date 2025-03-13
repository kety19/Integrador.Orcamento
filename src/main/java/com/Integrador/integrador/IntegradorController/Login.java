package com.Integrador.integrador.IntegradorController;

import org.springframework.security.access.prepost.PreAuthorize;
import com.Integrador.integrador.IntegradorService.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


	@RestController
	@RequestMapping("/api")
	@CrossOrigin("*")
	public class Login {
	  @Autowired
	    private ClienteService clienteService;

	    @PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
	    @PostMapping("/login")
	    public ResponseEntity<String> logar(@RequestBody LoginRequest login) {
	        try {
	            return ResponseEntity.ok(clienteService.logar(login));
	        }catch(AuthenticationException ex) {
	            System.out.println(ex.getMessage());
	            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	        }catch (Exception e) {
	            System.out.println(e.getMessage());
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        }
}
	 }
