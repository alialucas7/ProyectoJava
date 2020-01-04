
/**
 * La clase Docente contiene los datos necesarios para determininar si un docente puede alquilar o no libros.
 * 
 * @author Alfonzo, Micaela 
 * @version 6/11/2019
 */
public class Docente extends Socio{
    private String area;
    
    /**
     * Constructor de objetos de la clase Docente
     * 
     * @param int p_socio, String p_nombre, int p_diasPrestamo, String p_area
     */
    public Docente(int p_dniSocio, String p_nombre,int p_diasPrestamo, String p_area){
        super(p_dniSocio, p_nombre,p_diasPrestamo);
        this.setArea(p_area);
    }
    
     /**
     * Asigna un valor al atributo
     * 
     * @param String p_area
     */
    private void setArea(String p_area){
        this.area=p_area;
    }
    
    /**
     * Retorna el valor del atributo
     * 
     * @return area
     */
    public String getArea(){
        return this.area;
    }
    
    /**
     * Determina si el objeto docentees resposnable, verificando si no contiene prestamos vencidos
     * 
     * @return Retorna true o false segun corresponada en cada caso
     */
    public boolean esResponsable(){
        if(this.puedePedir()==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Retorna el valor del atributo
     * 
     * @return Retorna la suma total de los dias de prestamos, mas la cantidad de dias de prestamo que se le agreguen por ser responsable
     */
    public int agregarDiasDePrestamo(int p_dias){
        return this.getDiasPrestamo()+p_dias;
    }
    
    /**
     * Permite conocer a clase pertence el objeto
     * 
     * @return Retorna un String indicando a que clase pertenece
     */
    public String soyDeLaClase(){
        return "Docente";
    }
}
    