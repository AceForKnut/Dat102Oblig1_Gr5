package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;
        while (aktuell != null) {
            if(aktuell.data.getFilmNr() == nr) {
                return aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return null;

    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> forrige = null;
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.data.getFilmNr() == filmnr) {
                if (forrige == null) {
                    start = aktuell.neste;
                } else {
                    forrige.neste = aktuell.neste;
                }
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}
