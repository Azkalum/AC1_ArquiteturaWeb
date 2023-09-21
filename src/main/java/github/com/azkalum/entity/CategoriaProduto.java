package github.com.azkalum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String catNome;

    private String catDescricao;

    @Override
    public String toString() {
        return "CategoriaProduto{" +
                "idCategoria=" + idCategoria +
                ", catNome='" + catNome + '\'' +
                ", catDescricao='" + catDescricao + '\'' +
                '}';
    }
}
