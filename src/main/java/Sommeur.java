public class Sommeur implements Runnable{
    private int[] tableau;
    private int debut, fin;
    private int somme = 0;

    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    public int getSomme() {
        return somme;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
    }
}
