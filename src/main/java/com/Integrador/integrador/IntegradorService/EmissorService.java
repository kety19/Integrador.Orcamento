package com.Integrador.integrador.IntegradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorRepository.EmissorRepository;

@Service
public class EmissorService {

	@Autowired

	private EmissorRepository emissorRepository;

	public EmissorEntity salvarEmissor(EmissorEntity emissor) {
		return emissorRepository.save(emissor);
	}

    public EmissorEntity criarEmissor(EmissorEntity emissor) {
        // Validações
        if (emissor.getNome() == null || emissor.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (!isCnpjValido(emissor.getCnpj())) {
            throw new IllegalArgumentException("CNPJ inválido");
        }

        // Salva o emissor no repositório
        return emissorRepository.save(emissor);
    }

    private boolean isCnpjValido(String cnpj) {
        // Lógica para validar o CNPJ (implementar conforme necessário)
        return cnpj != null && cnpj.matches("\\d{14}"); // Exemplo de validação simples
    }

	public List<EmissorEntity> listarTodosEmissores() {
		return emissorRepository.findAll();
	}

	public void deletarEmissor(Long id) {
		EmissorEntity emissor = buscarEmissorPorId(id);
		emissorRepository.delete(emissor);
	}

	private EmissorEntity buscarEmissorPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
