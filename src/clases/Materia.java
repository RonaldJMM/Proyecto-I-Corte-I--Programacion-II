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
public class Materia {
    
    static int cantidadMateriasCreadas=0;
    static String materias[]= new String[50];
    
    private String asignacionMateria= "Ninguno";
    
    public Materia(){
        
    }
    /**
     * Constructor Materia
     * @param _asignacionMateria 
     */
    public Materia(String _asignacionMateria){
        for(int i=0;i<materias.length;i++){
            if(materias[i].equals(_asignacionMateria)){
             this.asignacionMateria=_asignacionMateria;
            }
        }
    }
    /**
     * Funcion para mostrar los datos de las materias y evaluarlos
     * @param contadorAct
     * @return respuesta
     */
    public String informarMateria(int contadorAct){
         String respuesta="";
         
         respuesta = materias[contadorAct];

         return respuesta;
     }
    /**
     * Funcion para moestrar las materias
     */
    public void imprimirMateria(){
        for (int i = 0; i < 10; i++) {
            if(materias[i]!=null && !materias[i].equals("")){
                System.out.println("Materia: "+materias[i]);
            }
        }
    }
    /**
     * Funcion para agregar las materias
     */
    public void agregarMateria(){
        for(int i=getCantidadMateriasCreadas();i<materias.length;i++){
            materias[i]=new String();
        }
        
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite la Materia que desea agregar: ");
        String materiaP;
        int bandera=0;
        materiaP = lecturaVar.nextLine();
        
        
        for(int i=0;i<materias.length;i++){
            if(materias[i].equals(materiaP)){
                System.out.println("La materia ya se encuentra registrada.");
                bandera=1;
            }
        }
       
        if(bandera==0){
        materias[getCantidadMateriasCreadas()] = materiaP;
            setCantidadMateriasCreadas(getCantidadMateriasCreadas() + 1);
        }
        bandera=0;
       
    }

    /**
     * muestra
     * @return asignacionMateria
     */
    public String getAsignacionMateria() {
        return this.asignacionMateria;
    }

    /**
     * asigna
     * @param asignacionMateria asigna
     */
    public void setAsignacionMateria(String asignacionMateria) {
        this.asignacionMateria = asignacionMateria;
    }
    
    

    /**
     * muestra
     * @return cantidadMateriasCreadas
     */
    public int getCantidadMateriasCreadas() {
        return cantidadMateriasCreadas;
    }

    /**
     * asigna
     * @param aCantidadMateriasCreadas asigna
     */
    public void setCantidadMateriasCreadas(int aCantidadMateriasCreadas) {
        cantidadMateriasCreadas = aCantidadMateriasCreadas;
    }
    @Override 
    public String toString(){ 
        return "Cantidad Materias Creadas: "+this.getCantidadMateriasCreadas()+" Materias: "+materias+" Asignacion Materias: "+getAsignacionMateria();
    }; 
    
}
