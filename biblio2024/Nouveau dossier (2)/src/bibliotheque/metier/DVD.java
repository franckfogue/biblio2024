package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static bibliotheque.metier.TypeOuvrage.DVD;

public class DVD extends Ouvrage{

    private long code;
    private String dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues=new ArrayList<>();
    private List<String> sousTitres=new ArrayList<>();
    public DVD(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre, long code, String dureeTotale, byte nbreBonus) {
        super(titre, ageMin, dateParution, DVD, prixLocation, langue, genre);
        this.code=code;
       this.dureeTotale=dureeTotale;
       this.nbreBonus=nbreBonus;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(String dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public byte getNbreBonus() {
        return nbreBonus;
    }

    public void setNbreBonus(byte nbreBonus) {
        this.nbreBonus = nbreBonus;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public void setAutresLangues(List<String> autresLangues) {
        this.autresLangues = autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(List<String> sousTitres) {
        this.sousTitres = sousTitres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return code == dvd.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return super.toString()+"DVD{" +
                "code=" + code +
                ", dureeTotale='" + dureeTotale + '\'' +
                ", nbreBonus=" + nbreBonus +
                ", autresLangues=" + autresLangues +
                ", sousTitres=" + sousTitres +
                "} " + super.toString();
    }
    @Override
    public double amendeRetard(int njours) {
        // Nombre de jours de retard
        int joursDeRetard = njours - 3; // 3 jours de prêt pour un DVD

        // Tarif de l'amende par jour de retard (exemple : 0.50 € par jour)
        double tarifAmendeParJour = 0.50;

        // Calcul de l'amende
        double amende = 0;
        if (joursDeRetard > 0) {
            amende = joursDeRetard * tarifAmendeParJour;
        }

        return amende;
    }

}
