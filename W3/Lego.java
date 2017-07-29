/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
import java.util.ArrayList;
import java.util.List;

class Piece{
    private String nom;

    public Piece(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }
    public String toString(){
        return nom;
    }

}

class Composant{
    private Piece piece;
    private int quantite;

    public Composant(Piece piece, int quantite){
        this.piece = piece;
        this.quantite = quantite;
    }
    public Piece getPiece(){
        return this.piece;
    }
    public int getQuantite(){
        return this.quantite;
    }
}

class Simple extends Piece{
    private String orientation;

    public Simple(String nom){
        super(nom);
        this.orientation = "aucune";
    }
    public Simple(String nom, String orientation){
        super(nom);
        this.orientation = orientation;
    }
    public String getOrientation(){
        return this.orientation;
    }
    public String toString(){
        if(this.orientation != "aucune")
        {
        return (getNom() +" "+ this.orientation);
    } else{
        return getNom();
    }

    }

}

class Composee extends Piece{
    private ArrayList<Piece> pieces = new ArrayList<Piece>();
    private int nb_pieces_max;
    public Composee(String nom,int nb_pieces_max){
        super(nom);
        this.nb_pieces_max = nb_pieces_max;
    }
    public int taille(){
        return pieces.size();
    }
    public int tailleMax(){
        return this.nb_pieces_max;
    }
    public void construire(Piece piece){
        if(this.pieces.size() < this.nb_pieces_max){
            pieces.add(piece);
        } else{
            System.out.println("Construction impossible");
        }
    }
    public String toString(){

        List<String> names = new ArrayList<String>();
        for (Piece piece : pieces) names.add(piece.toString());
        return (this.getNom() + "(" + String.join(",", names) + ")");       

    }

}

class Construction{
    private ArrayList<Composant> composants = new ArrayList<Composant>();
    private int nb_composants_max;

    public Construction(int nb_composants_max){
        this.nb_composants_max = nb_composants_max;
    }

    public int taille(){
        return composants.size();
    }
    public int tailleMax(){
        return this.nb_composants_max;
    }
    public void ajouterComposant(Piece piece, int nb_pieces){
        if(this.composants.size() < this.nb_composants_max){
            composants.add(new Composant(piece, nb_pieces));
        } else{
            System.out.println("Ajout de composant impossible");
        }
    }
    public String toString(){
        String results = "";
        for (Composant composant : composants) {
            results += (composant.getPiece().toString() + " (quantite " + composant.getQuantite() + ")\n") ;
        }
        return results;
    }

}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // déclare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}
