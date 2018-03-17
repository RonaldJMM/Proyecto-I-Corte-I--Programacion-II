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
public class Curso extends Materia{
    private static int cantidadCursosCreados=0;
    public static String cursos[]=new String[50];
    private String asignacionCurso="Ninguno";
    Curso(){
        
    }
    /**
     * Constructor Curso
     * @param _asignacionMateria
     * @param _asignacionCurso 
     */
    public Curso(String _asignacionMateria,String _asignacionCurso) {
        super(_asignacionMateria);
        for(int i=0;i<cursos.length;i++){
            if(cursos[i].equals(_asignacionCurso)){
             this.asignacionCurso=_asignacionCurso;
            }
        }
        
    }
    /**
     * Para evaluar los cursos
     * @param contadorAct
     * @return 
     */
    public String informarCurso(int contadorAct){
         String respuesta="";
         
         respuesta = cursos[contadorAct];

         return respuesta;
     }
    /**
     * Para imprimir los cursos
     */
     public void imprimirCurso(){
        for (int i = 0; i < 10; i++) {
            if(cursos[i]!=null && !cursos[i].equals("")){
                System.out.println("Curso: "+cursos[i]);
            }
        }
    }
     /**
      * Para agregar un curso
      */
    public void agregarCurso(){
        for(int i=getCantidadCursosCreados();i<cursos.length;i++){
            cursos[i]=new String();
        }
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite el curso que desea agregar: ");
        String cursoP;
        int bandera=0;
        cursoP = lecturaVar.nextLine();
        
        
        for(int i=0;i<cursos.length;i++){
            if(cursos[i].equals(cursoP)){
                System.out.println("El curso ya se encuentra registrado.");
                bandera=1;
            }
        }
       
        if(bandera==0){
        cursos[getCantidadCursosCreados()] = cursoP;
            setCantidadCursosCreados(getCantidadCursosCreados() + 1);
        }
        bandera=0;
       
    }
    /**
     * @return the asignacionCurso
     */
    public String getAsignacionCurso() {
        return asignacionCurso;
    }

    /**
     * @param asignacionCurso the asignacionCurso to set
     */
    public void setAsignacionCurso(String asignacionCurso) {
        this.asignacionCurso = asignacionCurso;
    }

    /**
     * @return the cantidadCursosCreados
     */
    public int getCantidadCursosCreados() {
        return cantidadCursosCreados;
    }

    /**
     * @param aCantidadCursosCreados the cantidadCursosCreados to set
     */
    public void setCantidadCursosCreados(int aCantidadCursosCreados) {
        cantidadCursosCreados = aCantidadCursosCreados;
    }
    @Override 
    public String toString(){ 
        return "Cantidad Cursos Creadas: "+this.getCantidadCursosCreados()+" Cursos: "+cursos+" Asignacion Cursos: "+getAsignacionCurso();
    }; 
}
