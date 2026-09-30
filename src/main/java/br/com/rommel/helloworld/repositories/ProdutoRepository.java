package br.com.rommel.helloworld.repositories;

import br.com.rommel.helloworld.models.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
