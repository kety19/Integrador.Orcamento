package com.Integrador.integrador.IntegradorService;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Integrador.integrador.IntegradorEntites.ClienteEntity;
import com.Integrador.integrador.IntegradorEntites.EmissorEntity;
import com.Integrador.integrador.IntegradorEntites.OrcamentoEntity;
import com.Integrador.integrador.IntegradorEntites.ProdutoServicoEntity;
import com.Integrador.integrador.IntegradorRepository.OrcamentoRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import jakarta.transaction.Transactional;

@Service
public class RelatorioService {
	@Autowired
	private OrcamentoRepository orcamentoRepository;

	@Autowired
	public RelatorioService(OrcamentoRepository orcamentoRepository) {
		this.orcamentoRepository = orcamentoRepository;
	}


public byte[] gerarPdf(Long id) {
    OrcamentoEntity orcamento = orcamentoRepository.findByIdWithRelations(id)
            .orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    try {
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Informações do orçamento
        document.add(new Paragraph("Orçamento ID: " + orcamento.getId()));
        document.add(new Paragraph("Total: " + orcamento.getTotal()));
        document.add(new Paragraph("Data de Criação: " + orcamento.getDataCriacao().toString()));

        // Informações do cliente
        ClienteEntity cliente = orcamento.getCliente();
        if (cliente != null) {
            document.add(new Paragraph("Cliente: " + cliente.getNome()));
            document.add(new Paragraph("Endereço: " + cliente.getEndereco()));
            document.add(new Paragraph("Telefone: " + cliente.getTelefone()));
            document.add(new Paragraph("Email: " + cliente.getEmail()));
        }

        // Informações do emissor
        EmissorEntity emissor = orcamento.getEmissor();
        if (emissor != null) {
            document.add(new Paragraph("Emissor: " + emissor.getNome()));
            document.add(new Paragraph("CNPJ: " + emissor.getCnpj()));
            document.add(new Paragraph("Endereço: " + emissor.getEndereco()));
            document.add(new Paragraph("Telefone: " + emissor.getTelefone()));
            document.add(new Paragraph("Email: " + emissor.getEmail()));
            document.add(new Paragraph("Logo URL: " + emissor.getLogoUrl()));
        }

        // Produtos/Serviços
        List<ProdutoServicoEntity> produtos = orcamento.getProdutosServicos();
        if (produtos != null && !produtos.isEmpty()) {
            document.add(new Paragraph("Produtos/Serviços:"));
            for (ProdutoServicoEntity produto : produtos) {
                document.add(new Paragraph("Nome: " + produto.getNome()));
                document.add(new Paragraph("Descrição: " + produto.getDescricao()));
                document.add(new Paragraph("Preço Unitário: " + produto.getPreco()));
                document.add(new Paragraph("Quantidade: " + produto.getQuantidade()));
                document.add(new Paragraph("----------"));
            }
        } else {
            document.add(new Paragraph("Nenhum produto ou serviço associado."));
        }

        document.close();
    } catch (RuntimeException e) {
        throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage(), e); // Inclui a exceção original
    } catch (Exception e) {
        throw new RuntimeException("Erro inesperado ao gerar PDF: " + e.getMessage(), e);
    }

    return outputStream.toByteArray();
}
}
