package App.Vista;

import App.Controlador.Validar;
import App.Controlador.PeticionPost;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import org.json.simple.parser.ParseException;
import javafx.stage.Stage;

public class V05RegistrarProducto implements Initializable {
    
    @FXML
    private JFXTextField txt_nombrePro, txt_descripcionPro, txt_codigoPro, txt_precioPro, txt_cantidadPro;

    @FXML
    private boolean RegistrarCliente(ActionEvent event) throws MalformedURLException, UnsupportedEncodingException, IOException, ParseException {
        
        Validar objValidar = new Validar();
        boolean aceptar = true;
        
        txt_nombrePro.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_descripcionPro.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_codigoPro.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_precioPro.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_cantidadPro.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        
        if(!objValidar.checkText(txt_nombrePro.getText())){
            txt_nombrePro.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_descripcionPro.getText())){
            txt_descripcionPro.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkCant(txt_precioPro.getText())){
            txt_precioPro.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkNum(txt_cantidadPro.getText())){
            txt_cantidadPro.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }
        
        if(aceptar == false){
            return aceptar;
        }
        
        //Realizar peticion al servidor, validar datos en la base de datos.
        PeticionPost post = new PeticionPost ();
        post.add("accion", "RegProducto");
        post.add("nombrePro", txt_nombrePro.getText());        
        post.add("descripcionPro", txt_descripcionPro.getText());
        post.add("codigoPro", txt_codigoPro.getText());
        post.add("precioPro", txt_precioPro.getText());
        post.add("cantidadPro", txt_cantidadPro.getText());
        
        //Convertir cadena que responde en servidor en un objeto
        String respuesta = post.getRespueta();
        System.out.println(respuesta);
        if(respuesta.equals("1")){
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }else{
            System.out.println("No guardar");
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
