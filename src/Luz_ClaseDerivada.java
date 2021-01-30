
/**
 *
 * @author Bryan
 */
import java.util.*;

public class Luz_ClaseDerivada extends EazyPay_SuperClase {

    Random rd = new Random();

    private int noMedidor;
    private int noServicio;
    private double consumo;
    private String tarifa;
    private String RMU;
    private String periodoFacturado;

    public Luz_ClaseDerivada(String nombreCliente, String direccionCliente, double adeudoPagar, String limitePago, String curp, double xConsumo, String xPeriodo) {
        super(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp);
        this.consumo = xConsumo;
        this.periodoFacturado = xPeriodo;
    }

    public void set_NoMedidor() {
        this.noMedidor = 14523658;
    }

    public void set_NoServicio() {
        this.noServicio = 26398574;
    }

    public void set_Tarifa() {
        this.tarifa = "1F";
    }

    public void set_RMU() {
        this.RMU = "GF1535FD5BS";
    }

    @Override
    public void set_AdeudoPagar() {
        this.adeudoPagar = 0.793 * this.consumo;
    }

    public int get_NoMedidor() {
        return this.noMedidor;
    }

    public int get_NoServicio() {
        return this.noServicio;
    }

    public double get_Consumo() {
        return this.consumo;
    }

    public String get_Tarifa() {
        return this.tarifa;
    }

    public String get_RMU() {
        return this.RMU;
    }

    public String get_PeriodoFacturado(){
        return this.periodoFacturado;
    }

}
