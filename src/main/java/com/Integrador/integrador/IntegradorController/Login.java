package com.Integrador.integrador.IntegradorController;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Login {
	  @Autowired
	    private UsuarioService pessoaService;

	    @PreAuthorize("hasRole('ADMIN') or hasRole('USUARIO')")
	    @PostMapping("/login")
	    public ResponseEntity<String> logar(@RequestBody LoginRequest login) {
	        try {
	            return ResponseEntity.ok(pessoaService.logar(login));
	        }catch(AuthenticationException ex) {
	            System.out.println(ex.getMessage());
	            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	        }catch (Exception e) {
	            System.out.println(e.getMessage());
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        }
}
