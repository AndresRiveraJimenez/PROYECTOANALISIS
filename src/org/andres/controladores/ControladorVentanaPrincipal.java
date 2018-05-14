/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andres.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.andres.sistema.Principal;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author d5
 */
public class ControladorVentanaPrincipal implements Initializable {
    
    @FXML private ImageView imgFondo;
    private Principal escenarioPrincipal;
    private TrayNotification tray = new TrayNotification();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transiciones();
    }
       public void transiciones(){
       FadeTransition trancicion = new FadeTransition(Duration.seconds(2), imgFondo);
       trancicion.setFromValue(1.0);
       trancicion.setToValue(0.01);
       trancicion.setCycleCount(2);
       trancicion.setAutoReverse(true);
       trancicion.play();
 
    }
        public void testMensaje(){
                String title = "Bienvenido";
                String message = "Aplicacion para boletas!";
                NotificationType notification = NotificationType.SUCCESS;
                AnimationType animacion = AnimationType.POPUP;
                    tray.setTray(title, message, notification);
                    tray.showAndDismiss(Duration.seconds(3));
             
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    public void mostrarClientes(){
        escenarioPrincipal.ventanaClientes();
    }   
    public void cerrar(){
        escenarioPrincipal.cerrar();
    }
}
