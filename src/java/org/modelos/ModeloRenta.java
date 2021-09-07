/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelos;

/**
 *
 * @author Jonathan
 */
public class ModeloRenta {

    /**
     * @return the tipopago
     */
    public int getTipopago() {
        return tipopago;
    }

    /**
     * @param tipopago the tipopago to set
     */
    public void setTipopago(int tipopago) {
        this.tipopago = tipopago;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idrenta
     */
    public int getIdrenta() {
        return idrenta;
    }

    /**
     * @param idrenta the idrenta to set
     */
    public void setIdrenta(int idrenta) {
        this.idrenta = idrenta;
    }

    /**
     * @return the idvehiculo
     */
    public int getIdvehiculo() {
        return idvehiculo;
    }

    /**
     * @param idvehiculo the idvehiculo to set
     */
    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    /**
     * @return the fechaini
     */
    public String getFechaini() {
        return fechaini;
    }

    /**
     * @param fechaini the fechaini to set
     */
    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    /**
     * @return the fechafin
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    private int idrenta;
    private int idvehiculo;
    private String fechaini;
    private String fechafin;
    private double precio;
    private int idcliente;
    private int tipopago;

}
