package no.hvl.data102.filmarkiv.klient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        // Velkomstmelding
        JOptionPane.showMessageDialog(null, "Velkommen til Filmarkivet!", "Velkomstmelding", JOptionPane.INFORMATION_MESSAGE);

        // Legg til noen filmer (dummy data)
        filmarkiv.leggTilFilm(new Film(1, "John Doe", "The Adventure Begins", 2023, Sjanger.ACTION, "Adventure Productions"));
        filmarkiv.leggTilFilm(new Film(2, "Jane Smith", "Mystery of the Night", 2021, Sjanger.THRILLER, "Mystery Studios"));
        filmarkiv.leggTilFilm(new Film(3, "Albert Johnson", "Love in the Park", 2022, Sjanger.ROMANCE, "Love Productions"));
        filmarkiv.leggTilFilm(new Film(4, "Emily Watson", "The Last Frontier", 2024, Sjanger.SCI_FI, "SciFi Creations"));
        filmarkiv.leggTilFilm(new Film(5, "Daniel Brown", "Comedy Extravaganza", 2020, Sjanger.COMEDY, "Laughs R Us"));

        // Åpne menyvinduet
        visMeny();
    }

    private void visMeny() {
        // Lag vinduet
        JFrame frame = new JFrame("Filmarkiv Meny");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Felt for input
        JLabel idLabel = new JLabel("Film ID:");
        idLabel.setBounds(50, 300, 100, 20); // Posisjon x, y, bredde, høyde

        JTextField idField = new JTextField();
        idField.setBounds(200, 300, 200, 20);

        JLabel tittelLabel = new JLabel("Tittel:");
        tittelLabel.setBounds(50, 330, 100, 20);
        JTextField tittelField = new JTextField();
        tittelField.setBounds(200, 330, 200, 20);

        JLabel aarLabel = new JLabel("År:");
        aarLabel.setBounds(50, 360, 100, 20);
        JTextField aarField = new JTextField();
        aarField.setBounds(200, 360, 200, 20);

        JLabel produsLabel = new JLabel("Produsent:");
        produsLabel.setBounds(50, 390, 100, 20);
        JTextField produsField = new JTextField();
        produsField.setBounds(200, 390, 200, 20);

        JLabel sjangerLabelNew = new JLabel("Sjanger:");
        sjangerLabelNew.setBounds(50, 420, 100, 20);
        JComboBox<Sjanger> sjangerComboNew = new JComboBox<>(Sjanger.values());
        sjangerComboNew.setBounds(200, 420, 200, 20);

        JLabel companyLabel = new JLabel("Produksjonsselskap:");
        companyLabel.setBounds(50, 450, 150, 20);
        JTextField companyField = new JTextField();
        companyField.setBounds(200, 450, 200, 20);

        // Legg til knapp for å legge til film
        JButton addButton = new JButton("Legg til Film");
        addButton.setBounds(150, 480, 150, 30);
        addButton.addActionListener(new ActionListener() { //adder en knapp som kjører når klikket
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String tittel = tittelField.getText();
                    int aar = Integer.parseInt(aarField.getText());
                    Sjanger sjanger = (Sjanger) sjangerComboNew.getSelectedItem();
                    String company = companyField.getText();
                    String produs = produsField.getText();

                    // Legg til film i arkivet
                    filmarkiv.leggTilFilm(new Film(id, produs, tittel, aar, sjanger, company));

                    JOptionPane.showMessageDialog(frame, "Film lagt til!", "Suksess", JOptionPane.INFORMATION_MESSAGE);

                    // Tøm feltene
                    idField.setText("");
                    tittelField.setText("");
                    aarField.setText("");
                    companyField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Feil input! Sjekk ID og År.", "Feil", JOptionPane.ERROR_MESSAGE); //Om det er input feil i feltene
                }
            }
        });

        // Søk etter tittel
        JLabel finnFilmLabel = new JLabel("Søk etter tittel:");
        finnFilmLabel.setBounds(50, 30, 150, 20);
        JTextField finnFilmField = new JTextField();
        finnFilmField.setBounds(200, 30, 200, 20);

        JButton searchTitleButton = new JButton("Søk Tittel");
        searchTitleButton.setBounds(420, 30, 150, 20);
        searchTitleButton.addActionListener(e -> {
            String searchText = finnFilmField.getText();
            Film[] results = filmarkiv.soekTittel(searchText);
            if (results.length > 0) {
                StringBuilder resultText = new StringBuilder("Fant følgende filmer:\n");
                for (Film film : results) {
                    resultText.append(film.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, resultText.toString(), "Søkeresultater", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Ingen filmer funnet med tittelen: " + searchText, "Ingen treff", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Søk etter produsent
        JLabel finnProdusentLabel = new JLabel("Søk etter produsent:");
        finnProdusentLabel.setBounds(50, 70, 150, 20);
        JTextField finnProdusentField = new JTextField();
        finnProdusentField.setBounds(200, 70, 200, 20);

        JButton searchProducerButton = new JButton("Søk Produsent");
        searchProducerButton.setBounds(420, 70, 150, 20);
        searchProducerButton.addActionListener(e -> {
            String searchText = finnProdusentField.getText();
            Film[] results = filmarkiv.soekProdusent(searchText);
            if (results.length > 0) {
                StringBuilder resultText = new StringBuilder("Fant følgende filmer:\n");
                for (Film film : results) {
                    resultText.append(film.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, resultText.toString(), "Søkeresultater", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Ingen filmer funnet med produsenten: " + searchText, "Ingen treff", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Slett film
        JLabel slettFilmLabel = new JLabel("Slett film (ID):");
        slettFilmLabel.setBounds(50, 110, 150, 20);
        JTextField slettFilmField = new JTextField();
        slettFilmField.setBounds(200, 110, 200, 20);

        JButton deleteButton = new JButton("Slett Film");
        deleteButton.setBounds(420, 110, 150, 20);
        deleteButton.addActionListener(e -> {
            try {
                int filmId = Integer.parseInt(slettFilmField.getText());
                boolean deleted = filmarkiv.slettFilm(filmId);
                if (deleted) {
                    JOptionPane.showMessageDialog(frame, "Filmen med ID " + filmId + " ble slettet.", "Sletting vellykket", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Fant ingen film med ID " + filmId, "Feil", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "ID må være et tall!", "Feil", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Antall filmer totalt
        JButton totalButton = new JButton("Totalt antall filmer");
        totalButton.setBounds(50, 150, 200, 20);
        totalButton.addActionListener(e -> {
            int totalFilms = filmarkiv.antall();
            JOptionPane.showMessageDialog(frame, "Totalt antall filmer i arkivet: " + totalFilms, "Totalt antall", JOptionPane.INFORMATION_MESSAGE);
        });

        // Antall filmer av en sjanger
        JLabel sjangerLabel = new JLabel("Antall filmer av sjanger:");
        sjangerLabel.setBounds(50, 190, 150, 20);
        JComboBox<Sjanger> sjangerCombo = new JComboBox<>(Sjanger.values());
        sjangerCombo.setBounds(200, 190, 150, 20);

        JButton countGenreButton = new JButton("Tell");
        countGenreButton.setBounds(370, 190, 100, 20);
        countGenreButton.addActionListener(e -> {
            Sjanger selectedSjanger = (Sjanger) sjangerCombo.getSelectedItem();
            int count = filmarkiv.antall(selectedSjanger);
            JOptionPane.showMessageDialog(frame, "Antall filmer i sjangeren " + selectedSjanger + ": " + count, "Resultat", JOptionPane.INFORMATION_MESSAGE);
        });

        // Avslutt-knapp
        JButton exitButton = new JButton("Avslutt");
        exitButton.setBounds(150, 530, 100, 30);
        exitButton.addActionListener(e -> System.exit(0));

        // Legg til komponenter i vinduet
        frame.add(finnFilmLabel);
        frame.add(finnFilmField);
        frame.add(searchTitleButton);
        frame.add(finnProdusentLabel);
        frame.add(finnProdusentField);
        frame.add(searchProducerButton);
        frame.add(slettFilmLabel);
        frame.add(slettFilmField);
        frame.add(deleteButton);
        frame.add(totalButton);
        frame.add(sjangerLabel);
        frame.add(sjangerCombo);
        frame.add(countGenreButton);
        frame.add(exitButton);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(tittelLabel);
        frame.add(tittelField);
        frame.add(aarLabel);
        frame.add(aarField);
        frame.add(sjangerLabelNew);
        frame.add(sjangerComboNew);
        frame.add(companyLabel);
        frame.add(companyField);
        frame.add(addButton);
        frame.add(produsField);
        frame.add(produsLabel);


        // Vis vinduet
        frame.setVisible(true);
    }
}
