import java.util.*;
public class Libro{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList prestamos;

    public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList());}
    public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio,Prestamo p_prestamo){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList());
        this.addPrestamo(p_prestamo);}
    public Libro(String p_titulo,int p_edicion,String p_editorial,int p_anio,ArrayList p_prestamos){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);}    
    
    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;}
    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;}
    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;}
    private void setAnio(int p_anio){
        this.anio = p_anio;}
    private void setPrestamos(ArrayList p_prestamos){
        this.prestamos = p_prestamos;}
        
    public String getTitulo(){
        return this.titulo;}
    public int getEdicion(){
        return this.edicion;}
    public String getEditorial(){
        return this.editorial;}
    public int getAnio(){
        return this.anio;}
    public ArrayList getPrestamos(){
        return this.prestamos;}
        
    public boolean addPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);}
    public boolean removePrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);}
        
    public Prestamo getPrestamo(){
        if(this.getPrestamos().size() > 0){
            return ((Prestamo)this.getPrestamos().get(this.getPrestamos().size() - 1));}
        else{
            System.out.println("No hay prestamos");
            return null;}}
    
    public boolean prestado(){
        Calendar cal = new GregorianCalendar(2019,10,1);
        if(this.getPrestamo().getFechaDevolucion().compareTo(cal) == 0){
            return true;}
        else{
            return false;}}
        
    public String toString(){
        return "Titulo: "+this.getTitulo();}
}