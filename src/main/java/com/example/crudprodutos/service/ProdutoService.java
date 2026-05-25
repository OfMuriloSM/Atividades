//service/ProdutoServece.java
package com.example.crudprodutos.service;

import com.example.crudprodutos.dto.ProdutoDTO;
import com.example.crudprodutos.model.Produto;
import com.example.crudprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrar(ProdutoDTO dto) {

        if(dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if(dto.getCategoria() == null || dto.getCategoria().isBlank()) {
            throw new RuntimeException("Categoria obrigatória");
        }

        if(dto.getPreco() < 0) {
            throw new RuntimeException("Preço não pode ser negativo");
        }

        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());

        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Produto> atualizar(Long id, ProdutoDTO dto) {

        if(dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RuntimeException("Nome obrigatório");
        }

        if(dto.getCategoria() == null || dto.getCategoria().isBlank()) {
            throw new RuntimeException("Categoria obrigatória");
        }

        if(dto.getPreco() < 0) {
            throw new RuntimeException("Preço não pode ser negativo");
        }

        Optional<Produto> produtoOpt = repository.findById(id);

        if(produtoOpt.isPresent()) {

            Produto produto = produtoOpt.get();

            produto.setNome(dto.getNome());
            produto.setPreco(dto.getPreco());
            produto.setCategoria(dto.getCategoria());

            repository.save(produto);

            return Optional.of(produto);
        }

        return Optional.empty();
    }

    public boolean deletar(Long id) {

        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}