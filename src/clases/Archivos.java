/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Ronald Jefrey Moreno Mora 
 * @author Luis Miguel Morales Sandoval
 * Grupo: 301 
 * Materia: Programacion II 
 */
import java.io.*;
import java.io.File;
import java.io.FileReader;
public class Archivos {
    private String primerParametro = " ";
    private String segundoParametro = " ";
    /**
     * Constructor Archivos
     * @param _segundoParametro 
     */
    Archivos(String _segundoParametro){
        this.segundoParametro = _segundoParametro;
    }
    /**
     * Constructor Archivos
     * @param _primerParametro
     * @param _segundoParametro 
     */
    public Archivos(String _primerParametro,String _segundoParametro){
        this.primerParametro = _primerParametro;
        this.segundoParametro = _segundoParametro;
    }
    /**
     * actualizar los datos del archivo
     * @param _contadorActualizar
     * @return 
     */
    public String actualizar(int _contadorActualizar){
        int contadorLocal=0;
        String contactoHallado="Ninguno";
        try{
            File f=new File("Personal.txt");
            if(f.exists()){
                FileReader fr=new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    String contacto[] = linea.split("&");
                        contadorLocal++;
                        if(contacto[1].equals(getSegundoParametro())&&_contadorActualizar==contadorLocal){
                           contactoHallado=contacto[0];
                        }
                    
                }
                
            }else{
                System.out.println("Archivo no existente.");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return contactoHallado;
    }
    /**
     * Imprimir los datos del archivo
     */
    public void imprimir(){
        try{
            File f=new File("Personal.txt");
            if(f.exists()){
                FileReader fr=new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    String contacto[] = linea.split("&");
                   
                        if(contacto[1].equals(getSegundoParametro())){
                            System.out.println("Nombre: "+contacto[0]);
                            System.out.println("Personal: "+contacto[1]);
                            System.out.println(" ");
                        }
                    
                }
                
            }else{
                System.out.println("Archivo no existente.");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * Escribir los datos en el archivo
     */
    public void escribir(){
        try{
            File f=new File("Personal.txt");
            FileWriter fw;
            BufferedWriter bw;
            if(f.exists()){
                fw= new FileWriter(f,true);
                bw=new BufferedWriter(fw);
                bw.newLine();
                bw.write(getPrimerParametro()+"&"+getSegundoParametro());
            }else{
                fw= new FileWriter(f);
                bw=new BufferedWriter(fw);
                bw.write(getPrimerParametro()+"&"+getSegundoParametro());
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * Eliminar datos del archivo
     */
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
                    if(linea2[0].equals(getPrimerParametro())){
                        bandera=true;
                        
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

    /**
     * @return the primerParametro
     */
    public String getPrimerParametro() {
        return primerParametro;
    }

    /**
     * @param primerParametro the primerParametro to set
     */
    public void setPrimerParametro(String primerParametro) {
        this.primerParametro = primerParametro;
    }

    /**
     * @return the segundoParametro
     */
    public String getSegundoParametro() {
        return segundoParametro;
    }

    /**
     * @param segundoParametro the segundoParametro to set
     */
    public void setSegundoParametro(String segundoParametro) {
        this.segundoParametro = segundoParametro;
    }

    @Override 
    public String toString(){ 
        return "Primer Parametro: "+getPrimerParametro()+" Segundo Parametro: "+getSegundoParametro();
    }; 
}
