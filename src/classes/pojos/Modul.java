/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.pojos;

/**
 *
 * @author grup3
 */
public class Modul {
    private String codiModul;
    private int duracio;
    private String cicle;
    
    public Modul (String codi, int duracio, String cicle){
        this.codiModul=codi;
        this.duracio= duracio;
        this.cicle= cicle;
    }
    
    //getters i setters
     public String getCodiModul() 
    {
        return this.codiModul;
    }
    public String getCicle() 
    {
        return this.cicle;
    }
    public int getDuracio() 
    {
        return this.duracio;
    }
    
    public void setCodimodul( String codi) 
    {
        this.codiModul=codi;
    }
    public void setCicle( String cicle) 
    {
        this.cicle=cicle;
    }
    public void setDuracio( int duracio) 
    {
        this.duracio=duracio;
    }
    
    @Override
    public String toString() {
        return "mòdul:" + this.codiModul + "-" + this.cicle + " amb una duració de " + this.duracio;
    }
    
}
