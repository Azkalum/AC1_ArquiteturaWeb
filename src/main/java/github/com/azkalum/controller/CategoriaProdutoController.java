package github.com.azkalum.controller;

import github.com.azkalum.entity.CategoriaProduto;
import github.com.azkalum.repository.CategoriaProdutoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorias")
@Tag(name = "Categoria Produto Controller", description = "Controle de categoria de produtos")
public class CategoriaProdutoController {

    private final CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping
    @Operation(summary = "Listar todas as categorias")
    @ApiResponse(responseCode = "200", description = "Sucesso ao listar categorias de produto")
    public ResponseEntity<List<CategoriaProduto>> listarCategorias() {
        List<CategoriaProduto> categorias = categoriaProdutoRepository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma categoria de  produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao buscar ID da categoria do produto"),
            @ApiResponse(responseCode = "404", description = "Categoria do produto não encontrada")})
    public ResponseEntity<CategoriaProduto> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<CategoriaProduto> categoria = categoriaProdutoRepository.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Salvar uma categoria de  produto")
    @ApiResponse(responseCode = "200", description = "Categoria de produto salva com sucesso")
    public ResponseEntity<CategoriaProduto> salvarCategoria(@RequestBody CategoriaProduto novaCategoria) {
        CategoriaProduto categoriaCriada = categoriaProdutoRepository.save(novaCategoria);
        return ResponseEntity.ok(categoriaCriada);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar uma categoria de  produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria do produto atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro ao atualizar categoria do produto")})
    public ResponseEntity<CategoriaProduto> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaProduto categoriaAtualizada) {
        if (!categoriaProdutoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        categoriaAtualizada.setIdCategoria(id);
        CategoriaProduto categoria = categoriaProdutoRepository.save(categoriaAtualizada);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma categoria de produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria do produto excluida"),
            @ApiResponse(responseCode = "404", description = "Erro excluir categoria do produto")})
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
        if (!categoriaProdutoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        categoriaProdutoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
