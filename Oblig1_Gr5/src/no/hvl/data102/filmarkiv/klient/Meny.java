package no.hvl.data102.filmarkiv.klient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        // Velkomst melding som dukker opp en gang og så forsvinner
        JOptionPane.showMessageDialog(null, "Velkommen til Filmarkivet!", "Velkomstmelding", JOptionPane.INFORMATION_MESSAGE);

        // Randome GPT filmer
        filmarkiv.leggTilFilm(new Film(1, "John Doe", "The Adventure Begins", 2023, Sjanger.ACTION, "Adventure Productions"));
        filmarkiv.leggTilFilm(new Film(2, "Jane Smith", "Mystery of the Night", 2021, Sjanger.THRILLER, "Mystery Studios"));
        filmarkiv.leggTilFilm(new Film(3, "Albert Johnson", "Love in the Park", 2022, Sjanger.ROMANCE, "Love Productions"));
        filmarkiv.leggTilFilm(new Film(4, "Emily Watson", "The Last Frontier", 2024, Sjanger.SCI_FI, "SciFi Creations"));
        filmarkiv.leggTilFilm(new Film(5, "Daniel Brown", "Comedy Extravaganza", 2020, Sjanger.COMEDY, "Laughs R Us"));

        // Åpne vindu
        visMeny();
    }

    private void visMeny() {
        // Lag vinduet
        JFrame frame = new JFrame("Filmarkiv Meny");
        frame.setSize(1000, 1000); // Bredde x høgde
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Avlsutt programmet når lukket
        frame.setLayout(null); // null for absolutt posisjoner

        // Felt for input
        JLabel idLabel = new JLabel("Film ID:");
        idLabel.setBounds(50, 30, 100, 20); // Posisjon x, y, bredde, høyde

        JTextField idField = new JTextField(); 
        idField.setBounds(150, 30, 200, 20);

        JLabel tittelLabel = new JLabel("Tittel:");
        tittelLabel.setBounds(50, 60, 100, 20);
        JTextField tittelField = new JTextField();
        tittelField.setBounds(150, 60, 200, 20);

        JLabel aarLabel = new JLabel("År:");
        aarLabel.setBounds(50, 90, 100, 20);
        JTextField aarField = new JTextField();
        aarField.setBounds(150, 90, 200, 20);

        JLabel sjangerLabel = new JLabel("Sjanger:");
        sjangerLabel.setBounds(50, 120, 100, 20);
        JComboBox<Sjanger> sjangerCombo = new JComboBox<>(Sjanger.values());
        sjangerCombo.setBounds(150, 120, 200, 20);

        JLabel companyLabel = new JLabel("Produksjonsselskap:");
        companyLabel.setBounds(50, 150, 150, 20);
        JTextField companyField = new JTextField();
        companyField.setBounds(200, 150, 200, 20);

        // Legg til knapp for å legge til film
        JButton addButton = new JButton("Legg til Film");
        addButton.setBounds(150, 200, 150, 30);
        addButton.addActionListener(new ActionListener() { //adder en knapp som kjører når klikket
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String tittel = tittelField.getText();
                    int aar = Integer.parseInt(aarField.getText());
                    Sjanger sjanger = (Sjanger) sjangerCombo.getSelectedItem();
                    String company = companyField.getText();

                    // Legg til film i arkivet
                    filmarkiv.leggTilFilm(new Film(id, "Ukjent", tittel, aar, sjanger, company));

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

        // Lag exit knappen
        JButton exitButton = new JButton("Avslutt");
        exitButton.setBounds(350, 200, 100, 30);
        exitButton.addActionListener(e -> System.exit(0)); //terminerer programmet når knappen trykkes


        // Legg til komponenter i vinduet
        frame.add(idLabel);
        frame.add(idField);
        frame.add(tittelLabel);
        frame.add(tittelField);
        frame.add(aarLabel);
        frame.add(aarField);
        frame.add(sjangerLabel);
        frame.add(sjangerCombo);
        frame.add(companyLabel);
        frame.add(companyField);
        frame.add(addButton);
        frame.add(exitButton);

        // Vis vinduet
        frame.setVisible(true);
    }
}
