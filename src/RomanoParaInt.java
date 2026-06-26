import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanoParaInt {

    public static int AlgarismoRomanoParaInteiro(String s) {

        Map<Character, Integer> valores = new HashMap<>();
        valores.put('I', 1);
        valores.put('V', 5);
        valores.put('X', 10);
        valores.put('L', 50);
        valores.put('C', 100);
        valores.put('D', 500);
        valores.put('M', 1000);

        s = s.toUpperCase();

        int total = 0;
        int anterior = 0;

        // Percorre da direita para a esquerda
        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);

            if (!valores.containsKey(c)) {
                throw new IllegalArgumentException(
                        "Algarismo romano inválido: " + c
                );
            }

            int atual = valores.get(c);

            if (atual < anterior) {
                total -= atual;
            } else {
                total += atual;
            }

            anterior = atual;
        }

        return total;
    }

    public static void main(String[] args) {

        // Passando argumento.
        if (args.length > 0) {
            String algarismos = String.join("", args);
            int valor = AlgarismoRomanoParaInteiro(algarismos);
            System.out.println(valor);
            return;
        }

        // Por pipe | ou interação com usuário.
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o algarismo: ");
        String algarismos = sc.nextLine();

        int valor = AlgarismoRomanoParaInteiro(algarismos);
        System.out.println(valor);

        sc.close();
    }
}