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
 * @author Isma
 */
public class main {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        //es necesario realizar los 2 imports anteriores, ya que si no es ponible que automaticamente no los haga produciendose un error.
        ObjectContainer baseDeDades=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"congreso.db4o");
        //creamos un alumne
        
        Cicles cicle1=new Cicles("R321","Cicle 1",430);
        Modul modul1=new Modul("M03",417,"Programació");
        Alumne alumne1=new Alumne("123654278F","Isma","Superior",23);
        try {
            //System.out.println("*********** GUARDAR CICLES (\"***********");
            //Metodes.guardarCicle(baseDeDades, cicle1);
            //System.out.println("*********** GUARDAR MÒDULS ***********");
            //Metodes.guardarModul(baseDeDades, modul1);
            //System.out.println("*********** GUARDAR ALUMNES ***********");
            //Metodes.guardarAlumne(baseDeDades, alumne1);
            
            System.out.println("*********** ESBORRAR CICLES ***********");
            Metodes.eliminarCicle(baseDeDades, "R321");
            
            System.out.println("*********** CONSULTAR CICLES ***********");
            Metodes.consultarCicles(baseDeDades, null);
            //System.out.println("*********** CONSULTAR MÒDULS ***********");
            //Metodes.consultarModuls(baseDeDades, null);
            //System.out.println("*********** CONSULTAR ALUMNES ***********");
            //Metodes.consultarAlumnes(baseDeDades, null);
            
        } catch (Exception e) {
            System.out.print(e);
        }
        finally{
            Metodes.cerrarConexion(baseDeDades);
        }
    }
    
    
}
