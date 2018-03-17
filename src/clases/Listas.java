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


public class Listas {
    private int totalMaestros=0;//total de maestros
    private int totalAlumnos=0;//total de alumnos
    private int totalMaterias=0;//total materias
    private int totalCursos=0;//total cursos
    private int cantidadObjetosMaestros=0;//total cantidad de objetos de maestros
    private int cantidadObjetosAlumnos=0;//total cantidad de objetos de alumnos
    
    /**
     * Constructor de la clase Listas
     */
    public Listas(){
        
    }
    /**
     * Metodo de la clase Listas - Cuerpo del programa - Menu
     */
    public void menu(){
        //OBJETOS DEL CUERPO DEL PROGRAMA
        Materia materia = new Materia();
        Curso curso = new Curso();
        Maestro maestro = new Maestro();
        Alumno alumno = new Alumno();
        
        Maestro maestros[] = new Maestro[300];
        Alumno alumnos[] = new Alumno[300];
        
        Scanner lecturaVar = new Scanner(System.in);
        
        
        
        byte opcionMenu=0;//opcion del menu
        
        float nota1,nota2,nota3,nota4,nota5;//notas de los mejores promedios
        String nombre1="",nombre2="",nombre3="",nombre4="",nombre5="";//nombres de los mejores promedios
        
        for (int i = 0; i < 300; i++) {//creacion de los objetos de alumnos
            alumnos[i]=new Alumno();
        }
        do{//repeticion del menu de opciones
        System.out.println(" ");
        System.out.println("******* GESTION DE LISTAS *******");     
        System.out.println(" ");        
        System.out.println("1.Añadir y Eliminar");
        System.out.println("2.Asignar Estudiante y Maestro");
        System.out.println("3.Asignar Notas Estudiante");
        System.out.println("4.Listado Alumnos por Materia");
        System.out.println("5.Mostrar 5 Mejores Promedios");
        System.out.println("6.Listado Docentes");
        System.out.println(" ");
        System.out.println("*********************************");                           
        System.out.println(" "); 
        System.out.print("R:/ ");                          
                                   
        
        opcionMenu = lecturaVar.nextByte();//escaneo del dato del menu del usuario
        switch(opcionMenu){

            case 1:
                do{//repeticion del menu de opciones
                System.out.println(" ");
                System.out.println("******* AÑADIR Y ELIMINAR *******");     
                System.out.println(" ");     
                System.out.println("1.Añadir Alumno");
                System.out.println("2.Eliminar Alumno");
                System.out.println("3.Añadir Maestro");
                System.out.println("4.Eliminar Maestro");
                System.out.println("5.Añadir Materia");
                System.out.println("6.Añadir Curso");
                System.out.println("7.Volver");
                System.out.println(" ");
                System.out.println("*********************************");                           
                System.out.println(" "); 
                System.out.print("R:/ ");
                opcionMenu = lecturaVar.nextByte();//escaneo del dato del menu del usuario
                switch(opcionMenu){

                    case 1://añadir alumno
                        System.out.println(" ");
                        System.out.println("******* AÑADIR *******"); 
                        Archivos archivo1= new Archivos("Alumno");
                        archivo1.imprimir();
                        System.out.println(" ");
                        System.out.println("*********************************");                           
                        System.out.println(" ");
                        alumno.actualizarAlumno();
                        alumno.agregarAlumno();
                        setTotalMaestros(maestro.cantidadMaestrosAgregados);
                        setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                        
                        break;

                    case 2://eliminar alumno
                        System.out.println(" ");
                        System.out.println("******* ELIMINACIÓN *******");        
                        
                        String alumnoEliminar=" ";
                        Archivos archivo2= new Archivos("Alumno");
                        archivo2.imprimir();
                        System.out.println(" ");
                        System.out.println("*********************************");                           
                        System.out.println(" ");
                        alumno.actualizarAlumno();
                        alumnoEliminar=alumno.eliminarAlumno();
                        for (int i = 0; i < getCantidadObjetosAlumnos(); i++) {
                            if(alumnoEliminar.equals(alumnos[i].getNombreAlumno())){
                               alumnos[i].setNombreAlumno("none");
                               alumnos[i].setAsignacionCurso("none");
                               alumnos[i].setAsignacionMateria("none");
                                for (int j = 0; j < alumnos[i].getNumeroNotas(); j++) {
                                  alumnos[i].notas[j]=0.0f;  
                                }
                               alumnos[i].setPromedioNotas(0);
                            }
                        }
                        
                        setTotalMaestros(maestro.cantidadMaestrosAgregados);
                        setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                        
                       break;

                    case 3://añadir maestro
                        System.out.println(" ");
                        System.out.println("******* AÑADIR *******"); 
                        Archivos archivo3= new Archivos("Maestro");
                        archivo3.imprimir();
                        System.out.println(" ");
                        System.out.println("*********************************");                           
                        System.out.println(" ");
                        maestro.actualizarMaestro();
                        maestro.agregarMaestro();
                        setTotalMaestros(maestro.cantidadMaestrosAgregados);
                        setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                       break;

                    case 4://eliminar maestro
                        System.out.println(" ");
                        System.out.println("******* ELIMINACIÓN *******");
                        String maestroEliminar=" ";
                        Archivos archivo4= new Archivos("Maestro");
                        archivo4.imprimir();
                        System.out.println(" ");
                        System.out.println("*********************************");                           
                        System.out.println(" ");
                        maestro.actualizarMaestro();
                        maestroEliminar=maestro.eliminarMaestro();
                        for (int i = 0; i < getCantidadObjetosMaestros(); i++) {
                            if(maestroEliminar.equals(maestros[i].getNombreMaestro())){
                               maestros[i].setNombreMaestro("none");
                               maestros[i].setAsignacionCurso("none");
                               maestros[i].setAsignacionMateria("none"); 
                              
                            }
                        }
                        setTotalMaestros(maestro.cantidadMaestrosAgregados);
                        setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                       break;
                       
                    case 5://añadir materia
                       System.out.println(" ");
                       System.out.println("******* AÑADIR *******"); 
                       materia.imprimirMateria();
                       System.out.println(" ");
                       System.out.println("*********************************");                           
                       System.out.println(" ");
                       materia.agregarMateria();
                       break;
                       
                    case 6://añadir curso
                       System.out.println(" ");
                       System.out.println("******* AÑADIR *******");
                       curso.imprimirCurso();
                       System.out.println(" ");
                       System.out.println("*********************************");                           
                       System.out.println(" ");
                       curso.agregarCurso();
                       break;

                    case 7:
                        //salida del menu.
                        break;
                    default:
                        //opcion no valida del menu.
                        System.out.println("La opcion no es valida.");
                        break;
                }

                }while(opcionMenu!=7);
                opcionMenu=0;

                break;

            case 2:
                                
                do{//repeticion del menu de opciones
                        System.out.println(" ");
                        System.out.println("************ ASIGNAR ************");     
                        System.out.println(" ");  
                        System.out.println("1.Asignar Alumno");
                        System.out.println("2.Asignar Maestro");
                        System.out.println("3.Volver");
                        System.out.println(" ");
                        System.out.println("*********************************");                           
                        System.out.println(" "); 
                        System.out.print("R:/ ");
                        opcionMenu = lecturaVar.nextByte();//escaneo del dato del menu del usuario
                        switch(opcionMenu){

                            case 1://asignar alumno
                                alumno.actualizarAlumno();
                                setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                                if(getTotalAlumnos()!=0){
                                    Archivos archivo21= new Archivos("Alumno");
                                    System.out.println(" ");
                                    System.out.println("******* ALUMNOS *******");
                                    System.out.println(" ");
                                    archivo21.imprimir();
                                    System.out.println(" ");
                                    System.out.println("************************");

                                    String respuestaDatosPersona=" ";
                                    String asignarPersona=" ";
                                    boolean existePersona=false;

                                    System.out.print("Digita el alumno al que deseas asignar:");
                                    asignarPersona=lecturaVar.nextLine();
                                    asignarPersona=lecturaVar.nextLine();

                                    for (int i = 0; i < getTotalAlumnos(); i++) {

                                        respuestaDatosPersona=alumno.informarAlumno(i);
                                        if(asignarPersona.equals(respuestaDatosPersona)){
                                            existePersona=true;
                                        }
                                    }
                                    

                                    if(existePersona==true){
                                        /*Validacion si existe una materia*/
                                        String asignarMateria=" ";
                                        String respuestaDatosMateria=" ";
                                        boolean existeMateria=false;
                                        setTotalMaterias(materia.getCantidadMateriasCreadas());
                                        if(getTotalMaterias()!=0){
                                            System.out.println(" ");
                                            System.out.println("******* MATERIAS *******");
                                            System.out.println(" ");
                                            materia.imprimirMateria();
                                            System.out.println(" ");
                                            System.out.println("************************");
                                            System.out.print("Digita la materia que desea asignar:");
                                            asignarMateria=lecturaVar.nextLine();
                                            for (int o = 0; o < getTotalMaterias(); o++) {
                                                respuestaDatosMateria=materia.informarMateria(o);
                                                if(asignarMateria.equals(respuestaDatosMateria)){
                                                    existeMateria=true;
                                                }
                                            }
                                            
                                            if(existeMateria==true){
                                                /*Validacion si existe un curso*/
                                                String asignarCurso=" ";
                                                String respuestaDatosCurso=" ";
                                                boolean existeCurso=false;
                                                setTotalCursos(curso.getCantidadCursosCreados());
                                                if(getTotalCursos()!=0){
                                                    System.out.println(" ");
                                                    System.out.println("******* CURSOS *******");
                                                    System.out.println(" ");
                                                    curso.imprimirCurso();
                                                    System.out.println(" ");
                                                    System.out.println("************************");
                                                    System.out.print("Digita el curso que desea asignar:");
                                                    asignarCurso=lecturaVar.nextLine();
                                                    for (int p = 0; p < getTotalCursos(); p++) {
                                                        respuestaDatosCurso=curso.informarCurso(p);
                                                        if(asignarCurso.equals(respuestaDatosCurso)){
                                                            existeCurso=true;
                                                        }
                                                    }

                                                    if(existeCurso==true){
                                                        /*Validacion si existe un objeto identico*/
                                                        boolean objetoExistente=false;
                                                        for (int q = 0; q < getCantidadObjetosAlumnos(); q++) {
                                                            if(asignarPersona.equals(alumnos[q].getNombreAlumno()) && asignarMateria.equals(alumnos[q].getAsignacionMateria()) && asignarCurso.equals(alumnos[q].getAsignacionCurso())){
                                                                objetoExistente=true;
                                                            }
                                                            if(asignarPersona.equals(alumnos[q].getNombreAlumno()) && asignarMateria.equals(alumnos[q].getAsignacionMateria())){
                                                                objetoExistente=true;
                                                            }
                                                        }
                                                        if(objetoExistente==false){
                                                            
                                                            alumnos[getCantidadObjetosAlumnos()]=new Alumno(asignarMateria, asignarCurso, asignarPersona);
                                                            setCantidadObjetosAlumnos(getCantidadObjetosAlumnos()+1);
                                                        }else{
                                                            System.out.println("Al estudiante ya se le ha asignado este curso y/o esta materia.");
                                                        }

                                                    }else{
                                                        System.out.println("El curso ingresado no se encuentra en el sistema.");
                                                    }

                                                }else{
                                                   System.out.println("No hay cursos para asignar."); 
                                                }
                                            }else{
                                                System.out.println("La materia ingresada no se encuentra en el sistema.");
                                            }

                                        }else{
                                           System.out.println("No hay materias para asignar."); 
                                        }

                                    }else{
                                        System.out.println("La persona ingresada no se encuentra en el sistema.");
                                    }

                                }else{
                                   System.out.println("No hay alumnos para asignar."); 
                                }
                                break;

                            case 2://asignar maestro
                                maestro.actualizarMaestro();
                                setTotalMaestros(maestro.cantidadMaestrosAgregados);
                                if(getTotalMaestros()!=0){
                                    Archivos archivo22= new Archivos("Maestro");
                                    System.out.println(" ");
                                    System.out.println("******* MAESTROS *******");
                                    System.out.println(" ");
                                    archivo22.imprimir();
                                    System.out.println(" ");
                                    System.out.println("************************");

                                    String respuestaDatosPersona=" ";
                                    String asignarPersona=" ";
                                    boolean existePersona=false;

                                    System.out.print("Digita el maestro al que deseas asignar:");
                                    asignarPersona=lecturaVar.nextLine();
                                    asignarPersona=lecturaVar.nextLine();

                                    for (int i = 0; i < getTotalMaestros(); i++) {

                                        respuestaDatosPersona=maestro.informarMaestro(i);
                                        if(asignarPersona.equals(respuestaDatosPersona)){
                                            existePersona=true;
                                        }
                                    }
                                    

                                    if(existePersona==true){
                                        /*Validacion si existe una materia*/
                                        String asignarMateria=" ";
                                        String respuestaDatosMateria=" ";
                                        boolean existeMateria=false;
                                        setTotalMaterias(materia.getCantidadMateriasCreadas());
                                        if(getTotalMaterias()!=0){
                                            System.out.println(" ");
                                            System.out.println("******* MATERIAS *******");
                                            System.out.println(" ");
                                            materia.imprimirMateria();
                                            System.out.println(" ");
                                            System.out.println("************************");
                                            System.out.print("Digita la materia que desea asignar:");
                                            asignarMateria=lecturaVar.nextLine();
                                            for (int o = 0; o < getTotalMaterias(); o++) {
                                                respuestaDatosMateria=materia.informarMateria(o);
                                                if(asignarMateria.equals(respuestaDatosMateria)){
                                                    existeMateria=true;
                                                }
                                            }
                                            
                                            if(existeMateria==true){
                                                /*Validacion si existe un curso*/
                                                String asignarCurso=" ";
                                                String respuestaDatosCurso=" ";
                                                boolean existeCurso=false;
                                                setTotalCursos(curso.getCantidadCursosCreados());
                                                if(getTotalCursos()!=0){
                                                    System.out.println(" ");
                                                    System.out.println("******* CURSOS *******");
                                                    System.out.println(" ");
                                                    curso.imprimirCurso();
                                                    System.out.println(" ");
                                                    System.out.println("************************");
                                                    System.out.print("Digita el curso que desea asignar:");
                                                    asignarCurso=lecturaVar.nextLine();
                                                    for (int p = 0; p < getTotalCursos(); p++) {
                                                        respuestaDatosCurso=curso.informarCurso(p);
                                                        if(asignarCurso.equals(respuestaDatosCurso)){
                                                            existeCurso=true;
                                                        }
                                                    }

                                                    if(existeCurso==true){
                                                        /*Validacion si existe un objeto identico*/
                                                        boolean objetoExistente=false;
                                                        for (int q = 0; q < getCantidadObjetosMaestros(); q++) {
                                                            if(asignarPersona.equals(maestros[q].getNombreMaestro()) && asignarMateria.equals(maestros[q].getAsignacionMateria()) && asignarCurso.equals(maestros[q].getAsignacionCurso())){
                                                                objetoExistente=true;
                                                            }
                                                        }
                                                        if(objetoExistente==false){
                                                            maestros[getCantidadObjetosMaestros()]=new Maestro(asignarMateria, asignarCurso, asignarPersona);
                                                            setCantidadObjetosMaestros(getCantidadObjetosMaestros()+1);
                                                        }else{
                                                            System.out.println("Al maestro ya se le ha asignado este curso con esta materia.");
                                                        }

                                                    }else{
                                                        System.out.println("El curso ingresado no se encuentra en el sistema.");
                                                    }

                                                }else{
                                                   System.out.println("No hay cursos para asignar."); 
                                                }
                                            }else{
                                                System.out.println("La materia ingresada no se encuentra en el sistema.");
                                            }

                                        }else{
                                           System.out.println("No hay materias para asignar."); 
                                        }

                                    }else{
                                        System.out.println("La persona ingresada no se encuentra en el sistema.");
                                    }

                                }else{
                                   System.out.println("No hay maestros para asignar."); 
                                }
                               break;

                            case 3:
                                //salida del menu
                               break;

                            default:
                                //opcion no valida del menu.
                                System.out.println("La opcion no es valida.");
                                break;
                        }

                        }while(opcionMenu!=3);
                        opcionMenu=0;
                
               break;

            case 3:/*modificar notas*/
                alumno.actualizarAlumno();
                setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                String nombreModificarAlumno=" ";
                String materiaModificarAlumno=" ";
                String cursoModificarAlumno=" ";
                boolean encontrado31=false;
                if(getCantidadObjetosAlumnos()!=0){
                    System.out.println(" ");
                    System.out.println("******* ALUMNOS *******");
                    System.out.println(" ");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    for (int i = 0; i < getCantidadObjetosAlumnos(); i++) {
                        if(alumnos[i].getNombreAlumno()!="none"){
                            System.out.println("Nombre: "+alumnos[i].getNombreAlumno());
                            System.out.println("Materia: "+alumnos[i].getAsignacionMateria());
                            System.out.println("Curso: "+alumnos[i].getAsignacionCurso());
                            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        }
                    }
                    System.out.println("************************");
                    System.out.print("Digite el nombre del estudiante que desea modificar:");
                    nombreModificarAlumno=lecturaVar.nextLine();
                    nombreModificarAlumno=lecturaVar.nextLine();
                    System.out.print("Digite la materia del estudiante que desea modificar:");
                    materiaModificarAlumno=lecturaVar.nextLine();
                    System.out.print("Digite el curso del estudiante que desea modificar:");
                    cursoModificarAlumno=lecturaVar.nextLine();
                    
                    for (int u = 0; u < getCantidadObjetosAlumnos(); u++) {
                        if((nombreModificarAlumno.equals(alumnos[u].getNombreAlumno())) && (materiaModificarAlumno.equals(alumnos[u].getAsignacionMateria())) && (cursoModificarAlumno.equals(alumnos[u].getAsignacionCurso()))){
                            
                            System.out.println(" ");
                            System.out.println("******* NOTAS DEL ALUMNO *******");
                            System.out.println(" ");
                            System.out.println("Nombre: "+alumnos[u].getNombreAlumno());
                            System.out.println("Materia: "+alumnos[u].getAsignacionMateria());
                            System.out.println("Curso: "+alumnos[u].getAsignacionCurso());
                            System.out.println("Numero de Notas: "+alumnos[u].getNumeroNotas());
                            alumnos[u].imprimirNotas();
                            alumnos[u].calcularPromedio();
                            System.out.println("Nota Final: "+alumnos[u].getPromedioNotas());
                            System.out.println(" ");
                            System.out.println("********************************");
                            System.out.println(" ");
                            
                            do{//repeticion del menu de opciones
                                System.out.println(" ");
                                System.out.println("******* MODIFICACIÓN *******");        
                                System.out.println("1.Modificar Cantidad de Notas");
                                System.out.println("2.Modificar Notas");
                                System.out.println("3.Regresar");
                                System.out.println(" ");
                                System.out.println("*********************************");                           
                                System.out.println(" "); 
                                System.out.print("R:/ ");
                                opcionMenu = lecturaVar.nextByte();//escaneo del dato del menu del usuario
                                switch(opcionMenu){

                                    case 1:
                                        int cantidadModificarNotas=0;
                                        System.out.print("Digite la cantidad de notas que desea establecer: ");
                                        cantidadModificarNotas=lecturaVar.nextInt();
                                        if(cantidadModificarNotas > alumnos[u].getNumeroNotas()){
                                            alumnos[u].asignarNumeroNotas(cantidadModificarNotas);
                                        }else{
                                            System.out.println("La cantidad de notas no puede ser inferior a la preestablecida.");
                                        }

                                        break;

                                    case 2:
                                        int numeroNotaModificar=0;
                                        float nuevaCalificacion=0.0f;
                                        System.out.print("Digite el numero de la nota que desea modificar: ");
                                        numeroNotaModificar=lecturaVar.nextInt();
                                        if(numeroNotaModificar<=alumnos[u].getNumeroNotas()&&numeroNotaModificar>0){
                                            System.out.print("Digite la calificacion nueva: ");
                                            nuevaCalificacion=lecturaVar.nextFloat();
                                            if((nuevaCalificacion<=(float)(5.0)) && (nuevaCalificacion>=0)){
                                                alumnos[u].notas[(numeroNotaModificar-1)]=nuevaCalificacion;
                                            }else{
                                                System.out.println("La nueva calificacion no es valida.");
                                            }
                                        }
                                       break;

                                    case 3:
                                        
                                       break;
                                       
                                    default:
                                        //opcion no valida del menu.
                                        System.out.println("La opcion no es valida.");
                                        break;
                                }

                                }while(opcionMenu!=3);
                                opcionMenu=0;
                            
                            //
                            u=getCantidadObjetosAlumnos();
                            encontrado31=true;
                        }
                    }
                    if(encontrado31==false){
                        System.out.println("El Alumno no se encuentra en el sistema o no ha sido asignado.");
                    }
                }else{
                    System.out.println(" ");
                    System.out.println("No hay alumnos en el sistema.");
                }
        
               break;

            case 4:/*listar alumnos por materia*/
                alumno.actualizarAlumno();
                setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                String materiaListar=" ";
                String respuestaListarMaterias=" ";
                boolean materiaListaExiste=false;
                setTotalMaterias(materia.getCantidadMateriasCreadas());
                if(getTotalMaterias()!=0){
                    System.out.println(" ");
                    System.out.println("******* MATERIAS *******");
                    System.out.println(" ");
                    materia.imprimirMateria();
                    System.out.println(" ");
                    System.out.println("************************");
                    System.out.print("Digita la materia que desea listar:");
                    materiaListar=lecturaVar.nextLine();
                    materiaListar=lecturaVar.nextLine();
                    for (int p = 0; p < getTotalMaterias(); p++) {
                        respuestaListarMaterias=materia.informarMateria(p);
                        if(materiaListar.equals(respuestaListarMaterias)){
                            materiaListaExiste=true;
                        }
                    }
                    
                    if(materiaListaExiste==true){
                        System.out.println(" ");
                        System.out.println("******* ESTUDIANTES *******");
                        System.out.println(" ");
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        for (int i = 0; i < getCantidadObjetosAlumnos(); i++) {
                            if(!alumnos[i].equals(null)){
                                if(materiaListar.equals(alumnos[i].getAsignacionMateria())){
                                    System.out.println("Nombre: "+alumnos[i].getNombreAlumno());
                                    System.out.println("Curso: "+alumnos[i].getAsignacionCurso());
                                    alumnos[i].imprimirNotas();
                                    alumnos[i].calcularPromedio();
                                    System.out.println("Nota Final: "+alumnos[i].getPromedioNotas());
                                }
                                
                            }
                            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            System.out.println(" ");
                        }
                        System.out.println(" ");
                        System.out.println("************************");
                    }else{
                        System.out.println("La materia ingresada no se encuentra en el sistema.");
                    }
                }else{
                    System.out.println("No hay materias en el sistema.");
                }
               break;

            case 5:/*mostrar mejores 5 promedios*/
                alumno.actualizarAlumno();
                maestro.actualizarMaestro();
                setTotalAlumnos(alumno.cantidadAlumnosAgregados);
                setTotalMaestros(maestro.cantidadMaestrosAgregados);
                nota1=alumnos[0].getPromedioNotas();
                nombre1=alumnos[0].getNombreAlumno();
                nota2=alumnos[1].getPromedioNotas();
                nombre2=alumnos[1].getNombreAlumno();
                nota3=alumnos[2].getPromedioNotas();
                nombre3=alumnos[2].getNombreAlumno();
                nota4=alumnos[3].getPromedioNotas();
                nombre4=alumnos[3].getNombreAlumno();
                nota5=alumnos[4].getPromedioNotas();
                nombre5=alumnos[4].getNombreAlumno();
                
                for(int i=5;i<getCantidadObjetosAlumnos();i++){
                    if(alumnos[i].getPromedioNotas()>nota1){
                        nota1=alumnos[i].getPromedioNotas();
                        nombre1=alumnos[i].getNombreAlumno();
                    }else{
                        if(alumnos[i].getPromedioNotas()>nota2){
                            nota2=alumnos[i].getPromedioNotas();
                            nombre2=alumnos[i].getNombreAlumno();
                        }else{
                            if(alumnos[i].getPromedioNotas()>nota3){
                                nota3=alumnos[i].getPromedioNotas();
                                nombre3=alumnos[i].getNombreAlumno();
                            }else{
                               if(alumnos[i].getPromedioNotas()>nota4){
                                    nota4=alumnos[i].getPromedioNotas();
                                    nombre4=alumnos[i].getNombreAlumno();
                                }else{
                                   if(alumnos[i].getPromedioNotas()>nota5){
                                        nota5=alumnos[i].getPromedioNotas();
                                        nombre5=alumnos[i].getNombreAlumno();
                                    }
                                }
                            }

                        }
                    }
                }
                System.out.println(" ");
                System.out.println("******* PROMEDIOS *******");
                System.out.println(" ");
                System.out.println("Nota 1: "+nota1);
                if(!nombre1.equals("none")){
                    System.out.println("Nombre: "+nombre1);
                }else{
                    System.out.println("Nombre: ");
                }
                System.out.println(" ");
                System.out.println("Nota 2: "+nota2);
                if(!nombre2.equals("none")){
                    System.out.println("Nombre: "+nombre2);
                }else{
                    System.out.println("Nombre: ");
                }
                System.out.println(" ");
                System.out.println("Nota 3: "+nota3);
                if(!nombre3.equals("none")){
                    System.out.println("Nombre: "+nombre3);
                }else{
                    System.out.println("Nombre: ");
                }
                System.out.println(" ");
                System.out.println("Nota 4: "+nota4);
                if(!nombre4.equals("none")){
                    System.out.println("Nombre: "+nombre4);
                }else{
                    System.out.println("Nombre: ");
                }
                System.out.println(" ");
                System.out.println("Nota 5: "+nota5);
                if(!nombre5.equals("none")){
                    System.out.println("Nombre: "+nombre5);
                }else{
                    System.out.println("Nombre: ");
                }
                System.out.println(" ");
                System.out.println("*************************");
                System.out.println(" ");
                break;
            case 6:/*Listado de docentes y sus materias*/
                maestro.actualizarMaestro();
                setTotalMaestros(maestro.cantidadMaestrosAgregados);
                    
                    System.out.println(" ");
                    System.out.println("******* LISTADO MAESTROS *******");
                    System.out.println(" ");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    for (int i = 0; i < getTotalMaestros(); i++) {
                       
                        System.out.println("Nombre: " + maestro.informarMaestro(i));
                        for (int j = 0; j < getCantidadObjetosMaestros(); j++) {
                            if(maestro.informarMaestro(i).equals(maestros[j].getNombreMaestro())){
                                System.out.println("Materia: "+maestros[j].getAsignacionMateria()+" - Curso: "+maestros[j].getAsignacionCurso());
                            }
                        }
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    }
                    
                    System.out.println(" ");
                    System.out.println("************************");
                break;
            default:
                //opcion no valida del menu.
                System.out.println("La opcion no es valida.");
                break;
        }

        }while(opcionMenu!=7);
    }

    /**
     * obtiene
     * @return totalMaestros
     */
    public int getTotalMaestros() {
        return totalMaestros;
    }

    /**
     * asignar
     * @param totalMaestros 
     */
    public void setTotalMaestros(int totalMaestros) {
        this.totalMaestros = totalMaestros;
    }

    /**
     * obtiene
     * @return totalAlumnos
     */
    public int getTotalAlumnos() {
        return totalAlumnos;
    }

    /**
     * asignar
     * @param totalAlumnos 
     */
    public void setTotalAlumnos(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    /**
     * obtiene
     * @return cantidadObjetosMaestros
     */
    public int getCantidadObjetosMaestros() {
        return cantidadObjetosMaestros;
    }

    /**
     * asignar
     * @param cantidadObjetosMaestros 
     */
    public void setCantidadObjetosMaestros(int cantidadObjetosMaestros) {
        this.cantidadObjetosMaestros = cantidadObjetosMaestros;
    }

    /**
     * obtiene
     * @return cantidadObjetosAlumnos
     */
    public int getCantidadObjetosAlumnos() {
        return cantidadObjetosAlumnos;
    }

    /**
     * asignar
     * @param cantidadObjetosAlumnos 
     */
    public void setCantidadObjetosAlumnos(int cantidadObjetosAlumnos) {
        this.cantidadObjetosAlumnos = cantidadObjetosAlumnos;
    }

    /**
     * obtiene
     * @return totalMaterias
     */
    public int getTotalMaterias() {
        return totalMaterias;
    }

    /**
     * asignar
     * @param totalMaterias 
     */
    public void setTotalMaterias(int totalMaterias) {
        this.totalMaterias = totalMaterias;
    }

    /**
     * obtiene
     * @return totalCursos
     */
    public int getTotalCursos() {
        return totalCursos;
    }

    /**
     * asignar
     * @param totalCursos
     * 
     */
    public void setTotalCursos(int totalCursos) {
        this.totalCursos = totalCursos;
    }
    
    @Override 
    public String toString(){ 
        return "Total Maestros: "+this.totalMaestros+" Total Alumnos: "+this.totalAlumnos+" Total Materias: "+this.totalMaterias + " Total Cursos: "+this.totalCursos + " Cantidad Objetos Maestros: "+this.cantidadObjetosMaestros+ " Cantidad Objtos Alumnos: "+this.cantidadObjetosAlumnos;
    }; 
}
