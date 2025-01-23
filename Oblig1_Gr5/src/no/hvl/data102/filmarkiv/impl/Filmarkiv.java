package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    public Filmarkiv(int lengde){
        this.filmer = new Film[lengde];
        this.antall = 0;
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
        Film[] nyFilmer = new Film[filmer.length * 2]; //2x lengden av arkivet
        for (int i = 0; i < filmer.length; i++) {
            nyFilmer[i] = filmer[i]; 
        }
        filmer = nyFilmer; 
    }


    //Denne løsningen tar ikke hensyn til at den siste posisjonen KAN være null (en film er ikke der fra før av)
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

        Film[] matchFilm = new Film[antall]; //Lager et nytt arkiv med filmer som matcher delstrengen
        int index = 0;

        for (int i = 0; i < antall; i++){
            if(filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                matchFilm[index++] = filmer[i];
            }
        }
        return trimArkiv(matchFilm, index);

    }
    //Hjelpe metode for å trimme arkivet ned til bare lengden av matchet søk
    public Film[] trimArkiv(Film[] arr, int lengde){
        return Arrays.copyOf(arr, lengde);
    }


    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] matchProdusent = new Film[antall]; //Lager et nytt arkiv med filmer som matcher delstrengen
        int index = 0;

        for (int i = 0; i < antall; i++){
            if(filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())){
                matchProdusent[index++] = filmer[i];
            }
        }
        return trimArkiv(matchProdusent, index);

    }


    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;

        for(int i = 0; i < antall; i++){
            if(filmer[i].getSjanger() == sjanger){
                antallSjanger++;
            }
        } return antallSjanger;
    }


    //Denne metoden tar hensyn til tilfeller der for eksempel posisjon 2 er null
    @Override
    public int antall() {
       int antallFilmer = 0;

       for(int i = 0; i < filmer.length; i++){
        if(filmer[i] != null){
            antallFilmer++;
        }
       } return antallFilmer;
    }


}
    


