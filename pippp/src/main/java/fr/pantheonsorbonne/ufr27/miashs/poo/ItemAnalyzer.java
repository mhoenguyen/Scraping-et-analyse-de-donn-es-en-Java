package fr.pantheonsorbonne.ufr27.miashs.poo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ItemAnalyzer {
    private ArrayList<Item> items;

    public ItemAnalyzer(ArrayList<Item> items) {
        this.items = items;
    }

    public Double getPrixMoyen() {
        if (items.isEmpty()) {
            return 0.0;
        }

        double totalPrix = 0.0;
        for (Item item : items) {
            totalPrix += item.getPrix();
        }

        return totalPrix / items.size();
    }

    public String getCouleurTendance() {
        if (items.isEmpty()) {
            return null;
        }

        // Utiliser une carte pour compter le nombre d'occurrences de chaque couleur
        Map<String, Integer> couleurCount = new HashMap<>();
        for (Item item : items) {
            String couleur = item.getCouleur();
            couleurCount.put(couleur, couleurCount.getOrDefault(couleur, 0) + 1);
        }

        // Trouver la couleur avec le nombre d'occurrences le plus élevé
        int maxCount = 0;
        String couleurTendance = null;
        for (Map.Entry<String, Integer> entry : couleurCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                couleurTendance = entry.getKey();
            }
        }

        return couleurTendance;
    }

    public Double getMeilleurReduction() {
        if (items.isEmpty()) {
            return 0.0;
        }

        double meilleurReduction = 0.0;
        for (Item item : items) {
            double reduction = item.getReduction();
            if (reduction > meilleurReduction) {
                meilleurReduction = reduction;
            }
        }

        return meilleurReduction;
    }

    public String getMarquePopulaire() {
        if (items.isEmpty()) {
            return null;
        }

        // Utiliser une carte pour compter le nombre d'occurrences de chaque marque
        Map<String, Integer> marqueCount = new HashMap<>();
        for (Item item : items) {
            String marque = item.getMarque();
            marqueCount.put(marque, marqueCount.getOrDefault(marque, 0) + 1);
        }

        // Trouver la marque avec le nombre d'occurrences le plus élevé
        int maxCount = 0;
        String marquePopulaire = null;
        for (Map.Entry<String, Integer> entry : marqueCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                marquePopulaire = entry.getKey();
            }
        }

        return marquePopulaire;
    }

    public String getTypeReccurent() {
        if (items.isEmpty()) {
            return null;
        }

        // Utiliser une carte pour compter le nombre d'occurrences de chaque type
        Map<String, Integer> typeCount = new HashMap<>();
        for (Item item : items) {
            String type = item.getType();
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        // Trouver le type avec le nombre d'occurrences le plus élevé
        int maxCount = 0;
        String typeReccurent = null;
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                typeReccurent = entry.getKey();
            }
        }

        return typeReccurent;
    }
}
