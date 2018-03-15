/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;
import static principal.Curso.cantidadCursosCreados;

/**
 *
 * @author Ronald
 */
public class Maestro extends Curso{
    
  
    private String primerNombreMaestro = " ";
    private String segundoNombreMaestro = " ";
    private String primerApellidoMaestro = " ";
    private String SegundoApellidoMaestro = " ";
    
    static int cantidadMaestrosAgregados=0;
    private static String maestros[]=new String[50];
    
    
    public Maestro(String _asignacionMateria, String _asignacionCurso) {
        super(_asignacionMateria, _asignacionCurso); 
    }
    
    public void agregarMaestro(){
        for(int i=cantidadMaestrosAgregados;i<maestros.length;i++){
            maestros[i]=new String();
        }
        //llenar maestros
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite el maestro que desea agregar: ");
        String maestroP;
        int bandera=0;
        maestroP = lecturaVar.nextLine();
        
        
        for(int i=0;i<maestros.length;i++){
            if(maestros[i].equals(maestroP)){
                System.out.println("El curso ya se encuentra registrado.");
                bandera=1;
            }
        }
       
        if(bandera==0){
        maestros[cantidadCursosCreados] = maestroP;
        cantidadMaestrosAgregados++;
        }
        bandera=0;
    }
    
    
    /*@Override 
    public String toString(){ 
        return "Nombre: "+this.getNombreMaestro();
    }; */

    /**
     * @return the primerNombreMaestro
     */
    public String getPrimerNombreMaestro() {
        return primerNombreMaestro;
    }

    /**
     * @param primerNombreMaestro the primerNombreMaestro to set
     */
    public void setPrimerNombreMaestro(String primerNombreMaestro) {
        this.primerNombreMaestro = primerNombreMaestro;
    }

    /**
     * @return the segundoNombreMaestro
     */
    public String getSegundoNombreMaestro() {
        return segundoNombreMaestro;
    }

    /**
     * @param segundoNombreMaestro the segundoNombreMaestro to set
     */
    public void setSegundoNombreMaestro(String segundoNombreMaestro) {
        this.segundoNombreMaestro = segundoNombreMaestro;
    }

    /**
     * @return the primerApellidoMaestro
     */
    public String getPrimerApellidoMaestro() {
        return primerApellidoMaestro;
    }

    /**
     * @param primerApellidoMaestro the primerApellidoMaestro to set
     */
    public void setPrimerApellidoMaestro(String primerApellidoMaestro) {
        this.primerApellidoMaestro = primerApellidoMaestro;
    }

    /**
     * @return the SegundoNombreMaestro
     */
    public String getSegundoApellidoMaestro() {
        return SegundoApellidoMaestro;
    }

    /**
     * @param SegundoNombreMaestro the SegundoNombreMaestro to set
     */
    public void setSegundoApellidoMaestro(String SegundoNombreMaestro) {
        this.SegundoApellidoMaestro = SegundoNombreMaestro;
    }

    
   
}

