
import java.io.*;
import java.net.Socket;

public class HiloSumar extends Thread {

    //private final int port;
    private BufferedReader reader;

    private Socket conexion;

    public HiloSumar() {
        //this.port = port;
    }

    public void aceptaConexion(Socket conexion) {
        this.conexion = conexion;
    }

    @Override
    public void run() {
        try {
            InputStream flujoBE = conexion.getInputStream();
            Reader flujoCE = new InputStreamReader(flujoBE);
            reader = new BufferedReader(flujoCE);

            //OutputStream flujoBS = conexion.getOutputStream();
            //Writer flujoCS = new OutputStreamWriter(conexion.getOutputStream());
            //writer = new BufferedWriter(flujoCS);

            String jugador = reader.readLine();
            System.out.println("Jugador conectado: " + jugador);
            while (true) {
                System.out.println(jugador + " tiene " + reader.readLine() + " aciertos ");
            }
        } catch (IOException ioe1) {
            System.out.println("Error");
        }
    }
}
