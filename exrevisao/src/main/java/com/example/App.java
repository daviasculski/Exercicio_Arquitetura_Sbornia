package com.example;

import com.example.Agregado.Venda;
import com.example.Entidade.CategoriaProduto;
import com.example.Entidade.Produto;
import com.example.Entidade.Usuario;
import com.example.Servico.ProdutoRepository;
import com.example.Servico.ServicoImposto;
import com.example.Servico.UsuarioRepository;
import com.example.Servico.impl.ProdutoRepositoryMemoria;
import com.example.Servico.impl.UsuarioRepositoryMemoria;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryMemoria();
        ProdutoRepository produtoRepository = new ProdutoRepositoryMemoria();
        ServicoImposto servicoImposto = new ServicoImposto();

        Usuario usuarioComum = new Usuario(0, "João Silva", LocalDate.of(1990, 5, 15), 1);
        Usuario usuarioIdoso = new Usuario(0, "Maria Antunes", LocalDate.of(1955, 1, 20), 0);
        Usuario usuarioComDependentes = new Usuario(0, "Carlos Pereira", LocalDate.of(1985, 11, 10), 4);
        
        usuarioRepository.salvar(usuarioComum);
        usuarioRepository.salvar(usuarioIdoso);
        usuarioRepository.salvar(usuarioComDependentes);

        Produto arroz = new Produto(0, "Arroz Tipo 1 (5kg)", 25.00, CategoriaProduto.ALIMENTICIOS);
        Produto pneu = new Produto(0, "Pneu Aro 15", 350.00, CategoriaProduto.AUTOMOTIVOS);
        Produto vinho = new Produto(0, "Vinho Tinto Suave", 40.00, CategoriaProduto.BEBIDAS_ALCOOLICAS);
        Produto teclado = new Produto(0, "Teclado Mecânico", 150.00, CategoriaProduto.OUTROS);

        produtoRepository.salvar(arroz);
        produtoRepository.salvar(pneu);
        produtoRepository.salvar(vinho);
        produtoRepository.salvar(teclado);

        System.out.println("--- Início das Simulações de Venda ---");

        System.out.println("\nCenário 1: Usuário Comum");
        Venda venda1 = new Venda(1, usuarioComum);
        venda1.adicionarItem(arroz, 2);
        venda1.adicionarItem(teclado, 1);
        processarVenda(venda1, servicoImposto);

        System.out.println("\nCenário 2: Usuário Idoso (compra sem álcool)");
        Venda venda2 = new Venda(2, usuarioIdoso);
        venda2.adicionarItem(pneu, 4);
        processarVenda(venda2, servicoImposto);
        
        System.out.println("\nCenário 3: Usuário Idoso (compra COM álcool)");
        Venda venda3 = new Venda(3, usuarioIdoso);
        venda3.adicionarItem(vinho, 2);
        venda3.adicionarItem(arroz, 1);
        processarVenda(venda3, servicoImposto);

        System.out.println("\nCenário 4: Usuário com >3 Dependentes");
        Venda venda4 = new Venda(4, usuarioComDependentes);
        venda4.adicionarItem(pneu, 1);
        venda4.adicionarItem(teclado, 2);
        venda4.adicionarItem(vinho, 1);
        processarVenda(venda4, servicoImposto);
    }

    private static void processarVenda(Venda venda, ServicoImposto servicoImposto) {
        double valorItens = venda.getValorTotalItens();
        double imposto = servicoImposto.calcularImpostoDaVenda(venda);
        double valorTotal = valorItens + imposto;

        System.out.printf("Valor dos Itens: R$ %.2f\n", valorItens);
        System.out.printf("Imposto Calculado: R$ %.2f\n", imposto);
        System.out.printf("Valor Total da Venda: R$ %.2f\n", valorTotal);
    }
}