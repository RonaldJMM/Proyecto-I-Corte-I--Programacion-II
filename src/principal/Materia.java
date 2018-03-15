/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author Ronald
 */
public class Materia {
    
    static int cantidadMateriasCreadas=0;
    static String materias[]= new String[50];
    
    private String asignacionMateria= "Ninguno";
    
    public Materia(){
        
    }
    public Materia(String _asignacionMateria){
        for(int i=0;i<materias.length;i++){
            if(materias[i].equals(_asignacionMateria)){
             this.asignacionMateria=_asignacionMateria;
            }
        }
    }
   
    public void agregarMateria(){
        for(int i=cantidadMateriasCreadas;i<materias.length;i++){
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
        materias[cantidadMateriasCreadas] = materiaP;
        cantidadMateriasCreadas++;
        }
        bandera=0;
       
    }

    /**
     * @return the asignacionMateria
     */
    public String getAsignacionMateria() {
        return this.asignacionMateria;
    }

    /**
     * @param asignacionMateria the asignacionMateria to set
     */
    public void setAsignacionMateria(String asignacionMateria) {
        this.asignacionMateria = asignacionMateria;
    }
    
    @Override 
    public String toString(){ 
        return "Materia: "+this.asignacionMateria;
    }; 
    
}
