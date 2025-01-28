package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

    private int filmNr;
    private String produsent;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String filmSelskap;


    public Film(){
        this.filmNr = 0;
        this.produsent = "";
        this.tittel = "";
        this.aar = 0;
        this.sjanger = sjanger.UDEFINERT;
        this.filmSelskap = "";
    }


    public Film(int filmNr, String produsent, String tittel, int aar, Sjanger sjanger, String filmSelskap){
        this.filmNr = filmNr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = sjanger;
        this.filmSelskap = filmSelskap;
    }

    
    
    public int getFilmNr() {
        return filmNr;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmSelskap() {
        return filmSelskap;
    }

    public void setFilmSelskap(String filmSelskap) {
        this.filmSelskap = filmSelskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 

        Film film = (Film) obj; 
        return filmNr == film.filmNr; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmNr);
    }

    @Override
public String toString() {
    return "Film ID: " + filmNr +
           ", Tittel: " + tittel +
           ", År: " + aar +
           ", Sjanger: " + sjanger +
           ", Produsent: " + produsent;
}

}
    