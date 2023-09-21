package github.com.azkalum.test;

import github.com.azkalum.entity.CategoriaProduto;
import github.com.azkalum.entity.Produto;
import github.com.azkalum.repository.CategoriaProdutoRepository;
import github.com.azkalum.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {


    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public MyCommandLineRunner(ProdutoRepository produtoRepository, CategoriaProdutoRepository categoriaProdutoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }


    @Override
    public void run(String... args) {

        //Produto CommandLineRunner


        //Salvar um produto
        Produto novoProduto = new Produto();
        novoProduto.setProdNome("Produto Teste");
        novoProduto.setProdQtd(10);
        Produto produtoCriado = produtoRepository.save(novoProduto);
        System.out.println("Produto criado: " + produtoCriado);

        //Editar um produto
        Optional<Produto> produtoExistente = produtoRepository.findById(1L);
        if (produtoExistente.isPresent()) {
            produtoExistente.get().setProdNome("Produto Editado");
            produtoRepository.save(produtoCriado);
            System.out.println("Produto editado: " + produtoExistente);
        } else {
            System.out.println("Produto não encontrado ");
        }

        //Excluir um produto
        Long idParaExcluir = 2L;
        produtoRepository.deleteById(idParaExcluir);
        System.out.println("Produto com ID " + idParaExcluir + " excluído.");

        //Buscar todos os produtos
        System.out.println("Lista de todos os produtos:");
        List<Produto> produtos = produtoRepository.findAll();
        produtos.forEach(System.out::println);

        //Buscar produtos por ID
        Long idParaSelecionar = 3L;
        Optional<Produto> produtoSelecionado = produtoRepository.findById(idParaSelecionar);
        if (produtoSelecionado.isPresent()) {
            System.out.println("Produto selecionado: " + produtoSelecionado);
        } else {
            System.out.println("Produto com ID " + idParaSelecionar + " não encontrado.");
        }

        //CategoriaProduto CommandLineRunner

        //Salvar uma Categoria Produto
        CategoriaProduto novaCategoriaProduto = new CategoriaProduto();
        novaCategoriaProduto.setCatNome("Categoria Produto Teste");
        novaCategoriaProduto.setIdCategoria(1L);
        novaCategoriaProduto.setCatDescricao("Categoria Teste");
        CategoriaProduto categoriaProduto = categoriaProdutoRepository.save(novaCategoriaProduto);
        System.out.println("Categoria Produto criada: " + categoriaProduto);

        //Editar uma categoria produto
        Optional<CategoriaProduto> categoriaProdutoExistente = categoriaProdutoRepository.findById(1L);
        if(categoriaProdutoExistente.isPresent()){
            produtoExistente.get().setProdNome("Categoria Produto Editada");
            categoriaProdutoRepository.save(novaCategoriaProduto);
            System.out.println("Categoria produto editada " + categoriaProdutoExistente);
        }else {
            System.out.println("Categoria produto não encontrada ");
        }

        //Excluir uma categoria produto
        Long idParaExcluirCategoria = 2L;
        categoriaProdutoRepository.deleteById(idParaExcluirCategoria);
        System.out.println("Categoria produto com ID " + idParaExcluirCategoria + " excluído.");

        //Buscar todas as categorias produto
        System.out.println("Lista de todas as categoria produto :");
        List<CategoriaProduto> categoriaProdutos = categoriaProdutoRepository.findAll();
        categoriaProdutos.forEach(System.out::println);

        //Buscar uma categoria produto por ID
        Long idParaSelecionarCategoria = 1L;
        Optional<CategoriaProduto> categoriaProdutoSelecionado = categoriaProdutoRepository.findById(idParaSelecionar);
        if (produtoSelecionado.isPresent()) {
            System.out.println("Categoria produto selecionado: " + categoriaProdutoSelecionado);
        } else {
            System.out.println("Categoria produto com ID " + idParaSelecionarCategoria + " não encontrado.");
        }

    }

}



