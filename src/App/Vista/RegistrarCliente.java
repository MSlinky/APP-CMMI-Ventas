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

public class RegistrarCliente implements Initializable {
    
    @FXML
    private JFXTextField txt_nombre, txt_apellido, txt_calle, txt_numExt, txt_numInt, txt_estado, txt_municipio, txt_colonia, txt_CP, txt_email, txt_RFC;
    
    @FXML
    private boolean RegistrarCliente(ActionEvent event) throws MalformedURLException, UnsupportedEncodingException, IOException, ParseException {
        
        Validar objValidar = new Validar();
        boolean aceptar = true;
        
        txt_nombre.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_apellido.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_calle.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_numExt.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_estado.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_municipio.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_colonia.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_CP.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        txt_RFC.setStyle("-jfx-unfocus-color: #4d4d4d; -jfx-focus-color: #4059a9; -fx-text-fill: white");
        
        if(!objValidar.checkText(txt_nombre.getText())){
            txt_nombre.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_apellido.getText())){
            txt_apellido.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_calle.getText())){
            txt_calle.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_numExt.getText())){
            txt_numExt.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_municipio.getText())){
            txt_municipio.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_colonia.getText())){
            txt_colonia.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_CP.getText())){
            txt_CP.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_estado.getText())){
            txt_estado.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }else if(!objValidar.checkText(txt_RFC.getText())){
            txt_RFC.setStyle("-jfx-unfocus-color: red; -jfx-focus-color: red; -fx-text-fill: white");
            aceptar = false;
        }
        
        if(aceptar == false){
            return aceptar;
        }
        
        //Realizar peticion al servidor, validar datos en la base de datos.
        PeticionPost post = new PeticionPost ("https://cmmi-ventas.herokuapp.com/");
        post.add("accion", "RegCliente");
        post.add("nombre", txt_nombre.getText());        
        post.add("apellido", txt_apellido.getText());
        post.add("calle", txt_calle.getText());
        post.add("numExt", txt_numExt.getText());
        post.add("numInt", txt_numInt.getText());
        post.add("estado", txt_estado.getText());
        post.add("municipio", txt_municipio.getText());
        post.add("colonia", txt_colonia.getText());
        post.add("CP", txt_CP.getText());
        post.add("email", txt_email.getText());
        post.add("RFC", txt_RFC.getText());
        
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
