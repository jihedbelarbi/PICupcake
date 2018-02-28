/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author jihed
 */
public class Rate {
    private int id_rate;
    private float rate;
    private int nbre_rate;
    private Patisserie patisserie;

    public Rate(int id_rate, float rate, int nbre_rate, Patisserie patisserie) {
        this.id_rate = id_rate;
        this.rate = rate;
        this.nbre_rate = nbre_rate;
        this.patisserie = patisserie;
    }

    public int getId_rate() {
        return id_rate;
    }

    public void setId_rate(int id_rate) {
        this.id_rate = id_rate;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getNbre_rate() {
        return nbre_rate;
    }

    public void setNbre_rate(int nbre_rate) {
        this.nbre_rate = nbre_rate;
    }

    public Patisserie getPatisserie() {
        return patisserie;
    }

    public void setPatisserie(Patisserie patisserie) {
        this.patisserie = patisserie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_rate;
        hash = 23 * hash + Float.floatToIntBits(this.rate);
        hash = 23 * hash + this.nbre_rate;
        hash = 23 * hash + Objects.hashCode(this.patisserie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rate other = (Rate) obj;
        if (this.id_rate != other.id_rate) {
            return false;
        }
        if (Float.floatToIntBits(this.rate) != Float.floatToIntBits(other.rate)) {
            return false;
        }
        if (this.nbre_rate != other.nbre_rate) {
            return false;
        }
        if (!Objects.equals(this.patisserie, other.patisserie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rate{" + "id_rate=" + id_rate + ", rate=" + rate + ", nbre_rate=" + nbre_rate + ", patisserie=" + patisserie + '}';
    }
    
    
}
