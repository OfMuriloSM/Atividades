//Controller/Produtocontroller.java
package com.example.crudprodutos.controller;

import com.example.crudprodutos.dto.ProdutoDTO;
import com.example.crudprodutos.model.Produto;
import com.example.crudprodutos.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDTO dto) {

        Produto produto = service.cadastrar(dto);

        return ResponseEntity.status(201).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {

        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {

        Optional<Produto> produto = service.buscarPorId(id);

        return produto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoDTO dto) {

        Optional<Produto> produto = service.atualizar(id, dto);

        return produto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        boolean removido = service.deletar(id);

        if(removido) {
            return ResponseEntity.ok("Produto removido com sucesso!");
        }

        return ResponseEntity.notFound().build();
    }
}