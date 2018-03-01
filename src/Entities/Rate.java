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
    private double rate;
    private int nbre_rate;
    private int id_patisserie;

    public Rate(int id_rate, double rate, int nbre_rate, int id_patisserie) {
        this.id_rate = id_rate;
        this.rate = rate;
        this.nbre_rate = nbre_rate;
        this.id_patisserie = id_patisserie;
    }

    public int getId_rate() {
        return id_rate;
    }

    public Rate(double rate,int nbre_rate,int id_patisserie) {
        this.rate = rate;
        this.nbre_rate = nbre_rate;
        this.id_patisserie = id_patisserie;
    }
    public Rate(int id_rate,double rate,int nbre_rate ) {
        this.rate = rate;
        this.nbre_rate = nbre_rate;
        this.id_rate = id_rate;
    }


    public void setId_rate(int id_rate) {
        this.id_rate = id_rate;
    }

    public double getRate() {
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

    public int getId_patisserie() {
        return id_patisserie;
    }

    public void setId_patisserie(int id_patisserie) {
        this.id_patisserie = id_patisserie;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id_rate;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.rate) ^ (Double.doubleToLongBits(this.rate) >>> 32));
        hash = 11 * hash + this.nbre_rate;
        hash = 11 * hash + Objects.hashCode(this.id_patisserie);
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
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        if (this.nbre_rate != other.nbre_rate) {
            return false;
        }
        if (!Objects.equals(this.id_patisserie, other.id_patisserie)) {
            return false;
        }
        return true;
    }


    

    @Override
    public String toString() {
        return "Rate{" + "id_rate=" + id_rate + ", rate=" + rate + ", nbre_rate=" + nbre_rate + ", id_patisserie=" + id_patisserie + '}';
    }
    
    
}
