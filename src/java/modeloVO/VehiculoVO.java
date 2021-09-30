/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author user
 */
public class VehiculoVO {
    
    private String vehPlaca, datID, catID, vehModelo, vehMarca, vehEstado, vehPrecio;

    public VehiculoVO(String vehPlaca, String datID, String catID, String vehModelo, String vehMarca, String vehEstado, String vehPrecio) {
        this.vehPlaca = vehPlaca;
        this.datID = datID;
        this.catID = catID;
        this.vehModelo = vehModelo;
        this.vehMarca = vehMarca;
        this.vehEstado = vehEstado;
        this.vehPrecio = vehPrecio;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getDatID() {
        return datID;
    }

    public void setDatID(String datID) {
        this.datID = datID;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(String vehEstado) {
        this.vehEstado = vehEstado;
    }

    public String getVehPrecio() {
        return vehPrecio;
    }

    public void setVehPrecio(String vehPrecio) {
        this.vehPrecio = vehPrecio;
    }
    
    
    
}
