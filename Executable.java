import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.awt.Button;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/** Importation necessaire pour affichage d'ecran en  plus*/ 
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.awt.Button;

public class Executable extends Application {
    private Pane root;
    private Group caracteres;
    private GestionJeu gestionnaire;
    private int hauteurTexte;
    private int largeurCaractere;
    public static void main(String[] args) {
        launch(args);
    }

    private void afficherCaracteres(){
        caracteres.getChildren().clear();
        int hauteur = (int) root.getHeight();
        for( ChainePositionnee c : gestionnaire.getChaines().chaines)
        {
            Text t = new Text (c.x*largeurCaractere,hauteur - c.y*hauteurTexte, c.c);
            t.setFont(Font.font ("Monospaced", 10));
            caracteres.getChildren().add(t);
        }
    }

    private void lancerAnimation() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                    new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent actionEvent) {
                            gestionnaire.jouerUnTour();
                            afficherCaracteres();
                        }
                    }),
                new KeyFrame(Duration.seconds(0.025))// Donnee.vitesse ++ a chaque elem
                );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private Scene creeSceneImagee(String patch)
    {
        BorderPane pane = new BorderPane();
        ImageView img = new ImageView(patch);
        img.setFitHeight(Donnee.hauteurEcran*hauteurTexte);
        img.setFitWidth(Donnee.largeurEcran*largeurCaractere);
        pane.setCenter(img);
        return new Scene(pane,Donnee.largeurEcran*this.largeurCaractere,Donnee.hauteurEcran*this.hauteurTexte);
    }

    @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Star Wars Invaders");
            caracteres = new Group();
            root= new AnchorPane(caracteres);
            gestionnaire = new GestionJeu();
            Text t=new Text("█");
            t.setFont(Font.font("Monospaced",10));
            hauteurTexte =(int) t.getLayoutBounds().getHeight();
            largeurCaractere = (int) t.getLayoutBounds().getWidth();

            Scene scene_Principal = creeSceneImagee("images/Ecran_Principal.gif");
            Scene scene_Choix = creeSceneImagee("images/Choix_Mode.gif");
            Scene sceneJeu = new Scene(root,Donnee.largeurEcran*largeurCaractere,Donnee.hauteurEcran*hauteurTexte);

            scene_Principal.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                if(key.getCode()==KeyCode.ENTER)
                {
                    primaryStage.setScene(scene_Choix);
                }
            });
    
            scene_Choix.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                if(key.getCode()==KeyCode.S)
                {
                    primaryStage.setScene(sceneJeu);
                    lancerAnimation();
                }
            });
    
            sceneJeu.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                if(key.getCode()==KeyCode.LEFT)
                    gestionnaire.toucheGauche();
                if(key.getCode()==KeyCode.RIGHT)
                    gestionnaire.toucheDroite();
                if(key.getCode()==KeyCode.SPACE)
                    gestionnaire.toucheEspace();
                if(key.getCode()==KeyCode.ENTER)
                    gestionnaire.toucheEnter();
            });
            primaryStage.setScene(scene_Principal);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
}
