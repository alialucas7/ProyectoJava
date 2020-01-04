import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 
 * la clase prestamo crea el prestamo del libro con una fecha de retiro,
 * y calcula su devolucion.
 * 
 * @autor Alan Ezequiel Chavez
 * @version 1.1
 */
public class Prestamo{
    private Calendar fechaRetiro,fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
    /**
     * Constructor de la clase prestamo
     * con fecha de retiro, el socio , y el libro.
     */
    
    Prestamo (Calendar p_fechaRetiro,Socio p_socio,Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        Calendar cal = new GregorianCalendar(2019,10,1);
        this.setFechaDevolucion(cal);
    }
    
    
    /**
     * setter de la fecha de retiro
     */
    private void setFechaRetiro(Calendar p_fechaRetiro){
        this.fechaRetiro= p_fechaRetiro;
    }
    /**
     * getter de la fecha de retiro
     */
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    
    /**
     * setter de ficha de devolucion
     * la fecha de devolucion se ingresa al devolver el libro 
     */
    private void setFechaDevolucion(Calendar p_fechaDevolucion){
        this.fechaDevolucion=p_fechaDevolucion;
    }
    /**
     * getter de la ficha de devolucion
     */
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    /**
     * regritrala fecha de devolucion cuando entregan el libro
     */
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion){
        this.setFechaDevolucion(p_fechaDevolucion);
    }
    
    /**
     * setter del socio
     */
    private void setSocio(Socio p_socio){
        this.socio= p_socio;
    }
    /**
     * getter del socio
     */
    public Socio getSocio(){
        return this.socio;
    }
    
    /**
     * setter del libro
     */
    private void setLibro(Libro p_libro){
        this.libro=p_libro;
    }
   
    /**
     * geter del libro
     */
    public Libro getLibro(){
        return this.libro;
    }
    
    
    public boolean vencido(Calendar p_fecha){
        Calendar fecha = Calendar.getInstance();
        fecha = this.getFechaRetiro();
        fecha.add(Calendar.DATE,this.getSocio().getDiasPrestamo());
        if(p_fecha.get(Calendar.DATE)>fecha.get(Calendar.DATE)){
            return true;
        }else{return false;
        }
    }
    
    
        /**
     * este toString envia informacion dettalalada como la que nos ordenaron en la fotocopia =)
     */
    public String toString(){
        //Retiro:? ?2014/10/15? ?-? ?Devolucion:? ?2014/10/28
        //Libro:? ?JAVA.? ?Como? ?Programar   
        //Socio:? ?Juan? ?Perez  
        return "Retiro: "+this.getFechaRetiro()+" - Devolucion: "+this.getFechaDevolucion()+
        "\nLibro: "+this.getLibro().getEditorial()+" . "+this.getLibro().getTitulo()+
        "\nSocio: "+this.getSocio().getNombre();
    }
    
}
    