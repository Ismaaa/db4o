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
        Cicles cicle1=new Cicles("R321","Cicle 1",430);
        //creem un modul
        Modul modul1=new Modul("M03",417,"Programació");
        //creem un alumne
        Alumne alumne1=new Alumne("123654278F","Isma","Superior",23);
        try {
            System.out.println("*********** GUARDAR CICLES (\"***********");
            Metodes.guardarCicle(baseDeDades, cicle1);
            System.out.println("*********** GUARDAR MÒDULS ***********");
            Metodes.guardarModul(baseDeDades, modul1);
            System.out.println("*********** GUARDAR ALUMNES ***********");
            Metodes.guardarAlumne(baseDeDades, alumne1);
            
            System.out.println("*********** ESBORRAR CICLES ***********");
            Metodes.eliminarCicle(baseDeDades, "R321");
            
            System.out.println("*********** CONSULTAR CICLES ***********");
            Metodes.consultarCicle(baseDeDades, null);
            System.out.println("*********** CONSULTAR MÒDULS ***********");
            Metodes.consultarModul(baseDeDades, null);
            System.out.println("*********** CONSULTAR ALUMNES ***********");
            Metodes.consultarAlumne(baseDeDades, null);
            
        } catch (Exception e) {
            System.out.print(e);
        }
        finally{
            Metodes.tancarConnexio(baseDeDades);
        }
    }
    
    
}
