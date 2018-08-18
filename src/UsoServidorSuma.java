
public class UsoServidorSuma {

    public static void main(String[] args) {
        ServidorSuma s = new ServidorSuma(2500);
        s.iniciarServidor();
        s.conectarClientes();
    }
}
