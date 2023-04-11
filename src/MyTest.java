
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyTest extends Application {

    private File myf = new File("data", "mamat.txt");
    private File myf2 = new File("data", "mamatresult.txt");
    private int totQues = 0;
    private int activeQ = 1;
    private int correctAns = 0;
    private Text labNameDesc,labIdDesc,labQuesNo, labQues,labId, labName,labCountry,labTimer;
    private ImageView imgQues,imgAnsA,imgAnsB,imgAnsC,imgAnsD,imgCountry;
    private Text labA, labB, labC,labD;
    private RadioButton radChoice1, radChoice2, radChoice3,radChoice4;
    private ToggleGroup grpChoices;
    private Button btnPrev, btnNext, btnSubmit;
    private Pane mainPane;
    private Pane paneC;
    private Scene mainScene;
    private MyGreeting winGreeting;
    private MyResult winFarewell;
    private Menu winMenu;
    private Login winLogin;
    private Winner winWinner;
    private Clock timer;
    private Timeline timeline;

    private LinkedList<Question> quesList = new LinkedList<Question>();

    public void start(Stage mainStage) {
        
        /* Apps Title Bar */
        mainStage.setTitle("MAMAT Battle Royale Knowledge Contest");
        mainStage.setResizable(false);
        
        /* Background Location */
        File Background = new File("data\\BgQuestion.jpeg");
        Image Bgimg = new Image(Background.toURI().toString());
        ImageView Bgimage = new ImageView(Bgimg);
        
        /* Background Position */
        Bgimage.setFitHeight(700);
        Bgimage.setFitWidth(1000);

        /* Label of ID */
        labIdDesc = new Text("ID:");
        labIdDesc.setLayoutX(120);
        labIdDesc.setLayoutY(115);

        /* ID Number */
        labId = new Text("");
        labId.setLayoutX(150);
        labId.setLayoutY(115);

        /* Label of Name */
        labNameDesc = new Text("Name:");
        labNameDesc.setLayoutX(120);
        labNameDesc.setLayoutY(140);

        /* Name */
        labName = new Text("");
        labName.setLayoutX(185);
        labName.setLayoutY(140);

        /* Country */
        labCountry = new Text("Country:");
        labCountry.setLayoutX(375);
        labCountry.setLayoutY(115);

        /* Timer */
        labTimer = new Text("Timer:");
        labTimer.setLayoutX(700);
        labTimer.setLayoutY(115);
        /*
        labTimer.setMinHeight(14);
        labTimer.setMinWidth(14); */

        /* Image of Country Flag */
        imgCountry = new ImageView();
        imgCountry.setLayoutX(470);
        imgCountry.setLayoutY(110);
        imgCountry.setFitHeight(50);
        imgCountry.setFitWidth(100);
        imgCountry.setImage(null);

        /* Question x÷25 */
        labQuesNo = new Text("");
        labQuesNo.setLayoutX(120);
        labQuesNo.setLayoutY(190);
        
        /* Questions */
        labQues = new Text("");
        labQues.setLayoutX(120);
        labQues.setLayoutY(220);

        /* Image of Question */
        imgQues = new ImageView();
        imgQues.setLayoutX(120);
        imgQues.setLayoutY(170);
        imgQues.setFitHeight(175);
        imgQues.setFitWidth(350);

        /* Radio Button A */
        labA = new Text("A");
        radChoice1 = new RadioButton("");
        imgAnsA = new ImageView();
        imgAnsA.setFitHeight(100);
        imgAnsA.setFitWidth(150);
        
        /* Radio Button B */
        labB = new Text("B");
        radChoice2 = new RadioButton("");
        imgAnsB = new ImageView();
        imgAnsB.setFitHeight(100);
        imgAnsB.setFitWidth(150);

        /* Radio Button C */
        labC = new Text("C");
        radChoice3 = new RadioButton("");
        imgAnsC = new ImageView();
        imgAnsC.setFitHeight(100);
        imgAnsC.setFitWidth(150);

        /* Radio Button D */
        labD = new Text("D");
        radChoice4 = new RadioButton("");
        imgAnsD = new ImageView();
        imgAnsD.setFitHeight(100);
        imgAnsD.setFitWidth(150);
        
        /* Text Font Import */ 
        Font Itim = Font.loadFont("file:data\\Itim.ttf", 20);

        /* Text Format */
        labIdDesc.setFont(Itim);
        labNameDesc.setFont(Itim);
        labQuesNo.setFont(Font.font("Itim", FontWeight.BOLD, 20));
        labQues.setFont(Itim);
        labId.setFont(Itim);
        labName.setFont(Itim);
        labCountry.setFont(Itim);
        labTimer.setFont(Itim);
        labA.setFont(Itim);
        labB.setFont(Itim);
        labC.setFont(Itim);
        labD.setFont(Itim);
        radChoice1.setFont(Itim);
        radChoice2.setFont(Itim);
        radChoice3.setFont(Itim);
        radChoice4.setFont(Itim);
        
        /* Text Colour */
        labIdDesc.setFill(Color.WHITE);
        labNameDesc.setFill(Color.WHITE);
        labQuesNo.setFill(Color.WHITE);
        labQues.setFill(Color.WHITE);
        labId.setFill(Color.WHITE);
        labName.setFill(Color.WHITE);
        labCountry.setFill(Color.WHITE);
        labTimer.setFill(Color.WHITE);
        labA.setFill(Color.WHITE);
        labB.setFill(Color.WHITE);
        labC.setFill(Color.WHITE);
        labD.setFill(Color.WHITE);
        radChoice1.setStyle("-fx-text-fill:#ffffff;");
        radChoice2.setStyle("-fx-text-fill:#ffffff;");
        radChoice3.setStyle("-fx-text-fill:#ffffff;");
        radChoice4.setStyle("-fx-text-fill:#ffffff;");
        
        /* Showing Screen */
        grpChoices = new ToggleGroup();

        radChoice1.setToggleGroup(grpChoices);
        radChoice2.setToggleGroup(grpChoices);
        radChoice3.setToggleGroup(grpChoices);
        radChoice4.setToggleGroup(grpChoices);
        paneC = new Pane();
        paneC.setLayoutX(25);
        paneC.setLayoutY(75);
        paneC.getChildren().add(imgQues);
        paneC.getChildren().add(labA);
        paneC.getChildren().add(radChoice1);
        paneC.getChildren().add(imgAnsA);
        paneC.getChildren().add(labB);
        paneC.getChildren().add(radChoice2);
        paneC.getChildren().add(imgAnsB);
        paneC.getChildren().add(labC);
        paneC.getChildren().add(radChoice3);
        paneC.getChildren().add(imgAnsC);
        paneC.getChildren().add(labD);
        paneC.getChildren().add(radChoice4);
        paneC.getChildren().add(imgAnsD);

        /* Previous & Next buttons */
        btnPrev = new Button(" < ");
        btnPrev.setLayoutX(150);
        btnPrev.setLayoutY(515);
        btnPrev.setStyle("-fx-pref-width: 75px;");
        btnPrev.setDisable(true);
        btnNext = new Button(" > ");
        btnNext.setLayoutX(250);
        btnNext.setLayoutY(515);
        btnNext.setStyle("-fx-pref-width: 75px;");
        btnSubmit = new Button("Submit");
        btnSubmit.setLayoutX(725);
        btnSubmit.setLayoutY(515);
        btnSubmit.setStyle("-fx-pref-width: 150px;");

        /* Correct answer reading from file */
        /* Extracting Answer to a File */
        readFromFile();
        radChoice1.setOnAction(e -> {
            quesList.get(activeQ-1).setSelected(0, true);
            quesList.get(activeQ-1).setSelected(1, false);
            quesList.get(activeQ-1).setSelected(2, false);
            quesList.get(activeQ-1).setSelected(3, false);
        });
        radChoice2.setOnAction(e -> {
            quesList.get(activeQ-1).setSelected(0, false);
            quesList.get(activeQ-1).setSelected(1, true);
            quesList.get(activeQ-1).setSelected(2, false);
            quesList.get(activeQ-1).setSelected(3, false);
        });
        radChoice3.setOnAction(e -> {
            quesList.get(activeQ-1).setSelected(0, false);
            quesList.get(activeQ-1).setSelected(1, false);
            quesList.get(activeQ-1).setSelected(2, true);
            quesList.get(activeQ-1).setSelected(3, false);
        });
        radChoice4.setOnAction(e -> {
            quesList.get(activeQ-1).setSelected(0, false);
            quesList.get(activeQ-1).setSelected(1, false);
            quesList.get(activeQ-1).setSelected(2, false);
            quesList.get(activeQ-1).setSelected(3, true);
        });
        if (totQues == 1)
            btnNext.setDisable(true);
        btnNext.setOnAction(e -> {
            activeQ++;
            btnPrev.setDisable(false);
            if (activeQ == totQues)
                btnNext.setDisable(true);
            reloadQues();
        });
        btnPrev.setOnAction(e -> {
            activeQ--;
            btnNext.setDisable(false);
            if (activeQ == 1)
                btnPrev.setDisable(true);
            reloadQues();
        });
        btnSubmit.setOnAction(e -> {
            timeline.pause();
            timer.Stop();
            mainStage.hide();
            compile();


            try {
                PrintWriter pw = new PrintWriter(new FileWriter("data/mamatresult.txt", true));
                pw.println("");
                pw.close();

            }
            catch (IOException f) {
                System.out.println("Error");
                f.printStackTrace();
            }
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
                pw.println("");
                pw.close();

            }
            catch (IOException f) {
                System.out.println("Error");
                f.printStackTrace();
            }


            winFarewell = new MyResult();
            winFarewell.setName(labName.getText());
            StudentAnswer();
            winFarewell.showStage();
            winFarewell.setOnHiding(g -> {
                winWinner = new Winner();
                winWinner.show();}
            );


        });

        mainPane = new Pane();
        mainPane.getChildren().add(Bgimage);
        mainPane.getChildren().add(labNameDesc);
        mainPane.getChildren().add(labIdDesc);
        mainPane.getChildren().add(labName);
        mainPane.getChildren().add(labId);
        mainPane.getChildren().add(labCountry);
        mainPane.getChildren().add(imgCountry);
        mainPane.getChildren().add(labTimer);
        mainPane.getChildren().add(labQuesNo);
        mainPane.getChildren().add(labQues);
        mainPane.getChildren().add(paneC);
        mainPane.getChildren().add(btnNext);
        mainPane.getChildren().add(btnPrev);
        mainPane.getChildren().add(btnSubmit);

        /* Show Pane Objects */
        mainScene = new Scene(mainPane, 1000, 700);
        mainStage.setScene(mainScene);
        reloadQues();
        winMenu = new Menu();
        winMenu.show();
        winLogin = new Login();
        winMenu.setOnHiding(e -> {winLogin.show();});

        winGreeting = new MyGreeting();
        winLogin.setOnHiding(e -> {
            winGreeting.show();
            winGreeting.setContestantName(winLogin.getName());
            winGreeting.setContestantId(winLogin.getContestantId());
        });
        winGreeting.setOnHiding(e -> {
            labName.setText(winLogin.getName());
            labId.setText(winLogin.getContestantId());
            mainStage.show();
            if(MyParam.getCountry()=="Greece") {
                File pFileA = new File("data/Greece.JPG");
                Image imgA = new Image(pFileA.toURI().toString());
                imgCountry.setImage(imgA);
            }
            else if(MyParam.getCountry()=="San Marino") {
                File pFileA = new File("data/SanMarinoFlag.jpg");
                Image imgA = new Image(pFileA.toURI().toString());
                imgCountry.setImage(imgA);
            }
            else if(MyParam.getCountry()=="Germany") {
                File pFileA = new File("data/GermanFlagA.jpg");
                Image imgA = new Image(pFileA.toURI().toString());
                imgCountry.setImage(imgA);
            }
            else if(MyParam.getCountry()=="Guinea-Bissau") {
                File pFileA = new File("data/GBFB.jpg");
                Image imgA = new Image(pFileA.toURI().toString());
                imgCountry.setImage(imgA);
            }
            else if(MyParam.getCountry()=="Iraq") {
                File pFileA = new File("data/iraqFlag.JPG");
                Image imgA = new Image(pFileA.toURI().toString());
                imgCountry.setImage(imgA);
            }


        });

        mainStage.setOnShown(e -> {
            timer = new Clock();
            mainPane.getChildren().add(timer);
             timeline = new Timeline(
                    new KeyFrame(Duration.seconds(180), f -> {
                        btnSubmit.fire();
                        mainStage.hide();
                            })
            );
            timeline.play();
        });

    }

    /* Type of Questions */
    public void reloadQues() {
        labQuesNo.setText("Question " + Integer.toString(activeQ)+"/"+totQues);
        labQues.setText(quesList.get(activeQ-1).getTheQues());

        imgQues.setImage(null);
        imgAnsA.setImage(null);
        imgAnsB.setImage(null);
        imgAnsC.setImage(null);
        imgAnsD.setImage(null);
        if (quesList.get(activeQ-1).getType() == 1) {
            radChoice1.setText(quesList.get(activeQ-1).getChoice(0));
            radChoice2.setText(quesList.get(activeQ-1).getChoice(1));
            radChoice3.setText(quesList.get(activeQ-1).getChoice(2));
            radChoice4.setText(quesList.get(activeQ-1).getChoice(3));
            labA.setLayoutX(120);
            labA.setLayoutY(200);
            radChoice1.setLayoutX(160);
            radChoice1.setLayoutY(200);
            labB.setLayoutX(520);
            labB.setLayoutY(200);
            radChoice2.setLayoutX(560);
            radChoice2.setLayoutY(200);
            labC.setLayoutX(120);
            labC.setLayoutY(300);
            radChoice3.setLayoutX(160);
            radChoice3.setLayoutY(300);
            labD.setLayoutX(520);
            labD.setLayoutY(300);
            radChoice4.setLayoutX(560);
            radChoice4.setLayoutY(300);
        }
        if (quesList.get(activeQ-1).getType() == 2) {
            radChoice1.setText(quesList.get(activeQ-1).getChoice(0));
            radChoice2.setText(quesList.get(activeQ-1).getChoice(1));
            radChoice3.setText(quesList.get(activeQ-1).getChoice(2));
            radChoice4.setText(quesList.get(activeQ-1).getChoice(3));
            File pFile = new File("data/" + quesList.get(activeQ-1).getQuesPic());
            Image img = new Image(pFile.toURI().toString());
            imgQues.setImage(img);
            labA.setLayoutX(550);
            labA.setLayoutY(200);
            radChoice1.setLayoutX(600);
            radChoice1.setLayoutY(185);
            labB.setLayoutX(550);
            labB.setLayoutY(250);
            radChoice2.setLayoutX(600);
            radChoice2.setLayoutY(235);
            labC.setLayoutX(550);
            labC.setLayoutY(300);
            radChoice3.setLayoutX(600);
            radChoice3.setLayoutY(285);
            labD.setLayoutX(550);
            labD.setLayoutY(350);
            radChoice4.setLayoutX(600);
            radChoice4.setLayoutY(335);
        }

        if (quesList.get(activeQ-1).getType() == 3) {
            radChoice1.setText("");
            radChoice2.setText("");
            radChoice3.setText("");
            radChoice4.setText("");

            File pFileA = new File("data/" + quesList.get(activeQ-1).getChoice(0));
            Image imgA = new Image(pFileA.toURI().toString());
            File pFileB = new File("data/" + quesList.get(activeQ-1).getChoice(1));
            Image imgB = new Image(pFileB.toURI().toString());
            File pFileC = new File("data/" + quesList.get(activeQ-1).getChoice(2));
            Image imgC = new Image(pFileC.toURI().toString());
            File pFileD = new File("data/" + quesList.get(activeQ-1).getChoice(3));
            Image imgD = new Image(pFileD.toURI().toString());
            imgAnsA.setImage(imgA);
            imgAnsB.setImage(imgB);
            imgAnsC.setImage(imgC);
            imgAnsD.setImage(imgD);

            labA.setLayoutX(120);
            labA.setLayoutY(180);
            radChoice1.setLayoutX(160);
            radChoice1.setLayoutY(165);
            imgAnsA.setLayoutX(210);
            imgAnsA.setLayoutY(165);

            labB.setLayoutX(520);
            labB.setLayoutY(180);
            radChoice2.setLayoutX(560);
            radChoice2.setLayoutY(165);
            imgAnsB.setLayoutX(610);
            imgAnsB.setLayoutY(165);

            labC.setLayoutX(120);
            labC.setLayoutY(300);
            radChoice3.setLayoutX(160);
            radChoice3.setLayoutY(290);
            imgAnsC.setLayoutX(210);
            imgAnsC.setLayoutY(290);

            labD.setLayoutX(520);
            labD.setLayoutY(300);
            radChoice4.setLayoutX(560);
            radChoice4.setLayoutY(290);
            imgAnsD.setLayoutX(610);
            imgAnsD.setLayoutY(290);
        }

        radChoice1.setSelected(quesList.get(activeQ-1).getSelected(0));
        radChoice2.setSelected(quesList.get(activeQ-1).getSelected(1));
        radChoice3.setSelected(quesList.get(activeQ-1).getSelected(2));
        radChoice4.setSelected(quesList.get(activeQ-1).getSelected(3));
    }

    /* Once submitted, system will help you mark */
    /* Auto Marking System */
    public void compile(){
        int i = 0;
        correctAns = i;
        for (int k = 0; k < totQues; k++) {
            if (quesList.get(k).getAns() =='A') {
                if (quesList.get(k).getSelected(0)) {
                    i++;
                }
            } else if (quesList.get(k).getAns() =='B') {
                if (quesList.get(k).getSelected(1)) {
                    i++;
                }
            } else if (quesList.get(k).getAns() =='C') {
                if (quesList.get(k).getSelected(2)) {
                    i++;
                }
            } else if (quesList.get(k).getAns() =='D') {
                if (quesList.get(k).getSelected(3)) {
                    i++;
                }
            }
        }

        try {
            PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
            pw.print(i+":");
            pw.close();

        }
        catch (IOException f) {
            System.out.println("Error");
            f.printStackTrace();
        }
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("data/ContestantInfo.txt", true));
            pw.print(labName.getText()+"("+i+"/"+totQues+")");
            pw.close();

        }
        catch (IOException f) {
            System.out.println("Error");
            f.printStackTrace();
        }



    }

    /* Saving Student Answer to a File */
    public void StudentAnswer(){
        int i = 0;
        int t = 0;
        correctAns = i;
        t = totQues;
        boolean ans = false;
        for (int k = 0; k < totQues; k++) {
            if (quesList.get(k).getSelected(0)){
                i++;
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/mamatresult.txt", true));
                    pw.print("A:");
                    pw.close();
                    i++;
                }
                catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
            else if (quesList.get(k).getSelected(1)){
                i++;
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/mamatresult.txt", true));
                    pw.print("B:");
                    pw.close();
                    i++;
                }
                catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
            else if (quesList.get(k).getSelected(2)){
                i++;
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/mamatresult.txt", true));
                    pw.print("C:");
                    pw.close();
                    i++;
                }
                catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
            else if (quesList.get(k).getSelected(3)){
                i++;
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("data/mamatresult.txt", true));
                    pw.print("D:");
                    pw.close();
                    i++;
                }
                catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
            else
            {
                i++;
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter(myf2, true));
                    pw.print("NULL:");
                    pw.close();
                }
                catch(IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }
        }
    }

    /* Read Questions from File */
    public void readFromFile() {
        Scanner sfile;
        int type;
        char answer;
        String theQues;
        String choices[] = new String[4];
        String quesPic;
        Question ques;
        try {
            sfile = new Scanner(myf);
            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totQues = Integer.parseInt(sline.next());
            for (int k = 1; k <= totQues; k++) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                type = Integer.parseInt(sline.next());
                answer = sline.next().charAt(0);
                theQues = sline.next();
                quesPic = "";
                if (type == 2)
                    quesPic = sline.next();
                choices[0] = sline.next();
                choices[1] = sline.next();
                choices[2] = sline.next();
                choices[3] = sline.next();
                sline.close();


                ques = new Question(type, answer, theQues, choices, quesPic);
                quesList.add(ques);
            }
            sfile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + myf + " not found!");
        }

    }

    /* Launch Apps */
    public static void main(String args[]) {
        Application.launch(args);
    }
}