package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    public Filmarkiv(int lengde){
        this.filmer = new Film[lengde];
        this.antall = 0;
    }

}
    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++){
            if(filmer[i].getFilmNr() == nr){
                return filmer[i];
            } 
            
            }
            return null; //returnerer null ETTER den har gått gjennom hele driten
        } 
        


    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length){
            utvidArkiv();
        }
        filmer[antall] = nyFilm;
        antall++;
        
    }
    private void utvidArkiv() {
        Film[] nyFilmer = new Film[filmer.length * 2]; 
        for (int i = 0; i < filmer.length; i++) {
            nyFilmer[i] = filmer[i]; 
        }
        filmer = nyFilmer; 
    }


    @Override
public boolean slettFilm(int filmnr) {
    for (int i = 0; i < antall; i++) {
        if (filmer[i] != null && filmer[i].getFilmNr() == filmnr) {
            // Midlertidig lagrer den siste filmen i arkivet
            Film temp = filmer[antall - 1];

            // Flytter siste filmen til posisjonen som skal slettes
            filmer[i] = temp;

            // Nullstiller den siste posisjonen
            filmer[antall - 1] = null;

            // Reduserer antall gyldige filmer i arkivet
            antall--;

            return true; // Returnerer true når filmen er slettet
        }
    }
    return false; // Returnerer false hvis filmen ikke finnes i arkivet
}

    @Override
    public Film[] soekTittel(String delstreng) {

    }


    @Override
    public Film[] soekProdusent(String delstreng) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'soekProdusent'");
    }


    @Override
    public int antall(Sjanger sjanger) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'antall'");
    }


    @Override
    public int antall() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'antall'");
    }


}
    


