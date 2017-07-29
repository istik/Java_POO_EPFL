import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    private String code;
    private int annee;
    private String pays;
    private double valeur;


    public Timbre(){
        code = CODE_DEFAUT;
        annee = ANNEE_COURANTE;
        pays = PAYS_DEFAUT;
        valeur = VALEUR_TIMBRE_DEFAUT;
    }
    public Timbre(String code){
            this.code = code;
            this.annee = ANNEE_COURANTE;
            this.pays = PAYS_DEFAUT;
            this.valeur = VALEUR_TIMBRE_DEFAUT;
    }
    public Timbre(String code, int annee){
            this.code = code;
            this.annee = annee;
            this.pays = PAYS_DEFAUT;
            this.valeur = VALEUR_TIMBRE_DEFAUT;
    }
    public Timbre(String code, int annee, String pays){
            this.code = code;
            this.annee = annee;
            this.pays = pays;
            this.valeur = VALEUR_TIMBRE_DEFAUT;
    }
    public Timbre(String code, int annee, String pays, Double valeur){
            this.code = code;
            this.annee = annee;
            this.pays = pays;
            this.valeur = valeur;
    }

    public double vente(){
        if(ANNEE_COURANTE - getAnnee() <= 5){
            return valeur;
        }else{
            return (valeur * (ANNEE_COURANTE - getAnnee()) * 2.5);
        }
    }

    public String toString(){
        return ("Timbre de code " + getCode() +" datant de " +  getAnnee() + " (provenance " + getPays() + ") ayant pour valeur faciale " + getValeurFaciale()+" francs");
    }

    public int age(){
        return ANNEE_COURANTE - annee;
    }

    public String getCode(){
        return  code;
    }
    public int getAnnee(){
        return annee;
    }
    public String getPays(){
        return pays;
    }
    public double getValeurFaciale(){
        return valeur;
    }


}

class Rare extends Timbre{
    private int nb_exemplaire;
    
    public Rare(int nb_exemplaire){
            super();
            this.nb_exemplaire = nb_exemplaire;
    }
    public Rare(String code, int nb_exemplaire){
            super(code);
            this.nb_exemplaire = nb_exemplaire;
    }
    public Rare(String code, int annee,int nb_exemplaire){
            super(code,annee);
            this.nb_exemplaire = nb_exemplaire;

    }
    public Rare(String code, int annee, String pays,int nb_exemplaire){
            super(code,annee,pays);
            this.nb_exemplaire = nb_exemplaire;
    }
    public Rare(String code, int annee, String pays, Double valeur,int nb_exemplaire){
            super(code,annee,pays,valeur);
            this.nb_exemplaire = nb_exemplaire;
    }

    public int getExemplaires(){
        return nb_exemplaire;
    }

    public String toString(){
        return ("Timbre de code " + getCode() +" datant de  " +  getAnnee() + " (provenance " + getPays() + ") ayant pour valeur faciale " + getValeurFaciale()+" francs\nNombre d'exemplaires -> " + getExemplaires() );
    }
    public double vente(){
        if(getExemplaires() < 100){
            return 600 * (ANNEE_COURANTE - getAnnee()) / 10.0 ;
        }else if(getExemplaires() < 1000 & nb_exemplaire >= 100){
            return 400 * (ANNEE_COURANTE - getAnnee()) / 10.0 ;
        }else{
            return 50 * (ANNEE_COURANTE - getAnnee()) / 10.0 ;
        }
    }

}

class Commemoratif extends Timbre{
    public Commemoratif(){
        super();
    }
    public Commemoratif(String code){
        super(code);
    }
    public Commemoratif(String code, int annee){
        super(code,annee);
    }
    public Commemoratif(String code, int annee, String pays){
        super(code,annee,pays);
    }
    public Commemoratif(String code, int annee, String pays, Double valeur){
        super(code,annee,pays,valeur);
    }

    public String toString(){
        return ("Timbre de code " + getCode() +" datant de " +  getAnnee() + " (provenance " + getPays() + ") ayant pour valeur faciale " + getValeurFaciale()+" francs\nTimbre celebrant un evenement"  );
    }
    public double vente(){
        if(ANNEE_COURANTE - getAnnee() <= 5){
            return (getValeurFaciale() * 2);
        }else{
            return (getValeurFaciale() * (ANNEE_COURANTE - getAnnee()) * 2.5 * 2);
        } 
    }
}


	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

