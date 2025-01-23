package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        filmarkiv.leggTilFilm(new Film(1, "John Doe", "The Adventure Begins", 2023, Sjanger.ACTION, "Adventure Productions"));
        filmarkiv.leggTilFilm(new Film(2, "Jane Smith", "Mystery of the Night", 2021, Sjanger.THRILLER, "Mystery Studios"));
        filmarkiv.leggTilFilm(new Film(3, "Albert Johnson", "Love in the Park", 2022, Sjanger.ROMANCE, "Love Productions"));
        filmarkiv.leggTilFilm(new Film(4, "Emily Watson", "The Last Frontier", 2024, Sjanger.SCI_FI, "SciFi Creations"));
        filmarkiv.leggTilFilm(new Film(5, "Daniel Brown", "Comedy Extravaganza", 2020, Sjanger.COMEDY, "Laughs R Us"));
    }
}
