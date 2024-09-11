package IntegradorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import IntegradorEntites.ProdutoServicoEntity;
import IntegradorRepository.ProdutoServicoRepository;

public class ProjetoServicoController {

    @Autowired
    private ProdutoServicoRepository projetoServicoRepository;

    // Criar um novo projeto/serviço
    @PostMapping
    public ResponseEntity<ProdutoServicoEntity> criarProjetoServico(@RequestBody ProdutoServicoEntity produtoServico) {
        ProdutoServicoEntity novoProjetoServico = projetoServicoRepository.save(produtoServico);
        return new ResponseEntity<>(novoProjetoServico, HttpStatus.CREATED);
    }

    // Listar todos os projetos/serviços
    @GetMapping
    public ResponseEntity<List<ProdutoServicoEntity>> listarProjetosServicos() {
        List<ProdutoServicoEntity> produtoServicos = projetoServicoRepository.findAll();
        return new ResponseEntity<>(produtoServicos, HttpStatus.OK);
    }
}
