package App.Vista;

import App.Controlador.Producto;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class V02Inicio implements Initializable {
    @FXML public TableView<Producto> table;
    @FXML public TableColumn colum_carrito;
    @FXML public TableColumn colum_boton;
    @FXML public TableColumn colum_cantidad;
    @FXML public TableColumn colum_precio;
    @FXML public TableColumn colum_inventario;
    
    static ObservableList<Producto> data;
    
    public boolean cargarCarro(Producto add){
        Producto p1 = new Producto(add.id, add.producto, new Spinner<Integer>(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, add.getInventario(), 1)), String.valueOf(add.getInventario()), add.precio, new Button("Eliminar"));
        data.add(p1);
        return true; 
    }
    
    public boolean abrirVentana(String nameFile, String name) throws IOException{
        Parent inicio = FXMLLoader.load(getClass().getResource(nameFile));
        Stage stage = new Stage();
        Scene scene = new Scene(inicio);

        stage.setScene(scene);
        stage.setTitle(name);
        stage.setX(50);
        stage.setY(50);
        stage.show();
        
        return true;
    }
    
    @FXML
    private boolean NewClient(ActionEvent event) throws IOException{
        abrirVentana("04RegistrarCliente.fxml", "Registrar cliente");
        return false;
    }
    
    @FXML
    private boolean NewProductos(ActionEvent event) throws IOException {
        abrirVentana("05RegistrarProducto.fxml", "Registrar producto");
        return true;
    }
    
    @FXML
    private boolean SelectProductos(ActionEvent event) throws IOException {
        abrirVentana("03Productos.fxml", "Productos");
        return true;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colum_carrito.prefWidthProperty().bind(table.widthProperty().multiply(0.59));
        colum_boton.prefWidthProperty().bind(table.widthProperty().multiply(0.10));
        colum_cantidad.prefWidthProperty().bind(table.widthProperty().multiply(0.10));
        colum_precio.prefWidthProperty().bind(table.widthProperty().multiply(0.10));
        colum_inventario.prefWidthProperty().bind(table.widthProperty().multiply(0.10));
        
        colum_carrito.setCellValueFactory(new PropertyValueFactory("producto"));
        colum_boton.setCellValueFactory(new PropertyValueFactory("button"));
        colum_cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        colum_precio.setCellValueFactory(new PropertyValueFactory("precio"));
        colum_inventario.setCellValueFactory(new PropertyValueFactory("inventario"));
        
        data = FXCollections.observableArrayList();
        table.setItems(data);
        
        
    }    
}
