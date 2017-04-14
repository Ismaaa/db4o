/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.pojos;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author grup3
 */
public class main {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        //es necessari realitzar els 2 imports anteriors, ja que es possible que si es fa automàticament es produeixqui un error.
        ObjectContainer baseDeDades=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"grup3.db4o");
        
        //creem un cicle
        Cicles cicle1=new Cicles("R9999","Cicle 1",430);
        //creem un modul
        Modul modul1=new Modul("M07",417,"Programació");
        //creem un alumne
        Alumne alumne1=new Alumne("321","Isma","Superior",23);
        try {
            /**
             * Desar els objectes
             */
            System.out.println("*********** GUARDAR CICLES (\"***********");
            Metodes.guardarCicle(baseDeDades, cicle1);
            System.out.println("*********** GUARDAR MÒDULS ***********");
            Metodes.guardarModul(baseDeDades, modul1);
            System.out.println("*********** GUARDAR ALUMNES ***********");
            Metodes.guardarAlumne(baseDeDades, alumne1);
            
            /**
             * Eliminar els objectes
             */
            System.out.println("*********** ESBORRAR CICLES ***********");
            //Metodes.eliminarCicle(baseDeDades, "R321");
            System.out.println("*********** ESBORRAR MÒDULS ***********");
            Metodes.eliminarModul(baseDeDades, "M03");            
            System.out.println("*********** ESBORRAR ALUMNES ***********");
            Metodes.eliminarAlumne(baseDeDades, "123654278F");
            
            /**
             * Consultar una llista de tots els objectes
             */
            //System.out.println("*********** CONSULTAR TOTS ELS CICLES ***********");
            //Metodes.consultarTotsCicles(baseDeDades);
            //System.out.println("*********** CONSULTAR TOTS ELS MÒDULS ***********");
            //Metodes.consultarTotsModuls(baseDeDades);
            //System.out.println("*********** CONSULTAR TOTS ELS ALUMNES ***********");
            //Metodes.consultarTotsAlumnes(baseDeDades);
            
            /**
             * Consultar un sol objecte
             */
            System.out.println("*********** CONSULTAR UN CICLE ***********");
            Metodes.consultarCicle(baseDeDades, "R321");
            System.out.println("*********** CONSULTAR UN MÒDUL ***********");
            Metodes.consultarModul(baseDeDades, "M03");
            System.out.println("*********** CONSULTAR UN ALUMNE ***********");
            Metodes.consultarAlumne(baseDeDades, "321");
            
        } catch (Exception e) {
            System.out.print(e);
        }
        finally{
            Metodes.tancarConnexio(baseDeDades);
        }
    }
    
    
}
