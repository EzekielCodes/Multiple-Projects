/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.data;

/**
 *
 * @author evertjan.jacobs
 */
public class Klant {
    private int id;
    private String naam;
    private String voornaam;
    private String adres;
    private String gemeente;

    public Klant(int id, String naam, String voornaam, String adres, String gemeente) {
        this.id = id;
        this.naam = naam;
        this.voornaam = voornaam;
        this.adres = adres;
        this.gemeente = gemeente;
    }

    @Override
    public String toString() {
        return "Klant{" + "id=" + id + ", naam=" + naam + ", voornaam=" + voornaam + ", adres=" + adres + ", gemeente=" + gemeente + '}';
    }
    
    
         
}
