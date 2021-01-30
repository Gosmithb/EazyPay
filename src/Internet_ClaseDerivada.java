
import java.util.Random;


public class Internet_ClaseDerivada extends EazyPay_SuperClase {
    Random rd = new Random();
    
    private int noFactura;
    private String mesFacturacion;
    private int telefono;
    private double pagoMes;
    private String RFC;

    public Internet_ClaseDerivada(String nombreCliente, String direccionCliente, double adeudoPagar, String limitePago, String curp, String xMes, int xTelefono, double xPago) {
        super(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp);
        this.mesFacturacion = xMes;
        this.telefono = xTelefono;
        this.pagoMes = xPago;
    }
    
    @Override
    public void set_AdeudoPagar(){
        this.adeudoPagar = pagoMes;
    }

    public void set_NoFactura(){
        this.noFactura = 152489658;
    }
    
    public void set_RFC(){
         this.RFC = "DFD51VF20DS511-DS";
    }
    
    public int get_NoFactura() {
        return this.noFactura;
    }

    public String get_MesFacturacion() {
        return this.mesFacturacion;
    }

    public int get_Telefono() {
        return this.telefono;
    }

    public String get_RFC() {
        return this.RFC;
    }

}
