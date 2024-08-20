package main;

import demo.Produto;
import demo.ProdutoImportado;
import demo.ProdutoUsado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Produto> produtos = new ArrayList<>();

    System.out.print("Insira o número de produtos: ");
    int numeroProduto = sc.nextInt();

    for (int i = 1; i <= numeroProduto; i++) {
        System.out.println("Dados do produto n°" + i + ":");
        System.out.print("Comum, usado ou importado (c/u/i)? ");
        char isCuI = sc.next().charAt(0);

        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        if (isCuI == 'c') {
            Produto produto = new Produto(nome, preco);
            produtos.add(produto);
        } else if (isCuI == 'u') {
            sc.nextLine();
            System.out.print("Data de fabricação (DD/MM/AAAA): ");
            String dataManufaturadoString = sc.nextLine();
            Date dataManufaturado = sdf.parse(dataManufaturadoString);
            Produto produto = new ProdutoUsado(nome, preco, dataManufaturado);
            produtos.add(produto);
        } else {
            System.out.print("Taxa alfandegária: ");
            double taxaAlfandega = sc.nextDouble();
            Produto produto = new ProdutoImportado(nome, preco, taxaAlfandega);
            produtos.add(produto);
        }
    }
    System.out.println();
    System.out.println("Etiquetas de preços:");
    for (Produto produto : produtos) {
      System.out.println(produto.precoTag());
    }

    sc.close();
  }
}
