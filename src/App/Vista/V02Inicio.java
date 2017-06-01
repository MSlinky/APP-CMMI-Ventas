package App.Vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class V02Inicio implements Initializable {
    
    @FXML
    private boolean NewClient(ActionEvent event) throws IOException {
        Parent inicio = FXMLLoader.load(getClass().getResource("RegistrarCliente.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(inicio);

        stage.setScene(scene);
        stage.setTitle("Registrar");
        stage.setX(50);
        stage.setY(50);
        stage.show();
        
        return false;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
