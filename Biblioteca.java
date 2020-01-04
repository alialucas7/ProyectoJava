import java.util.*;
/**
 * @author Collar Tomas, Alia Lucas, Abrahan Ulises
 * @version 3
 */

public class Biblioteca{
    private String nombre;
    private HashMap<String, Libro> libros;
    private HashMap<Integer, Socio> socios;
    
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setLibros(new HashMap<String,Libro>());
        this.setSocio(new HashMap<Integer,Socio>());
    }

    /**
     * 
     * @param p_nombre
     * @param p_libro
     */
    public Biblioteca(String p_nombre,  Libro p_libro){
        this.setNombre(p_nombre);
        this.setLibros(new HashMap<String,Libro>());
        this.setSocio(new HashMap<Integer,Socio>());
        this.addLibro(p_libro);
    }

    /**
     * 
     * @param p_nombre
     * @param p_socio
     */
    public Biblioteca(String p_nombre, Socio p_socio){
        this.setNombre(p_nombre);
        this.setLibros(new HashMap<String,Libro>());
        this.setSocio(new HashMap<Integer,Socio>());
        this.addSocio(p_socio);
    }


    public Biblioteca(String p_nombre, Libro p_libro, Socio p_socio){
        this.setNombre(p_nombre);
        this.setLibros(new HashMap<String,Libro>());
        this.addLibro(p_libro);
        this.setSocio(new HashMap<Integer,Socio>());
        this.addSocio(p_socio);
    }

    public Biblioteca(String p_nombre, HashMap<String,Libro> p_libros, Socio p_socio){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocio(new HashMap<Integer,Socio>());
        this.addSocio(p_socio);
    }

    public Biblioteca(String p_nombre, Libro p_libro, HashMap<Integer,Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(new HashMap<String,Libro>());
        this.addLibro(p_libro);
        this.setSocio(p_socios);
    }

    public Biblioteca(String p_nombre, HashMap<String,Libro> p_libros){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocio(new HashMap<Integer,Socio>());
    }

    public Biblioteca(HashMap<Integer,Socio> p_socios, String p_nombre){
        this.setNombre(p_nombre);
        this.setSocio(p_socios);
        this.setLibros(new HashMap<String,Libro>());
    }

    public Biblioteca(String p_nombre, HashMap<String,Libro> p_libros, HashMap<Integer,Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocio(p_socios);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
        
    private void setLibros(HashMap<String,Libro> p_libros){
        this.libros = p_libros;
    }
    
    public HashMap<String,Libro> getLibros(){
        return this.libros;
    }
    
    private void setSocio(HashMap<Integer, Socio> p_socios){
        this.socios = p_socios;
    }
    
    public HashMap<Integer,Socio> getSocios(){
        return this.socios;
    }
    
    private void addLibro(Libro p_libro){
        this.getLibros().put(p_libro.getTitulo(), p_libro);
    }
    
    public void removerLibro(Libro p_libro){
        this.getLibros().remove(p_libro.getTitulo());
    }
    
    /**
     * Agrega el socio p_socio al hashmap de socios
     */
    public void addSocio(Socio p_socio){
        this.getSocios().put(p_socio.getDniSocio(), p_socio);
    }
    
    /**
     * Elimina el socio p_socio del hashmap de socios
     */
    public void removerSocio(Socio p_socio){
        this.getSocios().remove(p_socio.getDniSocio());
    }
    
    /**
     * Agrega un nuevo libro a la la biblioteca
     * @param p_titulo
     * @param p_edicion
     * @param p_editorial
     * @param p_anio
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.addLibro(new Libro(p_titulo, p_edicion, p_editorial, p_anio));
    }
    
    /**
     * Agrega un nuevo socio de tipo estudiante al array de socios
     * @param p_dniSocio
     * @param p_nombre
     * @param p_carrera
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre,int p_diasPrestamo, String p_carrera){
        this.addSocio(new Estudiante(p_dniSocio, p_nombre, p_diasPrestamo, p_carrera));
    }
    
    /**
     * Agrega un nuevo socio de tipo docente al array de socios
     * @param p_dniSocio
     * @param p_nombre
     * @param p_area
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre,int p_diasPrestamo, String p_area){
        this.addSocio(new Docente(p_dniSocio, p_nombre,p_diasPrestamo, p_area));
    }
    
    /**
     * Cuenta la cantidad de socios docentes y estudiantes
     * @param p_objeto
     * @return Cantidad de socios por tipo
     */
    public int cantidadSociosPorTipo(String p_objeto){
        int cantidad = 0;
        for(Map.Entry<Integer,Socio> socio : this.getSocios().entrySet()){
            if(socio.getValue().soyDeLaClase().equals(p_objeto)){
                cantidad++;
            }
        }
        return cantidad;
    }    
    
    /**     
     * Crea un prestamo y lo asigna al respectivo Socio y Libro
     * @param p_fechaRetiro
     * @param p_socio
     * @param p_libro
     * @return true si se pudo realizar la operacion, false en caso contrario
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){//HACER
        boolean prestar = false;
        if(p_socio.puedePedir() == true){
            Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
            p_libro.addPrestamo(prestamo);
            p_socio.addPrestamo(prestamo);
            prestar = true;
        }
        return prestar;
    }
    
    /**
     * Devuelve el libro y registra su devolucion
     * @param p_libro
     */
    public void devolverLibro(Libro p_libro){
        Calendar hoy = Calendar.getInstance();
        
        if(p_libro.prestado() == true){
            p_libro.getPrestamo().registrarFechaDevolucion(hoy);
        }
    }
    
    /**
     * Devuelve en un array los prestamos que estan vencidos
     * @return ArrayList con los prestamos vencidos
     */
    public ArrayList<Prestamo> prestamosVencidos(){
        Calendar hoy = Calendar.getInstance();        
        ArrayList <Prestamo> presVencidos = new ArrayList<Prestamo>();
        
        for(Map.Entry<String, Libro> libro : this.getLibros().entrySet()){
            for(int i=0;i<libro.getValue().getPrestamos().size();i++){    
                //if(prestamo.vencido(hoy) == true){
                if(((Prestamo)libro.getValue().getPrestamos().get(i)).vencido(hoy) == true){    
                    //prest_vencidos.add(prestamo);
                    presVencidos.add(((Prestamo)libro.getValue().getPrestamos().get(i)));
                }
            }
        }
        return presVencidos;
    }
    
    /**
     * devuelve en un array los docentes responsables
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> devolver = new ArrayList<Docente>();
        
        for(Map.Entry<Integer,Socio> socio : this.getSocios().entrySet()){
            if(socio.getValue().getClass().getName().equals("Docente")){
                Docente temporal = (Docente)socio.getValue();
                
                if(temporal.esResponsable() == true){
                    devolver.add(temporal);
                }
            }
        }
        return devolver;
    }
    
    /**
     * devuelve un string con el nombre del socio que tiene el libro solicitado, si no lo tiene nadie devuelve una leyenda informando que se encuentra en la biblioteca
     * @param Libro p_libro
     * @return loTiene
     */
    public String quienTieneElLibro(Libro p_libro){
        String loTiene = "El libro se encuentra en la biblioteca";
        if(p_libro.prestado() == true){
            loTiene = p_libro.getPrestamo().getSocio().getNombre();
        }
        return loTiene;
    }
    
    /**
     * @return String lista
     */
    public String listaDeSocios(){
        String lista = "";
        int indice = 1;        
        for(Map.Entry<Integer,Socio> socio:this.getSocios().entrySet()){           
            lista = lista + indice +") "+socio.getValue().toString()+" || Libros Prestados: "+socio.getValue().cantLibrosPrestados()+"\n";
            indice ++;            
        }
        
        lista = lista + "\n***********************************************";
        lista = lista + "\n Cantidad Socios tipo Estudiante: " + this.cantidadSociosPorTipo("Estudiante") + "\n";
        lista = lista + "Cantidad Socios tipo Docente: " + this.cantidadSociosPorTipo("Docente") + "\n";
        lista = lista + "***********************************************";
        
        return lista;
    }
    
    /**
     * @return String lista
     */
    public String listaDeLibros(){
        String devolver = "";
        int indice = 1;
        
        for(Map.Entry<String,Libro> lib: this.getLibros().entrySet()){            
             String opc;             
             if(lib.getValue().prestado() == true){
                 opc = "SI";
             }else{
                 opc = "NO";
             }           
             devolver = devolver + indice + ") " + lib.getValue().getTitulo() + " || Prestado: " + "(" + opc + ")\n";
        }        
        return devolver;
    }
    
    /**
     * @return String lista
     */
    public String listaDeDocentesResponsables(){
        String lista = "";
                
        for(Map.Entry<Integer,Socio> socio:this.getSocios().entrySet()){
           
            if(socio.getValue().soyDeLaClase().equals("Docente")){
                 Docente temp = (Docente)socio.getValue();
                                  
                 if(temp.esResponsable() == true){
                    lista += "* " + socio.getValue().toString() + " || Libros Prestados: " + socio.getValue().cantLibrosPrestados() + "\n";                       
                 }
            }
        }
        return lista;
    }
    
    /**
     * Busca un socio por su dni
     * @param int p_dni
     * @return Socio busqueda
     */
    public Socio buscarSocio(int p_dni){        
        Socio busqueda = null;        
        for(Map.Entry<Integer,Socio> socio:this.getSocios().entrySet()){
             
             if(socio.getKey() == p_dni){
                 busqueda= socio.getValue();
             }
        }            
        return busqueda;    
    }
}
