import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("""
        \n      Conversor de Monedas
        \n USD - Dolar Americano
         MXN - Peso Mexicano
         BRL - Real Brasileño
         ARS - Peso Argentino
         PEN - Sol Peruano
         COP - Peso Colombiano
         CRC - Colón Costarricense
         GTQ - Peso Guatemalteco
         CLP - Peso Chileno
        
        --------------------------------------------------
        """);

        System.out.println("Ingrese el codigo de la moneda de origen");
        String baseMoneda = teclado.nextLine();

        System.out.println("Ingrese el codigo de moneda a convertir");
        String nuevaMoneda = teclado.nextLine();

        System.out.println("Ingrese el monto que desea convertir");
        double monto = teclado.nextDouble();

        DatosApi consulta = ConexionApi.datosMonedas(baseMoneda, nuevaMoneda);

        Moneda moneda = new Moneda(consulta);

        double resultado = moneda.convertir(monto, moneda.getCoheficiente());
        System.out.println("El monto de " + monto + " " + baseMoneda + " es igual a " + resultado + " " + nuevaMoneda);

    }
}
