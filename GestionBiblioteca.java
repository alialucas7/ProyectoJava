import java.util.*;
/**
 * Write a description of class GestionBiblioteca here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestionBiblioteca{
    public static void main(String[]args){
        Estudiante est1 = new Estudiante(33444555,"Juan Perez",15,"Lic. Matematica");
        Estudiante est2 = new Estudiante(35111777,"Juana Martinez",7,"Ing. Sistemas");
        
        Docente doc1 = new Docente(25111444,"Mario Castelli",20,"Quimica");
        Docente doc2 = new Docente(25111555,"Luigi Castelli",30,"Fisica");
        
        Calendar cal1 = new GregorianCalendar(2019,10,1);
        Calendar cal2 = new GregorianCalendar(2019,10,10);
        Calendar cal3 = new GregorianCalendar(2019,11,1);
        Calendar hoy = Calendar.getInstance();
        
        
        Biblioteca biblio1 = new Biblioteca("Belgrano");
        biblio1.addSocio(est1);
        biblio1.addSocio(est2);
        biblio1.addSocio(doc1);
        biblio1.addSocio(doc2);
        biblio1.nuevoLibro("Programando con JAVA",2005,"Estrada",2005);
        biblio1.nuevoLibro("Manual de Periodismo",15,"Estrada",1992);
        biblio1.nuevoLibro("Algebra 2",1,"Plus Ultra",1990);
        
        
        biblio1.prestarLibro(cal1,est1,biblio1.getLibros().get("Programando con JAVA"));
        biblio1.getLibros().get("Programando con JAVA").getPrestamo().registrarFechaDevolucion(cal2);
        //Pidio el libro "Programando con JAVA" y lo devolvio a tiempo*/
        
        biblio1.prestarLibro(cal1,doc1,biblio1.getLibros().get("Manual de Periodismo"));
        biblio1.devolverLibro(biblio1.getLibros().get("Manual de Periodismo"));
        //Pidio el libro "Manual de Periodismo" y lo devolvio tarde*/
        
        biblio1.prestarLibro(cal2,doc2,biblio1.getLibros().get("Algebra 2"));
        biblio1.getLibros().get("Algebra 2").getPrestamo().registrarFechaDevolucion(cal3);
        //Pidio el libro "Algebra 2" y lo devolvio a tiempo*/
        
        System.out.println("Existen: "+biblio1.cantidadSociosPorTipo("Estudiante")+" socios del tipo Estudiante");
        
        System.out.println("Lista de docentes responsables: \n"+biblio1.listaDeDocentesResponsables());
        
        System.out.println("Lista de libros: \n"+biblio1.listaDeLibros());
        System.out.println("Lista de socios: \n"+biblio1.listaDeSocios());
        
        System.out.println("El que tiene el libro 'Programando con JAVA' es: "+biblio1.quienTieneElLibro(biblio1.getLibros().get("Programando con JAVA")));
    }
}
