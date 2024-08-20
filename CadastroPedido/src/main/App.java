package main;

import demo.Cliente;
import demo.ItemPedido;
import demo.Ordem;
import demo.Produto;
import demo.StatusPedido;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

    List<ItemPedido> itemPedidos = new ArrayList<>();

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Entrar com os dados do cliente");
    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Data de aniversário (DD/MM/AAAA): ");
    String dataAniversarioString = sc.nextLine();
    Date dataAniversario = sdf.parse(dataAniversarioString);
    System.out.println("Insira dados do pedido:");
    System.out.print("Status: ");
    String statusPedido = sc.nextLine();

    Cliente cliente = new Cliente(nome, email, dataAniversario);

    System.out.println("Quantos itens há neste pedido? ");
    int numeroPedidos = sc.nextInt();

    for (int i = 1; i <= numeroPedidos; i++) {
        System.out.println("Insira dados do item #" + i + ":");
        System.out.print("Nome do produto: ");
        String nomeProduto = sc.nextLine();
        System.out.print("Preço do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Quantidade: ");
        Integer quantidade = sc.nextInt();

        Produto produto = new Produto(nomeProduto, preco);
        ItemPedido itemPedido = new ItemPedido(quantidade, preco, produto);
        itemPedidos.add(itemPedido);
    }
    Date momento = new Date();
    Ordem ordem = new Ordem(momento, StatusPedido.valueOf(statusPedido), cliente);
    System.out.println(ordem);
    System.out.println("Total valor: "+ordem.total());

    sc.close();
  }
}
