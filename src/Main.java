import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("ingrese el numero correspondiente a la operacion\n "+
                "1-Convertir USD a ARS\n "+
                "2-Convertir UDS a CAD\n "+
                "3-Convertir UDS a EUR\n "+
                "4-Convertir ARS a VES\n "+
                "0-PARA SALIR\n");
        var operacion = scan.nextInt();

        while(operacion < 0 || operacion > 5){
            System.out.println("ingrese el numero correspondiente a la operacion\n "+
                    "1-Convertir USD a ARS\n "+
                    "2-Convertir UDS a CAD\n "+
                    "3-Convertir UDS a EUR\n "+
                    "4-Convertir ARS a VES\n "+
                    "0-PARA SALIR\n");
            operacion = scan.nextInt();
        }

        while(operacion !=0){
            ConsultaApi consultaApi = new ConsultaApi();
            Calculos calculo = new Calculos();
            double resultado;

            System.out.println("ingrese el monto a convertir: ");
            var monto = scan.nextInt();
            while(monto <=0){
                System.out.println("ingrese nuevamente el monto a convertir: ");
                monto = scan.nextInt();
            }

            switch (operacion){
                case 1 ->{
                    Divisa div = consultaApi.consultaDivisa("USD", "ARS");
                    resultado = calculo.calcularConversion(div, monto);
                    System.out.println("El resultado de convertir "+ monto + " USD a ARS es: "+ resultado);
                    System.out.println("------------------------------------------------");
                }

                case 2->{
                    Divisa div = consultaApi.consultaDivisa("USD", "CAD");
                    resultado = calculo.calcularConversion(div, monto);
                    System.out.println("El resultado de convertir "+ monto + " USD a CAD es: "+ resultado);
                    System.out.println("------------------------------------------------");

                }

                case 3->{
                    Divisa div = consultaApi.consultaDivisa("USD", "EUR");
                    resultado = calculo.calcularConversion(div, monto);
                    System.out.println("El resultado de convertir "+ monto + " USD a EUR es: "+ resultado);
                    System.out.println("------------------------------------------------");


                }
                case 4->{
                    Divisa div = consultaApi.consultaDivisa("ARS", "VES");
                    resultado = calculo.calcularConversion(div, monto);
                    System.out.println("El resultado de convertir "+ monto + " ARS a VES es: "+ resultado);
                    System.out.println("------------------------------------------------");

                }
            }
            System.out.println("ingrese el numero correspondiente a la operacion\n "+
                    "1-Convertir USD a ARS\n "+
                    "2-Convertir UDS a CAD\n "+
                    "3-Convertir UDS a EUR\n "+
                    "4-Convertir ARS a VES\n "+
                    "0-PARA SALIR\n");
            operacion = scan.nextInt();
            while(operacion < 0 || operacion > 5){
                System.out.println("ingrese el numero correspondiente a la operacion\n "+
                        "1-Convertir USD a ARS\n "+
                        "2-Convertir UDS a CAD\n "+
                        "3-Convertir UDS a EUR\n "+
                        "4-Convertir ARS a VES\n "+
                        "0-PARA SALIR\n");
                operacion = scan.nextInt();
            }
        }

        System.out.println("****** Proceso Terminado ******");
    }
}