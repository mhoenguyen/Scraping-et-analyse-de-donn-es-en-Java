package fr.pantheonsorbonne.ufr27.miashs.poo;
import java.util.ArrayList;
public final class ItemsScrapper {
    ArrayList<Item> parseSource(String pageSource) {
        ArrayList<Item> itemList = new ArrayList<>();
        int index = pageSource.indexOf("<div class=\"sort-filters-wrapper\" data-v-6466cee8>");

        while (index != -1) {
            int indexPrix = pageSource.indexOf("<div class=\"price-final is-sale\" data-v-d3ffb9a2>", index);

            if (indexPrix == -1) {
                // Si on ne trouve pas de nouvel index pour le prix, sortir de la boucle
                break;
            }

            int indexPrixFin = pageSource.indexOf("</div><!---->", indexPrix);

            if (indexPrixFin == -1) {
                // Si on ne trouve pas de fin pour le prix, sortir de la boucle
                break;
            }

            String prixString = pageSource.substring(indexPrix, indexPrixFin);
            prixString = prixString.replaceAll("[^0-9.]", "");
            Double prixValue = Double.parseDouble(prixString);

            // Recherche du type
            int indexType = pageSource.indexOf("<h2 class=\"product-name\" data-v-1cb1e81c>", indexPrix);
            int indexTypeFin = pageSource.indexOf("</h2>", indexType);
            String type = pageSource.substring(indexType, indexTypeFin).replaceAll("<[^>]*>", "");

            // Recherche de la marque
            int indexMarque = pageSource.indexOf("<strong class=\"brand-name\" data-v-1cb1e81c>", indexType);
            int indexMarqueFin = pageSource.indexOf("</strong>", indexMarque);
            String marque = pageSource.substring(indexMarque, indexMarqueFin).replaceAll("<[^>]*>", "");

            // Recherche de la couleur
            int indexCouleur = pageSource.indexOf("<div class=\"name-container\" data-v-1cb1e81c>", indexMarque);
            int indexCouleurFin = pageSource.indexOf("</div>", indexCouleur);
            String couleur = pageSource.substring(indexCouleur, indexCouleurFin).replaceAll("<[^>]*>", "");

            // Recherche de la réduction
            int indexReduction = pageSource.indexOf("<span class=\"content\" style=\"color:#ffffff;\" data-v-15daad44 data-v-6273cf7a>", indexCouleur);
            int indexReductionFin = pageSource.indexOf("</span>", indexReduction);
            String reductionString = pageSource.substring(indexReduction, indexReductionFin).replaceAll("[^0-9.]", "");
            Double reduction = Double.parseDouble(reductionString);

            Item item = new Item();
            item.setPrix(prixValue);
            item.setType(type);
            item.setMarque(marque);
            item.setCouleur(couleur);
            item.setReduction(reduction);
            itemList.add(item);

            // Mettez à jour l'index pour la prochaine itération
            index = pageSource.indexOf("<div class=\"sort-filters-wrapper\" data-v-6466cee8>", index + 1);
        }

        return itemList;
    }
}
