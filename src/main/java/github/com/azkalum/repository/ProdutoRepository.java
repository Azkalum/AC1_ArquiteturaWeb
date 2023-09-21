package github.com.azkalum.repository;

import github.com.azkalum.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto save(Produto produto);
    void deleteById(Long id);

    List<Produto> findAll();
    Optional<Produto> findById(Long id);
}
