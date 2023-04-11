
import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Winner extends Stage {

    /* Declare Private Objects */
    private Label Results,winner,Name1,Name2,Country,score1,score2,Glabel,Gelabel,Gulabel,Slabel,Ilabel,GlabelScore,GelabelScore,GulabelScore,SlabelScore,IlabelScore;
    private int Gscore,Sscore,Gescore,Guscore,Iscore;
    private int Gtemp1,Gtemp2,Stemp1,Stemp2,Getemp1,Getemp2,Gutemp1,Gutemp2,Itemp1,Itemp2 = 0;
    private int tmpW ,contestant= 0;
    private int score = 0;
    private int winScore1,winScore2 = 0;
    private String Gname1,Gname2,Sname1,Sname2,Gename1,Gename2,Guname1,Guname2,Iname1,Iname2 = "";
    private int top,top1,Gtop,Getop,Gutop,Stop,Itop = 0;
    int g,gu ,ge,s,i = 0;
    private File ContestantInfo = new File("data","ContestantInfo.txt");
    private File contestants = new File("data","contestants.txt");
    private String win1,win2 = "";
    private String winCountry = "";
    private String Image1,Image2;
    private String country, name,id,ran = "";
    private ImageView winImg1,winImg2;
    private final MediaPlayer mdPlayer;


    public Winner() {
        checkFromFile();
        checkWinner();
        checkPicture();
        
        /* Create Labeling */
        // Results Label
        Results = new Label ("High Score");
        Results.setTranslateX(400);
        Results.setTranslateY(50);
        
        // Winnder Label
        winner = new Label("Winner:");
        winner.setTranslateX(400);
        winner.setTranslateY(150);

        // Name1 Label
        Name1 = new Label();
        Name1.setText(win1);
        Name1.setTranslateX(390);
        Name1.setTranslateY(320);

        // Name2 Label
        Name2 = new Label();
        Name2.setText(win2);
        Name2.setTranslateX(590);
        Name2.setTranslateY(320);

        // Winning Country Label
        Country = new Label();
        Country.setText(winCountry);
        Country.setTranslateX(515);
        Country.setTranslateY(150);

        // Name1 Winning Correct Answer Label
        score1 = new Label();
        score1.setText("Correct Answer: "+Integer.toString(winScore1));
        score1.setTranslateX(335);
        score1.setTranslateY(350);

        // Name2 Winning Correct Answer Label
        score2 = new Label();
        score2.setText("Correct Answer: "+Integer.toString(winScore2));
        score2.setTranslateX(535);
        score2.setTranslateY(350);



        
        /* Set Image */
        // Name1 image
        winImg1 = new ImageView();
        File pFileA = new File("data/"+Image1);
        Image imgA = new Image(pFileA.toURI().toString());
        winImg1.setImage(null);
        winImg1.setImage(imgA);

        // Name2 image
        winImg2 = new ImageView();
        File pFileB = new File("data/"+Image2);
        Image imgB = new Image(pFileB.toURI().toString());
        winImg2.setImage(null);
        winImg2.setImage(imgB);

        /* Image Positioning */
        // Image 1 (Name1)
        winImg1.setTranslateX(355);
        winImg1.setTranslateY(210);
        winImg1.setFitHeight(100);
        winImg1.setFitWidth(125);
        
        //Image 2 (Name2)
        winImg2.setTranslateX(555);
        winImg2.setTranslateY(210);
        winImg2.setFitHeight(100);
        winImg2.setFitWidth(125);

        /* Other Country Scoreing System */
        // Greece
        Glabel = new Label("Greece");
        Glabel.setTranslateX(345);
        Glabel.setTranslateY(415);

        GlabelScore = new Label();
        GlabelScore.setText("Total Correct Answer: "+Integer.toString(Gscore));
        GlabelScore.setTranslateX(495);
        GlabelScore.setTranslateY(415);

        // Germany
        Gelabel = new Label("Germany");
        Gelabel.setTranslateX(345);
        Gelabel.setTranslateY(435);

        GelabelScore = new Label();
        GelabelScore.setText("Total Correct Answer: "+Integer.toString(Gescore));
        GelabelScore.setTranslateX(495);
        GelabelScore.setTranslateY(435);

        // Guinea-Bissau
        Gulabel = new Label("Guinea-Bissau");
        Gulabel.setTranslateX(345);
        Gulabel.setTranslateY(455);

        GulabelScore = new Label();
        GulabelScore.setText("Total Correct Answer: "+Integer.toString(Guscore));
        GulabelScore.setTranslateX(495);
        GulabelScore.setTranslateY(455);

        // San Marino
        Slabel = new Label("San Marino");
        Slabel.setTranslateX(345);
        Slabel.setTranslateY(475);

        SlabelScore = new Label();
        SlabelScore.setText("Total Correct Answer: "+Integer.toString(Sscore));
        SlabelScore.setTranslateX(495);
        SlabelScore.setTranslateY(475);

        // Iraq
        Ilabel = new Label("Iraq");
        Ilabel.setTranslateX(345);
        Ilabel.setTranslateY(495);

        IlabelScore = new Label();
        IlabelScore.setText("Total Correct Answer: "+Integer.toString(Iscore));
        IlabelScore.setTranslateX(495);
        IlabelScore.setTranslateY(495);

        /* Button (Exit Application) */
        Button btnExit = new Button("Close");
        btnExit.setTranslateX(750);
        btnExit.setTranslateY(600);
        btnExit.setStyle("-fx-pref-width: 150px; -fx-pref-height: 30px");
        btnExit.setOnAction(e -> {
            System.exit(0);
        });
        
        /* Text Font Import */ 
        Font Itim = Font.loadFont("file:data\\Itim.ttf", 18);

        /* Text Format */
        Results.setFont(Font.font("Itim",50));
        winner.setFont(Font.font("Itim",30));
        Country.setFont(Font.font("Itim",30));
        Name1.setFont(Itim);
        Name2.setFont(Itim);
        score1.setFont(Itim);
        score2.setFont(Itim);
        Glabel.setFont(Font.font("Itim",20));
        Gelabel.setFont(Font.font("Itim",20));
        Gulabel.setFont(Font.font("Itim",20));
        Slabel.setFont(Font.font("Itim",20));
        Ilabel.setFont(Font.font("Itim",20));
        GlabelScore.setFont(Font.font("Itim",20));
        GelabelScore.setFont(Font.font("Itim",20));
        GulabelScore.setFont(Font.font("Itim",20));
        SlabelScore.setFont(Font.font("Itim",20));
        IlabelScore.setFont(Font.font("Itim",20));
        
        /* Text Colour */
        Results.setStyle("-fx-text-fill: WHITE");
        winner.setStyle("-fx-text-fill: WHITE");
        Country.setStyle("-fx-text-fill: WHITE");
        Name1.setStyle("-fx-text-fill: WHITE");
        Name2.setStyle("-fx-text-fill: WHITE");
        score1.setStyle("-fx-text-fill: WHITE");
        score2.setStyle("-fx-text-fill: WHITE");
        Glabel.setStyle("-fx-text-fill: WHITE");
        Gelabel.setStyle("-fx-text-fill: WHITE");
        Gulabel.setStyle("-fx-text-fill: WHITE");
        Slabel.setStyle("-fx-text-fill: WHITE");
        Ilabel.setStyle("-fx-text-fill: WHITE");
        GlabelScore.setStyle("-fx-text-fill: WHITE");
        GelabelScore.setStyle("-fx-text-fill: WHITE");
        GulabelScore.setStyle("-fx-text-fill: WHITE");
        SlabelScore.setStyle("-fx-text-fill: WHITE");
        IlabelScore.setStyle("-fx-text-fill: WHITE");
        
        
        /* Background Location */
        File Background = new File("data\\ResultsBackground.jpg");
        Image Bgimg = new Image(Background.toURI().toString());
        ImageView Bgimage = new ImageView(Bgimg);
      
        /* Background Position */
        Bgimage.setFitHeight(700);
        Bgimage.setFitWidth(1000);

        /* Play Music from mp3 */
        String musicFile = "data/Tada.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mdPlayer = new MediaPlayer(sound);

        /* Positioning */        
        if(top == 1)
        {
            Group root = new Group(Bgimage,Results,winner,Name1,Country,score1,winImg1,Glabel,Gelabel,Gulabel,Slabel,Ilabel,GlabelScore,GelabelScore,GulabelScore,SlabelScore,IlabelScore,btnExit);
            Scene scene = new Scene(root, 1000, 700, Color.BEIGE);
            this.setTitle("MAMAT Winners");
            this.setResizable(false);
            this.setScene(scene);
        }
        if(top ==2)
        {
            Group root = new Group(Bgimage,Results,winner,Name1,Name2,Country,score1,score2,winImg1,winImg2,Glabel,Gelabel,Gulabel,Slabel,Ilabel,GlabelScore,GelabelScore,GulabelScore,SlabelScore,IlabelScore,btnExit);
            Scene scene = new Scene(root, 1000, 700, Color.BEIGE);
            this.setTitle("MAMAT Winners");
            this.setResizable(false);
            this.setScene(scene);
        }
    }
    
    /* Check who is the Winner */
    public void checkWinner(){
        for (int k = 1; k <= contestant; k++){
            tmpW = Gscore;
            winCountry = "Greece";
            winScore1 = Gtemp1;
            winScore2 = Gtemp2;
            top = Gtop;
            win1= Gname1;
            win2= Gname2;
            if (tmpW < Guscore){
                tmpW = Guscore;
                winCountry = "Guinea-Bissau";
                winScore1 = Gutemp1;
                winScore2 = Gutemp2;
                top = Gutop;
                win1= Guname1;
                win2= Guname2;
            }
            if (tmpW < Gescore){
                tmpW = Gescore;
                winCountry = "Germany";
                winScore1 = Getemp1;
                winScore2 = Getemp2;
                top = Getop;
                win1= Gename1;
                win2= Gename2;
            }
            if (tmpW < Iscore){
                tmpW = Iscore;
                winCountry = "Iraq";
                winScore1 = Itemp1;
                winScore2 = Itemp2;
                top = Itop;
                win1= Iname1;
                win2= Iname2;
            }
            if (tmpW < Sscore){
                tmpW = Sscore;
                winCountry = "San Marino";
                winScore1 = Stemp1;
                winScore2 = Stemp2;
                top = Stop;
                win1= Sname1;
                win2= Sname2;
            }

        }

    }

    /* File Checking */
    public void checkFromFile() {
        Scanner sfile;


        try {
            sfile = new Scanner(ContestantInfo);
            String aLine;
            Scanner sline;

            while (sfile.hasNextLine()) {
                contestant++;
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");

                country = sline.next();
                name = sline.next();
                score = Integer.parseInt(sline.next());
                ran = sline.next();

                if (country.equals("Greece")){
                    if(g == 1){
                        Gtop = 2;
                        Gtemp2 = score;
                        Gname2 = name;
                        Gscore = Gtemp1+Gtemp2;

                    }
                    else{
                        Gtop = 1;
                        g = 1;
                        Gname1 = name;
                        Gtemp1 = score;
                        Gscore = Gtemp1;

                    }
                }
                if (country.equals("Germany")){
                    if(ge == 1){
                        Getop = 2;
                        Getemp2 = score;
                        Gename2 = name;
                        Gescore = Getemp1+Getemp2;

                    }
                    else{
                        Getop = 1;
                        ge = 1;
                        Getemp1 = score;
                        Gename1 = name;
                        Gescore = Getemp1;

                    }
                }
                if (country.equals("Guinea-Bissau")){
                    if(gu == 1){
                        Gutop = 2;
                        Gutemp2 = score;
                        Guname2 = name;
                        Guscore = Gutemp1+Gutemp2;
                    }
                    else{
                        Gutop = 1;
                        gu = 1;
                        Guname1 = name;
                        Gutemp1 = score;
                        Guscore = Gutemp1;
                    }
                }
                if (country.equals("Iraq")){
                    if(i == 1){
                        Itop = 2;
                        Iname2 = name;
                        Itemp2 = score;
                        Iscore = Itemp1+Itemp2;
                    }
                    else{
                        Itop = 1;
                        i = 1;
                        Iname1 = name;
                        Itemp1 = score;
                        Iscore = Itemp1;
                    }
                }
                if (country.equals("San Marino")){
                    if(s == 1){
                        Stop = 2;
                        Sname2 = name;
                        Stemp2 = score;
                        Sscore = Stemp1+Stemp2;
                    }
                    else{
                        Stop = 1;
                        s = 1;
                        Sname1 = name;
                        Stemp1 = score;
                        Sscore = Stemp1;
                    }

                }

                sline.close();

            }
            sfile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + ContestantInfo + " not found!");
        }

    }

    /* Picture Checking from file */
    public void checkPicture() {
        Scanner sfile;
        int totmember = 0;
        String user = "";
        String password = "";
        String image = "";
        int tmpTop = top;
        try {
            sfile = new Scanner(contestants);
            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totmember = Integer.parseInt(sline.next());
            while ( tmpTop > 0) {

                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                id = sline.next();
                user = sline.next();
                password = sline.next();
                image = sline.next();

                if (user.equals(win1)){
                    Image1=image;
                    tmpTop--;
                }
                if (user.equals(win2)){
                    Image2=image;
                    tmpTop--;
                }
                sline.close();

            }
            sfile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + ContestantInfo + " not found!");
        }
    }

    /* Execute part */
    public void showStage() {
        mdPlayer.play();
        this.show();
    }
}