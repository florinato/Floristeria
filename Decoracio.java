package Floristeria;

public class Decoracio extends Producto  {
    private static final long serialVersionUID = 1L;
    protected String tipoMaterial; // fusta o plàstic
    public Decoracio(){
        
    }
    public Decoracio(double precio, String tipoMaterial) {
        super(precio);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public String toString() {
        return "Decoracio [precio=" + precio + ", tipoMaterial=" + tipoMaterial + "]";
    }

}
