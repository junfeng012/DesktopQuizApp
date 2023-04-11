
import java.io.File;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView; 
import javafx.stage.Stage;

public class Menu extends Stage{ 
  
    public Menu(){ 
      
      /* Creating a Button */
      Button btnLogIn = new Button();
      Button btnExit = new Button();
      
      /* Button text */
      btnLogIn.setText("Log In");
      btnExit.setText("Exit");
      
      /* Button Size */
      btnLogIn.setStyle("-fx-pref-width: 300px; -fx-pref-height: 40px");
      btnExit.setStyle("-fx-pref-width: 300px; -fx-pref-height: 40px");
      
      /* Button Positioning */
      btnLogIn.setTranslateX(325);
      btnLogIn.setTranslateY(500);
      btnExit.setTranslateX(325);
      btnExit.setTranslateY(575);
      
      /* Button Event */
      btnLogIn.setOnAction(e -> {
        this.hide();
        });
      btnExit.setOnAction(e -> {
        System.exit(0);   
        });
      
      /* Logo Location*/
      File Image = new File("data\\Logo.png");
      Image Logo = new Image(Image.toURI().toString());
      
      /* Background Location */
      File Background = new File("data\\Background.jpg");
      Image Bgimg = new Image(Background.toURI().toString());
      ImageView Bgimage = new ImageView(Bgimg);
      
      /* Background Position */
      Bgimage.setFitHeight(700);
      Bgimage.setFitWidth(1000);
      
      /* Setting the Logo view */
      ImageView LogoView = new ImageView(Logo); 
      
      /* Logo Positioning */
      LogoView.setX(275); 
      LogoView.setY(200); 
      
      /* Logo height & width adjustment */
      LogoView.setFitHeight(300); 
      LogoView.setFitWidth(400); 
      
      /* Setting the preserve ratio */ 
      LogoView.setPreserveRatio(true);  
      
       /* Stage Setting */
      Group root = new Group(Bgimage,btnLogIn,btnExit,LogoView);
      Scene scene = new Scene(root, 1000, 700);
      this.setTitle("MAMAT Battle Royale Knowledge Contest");
      this.setResizable(false);
      this.setScene(scene);
      
    }
} 