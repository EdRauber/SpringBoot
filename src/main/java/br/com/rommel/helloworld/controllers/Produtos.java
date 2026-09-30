package br.com.rommel.helloworld.controllers;

import br.com.rommel.helloworld.models.Produto;
import br.com.rommel.helloworld.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class Produtos {

    @Autowired
    private ProdutoServices produtoServices;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoServices.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoID(@PathVariable String id){

        Optional<Produto> produto = produtoServices.buscarProdutoId(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoServices.adicionarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id){
        boolean deletado = produtoServices.deletarProduto(id);
        if (deletado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable String id,
            @RequestBody Produto produto
    ){
        Optional<Produto> atualizado = produtoServices.atualizarProduto(id, produto);

        if (atualizado.isPresent()){
            return ResponseEntity.ok(atualizado.get());
        }
        return  ResponseEntity.notFound().build();
    }
}
