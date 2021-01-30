
import java.util.Random;


public class Agua_ClaseDerivada extends EazyPay_SuperClase {

    Random rd = new Random();

    private int noMedidor;
    private double consumo;
    private double tarifa;
    private double IVA;
    private int NIS;

    public Agua_ClaseDerivada(String nombreCliente, String direccionCliente, double adeudoPagar, String limitePago, String curp, double xConsumo) {
        super(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp);
        this.consumo = xConsumo;
    }

    public void set_NoMedidor() {
        this.noMedidor = 14526638;
    }

    public void set_Tarifa() {
        this.tarifa = this.consumo * 16.74;
    }

    public void set_IVA() {
        this.IVA = this.tarifa * 0.16;
    }

    @Override
    public void set_AdeudoPagar() {
        this.adeudoPagar = this.tarifa + this.IVA;
    }

    public void set_NIS() {
        this.NIS = 254896587;
    }

    public int get_NoMedidor(){
        return this.noMedidor;
    }    
    
    public double get_Consumo(){
        return this.consumo;
    }
    
    public double get_Tarifa(){
        return this.tarifa;
    }
    
    public double get_IVA(){
        return this.IVA;
    }
    
    public int get_NIS(){
        return this.NIS;
    }
}
