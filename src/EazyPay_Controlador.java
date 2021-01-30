
import java.io.*;
import static java.lang.System.out;
import java.text.DecimalFormat;

public class EazyPay_Controlador {

    public static BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
    public static DecimalFormat df = new DecimalFormat("###,###,###.00");
    public static int opcion = 0;

    public static void main(String[] args) throws IOException {

        while (true) {
            Menu_Principal();

            opcion = (int) Leer_Numero("\t Elija una opcion: ");

            switch (opcion) {
                case 1:
                    Servicio_Internet("EazyPay Pago Servicio Internet");
                    break;
                case 2:
                    Servicio_Luz("EazyPay Pago Servicio Luz");
                    break;
                case 3:
                    Servicio_Agua("EazyPay Pago Servicio Agua");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opcion No Disponible");
                    ;
            }

        }

    }

    private static void Menu_Principal() {
        out.println("\n");
        out.println("+-------------------------------------------+");
        out.println("|                  EazyPay                  |");
        out.println("|           Sistema de Multipago            |");
        out.println("+-------------------------------------------+");
        out.println("|\tMenu:                               |");
        out.println("|\t1) Pago Internet                    |");
        out.println("|\t2) Pago Luz                         |");
        out.println("|\t3) Pago Agua                        |");
        out.println("|\t4) Exit                             |");
        out.println("+-------------------------------------------+");
        out.println("\n");
    }

    public static void Imprimir_Encabezado(String msg) {
        out.println("\n");
        out.println("------------------------------");
        out.println(msg);
        out.println("   'Exit' Para finalizar");
        out.println("------------------------------");

    }

    private static int Seleccion_Accion() throws IOException {
        out.println("\n\tOpciones:");
        out.println("\t1) Pagar");
        out.println("\t2) Cancelar");
        out.println("\t3) Historico");
        out.println("\t4) Duplicado");
        opcion = (int) Leer_Numero("\n\tElija una opcion: ");
        return opcion;
    }

    public static double Leer_Numero(String msg) throws IOException {
        String dato_Leido;
        double dato;

        do {
            out.print(msg + "");
            dato_Leido = kb.readLine();
            if (dato_Leido.equalsIgnoreCase("Exit")) {
                return 0x950428b;
            }
            try {
                dato = Double.parseDouble(dato_Leido);
                if (dato <= 0) {
                    System.out.println("******************");
                    System.out.println("Cantidad Invalida");
                    System.out.println("******************");
                    continue;
                }
                return dato;
            } catch (NumberFormatException e) {
                System.out.println("**************");
                System.out.println("Dato invalido");
                System.out.println("**************");
            }
        } while (true);

    }

    private static void Servicio_Internet(String msg) throws IOException {

        String nombreCliente, direccionCliente, limitePago, mesFacturacion, curp;
        int telefono;
        double adeudoPagar, pagoMes, cambio, pagoDepositado;

        while (true) {
            Imprimir_Encabezado(msg);

            out.print("Nombre completo: ");
            nombreCliente = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Direccion: ");
            direccionCliente = kb.readLine();
            if (direccionCliente.equalsIgnoreCase("Exit")) break;

            out.print("Cantidad a Pagar: ");
            adeudoPagar = Leer_Numero("");
            pagoMes = adeudoPagar;
            if (adeudoPagar == 0x950428b) break;

            out.print("Fecha limite de Pago: (DD/MM/YY) ");
            limitePago = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Curp: ");
            curp = kb.readLine();
            if (curp.equalsIgnoreCase("Exit")) break;

            out.print("Mes de Facturacion: ");
            mesFacturacion = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Telefono: ");
            telefono = (int) Leer_Numero("");
            if (telefono == 0x950428b) break;

            //Declarando y Construyendo objeto
            Internet_ClaseDerivada Servicio = new Internet_ClaseDerivada(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp, mesFacturacion, telefono, pagoMes);

            //Setters
            Servicio.set_RFC();
            Servicio.set_NoFactura();
            Servicio.set_AdeudoPagar();

            Consulta_Info_Internet(Servicio.get_NombreCliente(), Servicio.get_DireccionCliente(),
                    Servicio.get_Telefono(), Servicio.get_AdeudoPagar());

            while (true) {
                opcion = Seleccion_Accion();
                switch (opcion) {
                    case 1:
                        pagoDepositado = Leer_Numero("\nCantidad a Depositar: ");
                        cambio = Servicio.get_AdeudoPagar() - pagoDepositado;

                        Imprimir_Recibo_Internet(Servicio.get_NombreCliente(), Servicio.get_DireccionCliente(),
                                Servicio.get_MesFacturacion(), Servicio.get_LimitePago(),
                                Servicio.get_NoFactura(), Servicio.get_RFC(), Servicio.get_Telefono(),
                                Servicio.get_AdeudoPagar(), Servicio.get_Curp(), pagoDepositado, cambio);
                        break;
                    case 2:
                        break;
                    case 3:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    case 4:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    default:
                        out.println("\n****************\n");
                        out.println("Opcion No Valida");
                        out.println("\n****************\n");
                }
                break;
            }

        }
    }

    private static void Servicio_Luz(String msg) throws IOException {
        String nombreCliente, direccionCliente, limitePago, curp, periodoFacturado;
        double consumo, adeudoPagar = 0, pagoDepositado, cambio;

        while (true) {

            Imprimir_Encabezado(msg);

            out.print("Nombre completo: ");
            nombreCliente = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Direccion: ");
            direccionCliente = kb.readLine();
            if (direccionCliente.equalsIgnoreCase("Exit")) break;

            out.print("Consumo de kWh: ");
            consumo = Leer_Numero("");
            if (consumo == 0x950428b) break;

            out.print("Fecha limite de Pago: (DD/MM/YY) ");
            limitePago = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Curp:");
            curp = kb.readLine();
            if (curp.equalsIgnoreCase("Exit")) break;

            out.print("Periodo Facturado (DD/MM - DD/MM): ");
            periodoFacturado = kb.readLine();
            if (periodoFacturado.equalsIgnoreCase("Exit")) break;

            //Declarando y Construyendo objeto
            Luz_ClaseDerivada Servicio = new Luz_ClaseDerivada(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp, consumo, periodoFacturado);

            //Setters
            Servicio.set_NoMedidor();
            Servicio.set_RMU();
            Servicio.set_Tarifa();
            Servicio.set_NoServicio();
            Servicio.set_AdeudoPagar();

            Consulta_Info_Luz(Servicio.get_NombreCliente(), Servicio.get_DireccionCliente(),
                    Servicio.get_NoMedidor(), Servicio.get_AdeudoPagar());

            while (true) {
                opcion = Seleccion_Accion();
                switch (opcion) {
                    case 1:
                        pagoDepositado = Leer_Numero("\nCantidad a Depositar: ");

                        cambio = Servicio.get_AdeudoPagar() - pagoDepositado;

                        Imprimir_Recibo_Luz(Servicio.get_NombreCliente(), Servicio.get_DireccionCliente(),
                                Servicio.get_NoMedidor(), Servicio.get_NoServicio(),
                                Servicio.get_LimitePago(), Servicio.get_Curp(),
                                Servicio.get_Consumo(), Servicio.get_AdeudoPagar(),
                                Servicio.get_PeriodoFacturado(), Servicio.get_RMU(),
                                cambio, pagoDepositado);
                        break;
                    case 2:
                        break;
                    case 3:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    case 4:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    default:
                        out.println("\n****************\n");
                        out.println("Opcion No Valida");
                        out.println("\n****************\n");
                }
                break;
            }
        }

    }

    private static void Servicio_Agua(String msg) throws IOException {
        String nombreCliente, direccionCliente, limitePago, curp;
        double consumo, adeudoPagar = 0, pagoDepositado, cambio;

        while (true) {

            Imprimir_Encabezado(msg);

            out.print("Nombre completo: ");
            nombreCliente = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Direccion: ");
            direccionCliente = kb.readLine();
            if (direccionCliente.equalsIgnoreCase("Exit")) break;

            out.print("Consumo Metro Cubico: ");
            consumo = Leer_Numero("");
            if (consumo == 0x950428b) break;

            out.print("Fecha de Vencimiento(DD/MM/YY): ");
            limitePago = kb.readLine();
            if (nombreCliente.equalsIgnoreCase("Exit")) break;

            out.print("Curp: ");
            curp = kb.readLine();
            if (curp.equalsIgnoreCase("Exit")) break;

            //Declarando y Construyendo objeto
            Agua_ClaseDerivada Servicio = new Agua_ClaseDerivada(nombreCliente, direccionCliente, adeudoPagar, limitePago, curp, consumo);

            //Setters
            Servicio.set_IVA();
            Servicio.set_NIS();
            Servicio.set_NoMedidor();
            Servicio.set_Tarifa();
            Servicio.set_AdeudoPagar();

            Consulta_Info_Agua(Servicio.get_NombreCliente(), Servicio.get_DireccionCliente(),
                    Servicio.get_Curp(), Servicio.get_AdeudoPagar());

            while (true) {
                opcion = Seleccion_Accion();
                switch (opcion) {
                    case 1:
                        pagoDepositado = Leer_Numero("\nCantidad a Depositar: ");

                        cambio = Servicio.get_AdeudoPagar() - pagoDepositado;

                        Imprimir_Recibo_Agua(Servicio.get_AdeudoPagar(), Servicio.get_Consumo(),
                                Servicio.get_Curp(), Servicio.get_DireccionCliente(),
                                Servicio.get_IVA(), Servicio.get_LimitePago(),
                                Servicio.get_NIS(), Servicio.get_NoMedidor(),
                                Servicio.get_NombreCliente(), Servicio.get_Tarifa(), cambio, pagoDepositado);
                        break;
                    case 2:
                        break;
                    case 3:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    case 4:
                        out.println("\n****************\n");
                        out.println("En Mantenimiento");
                        out.println("\n****************\n");
                        continue;
                    default:
                        out.println("\n****************\n");
                        out.println("Opcion No Valida");
                        out.println("\n****************\n");
                }
                break;
            }
        }

    }
    
    private static void Imprimir_Recibo_Internet(String _Nombre, String _Direccion, String _MesFact, String _Limite, int _NoFactura, String _RFC, int _Telefono, double _Adeudo, String _Curp, double _Pago, double _Cambio) {
        out.println("----------------------------------------------------------------------------");
        out.printf("%-40s%-10s\n", "Telmex", "EazyPay Pago de Servicios");
        out.printf("%-20s\n", "Telefonos de Mexico");
        out.println("-----------------------------------------------------------------------------");
        out.printf("%-20s\n", "C.P. 06500 Mexico D.F.");
        out.printf("%-40s%-10s%-10s\n", "RFC: TME84035-JUN-2020 dv7", "Total a Pagar: ", df.format(_Adeudo));
        out.printf("%-40s%-10s%-10s\n", "", "Pagar Antes de: ", _Limite.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", _Nombre.toUpperCase(), "Mes Facturacion: ", _MesFact.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", "", "Telefono: ", _Telefono);
        out.printf("%-40s%-10s%-10s\n", "", "Factura No.: ", _NoFactura);
        out.printf("%-20s\n", _Direccion.toUpperCase());
        out.printf("%-20s\n", _Curp.toUpperCase());
        out.printf("%-20s\n", _RFC.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", "", "Cambio/Adeudo: ", df.format(_Cambio));
        out.print("\n");
    }

    private static void Imprimir_Recibo_Luz(String _Nombre, String _Direccion, int _NoMedidor, int _NoServicio, String _Limite, String _Curp, double _Consumo, double _AdeudoPagar, String _Periodo, String _RMU, double _Cambio, double _Pago) {
        out.println("------------------------------------------------------------------------------");
        out.printf("%-50s%-10s\n", "CFE", "EazyPay Pago de Servicios");
        out.printf("%-50s%-10s\n", "", "Hermosillo, Sonora. C.P 0000");
        out.printf("%-50s%-10s\n", "", "RFC: BNDL838CP7");
        out.printf("\n");
        out.printf("%-50s%-10s\n", "Nombre:", "Total a Pagar");
        out.printf("%-50s%-10s\n", _Nombre.toUpperCase(), df.format(_AdeudoPagar));
        out.printf("%-50s%-10s\n", "Direccion:", "Curp: ");
        out.printf("%-50s%-10s\n", _Direccion.toUpperCase(),  _Curp.toUpperCase());
        out.printf("------------------------------------------------------------------------------\n");
        out.printf("%-10s%-35s%-10s\n", "No. Servicio:", _NoServicio, "Periodo Facturado:");
        out.printf("%-10s%-40s%-10s\n", "RMU:", _RMU.toUpperCase(), _Periodo.toUpperCase());
        out.printf("------------------------------------------------------------------------------\n");
        out.printf("%-13s%-10s%-13s%-13s%-13s%-10s\n", "Tarifa: 1F", "No. Medidor:", _NoMedidor, "Multiplicador: 1", "Limite de Pago:", _Limite.toUpperCase());
        out.printf("%-15s%-20s%-20s%-20s\n", "Concepto", "Lectura Actual", "Precio(MXN)", "Subtotal(MXN)");
        out.printf("%-15s%-20s%-20s%-20s\n", "Energia(kWh)", _Consumo, "$ 0.793         $", df.format(_AdeudoPagar));
        out.printf("\n");
        out.printf("%-15s%-20s%-20s%-20s\n", "", "", "Deposito       $", df.format(_Pago));
        out.printf("%-15s%-20s%-20s%-20s\n", "", "", "Cambio/Adeudo  $", df.format(_Cambio));
        out.print("\n");
    }

    private static void Imprimir_Recibo_Agua(double _Adeudo, double _Consumo, String _Curp, String _Direccion, double _iva, String _Limite, int _nis, int _NoMedidor, String _Nombre, double _Tarifa, double _Cambio, double _Pago) {
        out.println("----------------------------------------------------------------------------");
        out.println("                                Recibo                   ");
        out.printf("%-40s%-10s\n", "Agua", "EazyPay Pago de Servicios");
        out.printf("%-20s\n", "COMPAÑIA SUMINISTRADORA DE AGUA");
        out.println("----------------------------------------------------------------------------");
        out.printf("%-20s\n", "BLVD. LUIS ENCINAS J.");
        out.printf("%-40s%-10s%-10s\n", "6622896000", "Medidor:", _NoMedidor);
        out.printf("%-40s%-10s%-10s\n", "", "Pagar Antes de: ", _Limite.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", "", "Consumo", df.format(_Consumo));
        out.printf("%-40s%-10s%-10s\n", "", "Tarifa", df.format(_Tarifa));
        out.printf("%-40s%-10s%-10s\n", _Nombre.toUpperCase(), "IVA:", df.format(_iva));
        out.printf("%-40s%-10s%-10s\n", "", "Fecha de Vencimiento:", _Limite.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", _Direccion.toUpperCase(), "Total a Pagar:", df.format(_Adeudo));
        out.printf("%-40s%-10s%-10s\n", "", "Curp:", _Curp.toUpperCase());
        out.printf("%-40s%-10s%-10s\n", "", "NIS:", _nis);
        out.printf("%-40s%-10s%-10s\n", "", "Pago:", _Pago);
        out.printf("%-40s%-10s%-10s\n", "", "Cambio/Adeudo:", df.format(_Cambio));
        out.print("\n");
    }

    private static void Consulta_Info_Luz(String _Nombre, String _Direccion, int _NoMedidor, double _AdeudoPagar) {
        out.println("\n");
        out.println("Nombre...........: " + _Nombre.toUpperCase());
        out.println("Direccion........: " + _Direccion.toUpperCase());
        out.println("Numero de Medidor: " + _NoMedidor);
        out.println("Adeudo a pagar...: " + df.format(_AdeudoPagar));
        out.println("\n");
    }

    private static void Consulta_Info_Internet(String _Nombre, String _Direccion, int _Telefono, double _Adeudo) {
        out.println("\n");
        out.println("Nombre...........: " + _Nombre.toUpperCase());
        out.println("Direccion........: " + _Direccion.toUpperCase());
        out.println("Numero de Celular: " + _Telefono);
        out.println("Adeudo a Pagar...: " + df.format(_Adeudo));
        out.println("\n");
    }

    private static void Consulta_Info_Agua(String _Nombre, String _Direccion, String _Curp, double _Adeudo) {
        out.println("\n");
        out.println("Nombre........: " + _Nombre.toUpperCase());
        out.println("Direccion.....: " + _Direccion.toUpperCase());
        out.println("Curp:.........: " + _Curp.toUpperCase());
        out.println("Adeudo a Pagar: " + df.format(_Adeudo));
        out.println("\n");
    }

}
