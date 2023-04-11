
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyGreeting extends Stage {
    private String contestantName;
    private Text txtId, txtName,txtEmpty,txtEmpty2,labCountry,txtGreet,txtName2;
    private RadioButton button1,button2,button3,button4,button5;
    private ToggleGroup buttonGroup;
    private MediaPlayer mdPlayer2;
    private ImageView Img1;
    private Boolean mediaStop;
    Scene scene1,scene2;

    public MyGreeting() {
        
        /* Create Label */
        txtEmpty = new Text();
        txtEmpty2 = new Text();
        labCountry = new Text("Please Select Your Country: ");
        txtId = new Text();
        txtName = new Text();
        txtName2 = new Text();
        txtGreet = new Text("Welcome Back,");
        
        /* Text Font Import */ 
        Font Itim = Font.loadFont("file:data\\Itim.ttf", 25);

        /* Text Format */
        txtEmpty.setFont(Itim);
        txtEmpty2.setFont(Itim);
        labCountry.setFont(Itim);
        txtId.setFont(Itim);
        txtName.setFont(Itim);
        txtName2.setFont(Itim);
        txtGreet.setFont(Itim);
        
        /* Text Colour */
        txtEmpty.setFill(Color.WHITE);
        txtEmpty2.setFill(Color.WHITE);
        labCountry.setFill(Color.WHITE);
        txtId.setFill(Color.WHITE);
        txtName.setFill(Color.WHITE);
        txtName2.setFill(Color.WHITE);
        txtGreet.setFill(Color.WHITE);
        
        /* Text Position */
        txtEmpty.setX(450);
        txtEmpty.setY(125);
        txtEmpty2.setX(100);
        txtEmpty2.setY(270);
        labCountry.setX(325);
        labCountry.setY(225);
        txtId.setX(400);
        txtId.setY(100);
        txtName.setX(360);
        txtName.setY(150);
        txtName2.setX(525);
        txtName2.setY(125);
        txtGreet.setX(350);
        txtGreet.setY(125);
        
        /* Background Location */
        File Background = new File("data\\BgGreeting.jpg");
        Image Bgimg = new Image(Background.toURI().toString());
        ImageView Bgimage = new ImageView(Bgimg);
        
        /* Background2 Location */
        File Background2 = new File("data\\BgGreeting.jpg");
        Image Bgimg2 = new Image(Background2.toURI().toString());
        ImageView Bgimage2 = new ImageView(Bgimg2);
      
        /* Background Position */
        Bgimage.setFitHeight(700);
        Bgimage.setFitWidth(1000);
        
        Bgimage2.setFitHeight(700);
        Bgimage2.setFitWidth(1000);
    
        /* Create RadioButton */
        button1 = new RadioButton("Greece");
        button2 = new RadioButton("San Marino");
        button3 = new RadioButton("Germany");
        button4 = new RadioButton("Guinea-Bissau");
        button5 = new RadioButton("Iraq");
        buttonGroup = new ToggleGroup();
        button1.setToggleGroup(buttonGroup);
        button2.setToggleGroup(buttonGroup);
        button3.setToggleGroup(buttonGroup);
        button4.setToggleGroup(buttonGroup);
        button5.setToggleGroup(buttonGroup);
        
        /* RadioButton Text Format */
        button1.setFont(Font.font("Itim",15));
        button2.setFont(Font.font("Itim",15));
        button3.setFont(Font.font("Itim",15));
        button4.setFont(Font.font("Itim",15));
        button5.setFont(Font.font("Itim",15));
        
        /* RadioButton Text Colour */
        button1.setStyle("-fx-text-fill:#ffffff;");
        button2.setStyle("-fx-text-fill:#ffffff;");
        button3.setStyle("-fx-text-fill:#ffffff;");
        button4.setStyle("-fx-text-fill:#ffffff;");
        button5.setStyle("-fx-text-fill:#ffffff;");
        
        /* RadioButton Position */
        button1.setLayoutX(415);
        button1.setLayoutY(300);
        button2.setLayoutX(415);
        button2.setLayoutY(330);
        button3.setLayoutX(415);
        button3.setLayoutY(360);
        button4.setLayoutX(415);
        button4.setLayoutY(390);
        button5.setLayoutX(415);
        button5.setLayoutY(420);
        

        /* Picture of the contestant */
        Img1 = new ImageView();
        Img1.setImage(null);
        Img1.setLayoutX(325);
        Img1.setLayoutY(150);
        Img1.setFitHeight(300);
        Img1.setFitWidth(300);

        /* Button */
        Button btnDone = new Button("Done");
        btnDone.setTranslateX(400);
        btnDone.setTranslateY(480);
        btnDone.setStyle("-fx-pref-width: 150px; -fx-pref-height: 30px");
        btnDone.setOnAction(e -> {

            if(button1.isSelected())
            {

                MyParam.setCountry("Greece");
                String musicFile = "data/Greece_NA.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                mdPlayer2 = new MediaPlayer(sound);
                mdPlayer2.play();
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                    pw.print("Greece:");
                    pw.close();

                }
                catch (IOException f) {
                    System.out.println("Error");
                    f.printStackTrace();
                }
            }
            else if(button2.isSelected())
            {
                MyParam.setCountry("San Marino");
                String musicFile = "data/SanMarino_NA.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                mdPlayer2 = new MediaPlayer(sound);
                mdPlayer2.play();
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                    pw.print("San Marino:");
                    pw.close();

                }
                catch (IOException f) {
                    System.out.println("Error");
                    f.printStackTrace();
                }

            }
            else if(button3.isSelected())
            {
                MyParam.setCountry("Germany");
                String musicFile = "data/Germany_NA.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                mdPlayer2 = new MediaPlayer(sound);
                mdPlayer2.play();
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                    pw.print("Germany:");
                    pw.close();

                }
                catch (IOException f) {
                    System.out.println("Error");
                    f.printStackTrace();
                }

            }
            else if(button4.isSelected())
            {
                MyParam.setCountry("Guinea-Bissau");
                String musicFile = "data/GuineaBissau_NA.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                mdPlayer2 = new MediaPlayer(sound);
                mdPlayer2.play();
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                    pw.print("Guinea-Bissau:");
                    pw.close();

                }
                catch (IOException f) {
                    System.out.println("Error");
                    f.printStackTrace();
                }
            }
            else if(button5.isSelected())
            {
                MyParam.setCountry("Iraq");
                String musicFile = "data/Iraq_NA.mp3";
                Media sound = new Media(new File(musicFile).toURI().toString());
                mdPlayer2 = new MediaPlayer(sound);
                mdPlayer2.play();
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                    pw.print("Iraq:");
                    pw.close();

                }
                catch (IOException f) {
                    System.out.println("Error");
                    f.printStackTrace();
                }
            }
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                pw.print(contestantName+":");
                pw.close();

            }
            catch (IOException f) {
                System.out.println("Error");
                f.printStackTrace();
            }



            /* Contestant picture */
            File pFileA = new File("data/"+contestantName+".jpg");
            Image imgA = new Image(pFileA.toURI().toString());
            Img1.setImage(imgA);


            MyParam.setName2(txtName.getText());
            this.setScene(scene2);
            mdPlayer2.setOnEndOfMedia(()->this.hide());

        });

        Button btnGo = new Button("Start Test");
        btnGo.setTranslateX(400);
        btnGo.setTranslateY(480);
        btnGo.setStyle("-fx-pref-width: 150px; -fx-pref-height: 30px");
        btnGo.setOnAction(e -> {
            mdPlayer2.pause();
            this.hide();
        });
        
        /* Scene Display */
        Group root1 = new Group(Bgimage,txtId, txtName,txtEmpty,labCountry,txtEmpty2,button1,button2,button3,button4,button5, btnDone);
        scene1 = new Scene(root1, 1000, 700, Color.BEIGE);
        this.setTitle("MAMAT Battle Royale Knowledge Contest");
        this.setResizable(false);
        this.setScene(scene1);
        
        Group root2 = new Group(Bgimage2,btnGo,txtGreet,txtName2,Img1);
        scene2 = new Scene(root2, 1000, 700, Color.BEIGE);
        this.setTitle("MAMAT Battle Royale Knowledge Contest");
        this.setResizable(false);

    }

    public String getName() {
        return txtName.getText();
    }
    public void setContestantName(String s){contestantName = s;

    txtName.setText("Name: "+contestantName);
    txtName2.setText(contestantName);}

    public void setContestantId(String d){
        txtId.setText("ID: "+d);}



}