package App.Controlador;

import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

public class Producto{
    public String id;
    public String producto;
    public double precio;
    private final Button button;
    private final Spinner<Integer> cantidad;
    private int inventario;

    public Producto(String id, String producto, Spinner cantidad, String inventario, double precio, Button button) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.button = button;
        this.inventario = Integer.parseInt(inventario);
    }
    
    public String getId() {            return id;}
    public String getProducto() {   return producto;}
    public Spinner getCantidad() {  return cantidad;}
    public int getInventario() {return inventario;}
    public String getPrecio() {     return "$ "+precio;}
    public Button getButton() {     return button;}   
}