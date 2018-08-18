
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSuma {

    private ServerSocket servidor;
    private final int puerto;

    public ServidorSuma(int puerto) {
        this.puerto = puerto;
    }

    public void iniciarServidor() {
        try {
            servidor = new ServerSocket(puerto);
            System.out.print("El puerto utilizado por el Socket es: ");
            System.out.println(servidor.getLocalPort());
            System.out.println("Los clientes deberan conectarse usando este puerto");
            System.out.print("La direccion IP del servidor es: ");
            System.out.println(InetAddress.getLocalHost());
        } catch (IOException e) {
            System.out.println("No se puede correr en el puerto " + puerto);
            System.exit(0);
        }
    }

    public void conectarClientes() {
        while (true) {
            HiloSumar s = new HiloSumar();
            Socket conexion = null;
            System.out.println("Esperando un cliente");
            try {
                conexion = servidor.accept();
                System.out.println("Acepta conexion");
                s.aceptaConexion(conexion);
                s.start();
            } catch (IOException e) {
                System.out.println("Error de conexion");
            }
        }
    }
}
