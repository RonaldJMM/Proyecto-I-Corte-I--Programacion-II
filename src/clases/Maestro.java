/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author Ronald Jefrey Moreno Mora 
 * @author Luis Miguel Morales Sandoval
 * Grupo: 301 
 * Materia: Programacion II 
 */
public class Maestro extends Curso{
    
  
    private String nombreMaestro = " ";
    static int cantidadMaestrosAgregados=0;
    private static String maestros[]=new String[50];
    
    Maestro(){
        
    }
    /**
     * Constructor Maestro
     * @param _asignacionMateria
     * @param _asignacionCurso
     * @param _nombreMaestro 
     */
    public Maestro(String _asignacionMateria, String _asignacionCurso,String _nombreMaestro) {
        super(_asignacionMateria, _asignacionCurso);
        this.nombreMaestro=_nombreMaestro;
    }
    /**
     * Para evaluar los maestros
     * @param contadorAct
     * @return 
     */
    public String informarMaestro(int contadorAct){
        String respuesta="";
        if(contadorAct>cantidadMaestrosAgregados){
            respuesta="none";
        }else{
            respuesta=maestros[contadorAct];
        }
        
        return respuesta;
    }
    /**
     * Para actualizar los maestros
     */
    public void actualizarMaestro(){
        int contadorAct=0;
        Archivos maestros1=new Archivos(getNombreMaestro(),"Maestro");
        for(int i=0;i<maestros.length;i++){
            maestros[i]=new String();
        }
        cantidadMaestrosAgregados=0;
        for(int i=0;i<maestros.length;i++){
            if(maestros1.actualizar(i)!="Ninguno"){
                maestros[contadorAct]=maestros1.actualizar(i);
                contadorAct++;
                cantidadMaestrosAgregados++;
            }
        }
    }
    /**
     * Para agregar un maestro
     */
    public void agregarMaestro(){
        for(int i=cantidadMaestrosAgregados;i<maestros.length;i++){
            maestros[i]=new String();
        }
        //llenar maestros
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite el maestro que desea agregar: ");
        String maestroP1;
        int bandera=0;
        maestroP1 = lecturaVar.nextLine();
       
        
        
        for(int i=0;i<maestros.length;i++){
            if(maestros[i].equals(maestroP1)){
                System.out.println("El maestro ya se encuentra registrado.");
                bandera=1;
            }
        }
       
        if(bandera==0){
        maestros[getCantidadCursosCreados()] = (maestroP1);
        cantidadMaestrosAgregados++;
        
        Archivos maestros2=new Archivos(maestroP1,"Maestro");
        maestros2.escribir();
        System.out.println("El maestro ha sido agregado a la base de datos.");
        }
        bandera=0;
    }
    /**
     * Para eliminar un maestro
     * @return maestroP2
     */
    public String eliminarMaestro(){
        for(int i=cantidadMaestrosAgregados;i<maestros.length;i++){
            maestros[i]=new String();
        }
        Scanner lecturaVar = new Scanner(System.in);
        System.out.println("Digite maestro que desea eliminar: ");
        String maestroP2;
        int bandera=1;
        maestroP2 = lecturaVar.nextLine();
       
        
        
        for(int i=0;i<maestros.length;i++){
            if(maestros[i].equals(maestroP2)){
                System.out.println("El maestro se ha eliminado.");
                bandera=0;
            }
        }
       
        if(bandera==0){
        Archivos alumnos3=new Archivos(maestroP2,"Maestro");
            alumnos3.eliminar();
            actualizarMaestro();
        }else{
            System.out.println("El maestro no se encuentra en la base de datos.");
        }
        bandera=1;
        return maestroP2;
    }
    
    /**
     * @return the NombreMaestro
     */
    public String getNombreMaestro() {
        return nombreMaestro;
    }

    /**
     * @param NombreMaestro the NombreMaestro to set
     */
    public void setNombreMaestro(String NombreMaestro) {
        this.nombreMaestro = NombreMaestro;
    }

    @Override 
    public String toString(){ 
        return "Nombre Maestro: "+this.getNombreMaestro()+" Cantidad Maestros Agregados: "+cantidadMaestrosAgregados+" Maestros: "+maestros;
    }; 

    
   
}

