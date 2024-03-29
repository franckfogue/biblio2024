package bibliotheque.metier;

import java.time.LocalDate;
import java.util.Objects;
import java.time.temporal.ChronoUnit;


public class Location {
    private LocalDate dateLocation;
    private LocalDate dateRestitution;
    private Lecteur loueur;
    private Exemplaire exemplaire;

    public Location(LocalDate dateLocation, LocalDate dateRestitution, Lecteur loueur, Exemplaire exemplaire) {
        this.dateLocation = dateLocation;
        this.dateRestitution = dateRestitution;
        this.loueur = loueur;
        this.exemplaire = exemplaire;
        this.loueur.getLloc().add(this);
        this.exemplaire.getLloc().add(this);
    }

    public Location(Lecteur loueur, Exemplaire exemplaire) {
        this.loueur = loueur;
        this.exemplaire = exemplaire;
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public LocalDate getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(LocalDate dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public Lecteur getLoueur() {
        return loueur;
    }

    public void setLoueur(Lecteur loueur) {
        this.loueur = loueur;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(dateLocation, location.dateLocation) && Objects.equals(loueur, location.loueur) && Objects.equals(exemplaire, location.exemplaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateLocation, loueur, exemplaire);
    }

    @Override
    public String toString() {
        return "Location{" +
                "dateLocation=" + dateLocation +
                ", dateRestitution=" + dateRestitution +
                ", loueur=" + loueur +
                ", exemplaire=" + exemplaire +
                '}';
    }
    public double calculerAmende() {
        // Calcul de l'amende en fonction de la durée de location et du type d'ouvrage
        int dureeLocation = (int) ChronoUnit.DAYS.between(dateLocation, LocalDate.now());
        int dureeMax = 0;
        switch (exemplaire.getOuvrage().getTo()) {
            case LIVRE:
                dureeMax = 15;
                break;
            case DVD:
                dureeMax = 3;
                break;
            case CD:
                dureeMax = 7;
                break;
        }
        int joursDeRetard = Math.max(0, dureeLocation - dureeMax);
        double amende = joursDeRetard * 0.5; // Supposons une amende de 0.5€ par jour de retard
        return amende;
    }

    public void enregistrerRetour() {
        dateRestitution = LocalDate.now();
    }

}
