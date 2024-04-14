package Floristeria;

public class Arbre extends Producto  {
    private static final long serialVersionUID = 1L;
    protected double altura;
    public Arbre() {
        
    }

    public Arbre(double precio, double altura) {
        super(precio);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Arbre [precio=" + precio + ", altura=" + altura + "]";
    }

    
}
