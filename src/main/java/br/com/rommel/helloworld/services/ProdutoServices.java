package br.com.rommel.helloworld.services;


import br.com.rommel.helloworld.models.Produto;
import br.com.rommel.helloworld.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoId(String id){
        return produtoRepository.findById(id);
    }

    public Produto adicionarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public boolean deletarProduto(String id){
        if (!produtoRepository.existsById(id)){
            return false;
        }

        produtoRepository.deleteById(id);

        return true;
    }

    public Optional<Produto> atualizarProduto(String id, Produto novosDados){
        Optional<Produto> produtoEncontrado = produtoRepository.findById(id);

        if (produtoEncontrado.isEmpty()){
            return Optional.empty();
        }

        Produto produto = produtoEncontrado.get();

        produto.setNome(novosDados.getNome());
        produto.setPreco(novosDados.getPreco());

        Produto produtoAtualizado= produtoRepository.save(produto);

        return Optional.of(produtoAtualizado);
    }
}
