import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * calse socio de la cual heredan dos clase :Estudiante y Docente
 *
 * @author Alan Ezequiel Chavez
 * @version 1.1
 */
public abstract class  Socio{
    private int dniSocio,diasPrestamo;
    private String nombre;
    private ArrayList prestamos;
    /**
     * Contructir de la clase socio
     */
    Socio(int p_dniSocio,String p_nombre,int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        
        this.setPrestamos(new ArrayList());
    }
    Socio(int p_dniSocio,String p_nombre,int p_diasPrestamo, Prestamo p_prestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        
        this.setPrestamos(new ArrayList());
        this.addPrestamo(p_prestamo);}
    Socio(int p_dniSocio,String p_nombre,int p_diasPrestamo, ArrayList p_prestamos){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setPrestamos(p_prestamos);
    }
    /**
     * setter del Dni del Socio
     */
    private void setDniSocio(int p_dniSocio){
        this.dniSocio=p_dniSocio;
    }
    /**
     * getter del dni del socio
     */
    public int getDniSocio(){
        return this.dniSocio;
    }
    
    /**
     * setter del nombre
     */
    private void setNombre(String p_nombre){
        this.nombre=p_nombre;
    }
    /**
     * getter del nombre
     */
    public String getNombre(){
        return this.nombre;
    }
        
    private void setPrestamos(ArrayList p_prestamos){
        this.prestamos = p_prestamos;}
    /**
     * getter de prestamos
     */
    public ArrayList getPrestamos(){
        return this.prestamos;
    }
    /**
     * adicion de prestamos
     */
    public boolean addPrestamo(Prestamo p_prestamos){
        return this.getPrestamos().add(p_prestamos);
    }
    /**
     * remover de prestamos
     */
    public boolean removePrestamo(Prestamo p_prestamos){
        return this.getPrestamos().remove(p_prestamos);
    }
    /**
     * devuelve la cantidad de libros prestado por socio
     */
    public int cantLibrosPrestados(){
        return this.getPrestamos().size();
    }
    
    /**
     * setter de la cantidad de dias prestados
     */
    private void setDiasPrestamo(int p_diasprestamo){
        this.diasPrestamo=p_diasprestamo;
    }
    /**
     * getter de los dias prestados
     */
    public int getDiasPrestamo(){
        return this.diasPrestamo;
    }
    
    /**
     * calse abstarcta que al heredan docentes y estudiantes apra identificar su tipo de socio
     */
    public abstract String soyDeLaClase();
    
    
    /**
     * devuelve el string que me oredenan en la fotocopia con su formato
     */
    public String toString(){
        if(soyDeLaClase()=="Docente"){
            return "D.N.I.: "+this.getDniSocio()+" || "+ this.getNombre()+
            " ("+this.soyDeLaClase()+") || Libros Prestados: "+this.cantLibrosPrestados();
        }else
        if(soyDeLaClase()=="Estudiante"){
            return "D.N.I.: "+this.getDniSocio()+" || "+ this.getNombre()+
            " ("+this.soyDeLaClase()+") || Libros Prestados: "+this.cantLibrosPrestados();
        }else{
            return "NO ES UN TIPO DE SOCIO VALIDO";
        }
        
    }
    
    /**
     * puede pedir evalua la condicion si puede pedir otro libro
     */
    public boolean puedePedir(){
        GregorianCalendar fechaHoy = new GregorianCalendar();
        fechaHoy.getInstance();
        boolean a = true;
        for (int i=0;i<this.getPrestamos().size();i++){
            if ( ((Prestamo)this.getPrestamos().get(i)).vencido(fechaHoy) ==true){
                a = false;
            }
        }
        return a;
    }
}
