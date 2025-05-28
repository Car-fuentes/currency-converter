public class Moneda {

    private String codigoMoneda;
    private double coheficiente;
    private String nuevaMoneda;

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public double getCoheficiente() {
        return coheficiente;
    }

    public Moneda(DatosApi moneda){
        this.codigoMoneda = moneda.base_code();
        this.coheficiente = moneda.conversion_rate();
        this.nuevaMoneda = moneda.target_code();
    }

    public String toString(){
        return "la moneda " + codigoMoneda + "posee un coheficiente de " + getCoheficiente() +
                "respecto a la moneda " + nuevaMoneda;
    }

    public double convertir(double monto, double coheficiente) {
        double montoResultado = monto * this.coheficiente;
        return montoResultado;
    }

}
