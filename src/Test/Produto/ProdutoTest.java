package Test.Produto;
import java.util.Locale;
import java.util.Scanner;

import Demo.Produto.Produto;

public class ProdutoTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);  
        Scanner sc = new Scanner(System.in);  
        

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        Produto produto = new Produto(name, price);
        System.out.println();


        produto.setName("Computador");
        System.out.println("Updated name: " + produto.getName());
        produto.setPrice(1200.00);
        System.out.println("Updated price: " + produto.getPrice());
        

        System.out.println("Product data: " + produto);

        System.out.println("Enter the number of of products to be added in stock: ");
        int quantity = sc.nextInt();
        produto.addProducts(quantity);
        System.out.print("Updated data: " + produto);
   
        System.out.println("Enter the number of of products to be removed from stock: ");
        int removed = sc.nextInt();
        produto.removeProducts(removed);
        System.out.print("Updated data: " + produto);

        

        sc.close();
    }
}
