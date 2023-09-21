package github.com.azkalum.repository;

import github.com.azkalum.entity.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {

    CategoriaProduto save(CategoriaProduto categoriaProduto);
    void deleteById(Long id);

    List<CategoriaProduto> findAll();
    Optional<CategoriaProduto> findById(Long id);

}
