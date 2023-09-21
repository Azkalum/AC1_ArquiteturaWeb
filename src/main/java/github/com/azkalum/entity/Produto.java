package github.com.azkalum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    private String prodNome;

    private int prodQtd;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaProduto categoria;

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", prodNome='" + prodNome + '\'' +
                ", prodQtd=" + prodQtd +
                ", categoria=" + categoria +
                '}';
    }
}
