/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.List;
import java.util.ArrayList;
/*"Nous avons un nouvel employé : "
"Montant de la prime souhaitée par "
"  A voyagé "
" jours et apporté "
"  A corrigé "
"  A mené à bien "*/

abstract class Employe{
    private String nom;
    private double revenue;
    private int taux_occupation;

    public Employe(String nom, double revenue){
        this.nom = nom;
        this.revenue = revenue;
        this.taux_occupation = 100;
    }

    public Employe(String nom, double revenue, int taux_occupation){
        this.nom = nom;
        this.revenue = revenue;
        if(this.taux_occupation<10) {
            this.taux_occupation = 10;}
        else if(this.taux_occupation < 100){
            this.taux_occupation = taux_occupation;
        }else{
            this.taux_occupation = 100;
        }
    }

    public String getNom() {
        return nom;
    }

    public double revenuAnnuel() {
        return 12*revenue*taux_occupation/100.0;
    }

}


class Manager extends Employe{
    private int jours_voyages;
    private int clients_apportes;

    public static final int FACTEUR_GAIN_CLIENT = 500;
    public static final int FACTEUR_GAIN_VOYAGE = 100;


    public Manager(String nom, double revenue, int jours_voyages, int clients_apportes){
        super(nom,revenue);
        this.jours_voyages = jours_voyages;
        this.clients_apportes = clients_apportes;
    }
    public Manager(String nom, double revenue, int jours_voyages, int clients_apportes, int taux_occupation){
        super(nom,revenue,taux_occupation);
        this.jours_voyages = jours_voyages;
        this.clients_apportes = clients_apportes;
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + jours_voyages * FACTEUR_GAIN_VOYAGE +  clients_apportes * FACTEUR_GAIN_CLIENT;
    }

    @Override
    public String toString() {
        return "Nous avons un nouvel employé : " + super.getNom() +", c'est un manager.";
    }
}

class Testeur extends Employe{
    private int erreurs_corrigees;

    public static final int FACTEUR_GAIN_ERREURS = 10;


    public Testeur(String nom, double revenue, int erreurs_corrigees){
        super(nom,revenue);
        this.erreurs_corrigees = erreurs_corrigees;
    }

    public Testeur(String nom, double revenue, int erreurs_corrigees, int taux_occupation){
        super(nom,revenue,taux_occupation);
        this.erreurs_corrigees = erreurs_corrigees;
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + erreurs_corrigees * FACTEUR_GAIN_ERREURS;
    }

    @Override
    public String toString() {
        return "Nous avons un nouvel employé : " + super.getNom() +", c'est un testeur.";
    }

}

class Programmeur extends Employe{
    private int projets_acheves;

    public static final int FACTEUR_GAIN_PROJETS = 200;

    public Programmeur(String nom, double revenue, int projets_acheves){
        super(nom,revenue);
        this.projets_acheves = projets_acheves;
    }

    public Programmeur(String nom, double revenue, int projets_acheves, int taux_occupation){
        super(nom,revenue,taux_occupation);
        this.projets_acheves = projets_acheves;
    }

    @Override
    public double revenuAnnuel() {
        return super.revenuAnnuel() + projets_acheves * FACTEUR_GAIN_PROJETS;
    }

    @Override
    public String toString() {
        return "Nous avons un nouvel employé : " + super.getNom() +", c'est un programmeur.";
    }
}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Employes {
    public static void main(String[] args) {

        List<Employe> staff = new ArrayList<Employe>();

        // TEST PARTIE 1:

        System.out.println("Test partie 1 : ");
        staff.add(new Manager("Serge Legrand", 7456, 30, 4 ));
        staff.add(new Programmeur("Paul Lepetit" , 6456, 3, 75 ));
        staff.add(new Testeur("Pierre Lelong", 5456, 124, 50 ));

        System.out.println("Affichage des employés : ");
        for (Employe modele : staff) {
            System.out.println(modele);
        }
        // FIN TEST PARTIE 1
        // TEST PARTIE 2
        System.out.println("Test partie 2 : ");

        //staff.get(0).demandePrime();

        System.out.println("Affichage après demande de prime : ");
        System.out.println(staff.get(0));

        // FIN TEST PARTIE 2
    }
}

