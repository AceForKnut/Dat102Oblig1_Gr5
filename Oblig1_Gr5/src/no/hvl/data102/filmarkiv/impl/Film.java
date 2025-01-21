package no.hvl.data102.filmarkiv.impl;

public class Film {

    private int filmNr;
    private String produsent;
    private String tittel;
    private int aar;
    //enum Sjanger;
    private String filmSelskap;
}
    public Film(int filmNr, String produsent, String tittel, int aar, enum Sjanger, String filmSelskap){
        this.filmNr = filmNr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        //placeholder for enum
        this.filmSelskap = filmSelskap;
    }



