
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Stage {

    ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private int totmember = 0;
    private int c = 0;
    private TextField txtName, txtPass;
    private File contestants = new File("data","contestants.txt");
    private String user ="";
    private String entered = "";
    private String password = "";
    private String checkBox = "";
    private String contestantId;
    private Text InvalidPass;
    private Text InvalidPass2;

    public Login(){

        /* Creating a Button */
        Button btnContinue = new Button();

        /* Button text */
        btnContinue.setText("Continue");

        /* Button Size */
        btnContinue.setStyle("-fx-pref-width: 150px; -fx-pref-height: 30px");

        /* Button Positioning */

        btnContinue.setTranslateX(700);
        btnContinue.setTranslateY(475);
        
        /* Background Location */
        File Background = new File("data\\Background2.jpg");
        Image Bgimg = new Image(Background.toURI().toString());
        ImageView Bgimage = new ImageView(Bgimg);
    
        /* Background Position */
        Bgimage.setFitHeight(700);
        Bgimage.setFitWidth(1000);

        /* Creating a Text */
        Text Title = new Text();
        Text Input = new Text();
        Text Name = new Text();
        Text Pass = new Text();
        InvalidPass = new Text ();
        InvalidPass2 = new Text ();

        /* Text Edit */
        Title.setText("Log In");
        Input.setText("Please Enter your name and password:(TestExample-Name:Hendrey,Password:abc111)");
        Name.setText("Name: ");
        Pass.setText("Password: ");
        InvalidPass.setText("");
        InvalidPass2.setText("");
        
        /* Text Font Import */ 
        Font Itim = Font.loadFont("file:data\\Itim.ttf", 20);

        /* Text Format */
        Title.setFont(Font.font("Itim",50));
        Input.setFont(Itim);
        Name.setFont(Itim);
        Pass.setFont(Itim);
        InvalidPass.setFont(Itim);
        InvalidPass2.setFont(Itim);
        
        /* Text Colour */
        Title.setFill(Color.WHITE);
        Input.setFill(Color.WHITE);
        Name.setFill(Color.WHITE);
        Pass.setFill(Color.WHITE);
        InvalidPass.setFill(Color.web("#ff6961"));
        InvalidPass2.setFill(Color.web("#ff6961"));

        /* ChoiceBox Positioning */
        choiceBox.setLayoutX(100);
        choiceBox.setLayoutY(280);
        
        /* ChoiceBox Length */
        choiceBox.setPrefWidth(200);

        /* Position of Text */
        Title.setX(450);
        Title.setY(125);
        Input.setX(100);
        Input.setY(225);
        Name.setX(100);
        Name.setY(270);
        Pass.setX(100);
        Pass.setY(340);
        InvalidPass.setX(100);
        InvalidPass.setY(425);
        InvalidPass2.setX(100);
        InvalidPass2.setY(450);

        /* Creating a TextField */
        txtName = new TextField();

        /* Position of Text Field */
        txtName.setLayoutX(100);
        txtName.setLayoutY(110);

        /* Password */
        txtPass = new TextField();
        
        /* TextField Length */
        txtPass.setPrefWidth(200);

        /* Password Positioning */
        txtPass.setLayoutX(100);
        txtPass.setLayoutY(350);

        /* Call Out */
        checkContestant();

        /* Stage Setting */
        Group root = new Group(Bgimage,Title,Input,Name,Pass,choiceBox,txtPass,InvalidPass, InvalidPass2,btnContinue);
        Scene scene = new Scene(root, 1000, 700, Color.BEIGE);
        this.setTitle("MAMAT Battle Royale Knowledge Contest");
        this.setResizable(false);
        this.setScene(scene);

        /* Button Event */ 
        btnContinue.setOnAction(e -> {
            checkFromFile();
            if ( c == 2 ){
                this.hide();
            }
        });
    }

    /* Getter Infomation */
    public String getName() {
        return choiceBox.getValue();
    }
    
    public String getContestantId() {
        return contestantId;
    }
    
    public String getInvalidText() {
        return InvalidPass.getText();
    }
    
    public String getInvalidText2() {
        return InvalidPass2.getText();
    }
    

    /* Password Verification */
    public void checkFromFile() {
        Scanner sfile;
        String id;
        try {
            sfile = new Scanner(contestants);
            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totmember = Integer.parseInt(sline.next());

            for (int k = 1; k <= totmember; k++) {

                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                id = sline.next();
                user = sline.next();
                password = sline.next();

                if (user.equals(choiceBox.getValue())){
                    c = 1;
                    if(password.equals(txtPass.getText())){
                        c = 2;
                        contestantId = id;
                    }
                }
                else {
                    InvalidPass.setText("Invalid Password. Please try again.");
                    InvalidPass2.setText("Note: Check the report document for passwords");
                }
                sline.close();
            }
            sfile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File to read " + contestants + " not found!");
        }
    }

    /* Data Extraction From Files */
    public void checkContestant() {
        Scanner sfile;
        String id;
        try {
            sfile = new Scanner(contestants);
            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totmember = Integer.parseInt(sline.next());
            for (int k = 1; k <= totmember; k++) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                id = sline.next();

                user = sline.next();
                password = sline.next();
                checkBox = user;

                choiceBox.getItems().add(checkBox);

                sline.close();
            }

            sfile.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File to read " + contestants + " not found!");
        }

    }
} 