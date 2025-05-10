package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.lang.Double;
import java.lang.String;
import java.math.BigDecimal;

public final class Item {
  private Double Prix;

  private String Type;

  private String Marque;

  private String Couleur;

  private Double Reduction;

  public Double getPrix() {
    return this.Prix;
  }

  public void setPrix(Double Prix) {
    this.Prix= Prix;
  }

  public String getType() {
    return this.Type;
  }

  public void setType(String Type) {
    this.Type=Type;
  }

  public String getMarque() {
    return this.Marque;
  }

  public void setMarque(String Marque) {
    this.Marque=Marque;
  }

  public String getCouleur() {
    return this.Couleur;
  }

  public void setCouleur(String Couleur) {
    this.Couleur=Couleur;
  }

  public Double getReduction() {
    return this.Reduction;
  }

  public void setReduction(Double Reduction) {
    this.Reduction=Reduction;
  }
}
