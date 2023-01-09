/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Yasmany
 */
public class Mis_gastos {

    private Integer id_gasto;
    private String tipo_gasto;
    private String detalle;
    private String valor;
    private Date fecha;
    
    public Mis_gastos(Integer id_gasto, String tipo_gasto, String detalle, String valor, Date fecha) {
        this.id_gasto = id_gasto;
        this.tipo_gasto = tipo_gasto;
        this.detalle = detalle;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Mis_gastos() {
    }

    public Integer getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(Integer id_gasto) {
        this.id_gasto = id_gasto;
    }

    public String getTipo_gasto() {
        return tipo_gasto;
    }

    public void setTipo_gasto(String tipo_gasto) {
        this.tipo_gasto = tipo_gasto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
