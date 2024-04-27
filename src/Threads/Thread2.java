package Threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Thread2 implements Runnable {
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);


        int mayus = 0 , minus = 0, numeros = 0;
        boolean especial = false;

        System.out.print("\nIntroduzca su contrasena: ");
        String contra = sc.nextLine();

        Pattern pattern = Pattern.compile("[#%@$!?/]");
        Matcher matcher = pattern.matcher(contra);
        if (matcher.find()) {
            especial = true;
        }

        for (char c : contra.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayus++;
            } else if (Character.isLowerCase(c)) {
                minus++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }

        }

        if (contra.length() >= 8 && mayus >= 2 && minus >= 3 && numeros >= 1 && especial) {
            System.out.println("Contrasena segura");

            Texto texto =
                    () -> {
                        try {
                            BufferedWriter contrasena = new BufferedWriter(new FileWriter("Contra2.txt"));
                            contrasena.write(contra);
                            contrasena.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    };

            texto.txt();
        }
        else {
            System.out.println("Contrasena insegura");
        }
    }
}