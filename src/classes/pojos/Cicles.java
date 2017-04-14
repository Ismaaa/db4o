/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.pojos;

/**
 *
 * @author santi
 */
public class Cicles {
    private String codi;
    private String nom;
    private int duracio;
    
    public Cicles (String codi, String nom, int duracio)
    {
        this.codi=codi;
        this.nom=nom;
        this.duracio=duracio;
    }
    
    public Cicles (String codi, String nom)
    {
        this.codi=codi;
        this.nom=nom;
        this.duracio=2000;
    }
    
    //getters i Setters
    public String getCodi() 
    {
        return this.codi;
    }
    public String getNom() 
    {
        return this.nom;
    }
    public int getDuracio() 
    {
        return this.duracio;
    }
    
    public void setCodi( String codi) 
    {
        this.codi=codi;
    }
    public void setNom( String nom) 
    {
        this.nom=nom;
    }
    public void setDuracio( int duracio) 
    {
        this.duracio=duracio;
    }
    
    @Override
    public String toString() {
        return "Cicle:" + this.codi + "-" + this.nom + " amb una duració de " + this.duracio;
    }
}
