import java.util.HashSet;
import java.util.Set;

public class TSPNearestNeighbor {
    public static void main(String[] args) {
        int[][] distances = {{0, 10, 15, 20},
                             {10, 0, 35, 25},
                             {15, 35, 0, 30},
                             {20, 25, 30, 0}};
        int[] tur = tspNearestNeighbor(distances);
        System.out.println("Tur terdekat: ");
        for (int i = 0; i < tur.length; i++) {
            System.out.print(tur[i] + " ");
        }
        System.out.println();
    }

    public static int[] tspNearestNeighbor(int[][] distances) {
        int kotaAwal = 0;
        int[] tur = new int[distances.length];
        Set<Integer> kotaBelumDikunjungi = new HashSet<>();
        for (int i = 0; i < distances.length; i++) {
            if (i != kotaAwal) {
                kotaBelumDikunjungi.add(i);
            }
        }
        tur[0] = kotaAwal;
        int kotaSaatIni = kotaAwal;
        for (int i = 1; i < distances.length; i++) {
            int kotaTerdekat = cariKotaTerdekat(kotaSaatIni, kotaBelumDikunjungi, distances);
            tur[i] = kotaTerdekat;
            kotaBelumDikunjungi.remove(kotaTerdekat);
            kotaSaatIni = kotaTerdekat;
        }
        return tur;
    }

    public static int cariKotaTerdekat(int kota, Set<Integer> kotaBelumDikunjungi, int[][] distances) {
        int kotaTerdekat = -1;
        int jarakTerdekat = Integer.MAX_VALUE;
        for (int tetangga : kotaBelumDikunjungi) {
            int jarak = distances[kota][tetangga];
            if (jarak < jarakTerdekat) {
                kotaTerdekat = tetangga;
                jarakTerdekat = jarak;
            }
        }
        return kotaTerdekat;
    }
}
