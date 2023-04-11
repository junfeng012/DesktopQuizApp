
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyResult extends Stage {

    /* Creating Private Objects */
    private Pane paneR;
    private Text greeting,labConName, conName, labConCountry, conCountry,overall,percentage,labConAns, labCorrectAns, labEmpty, SwitchCharc;
    private final MediaPlayer mdPlayer;
    private Button btnSwitch;
    private ComboBox comBox1, comBox2, comBoxName;
    private File myAnsFile = new File("data","mamatresult.txt");
    private File myConInfoFile = new File("data", "ContestantInfo.txt");
    private File myQuesFile = new File("data", "mamat.txt");
    private int quesTotal;

    public MyResult() {
        
        /* Each question results */
        comBox1 = new ComboBox();
        comBox2 = new ComboBox();
        comBoxName = new ComboBox();
        
        /* ComBox positioning */
        comBox1.setLayoutX(230);
        comBox1.setLayoutY(425);
        comBox2.setLayoutX(565);
        comBox2.setLayoutY(425);
        comBoxName.setLayoutX(300);
        comBoxName.setLayoutY(535);
        
        /* ChoiceBox Length */
        comBox1.setPrefWidth(200);
        comBox2.setPrefWidth(200);
        comBoxName.setPrefWidth(250);
        
        /* Create Labeling */
        greeting = new Text();
        labConName = new Text();
        conName = new Text();
        labConCountry = new Text();
        conCountry = new Text();
        overall = new Text();
        percentage = new Text();
        labConAns = new Text();
        labCorrectAns = new Text();
        labEmpty = new Text();
        SwitchCharc = new Text();
        
        /* Button (Exit Application) */
        Button btnExit = new Button("High Score");
        btnExit.setStyle("-fx-pref-width: 150px; -fx-pref-height: 30px");
        btnExit.setTranslateX(450);
        btnExit.setTranslateY(650);
        btnExit.setOnAction(e -> {
            this.close();
        });


        /* Button (Display Results) */

        Button btnSwitch = new Button("Show Contestant");
        btnSwitch.setTranslateX(600);
        btnSwitch.setTranslateY(535);
        btnSwitch.setOnAction(e -> {
            changeContestant();
            getAnsFromFile();
        });
        
        /* Text Font Import */ 
        Font Itim = Font.loadFont("file:data\\Itim.ttf", 20);

        /* Text Format */
        greeting.setFont(Font.font("Itim",FontWeight.BOLD,50));
        labConName.setFont(Font.font("Itim",22));
        conName.setFont(Font.font("Itim",22));
        labConCountry.setFont(Font.font("Itim",22));
        conCountry.setFont(Font.font("Itim",22));
        overall.setFont(Itim);
        percentage.setFont(Itim);
        labConAns.setFont(Itim);
        labCorrectAns.setFont(Itim);
        labEmpty.setFont(Font.font("Itim",18));
        SwitchCharc.setFont(Itim);
        
        /* Text Colour */
        greeting.setFill(Color.WHITE);
        labConName.setFill(Color.WHITE);
        conName.setFill(Color.WHITE);
        labConCountry.setFill(Color.WHITE);
        conCountry.setFill(Color.WHITE);
        overall.setFill(Color.WHITE);
        percentage.setFill(Color.WHITE);
        labConAns.setFill(Color.WHITE);
        labCorrectAns.setFill(Color.WHITE);
        labEmpty.setFill(Color.WHITE);
        SwitchCharc.setFill(Color.WHITE);
        
        /* Text Positioning */
        greeting.setX(400);
        greeting.setY(100);
        labConName.setX(350);
        labConName.setY(175);
        conName.setX(520);
        conName.setY(175);
        labConCountry.setX(430);
        labConCountry.setY(225);
        conCountry.setX(520);
        conCountry.setY(225);
        overall.setX(385);
        overall.setY(275);
        percentage.setX(410);
        percentage.setY(325);
        labConAns.setX(200);
        labConAns.setY(400);
        labCorrectAns.setX(550);
        labCorrectAns.setY(400);
        labEmpty.setX(325);
        labEmpty.setY(600);
        SwitchCharc.setX(325);
        SwitchCharc.setY(515);
        
        /* Play Music from mp3 */
        String musicFile = "data/Tada.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mdPlayer = new MediaPlayer(sound);
        
        /* Background Location */
        File Background = new File("data\\BackgroundResults.jpg");
        Image Bgimg = new Image(Background.toURI().toString());
        ImageView Bgimage = new ImageView(Bgimg);
    
        /* Background Position */
        Bgimage.setFitHeight(700);
        Bgimage.setFitWidth(1000);


        /* Stage Setting */
        Group root = new Group(Bgimage,greeting,labConName,conName,labConCountry,conCountry,overall,percentage,labEmpty,comBoxName,comBox1,SwitchCharc,labConAns,btnSwitch,btnExit,labCorrectAns,comBox2);
        Scene scene = new Scene(root, 1000, 700, Color.BEIGE);
        this.setTitle("MAMAT Battle Royale Knowledge Contest");
        this.setResizable(false);
        this.setScene(scene);
    }

    /* Execute part */
    public void showStage() {
        mdPlayer.play();
        quesTotal = getQuesTotal();
        getConInfo();
        getAnsFromFile();
        getCorAnsFromFile();
        this.show();
    }


    /* Text */
    public void setName(String name) {
        greeting.setText("Results");
        labConName.setText("Candidate Name: ");
        conName.setText(name);
        labConCountry.setText("Country: ");
        conCountry.setText(MyParam.getCountry());
        overall.setText("Overall Marks:   ");
        percentage.setText("Percentage:   ");
        SwitchCharc.setText("Show other contestant's results here!!");
        labConAns.setText("Showing Contestant's Answers");
        labCorrectAns.setText("Showing Correct Answers");
    }

    /* Add all contestant details to a combo box */
    public void getConInfo() {
        Scanner sfile;
        String cName;
        String cCountry;
        String aLine;
        Scanner sline;
        int conNo = 1;

        try {
            sfile = new Scanner(myConInfoFile);

            while (sfile.hasNextLine()) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNextLine()) {
                    cCountry = sline.next();
                    cName = sline.next();
                    sline.next();
                    sline.next();
                    String s = conNo + ". "+ cName + " (" + cCountry + ") ";
                    comBoxName.getItems().add(s);
                    conNo++;
                }
                sline.close();
            }
            sfile.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myAnsFile + " not found!");
        }
    }

    /* Switch Contestant/View Other Contestants Results */
    public void changeContestant(){
        boolean checkEmpty;
        checkEmpty = comBoxName.getSelectionModel().isEmpty();
        if (checkEmpty == true) {
            labEmpty.setText("Choose a contestant first.");
        } else {
            int choice = comBoxName.getSelectionModel().getSelectedIndex();
            choice += 1;

            Scanner sfile;
            String aLine;
            Scanner sline;
            String cName;
            String cCountry;
            try {
                sfile = new Scanner(myConInfoFile);
                for (int k = 1; k < choice; k++) {
                    sfile.nextLine();
                }
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNextLine()) {
                    cCountry = sline.next();
                    cName = sline.next();
                    sline.next();
                    sline.next();
                    conName.setText(cName);
                    conCountry.setText(cCountry);


                }
                sline.close();
                sfile.close();

            }
            catch (FileNotFoundException e) {
                System.out.println("File to read " + myAnsFile + " not found!");
            }
            labEmpty.setText("Switched to Contestant " + conName.getText() +  "(" + conCountry.getText() + ")" + " Result.");
        }
    }


    /* Find the position of the current/chosen contestant in the file */
    public int getConNo() {
        Scanner sfile;
        String aLine;
        Scanner sline;
        int conNo = 1;
        String cName = "";
        String cCountry = "";
        try {
            sfile = new Scanner(myConInfoFile);

            while (sfile.hasNextLine()) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNextLine()) {
                    cCountry = sline.next();
                    cName = sline.next();
                    sline.next();
                    sline.next();
                    if ( (cName.equals(conName.getText())) && (cCountry.equals(conCountry.getText())) ) {
                        break;
                    }
                    conNo++;
                }
                sline.close();
                if ( (cName.equals(conName.getText())) && (cCountry.equals(conCountry.getText())) ) {
                    break;
                }
            }
            sfile.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myAnsFile + " not found!");
        }
        return conNo;
    }


    /* Get the chosen contestant's answers from the file */
    public void getAnsFromFile() {
        int choice;
        choice = getConNo();

        int correctTotal;
        int score;
        correctTotal = getCorTotalFromFile(choice);
        score = correctTotal*100/quesTotal;
        overall.setText("Overall Marks: " + correctTotal + " / " + quesTotal);
        percentage.setText("Percentage: " + score + "%");

        Scanner sfile;
        int totquestions = quesTotal;
        String conAns;
        String aLine;
        Scanner sline;

        comBox1.getItems().clear();
        try {
            sfile = new Scanner(myAnsFile);
            sfile.nextLine(); //to skip the empty line at the start
            for (int k = 1; k < choice; k++) {
                sfile.nextLine();
            }
            aLine = sfile.nextLine();
            sline = new Scanner(aLine);
            sline.useDelimiter(":");
            for (int k = 1; k <= totquestions; k++) {
                conAns = sline.next();
                String s = k + ". " + conAns;
                comBox1.getItems().add(s);
            }
            sline.close();
            sfile.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myAnsFile + " not found!");
        }

    }

    /* Get the chosen contestant's total correct answers from the file */
    public int getCorTotalFromFile(int c) {
        Scanner sfile;
        String aLine;
        Scanner sline;
        int correctTotal = 0;
        try {
            sfile = new Scanner(myConInfoFile);

            for (int k = 1; k < c; k++) {
                sfile.nextLine();
            }
            aLine = sfile.nextLine();
            sline = new Scanner(aLine);
            sline.useDelimiter(":");
            while (sline.hasNextLine()) {
                sline.next();
                sline.next();
                correctTotal = Integer.parseInt(sline.next());
                sline.next();
            }
            sline.close();
            sfile.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myConInfoFile + " not found!");
        }
        return correctTotal;
    }

    /* Get the total number of questions from the question file */
    public int getQuesTotal() {
        Scanner sfile;
        int qTotal = 0;
        try {
            sfile = new Scanner(myQuesFile);
            qTotal = Integer.parseInt(sfile.nextLine());
            sfile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myQuesFile + " not found!");
        }
        return qTotal;
    }

    /* Get the correct answers from the question file */
    public void getCorAnsFromFile() {
        Scanner sfile;
        String aLine;
        Scanner sline;
        char quesAns;
        int quesNo = 1;
        int type;
        quesTotal = 25;

        try {
            sfile = new Scanner(myQuesFile);
            sfile.nextLine();
            for (int k = 1; k <= quesTotal; k++) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                while (sline.hasNextLine()) {
                    type = Integer.parseInt(sline.next());
                    quesAns = sline.next().charAt(0);
                    if (type == 2)
                        sline.next();
                    sline.next();
                    sline.next();
                    sline.next();
                    sline.next();
                    sline.next();
                    String s = quesNo + ". " + quesAns;
                    comBox2.getItems().add(s);
                    quesNo++;
                }
                sline.close();
            }
            sfile.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myAnsFile + " not found!");
        }
    }
}