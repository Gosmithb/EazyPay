
public abstract class EazyPay_SuperClase {
    
    
    protected String nombreCliente;
    protected String direccionCliente;
    protected double adeudoPagar;
    protected String limitePago;
    protected String curp;
    
    abstract void set_AdeudoPagar();
    
    public EazyPay_SuperClase(String xNombre, String xDireccion, double xAdeudo,String xLimite, String xCurp){
        this.nombreCliente = xNombre;
        this.direccionCliente = xDireccion;
        this.adeudoPagar = xAdeudo;
        this.limitePago = xLimite;
        this.curp = xCurp;
    }
    
    public String get_NombreCliente(){
        return this.nombreCliente;
    }
    
    public String get_DireccionCliente(){
        return this.direccionCliente;
    }
    
    public String get_LimitePago(){
        return this.limitePago;
    }
    
    public double get_AdeudoPagar(){
        return this.adeudoPagar;
    }
    
    public String get_Curp(){
        return this.curp;
    }
    
}
