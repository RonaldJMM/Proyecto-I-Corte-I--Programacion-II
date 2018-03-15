/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Ronald
 */
import java.io.*;
import java.io.File;
import java.io.FileReader;
public class Archivos {
    
    public void imprimir(){
        try{
            File f=new File("Personal.txt");
            if(f.exists()){
                FileReader fr=new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    String contacto[] = linea.split("&");
                    
                }
            }else{
                System.out.println("Archivo no existente.");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void escribir(Maestro nueva){
        try{
            File f=new File("personal.txt");
            FileWriter fw;
            BufferedWriter bw;
            if(f.exists()){
                fw= new FileWriter(f,true);
                bw=new BufferedWriter(fw);
                bw.newLine();
                bw.write(nueva.getPrimerNombreMaestro()+"&"+nueva.getSegundoNombreMaestro()+"&"+nueva.getPrimerApellidoMaestro()+"&"+nueva.getSegundoApellidoMaestro());
            }else{
                fw= new FileWriter(f);
                bw=new BufferedWriter(fw);
                bw.write(nueva.getPrimerNombreMaestro()+"&"+nueva.getSegundoNombreMaestro()+"&"+nueva.getPrimerApellidoMaestro()+"&"+nueva.getSegundoApellidoMaestro());
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void eliminar(){
        try{
        File f=new File("Personal.txt");
            if(f.exists()){
                FileReader fr= new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int numLineas=0;
                while((linea=br.readLine())!=null){
                    numLineas++;
                }
                System.out.println("Total de lineas: "+numLineas);
                String personal[]= new String[numLineas];
                br = new BufferedReader(new FileReader(f));
                int i=0;
                while((linea=br.readLine())!=null){
                    
                    personal[i]=linea;
                    i++;
                }
                br.close();
                fr.close();
                
                FileWriter fw=new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                boolean bandera=false;
                boolean primeraL=true;
                for (int j = 0; j < personal.length; j++) {
                    String linea2[]= personal[j].split("&");
                    if(linea2[0].equals("s")){
                        bandera=true;
                        System.out.println("Ha sido eliminado");
                    }else{
                        if(primeraL==true){
                            bw.write(personal[j]);
                            primeraL=false;
                        }else{
                            bw.newLine();
                            bw.write(personal[j]);
                        }
                           
                    }
                        
                }
                if(bandera==false){
                    System.out.println("No se encontro el contacto");
                }
                bw.close();
                fw.close();
                if(numLineas==1 && bandera==true){
                    f.delete();
                }
            }else{
                System.out.println("No hay personas");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
