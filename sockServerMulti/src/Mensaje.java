/**
 *
 * @author Juan Camilo Sarmiento Reyes
 * @author Samuel Holguin
 * @version 0.2
 */
public class Mensaje {
    
    private String texto;
    private int estado;
    private int []horaMensaje;
    private String ipReceptor;

    public Mensaje(String texto, int estado, int[] horaMensaje, String ipReceptor) {
        this.texto = texto;
        this.estado = estado;
        this.horaMensaje = horaMensaje;
        this.ipReceptor = ipReceptor;
    }
    
     //Métodos get y set
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int[] getHoraMensaje() {
        return horaMensaje;
    }

    public void setHoraMensaje(int[] horaMensaje) {
        this.horaMensaje = horaMensaje;
    }

    public String getIpReceptor() {
        return ipReceptor;
    }

    public void setIpReceptor(String ipReceptor) {
        this.ipReceptor = ipReceptor;
    }
}
