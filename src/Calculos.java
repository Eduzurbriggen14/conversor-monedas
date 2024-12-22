public class Calculos {

    public Calculos(){}

    public double calcularConversion(Divisa div, int cantidad){
        double resultado = div.conversion() * cantidad;

        return resultado;
    }
}
