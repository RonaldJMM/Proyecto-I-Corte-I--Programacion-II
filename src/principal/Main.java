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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Archivos pe = new Archivos();
        Maestro rt = new Maestro("Ingles", "Español");
        pe.escribir(rt);
        
        
        
        
    }
    
    public static void menu(){
        Scanner lecturaVar = new Scanner(System.in);
        System.out.println("1.Añadir Profesor");
        System.out.println("2.Añadir Estudiante");
        System.out.println("3.Crear Curso");
        System.out.println("4.Crar Materia");
        System.out.println("5.Asignar Estudiante");
        System.out.println("6.Asignar Notas Estudiante");
        System.out.println("7.Añadir Profesor");
        byte opcionMenu=0;
                 do{//repeticion del menu de opciones
                     
                    opcionMenu = lecturaVar.nextByte();//escaneo del dato del menu del usuario
                    switch(opcionMenu){

                        case 1:
                          
                            break;

                        case 2:
                            ;
                           break;

                        case 3:
                          
                           break;

                        case 4:
                            
                           break;

                        case 5:
                            //salida del menu.
                            break;
                        default:
                            //opcion no valida del menu.
                            System.out.println("La opcion no es valida.");
                            break;
                    }

                    }while(opcionMenu!=5);
    }
    
}
