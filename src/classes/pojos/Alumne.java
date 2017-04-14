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
public class Alumne {
    private String DNI;
    private String nom;
    private int edat;
    private String cicle;
    
    public Alumne (String DNI, String nom, String cicle)
    {
        this.DNI=DNI;
        this.nom=nom;
        this.cicle=cicle;
    }
    
    public Alumne (String DNI, String nom, String cicle, int edat)
    {
        this.DNI=DNI;
        this.nom=nom;
        this.cicle=cicle;
        this.edat=edat;
    }
    
    //getters i setters
     public String getDNI() 
    {
        return this.DNI;
    }
    public String getNom() 
    {
        return this.nom;
    }
    public int getEdat() 
    {
        return this.edat;
    }
    public String getCicle(){
        return this.cicle;
    }
    
    public void setDNI( String DNI) 
    {
        this.DNI=DNI;
    }
    public void setNom( String nom) 
    {
        this.nom=nom;
    }
    public void setEdat( int edat) 
    {
        this.edat=edat;
    }
    
    public void setCicle(String cicle){
        this.cicle=cicle;
    }
    
    @Override
    public String toString() {
        return "Alumne:" + this.DNI + "-" + this.nom + " matriculat al cicle " + this.cicle;
    }
}
