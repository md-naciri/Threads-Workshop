public class Sommeur implements Runnable{
    private int[] tableau;
    private int debut, fin;
    private int somme;

    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {

    }
}
