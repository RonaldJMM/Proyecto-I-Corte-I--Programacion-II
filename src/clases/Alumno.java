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
    public class Alumno extends Curso{
    
    private String nombreAlumno = " ";
    private int numeroNotas=1;
    private float promedioNotas=0.0f;
    public float notas[] = new float[1000];
    static int cantidadAlumnosAgregados=0;
    private static String alumnos[]=new String[50];
   
    Alumno(){
        
    }
    /**
     * Constructor Alumno
     * @param _asignacionMateria
     * @param _asignacionCurso
     * @param _nombreAlumno 
     */
    Alumno(String _asignacionMateria, String _asignacionCurso,String _nombreAlumno){
        super(_asignacionMateria, _asignacionCurso);
        this.nombreAlumno=_nombreAlumno;
    }
    /**
     * Para asignar el numero de notas del alumno
     * @param _numeroNotas 
     */
    public void asignarNumeroNotas(int _numeroNotas){
        
        setNumeroNotas(_numeroNotas);
    }
    /**
     * Para imprimir las notas del alumno
     */
    public void imprimirNotas(){
        
        for(int i=0;i<getNumeroNotas();i++){
            System.out.println("Nota "+(1+i)+": "+getNotas()[i]);
        }
        
    }
    /**
     * Para calcular el promedio del alumno
     */
    public void calcularPromedio(){
        float _promedioNotas=0.0f;
        for (int i = 0; i < 10; i++) {
            _promedioNotas=_promedioNotas+getNotas()[i];
        }
        
        _promedioNotas=_promedioNotas/getNumeroNotas();
        setPromedioNotas(_promedioNotas);
    }
    /**
     * Para evaluar los alumnos
     * @param contadorAct
     * @return respuesta
     */
    public String informarAlumno(int contadorAct){
         String respuesta="";
         
         respuesta = alumnos[contadorAct];

         return respuesta;
     }
    /**
     * Para actualizar los alumnos de la base de datos
     */
    public void actualizarAlumno(){
        Archivos alumnos1=new Archivos(getNombreAlumno(),"Alumno");
        for(int i=0;i<alumnos.length;i++){
            alumnos[i]=new String();
        }
        int contadorAct=0;
        cantidadAlumnosAgregados=0;
        for(int i=0;i<alumnos.length;i++){
            if(alumnos1.actualizar(i)!="Ninguno"){
                alumnos[contadorAct]=alumnos1.actualizar(i);
                contadorAct++;
                cantidadAlumnosAgregados++;
            }
        }
    }
    /**
     * Para agregar un alumno
     * 
     */
    public void agregarAlumno(){
        for(int i=cantidadAlumnosAgregados;i<alumnos.length;i++){
            alumnos[i]=new String();
        }
        
        //llenar maestros
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite alumno que desea agregar: ");
        String alumnoP1;
        int bandera=0;
        alumnoP1 = lecturaVar.nextLine();
       
        
        
        for(int i=0;i<alumnos.length;i++){
            if(alumnos[i].equals(alumnoP1)){
                System.out.println("El alumno ya se encuentra registrado.");
                bandera=1;
            }
        }
       
        if(bandera==0){
        alumnos[getCantidadCursosCreados()] = (alumnoP1);
        cantidadAlumnosAgregados++;
        
        Archivos alumnos2=new Archivos(alumnoP1,"Alumno");
        alumnos2.escribir();
        System.out.println("El alumno ha sido agregado a la base de datos.");
        }
        bandera=0;
    }
    /**
     * Para eliminar un alumno
     * @return alumnoP2
     */
    public String eliminarAlumno(){
        for(int i=cantidadAlumnosAgregados;i<alumnos.length;i++){
            alumnos[i]=new String();
        }
        Scanner lecturaVar = new Scanner(System.in);
        System.out.println("Digite alumno que desea eliminar: ");
        String alumnoP2;
        int bandera=1;
        alumnoP2 = lecturaVar.nextLine();
       
        
        
        for(int i=0;i<alumnos.length;i++){
            if(alumnos[i].equals(alumnoP2)){
                System.out.println("El alumno se ha eliminado.");
                bandera=0;
            }
        }
       
        if(bandera==0){
        Archivos alumnos3=new Archivos(alumnoP2,"Alumno");
            alumnos3.eliminar();
            actualizarAlumno();
        }else{
            System.out.println("El alumno no se encuentra en la base de datos.");
        }
        bandera=1;
        return alumnoP2;
    }

    /**
     * @return the nombreAlumno
     */
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    /**
     * @param nombreAlumno the nombreAlumno to set
     */
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    /**
     * @return the numeroNotas
     */
    public int getNumeroNotas() {
        return numeroNotas;
    }

    /**
     * @param numeroNotas the numeroNotas to set
     */
    public void setNumeroNotas(int numeroNotas) {
        this.numeroNotas = numeroNotas;
    }

    /**
     * @return the promedioNotas
     */
    public float getPromedioNotas() {
        return promedioNotas;
    }

    /**
     * @param promedioNotas the promedioNotas to set
     */
    public void setPromedioNotas(float promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    /**
     * @return the notas
     */
    public float[] getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    @Override 
    public String toString(){ 
        return "Nombre Alumno: "+this.getNombreAlumno()+" Cantidad Alumnos Agregados: "+cantidadAlumnosAgregados+" Alumnos: "+alumnos+" Numero de Notas: "+this.getNumeroNotas()+" Promedio Notas: "+this.getPromedioNotas()+" Notas: "+notas;
    };  

    
}
