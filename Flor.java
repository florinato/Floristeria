package Floristeria;

public class Flor extends Producto  {
    private static final long serialVersionUID = 1L;
    protected String color;
    public Flor(){
        
    }
    public Flor(double precio, String color) {
        super(precio);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flor [precio=" + precio + ", color=" + color + "]";
    }
    
}
