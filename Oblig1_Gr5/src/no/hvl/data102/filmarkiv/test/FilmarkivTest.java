package no.hvl.data102.filmarkiv.test;
import static org.junit.jupiter.api.Assertions.*;
    
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

public class FilmarkivTest {
    
    public class FilmarkivTest {
    
        private Filmarkiv arkiv;
    
        @BeforeEach
        public void setUp() {
            // Initialiserer et filmarkiv med kapasitet for 5 filmer
            arkiv = new Filmarkiv(5);
    
            // Legger til noen filmer for testing
            arkiv.leggTilFilm(new Film(1, "Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal Pictures"));
            arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, Sjanger.THRILLER, "Warner Bros"));
            arkiv.leggTilFilm(new Film(3, "Cameron", "Avatar", 2009, Sjanger.SCIENCE_FICTION, "20th Century Fox"));
            arkiv.leggTilFilm(new Film(4, "Lucas", "Star Wars", 1977, Sjanger.SCIENCE_FICTION, "Lucasfilm"));
        }
    
        @Test
        public void testLeggTilFilm() {
            int antallFør = arkiv.antall();
            arkiv.leggTilFilm(new Film(5, "Spielberg", "E.T. the Extra-Terrestrial", 1982, Sjanger.ACTION, "Universal Pictures"));
            assertEquals(antallFør + 1, arkiv.antall(), "Antallet filmer skal øke med 1 etter å legge til en film.");
        }
    
        @Test
        public void testSlettFilm() {
            boolean slettet = arkiv.slettFilm(2); // Sletter filmen "Inception"
            assertTrue(slettet, "Filmen med filmNr 2 skal bli slettet.");
            assertNull(arkiv.finnFilm(2), "Filmen med filmNr 2 skal ikke finnes etter sletting.");
            assertEquals(3, arkiv.antall(), "Antallet filmer skal reduseres med 1 etter sletting.");
        }
    
        @Test
        public void testFinnFilm() {
            Film film = arkiv.finnFilm(3); // Søker etter filmen "Avatar"
            assertNotNull(film, "Filmen med filmNr 3 skal finnes.");
            assertEquals("Avatar", film.getTittel(), "Filmen med filmNr 3 skal ha tittelen 'Avatar'.");
        }
    
        @Test
        public void testSoekTittel() {
            Film[] resultater = arkiv.soekTittel("Star");
            assertEquals(1, resultater.length, "Det skal være 1 film som inneholder 'Star' i tittelen.");
            assertEquals("Star Wars", resultater[0].getTittel(), "Den matchede filmen skal være 'Star Wars'.");
        }
    
        @Test
        public void testSoekProdusent() {
            Film[] resultater = arkiv.soekProdusent("Spielberg");
            assertEquals(1, resultater.length, "Det skal være 1 film produsert av 'Spielberg'.");
            assertEquals("Jurassic Park", resultater[0].getTittel(), "Den matchede filmen skal være 'Jurassic Park'.");
        }
    
        @Test
        public void testAntallSjanger() {
            int antallSciFi = arkiv.antall(Sjanger.SCIENCE_FICTION);
            assertEquals(2, antallSciFi, "Det skal være 2 filmer i SCIENCE_FICTION-sjangeren.");
        }
    
        @Test
        public void testAntall() {
            int totalAntall = arkiv.antall();
            assertEquals(4, totalAntall, "Det totale antallet filmer skal være 4.");
        }
    }
    
}
