import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Exercice 1:
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new Talkative(i));
//            t.start();
//        }

//        Exercice 2:
        int[] tableau = new int[100];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }

        int nombreThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(nombreThreads);
        Future<Integer>[] results = new Future[nombreThreads];

        int taille = tableau.length / nombreThreads;
        for (int i = 0; i < nombreThreads; i++) {
            int debut = i * taille;
            int fin = (i == nombreThreads - 1) ? tableau.length : (i + 1) * taille;
            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            results[i] = executor.submit(() -> {
                sommeur.run();
                return sommeur.getSomme();
            });
        }

        executor.shutdown();
        int sommeTotale = 0;
        for (Future<Integer> result : results) {
            sommeTotale += result.get();
        }

        System.out.println("Somme totale: " + sommeTotale);



    }
}
