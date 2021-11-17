package divinar;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class divinar {

    //metodos
    private static int GeneraAleatorio(int a, int b) {
        Random rd = new Random();
        int numeroAleatorio;
        if (a > b) {
            numeroAleatorio = rd.nextInt(a - b + 1) + b;
        } else {
            numeroAleatorio = rd.nextInt(b - a + 1) + a;//nextInt(max - min + 1) + min;
        }

        return numeroAleatorio;

    }

    private static int pedirDatos() {
        boolean solicitarDatos = true;
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        do {
            solicitarDatos = true;
            try {
                // Bloque de código candidato a lanzar la excepción
                System.out.println("Introduce un numero devinado");
                numero = sc.nextInt();
                solicitarDatos = false;
            } catch (InputMismatchException ime) {
                // Código para tratar el error
                System.out.println("Se ha introducido texto en lugar de números. "
                        + "Vuelva a introducir los datos");
                sc.nextLine();
            }
        } while (solicitarDatos);
        return numero;
    }

    public static void main(String[] args) {
        int numero, contador = 0;
        int a, b, numeroAleatorio;
        Scanner sc=new Scanner(System.in);
            //pedir el rango del numero aleatorio
            System.out.println("Introduce numero Min" );
            a =sc.nextInt();
            System.out.println("Introduce numero Max" );
            b =sc.nextInt();
            numeroAleatorio = GeneraAleatorio(a, b);
            
            
        do {
            //pedir el numero
            numero = pedirDatos();
            
            if (numero > numeroAleatorio) {
                System.out.println("El numero y mas pequiño de " + numero);
                contador++;
            } else if(numero < numeroAleatorio){
                System.out.println("El numero mas grande de "+numero);  
                contador++;    
            }else{
                System.out.println("Bien!! eso es el numero aleatorio "+numeroAleatorio);             
                System.out.println("Termina");
                break;
            }
            
        } while (contador != 3);
        
        if(contador==3){
            System.out.println("Has perdido");
            System.out.println("el numero aleatorio:" + numeroAleatorio);
        }
    }
}
