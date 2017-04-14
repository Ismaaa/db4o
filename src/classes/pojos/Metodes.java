/*
* M3_Cas5_Grup 3
*/
package classes.pojos;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.util.List;

/**
 *
 * @author Grup3
 */
public class Metodes {
     /**
     * Permet tancar la connexió a la base de dades que estem utilitzant
     * @param baseDeDades el ObjectContainer de la base de dades
     */
    public static void tancarConnexio(ObjectContainer baseDades){
        try{
            baseDades.close();
        }catch(Exception e){
            System.out.println("Error al tancar la connexió");
        }
    }
    
    /**
     * Desem un cicle
     * @param baseDeDades
     * @param cicle 
     */
    public static void guardarCicle(ObjectContainer baseDeDades, Cicles cicle){
        try{
            baseDeDades.store(cicle);
            System.out.println("S'ha desat correctament el cicle");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }    
    
    /**
     * Desem un mòdul
     * @param baseDeDades
     * @param modul 
     */
    public static void guardarModul(ObjectContainer baseDeDades, Modul modul){
        try{
            baseDeDades.store(modul);
            System.out.println("S'ha desat correctament el mòdul");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }        
    
    
    /**
     * Desem un alumne
     * @param baseDeDades
     * @param alumne 
     */
    public static void guardarAlumne(ObjectContainer baseDeDades, Alumne alumne){
        try{
            baseDeDades.store(alumne);
            System.out.println("S'ha desat correctament el alumne");
        } catch(Exception e){
            System.out.println("S'ha produït un error a la inserció");
        }
    }
       
    /**
     * Eliminem un cicle
     * @param baseDeDades
     * @param codi 
     */
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
     * Imprimeix per pantalla el resultat d'una consulta sense importar 
     * el mètode de consulta
     * @param resultat
     */
    public static void imprimirResultatConsulta(ObjectSet resultat) {
        System.out.println("Trobats " + resultat.size() + " Objectes");
        while (resultat.hasNext()) {
            System.out.println(resultat.next());
        }

    }
    

    
    /**
     * Consultem un cicle
     * @param baseDeDades
     * @param codi 
     */
    public static void consultarCicle(ObjectContainer baseDeDades, String codi) {
        Cicles cicle = new Cicles(codi, null, 0);
        ObjectSet resultat = baseDeDades.queryByExample(cicle);
        imprimirResultatConsulta(resultat);
    }
    
    /**
     * Consultem un els mòdul
     * @param baseDeDades
     * @param codi 
     */
    public static void consultarModul(ObjectContainer baseDeDades, String codi) {
        Modul modul = new Modul(codi, 0, null);
        ObjectSet resultat = baseDeDades.queryByExample(modul);
        imprimirResultatConsulta(resultat);
    }    
    
    /**
     * Consultem un alumne
     * @param baseDeDades
     * @param nom 
     */
    public static void consultarAlumne(ObjectContainer baseDeDades, String nom) {
        Alumne alumne = new Alumne(null, nom, null, 0);
        ObjectSet resultat = baseDeDades.queryByExample(alumne);
        imprimirResultatConsulta(resultat);
    }
    
    
    /**
     * Consultar comparant 
     * @param baseDeDades
     * @param edat 
     */
    // ÉS UN EXEMPLE, HI HA QUE MODIFICAR
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
        imprimirResultatConsulta((ObjectSet) res);
    }
    
    /**
     * Permite realizar una consulta SODA cuyo resultat sean todos los ponentes
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     */
    // ÉS UN EXEMPLE, HI HA QUE MODIFICAR
    public static void consultaSODAponentes(ObjectContainer baseDeDades) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);//declara las restricciones
        ObjectSet resultat = query.execute();
        imprimirResultatConsulta(resultat);
    }

    /**
     * Permite realizar una consulta SODA cuyo resultat sea el alumne cuyo
     * nombre se ha introducido por parametro
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     * @param nombre el nombre del alumne que se quiere recuperar
     */
    // ÉS UN EXEMPLE, HI HA QUE MODIFICAR
   public static void consultaSODAPonentesNombre(ObjectContainer baseDeDades, String nombre) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        //creamos el constraint diciendo que el campo donde lo tiene que aplicar es nombre y la restricion es el parametro nombre
        Constraint constraint = query.descend("nombre").constrain(nombre);
        ObjectSet resultat = query.execute();
        imprimirResultatConsulta(resultat);
    } 
   
     /**
     * Permite realizar una consulta SODA que recupera los ponentes cuyo cache
     * esta entre los indicados por parametro
     *
     * @param baseDeDadesla base de datos desde la que se va a operar
     * @param cacheInferior el cache que marca limite inferior
     * @param CacheSuperior el cache que marcha el limite superior
     */
    // ÉS UN EXEMPLE, HI HA QUE MODIFICAR
    public static void consultaSODAPonentesCacheEntre(ObjectContainer baseDeDades, float cacheInferior, float CacheSuperior) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        //creamos el primer constraint diciendole que el cache ha de ser menor del superior
        Constraint constraint = query.descend("cache").constrain(CacheSuperior).smaller();
        //se enlazan las dos restricciones a aplicar
        query.descend("cache").constrain(cacheInferior).greater().and(constraint);
        ObjectSet resultat = query.execute();
        imprimirResultatConsulta(resultat);
    }

    /**
     * Consulta SODA que permite recuperar ordenados por cache todos los
     * ponentes
     *
     * @param baseDeDades la base de datos desde la que se va a operar
     */
    // ÉS UN EXEMPLE, HI HA QUE MODIFICAR
    public static void consultaSODAPonentesOrdenadosCache(ObjectContainer baseDeDades) {
        Query query = baseDeDades.query();
        query.constrain(Alumne.class);
        query.descend("cache").orderDescending();
        ObjectSet resultat = query.execute();
        imprimirResultatConsulta(resultat);
    } 
}
