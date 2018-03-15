/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Scanner;
import static principal.Materia.cantidadMateriasCreadas;
import static principal.Materia.materias;

/**
 *
 * @author Ronald
 */
public class Curso extends Materia{
    static int cantidadCursosCreados=0;
    private static String cursos[]=new String[50];
    private String asignacionCurso="Ninguno";
    
    public Curso(String _asignacionMateria,String _asignacionCurso) {
        super(_asignacionMateria);
        for(int i=0;i<cursos.length;i++){
            if(cursos[i].equals(_asignacionCurso)){
             this.asignacionCurso=_asignacionCurso;
            }
        }
        
    }
    
    public void agregarCurso(){
        for(int i=cantidadCursosCreados;i<cursos.length;i++){
            cursos[i]=new String();
        }
        Scanner lecturaVar = new Scanner(System.in);
        System.out.print("Digite la Materia que desea agregar: ");
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
        cursos[cantidadCursosCreados] = cursoP;
        cantidadCursosCreados++;
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
    
}
