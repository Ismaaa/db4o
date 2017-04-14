/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.pojos;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.util.List;

/**
 *
 * @author Isma
 */
public class Metodes {
     /**
     * Permite cerrar la conexion a la base de datos que se esta utilizando
     * @param baseDeDades el ObjectContainer de la base de datos
     */
    public static void cerrarConexion(ObjectContainer baseDades){
        try{
            baseDades.close();
        }catch(Exception e){
            System.out.println("error al cerrar la conexion");
        }
    }
    
    public static void guardarCicle(ObjectContainer baseDeDades, Cicles cicle){
        try{
            baseDeDades.store(cicle);
            System.out.println("S'ha desat correctament el cicle");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }    
    
    public static void guardarModul(ObjectContainer baseDeDades, Modul modul){
        try{
            baseDeDades.store(modul);
            System.out.println("S'ha desat correctament el mòdul");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }        
    
    
    /**
     * Permite almacenar un Alumne en la base de datos
     * @param baseDeDades el objeto que representa la base de datos en la que se almacenara el alumne
     * @param alumne el alumne que se desea almacear en la base de datos
     */
    public static void guardarAlumne(ObjectContainer baseDeDades, Alumne alumne){
        try{
            baseDeDades.store(alumne);
            System.out.println("S'ha desat correctament el alumne");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }
       
    
    public static void eliminarCicle(ObjectContainer baseDeDades,String codi){
        try{
            ObjectSet result = baseDeDades.queryByExample(new Cicles(codi,null, 0));
            Cicles found = (Cicles) result.next();
            baseDeDades.delete(found);
            System.out.println("S'ha esborrat correctament el cicle");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la eliminació");
        }
    }    
    
    
     /**
     * Imprime por pantalla el resultado de una consulta sin importar el metodo
     * de consulta
     *
     * @param resultado el objeto en el que se ha almacenado el resultado de la
     * consulta
     */
    public static void imprimirResultadoConsulta(ObjectSet resultado) {
        System.out.println("Trobats " + resultado.size() + " Objectes");
        while (resultado.hasNext()) {
            System.out.println(resultado.next());
        }

    }
    
    public static void consultarQBEPonentesDni(ObjectContainer baseDeDades, String dni) {
        Alumne alumne = new Alumne(dni, null, null, 0);
        ObjectSet resultado = baseDeDades.queryByExample(alumne);
        imprimirResultadoConsulta(resultado);
    }    
    
        /**
     * Permite hacer una consulta mediante Query-by-Example a partir de un dni e
     * imprimirla por pantalla
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param dni el dni del alumne que se quiere buscar
     */
    public static void consultarCicles(ObjectContainer baseDeDades, String codi) {
        Cicles cicle = new Cicles(codi, null, 0);
        ObjectSet resultado = baseDeDades.queryByExample(cicle);
        imprimirResultadoConsulta(resultado);
    }
    
    public static void consultarModuls(ObjectContainer baseDeDades, String codi) {
        Modul modul = new Modul(codi, 0, null);
        ObjectSet resultado = baseDeDades.queryByExample(modul);
        imprimirResultadoConsulta(resultado);
    }    
    
      /**
     * Permite hacer una consulta mediante Query-by-Example a partir de un
     * nombre e imprimirla por pantalla
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param nombre el nombre del alumne que se desea encontrar
     */
    public static void consultarAlumnes(ObjectContainer baseDeDades, String nom) {
        Alumne alumne = new Alumne(null, nom, null, 0);
        ObjectSet resultado = baseDeDades.queryByExample(alumne);
        imprimirResultadoConsulta(resultado);

    }
    
     /**
     * Permite hacer una consulta mediante Query-by-Example a partir de un cache
     * imprimirla por pantalla
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param cache el cache del alumne que se desea encontrar
     */
    public static void consultarQBEPonentesCache(ObjectContainer baseDeDades, String cicle) {
        Alumne alumne = new Alumne(null, null, cicle, 0);
        ObjectSet resultado = baseDeDades.queryByExample(alumne);
        imprimirResultadoConsulta(resultado);

    }
    
    /**
     * Permite realizar una consulta Nativa a partir del dni e imprimirla en
     * pantalla
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param dni el dni del alumne que se desea encontrar
     */
    public static void consultarNatPonentesDni(ObjectContainer baseDeDades, final String dni) {
        List res = baseDeDades.query(new com.db4o.query.Predicate() {
            public boolean match(Alumne alumne) {
                return alumne.getDNI().equalsIgnoreCase(dni);
            }

            @Override
            public boolean match(Object et) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        imprimirResultadoConsulta((ObjectSet) res);
    }
    /**
     * Permite realizar una consulta Nativa y obtener a todos los ponentes que
     * tengan un determinado cache
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param cache el cacha que ha de tener el alumne
     */
    public static void consulrtarNatPonentesCacheIgualA(ObjectContainer baseDeDades, final int edat) {

        List res = baseDeDades.query(new com.db4o.query.Predicate() {
            public boolean match(Alumne alumne) {
                return alumne.getEdat() == edat;
            }

            @Override
            public boolean match(Object et) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        imprimirResultadoConsulta((ObjectSet) res);
    }

    /**
     * Permite realizar una consulta Nativa y obtener todos los ponentes que
     * tengan un cache superior al indicado
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param cacheBase el cache base de los ponentes
     */
    public static void consultarNatPonentesCacheSuperiorA(ObjectContainer baseDeDades, final int edat) {

        List res = baseDeDades.query(new com.db4o.query.Predicate() {
            public boolean match(Alumne alumne) {
                return alumne.getEdat() >= edat;
            }

            @Override
            public boolean match(Object et) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        imprimirResultadoConsulta((ObjectSet) res);
    }
    
    /**
     * Permite realizar una consulta SODA cuyo resultado sean todos los ponentes
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     */
    public static void consultaSODAponentes(ObjectContainer baseDeDades) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);//declara las restricciones
        ObjectSet resultado = query.execute();
        imprimirResultadoConsulta(resultado);
    }

    /**
     * Permite realizar una consulta SODA cuyo resultado sea el alumne cuyo
     * nombre se ha introducido por parametro
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param nombre el nombre del alumne que se quiere recuperar
     */
   public static void consultaSODAPonentesNombre(ObjectContainer baseDeDades, String nombre) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        //creamos el constraint diciendo que el campo donde lo tiene que aplicar es nombre y la restricion es el parametro nombre
        Constraint constraint = query.descend("nombre").constrain(nombre);
        ObjectSet resultado = query.execute();
        imprimirResultadoConsulta(resultado);


    } 
   
     /**
     * Permite realizar una consulta SODA que recupera los ponentes cuyo cache
     * esta entre los indicados por parametro
     *
     * @param baseDeDadesla base de datos desde la que se va a operar
     * @param cacheInferior el cache que marca limite inferior
     * @param CacheSuperior el cache que marcha el limite superior
     */
    public static void consultaSODAPonentesCacheEntre(ObjectContainer baseDeDades, float cacheInferior, float CacheSuperior) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        //creamos el primer constraint diciendole que el cache ha de ser menor del superior
        Constraint constraint = query.descend("cache").constrain(CacheSuperior).smaller();
        //se enlazan las dos restricciones a aplicar
        query.descend("cache").constrain(cacheInferior).greater().and(constraint);
        ObjectSet resultado = query.execute();
        imprimirResultadoConsulta(resultado);
    }

    /**
     * Consulta SODA que permite recuperar ordenados por cache todos los
     * ponentes
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     */
    public static void consultaSODAPonentesOrdenadosCache(ObjectContainer baseDeDades) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        query.descend("cache").orderDescending();
        ObjectSet resultado = query.execute();
        imprimirResultadoConsulta(resultado);
    }
    
    
}
