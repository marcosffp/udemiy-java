import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        methodo01();
        System.out.println("Fim do programa");

    }
    
    public static void methodo01() {
        System.out.println("--------Metodo1 start-------");
        methodo02();
        System.out.println("---------Metodo1 end------------");
    }
  
    public static void methodo02() {
        System.out.println("----------Metodo2 start------------");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Valor inválido");
            e.printStackTrace();
            sc.next();
        } catch (InputMismatchException e) {
            System.out.println("input erro");
        }
        sc.close();
    System.out.println("Metoddsfd o2 end");
    }
    
}
