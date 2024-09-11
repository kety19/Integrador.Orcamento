package IntegradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import IntegradorEntites.ClienteEntity;
import org.springframework.stereotype.Service;
import IntegradorRepository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }


}
