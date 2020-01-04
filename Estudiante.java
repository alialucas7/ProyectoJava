
/**
 * La clase Estudiante contiene los datos necesarios para determininar si un estudiante puede alquilar o no libros.
 * 
 * @author Alfonzo, Micaela
 * @version 06/11/2019
 */
public class Estudiante extends Socio{
        private String carrera;
        
    /**
     * Constructor de objetos de la clase Estudiante
     * 
     * @param int p_socio, String p_nombre, int p_diasPrestamo, String p_carera
     */
    public Estudiante(int p_dniSocio, String p_nombre, int p_diasPrestamo, String p_carrera){
        super(p_dniSocio, p_nombre,p_diasPrestamo);
        this.setCarrera(p_carrera);
    }
    
    /**
     * Asigna un valor al atributo
     * 
     * @param String p_carera
     */
     public void setCarrera(String p_carrera){
        this.carrera=p_carrera;
    }
    
     /**
     * Retorna el valor del atributo
     * 
     * @return carrera
     */
    private String getCarrera(){
        return this.carrera;
    }
    
    /**
     * Permite conocer a clase pertence el objeto
     * 
     * @return Retorna un String indicando a que clase pertenece
     */
    public String soyDeLaClase(){
        return "Estudiante";
    }
    
    /**
     * Permite determinar si el objeto puede pedir un prestamo de libros, verificando si cumple con los requisitos
     * 
     * @return Retorna true o false segun corresponda en cada caso
     */
    public boolean puedePedir(){
        if(super.puedePedir()==true && this.cantLibrosPrestados()<3){
            return true;
        }
        else{
            return false;
        }
    }
}