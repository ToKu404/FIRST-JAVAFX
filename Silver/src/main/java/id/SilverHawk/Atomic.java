package id.SilverHawk;

//menyediakan kelas khusus aplikasi
import javafx.application.Application;
//import kelas geometry untuk posisi objek
import javafx.geometry.Pos;
import javafx.geometry.Insets;
//import stage
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import scene
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Cursor;
import javafx.scene.Group;
//import file io
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;

public class Atomic extends Application{
    static Stage primaryStage;
    static HBox mainBox;
    static Scene loginScene;
    static String ioUser = "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\DataUser.txt";
    static GridPane rightLoginPane;
    static String ioAsasAufbau = "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\AsasAufbau.txt"; 
    static String ioGol = "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\Golongan.txt"; 
    static Pane leftP;
    @Override
    // method start yg pertama muncul
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        // judul aplikasi
        primaryStage.setTitle("Atomic");
        // icon aplikasi
        FileInputStream inputIcon = new FileInputStream(
                "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\AtomicIcon.png");
        primaryStage.getIcons().add(new Image(inputIcon));
        // menyembunyikan title bar aplikasi
        primaryStage.resizableProperty();
        // login scane
        // left Pane
        GridPane leftLoginPane = new GridPane();
        leftLoginPane.setMinSize(566.7, 638.36);
        leftLoginPane.setAlignment(Pos.CENTER);
        FileInputStream inputLogo = new FileInputStream(
                "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\AtomicLogo.png");
        Image logo = new Image(inputLogo);
        ImageView imageLogo = new ImageView(logo);
        imageLogo.setFitHeight(400.9);
        imageLogo.setFitWidth(375.5);
        Label leftimageLabel = new Label("Atomic v.1.0");
        leftimageLabel.setStyle("-fx-font-family:'Pirates of Cydonia';-fx-text-fill:#70D85C;-fx-font-size: 46px");
        HBox leftimageBox = new HBox(leftimageLabel);
        leftimageBox.setAlignment(Pos.CENTER);
        leftLoginPane.add(imageLogo, 0, 0);
        leftLoginPane.add(leftimageBox, 0, 1);
        // right loginPane
        rightLoginPane = new GridPane();
        rightLoginPane.setPrefSize(566.7, 638.36);
        rightLoginPane.setAlignment(Pos.CENTER);
        rightLoginPane.setVgap(15);
        rightLoginPane.setHgap(15);
        Label login = new Label("LOGIN");
        login.setStyle("-fx-font-family:'Arial';-fx-text-fill:#70D85C;-fx-font-size: 57.41px");
        HBox loginBox = new HBox(login);
        loginBox.setAlignment(Pos.CENTER);
        TextField textName = new TextField();
        textName.setPrefSize(350, 50);
        textName.setStyle("-fx-font-family: Arial;-fx-text-fill: black;-fx-font-size: 20px;-fx-background-radius:0.5em");
        textName.setPromptText("Masukkan nama anda");
        HBox name = new HBox(textName);
        name.setAlignment(Pos.CENTER);
        PasswordField textPassword = new PasswordField();
        textPassword.setPrefSize(350, 50);
        textPassword.setPromptText("Masukkan password anda");
        textPassword.setStyle("-fx-font-family: Arial;-fx-text-fill: black;-fx-font-size: 20px;-fx-background-radius:0.7em");
        HBox password = new HBox(textPassword);
        password.setAlignment(Pos.CENTER);
        Hyperlink signUpLink = new Hyperlink("I don't Have Account");
        signUpLink.setCursor(Cursor.HAND);
        HBox signUp = new HBox(signUpLink);
        signUp.setAlignment(Pos.CENTER_RIGHT);
        Button loginButton = new Button("Sign in");
        loginButton.setPrefSize(165, 30);
        loginButton.setId("style1");
        loginButton.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        Button closeButton = new Button("Close");
        closeButton.setId("style1");
        closeButton.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        closeButton.setPrefSize(165, 30);
        HBox button = new HBox(closeButton, loginButton);
        button.setAlignment(Pos.CENTER);
        button.setSpacing(20);
        rightLoginPane.add(loginBox, 0, 0);
        rightLoginPane.add(name, 0, 3);
        rightLoginPane.add(password, 0, 5);
        rightLoginPane.add(signUp, 0, 6);
        rightLoginPane.add(button, 0, 8);

        //sorry jika data user tidak sesuai
        Label sorry = new Label("");
        sorry.setStyle("-fx-text-fill:#D94242;-fx-font-size: 15px;");
        HBox sorryBox = new HBox(sorry);
        sorryBox.setAlignment(Pos.CENTER);
        rightLoginPane.add(sorryBox, 0, 7);
        //tempilan panel kiri
        leftP = new Pane(rightLoginPane); 
        HBox boxLogin = new HBox(leftLoginPane, leftP);
        Group loginGroup = new Group(boxLogin);
        loginScene = new Scene(loginGroup, 1133.85, 638.36, Color.rgb(28, 28, 28));
        loginScene.setCursor(Cursor.DEFAULT);
        primaryStage.setScene(loginScene);
        primaryStage.show();
        //action dari closebutton
        closeButton.setOnAction(act -> {
            primaryStage.close();
        });
        //action dari signUpLink
        signUpLink.setOnAction(act -> {
            try {
                leftP.getChildren().clear();
                signUpMethod();
                sorry.setText("");
                textName.clear();
                textPassword.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //action dari login button
        loginButton.setOnAction(act -> {
            try {
                if(cekUser(textName,textPassword)==true){
                    sorry.setText("");
                    menuBar(textName, logo);
                    textName.clear();
                    textPassword.clear();
                    Dashboard();
                }
                else{
                    sorry.setText("Maaf username dan password tidak valid");
                    textName.clear();
                    textPassword.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
    //method untuk mengecek apakah input user ada
    public static Boolean cekUser(TextField textName, PasswordField textPassword)throws Exception{
        File dataSumber = new File(ioUser);
        String dataUser = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(dataSumber);
            br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                dataUser += str;
            }
        } finally {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        String userData []= dataUser.split("#");
        for(int i=0;i<userData.length;i++){
            String namePassword [] = userData[i].split(";");
            String userName = namePassword[0];
            String userPassword = namePassword[1];
            if(userName.equals(textName.getText())&&userPassword.equals(textPassword.getText())){
                return true;
            }
        }
        return false;
    }
    //method untuk melakukan pendaftaran
    public void signUpMethod() throws Exception {
        GridPane rightSignUpPane = new GridPane();
        rightSignUpPane.setPrefSize(566.7, 638.36);
        rightSignUpPane.setAlignment(Pos.CENTER);
        rightSignUpPane.setVgap(20);
        rightSignUpPane.setHgap(15);
        Label login = new Label("DAFTAR");
        login.setStyle("-fx-font-family:'Arial';-fx-text-fill:#70D85C;-fx-font-size: 57.41px");
        HBox loginBox = new HBox(login);
        loginBox.setAlignment(Pos.CENTER);
        TextField textName = new TextField();
        textName.setPrefSize(350, 40);
        textName.setStyle("-fx-font-family: Arial;-fx-text-fill: black;-fx-font-size: 20px;-fx-background-radius:0.5em");
        textName.setPromptText("Masukkan nama anda");
        HBox name = new HBox(textName);
        name.setAlignment(Pos.CENTER);
        TextField textPassword = new TextField();
        textPassword.setPrefSize(350, 40);
        textPassword.setPromptText("Masukkan password anda");
        textPassword.setStyle("-fx-font-family: Arial;-fx-text-fill: black;-fx-font-size: 20px;-fx-background-radius:0.5em");
        HBox password = new HBox(textPassword);
        password.setAlignment(Pos.CENTER);
        TextField textPassword2 = new TextField();
        textPassword2.setPrefSize(350, 40);
        textPassword2.setPromptText("Masukkan kembali password anda");
        textPassword2.setStyle("-fx-font-family: Arial;-fx-text-fill: black;-fx-font-size: 20px;-fx-background-radius:0.5em");
        HBox password2 = new HBox(textPassword2);
        password2.setAlignment(Pos.CENTER);
        Button signUpButton = new Button("Daftar");
        signUpButton.setPrefSize(165, 30);
        signUpButton.setId("style1");
        signUpButton.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        Button backButton = new Button("Back");
        backButton.setPrefSize(165, 30);
        backButton.setId("style1");
        backButton.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        HBox button = new HBox(backButton, signUpButton);
        button.setAlignment(Pos.CENTER);
        button.setSpacing(20);
        Label passSame = new Label("");
        passSame.setStyle("-fx-text-fill:#D94242;-fx-font-size: 15px;");
        HBox passSameBox = new HBox(passSame);
        passSameBox.setAlignment(Pos.CENTER);

        rightSignUpPane.add(loginBox, 0, 0);
        rightSignUpPane.add(name, 0, 3);
        rightSignUpPane.add(password, 0, 4);
        rightSignUpPane.add(password2, 0, 5);
        rightSignUpPane.add(passSameBox, 0, 6);
        rightSignUpPane.add(button, 0, 7);
        //label berhasil
        Label berhasil = new Label("Selamat pendaftaran Berhasil");
        berhasil.setStyle("-fx-font-size: 22px;-fx-text-fill:White");
        HBox berhasilBox = new HBox(berhasil);
        berhasilBox.setAlignment(Pos.CENTER);

        Button backHome = new Button("Back to Home");
        backHome.setId("style1");
        backHome.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        //action back button 1
        backHome.setOnAction(act->{
            leftP.getChildren().clear();
            leftP.getChildren().addAll(rightLoginPane);
        });
        HBox backHomeBox = new HBox(backHome);
        backHomeBox.setAlignment(Pos.CENTER);
        //action back button
        backButton.setOnAction(act->{
            leftP.getChildren().clear();
            leftP.getChildren().addAll(rightLoginPane);
        });
        //acton bila pendaftaran selesai
        signUpButton.setOnAction(act->{
            try {
                if(textPassword2.getText().equals(textPassword.getText())){
                    tambahUser(textName,textPassword);
                    passSame.setText("");
                    textName.clear();
                    textPassword.clear();
                    textPassword2.clear();
                    rightSignUpPane.getChildren().clear();
                    rightSignUpPane.add(berhasilBox, 0, 0);
                    rightSignUpPane.add(backHomeBox, 0, 3);

                }
                else{
                    passSame.setText("Input Password tidak valid");
                    textName.clear();
                    textPassword.clear();
                    textPassword2.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // Sign Up Scene
        leftP.getChildren().addAll(rightSignUpPane);
    }
    //turunan method pendaftaran dimana akan menambah user ke file
    public static void tambahUser(TextField Name, TextField Password) throws Exception{
        String newUser = "\n"+Name.getText()+";"+Password.getText()+"#";
        FileWriter fw = null;
        try {
            fw = new FileWriter(ioUser, true);
            fw.append(newUser);
        } finally {
            if (fw != null) {
                fw.close();
            }
        }

    }
    //method menu bar 
    public static void menuBar (TextField nama, Image logo)throws Exception{
        //user name yang didapat dari tampilan sebelumnya
        String user = nama.getText();
        Label userName = new Label(user);
        userName.setStyle("-fx-font-family: Arial;-fx-text-fill: white;-fx-font-size: 14px");
        FileInputStream inputUserPic = new FileInputStream(
                "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\LoginBoy.png");
        ImageView userPic = new ImageView(new Image(inputUserPic));
        userPic.setFitHeight(14.5);
        userPic.setFitWidth(10.26);
        HBox userBox = new HBox(userPic, userName);
        userBox.setAlignment(Pos.TOP_LEFT);
        //gambar logo
        ImageView titlePic = new ImageView(logo);
        titlePic.setFitHeight(88.74);
        titlePic.setFitWidth(84.66);
        Label titleMenu = new Label("Atomic");
        titleMenu.setStyle("-fx-font-family:'Pirates of Cydonia';-fx-text-fill:#70D85C;-fx-font-size: 40pt");
        HBox titleBox = new HBox (titlePic,titleMenu);
        titleBox.setSpacing(6);
        titleBox.setAlignment(Pos.CENTER);
        //menu pilihan
        VBox pilihMenu = new VBox();
        pilihMenu.setPadding(new Insets(20,32,39,32));
        pilihMenu.setSpacing(35);
        //buat tombol dengan array
        Button tombolMenu[]=new Button[4];
        String pilihanMenu [] = {"Dashboard","Periodic Table", "Sign Out", "Close"};
        for(int i=0;i<4;i++){
            tombolMenu[i] = new Button(pilihanMenu[i]);
            tombolMenu[i].setPrefSize(250, 50.6);
            tombolMenu[i].setId("style1");
            tombolMenu[i].getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
            pilihMenu.getChildren().add(tombolMenu[i]);
        }
        //action dari tombol
        tombolMenu[0].setOnAction(act ->{
            try {
                Dashboard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombolMenu[1].setOnAction(act ->{
            try {
                periodicTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombolMenu[2].setOnAction(act->{
            primaryStage.setScene(loginScene);
        });
        tombolMenu[3].setOnAction(act->{
            primaryStage.close();
        });
        Label team = new Label("@Kelompok5");
        team.setStyle("-fx-text-fill:#616161;-fx-font-size:10pt");
        team.setPadding(new Insets(30,0,0,10));
        VBox menu = new VBox(userBox,titleBox,pilihMenu,team);
        menu.setPrefSize(323.9, 638.36);
        menu.setPadding(new Insets(10));
        menu.setSpacing(32);
        menu.setStyle("-fx-background-color:#1C1C1C ");
        mainBox = new HBox(menu);
        userBox.setSpacing(8);
    }
    //method tampilan dashboard
    static Pane leftPanell;
    public static void Dashboard() throws Exception {
        GridPane dashboardPane = new GridPane();
        dashboardPane.setPadding(new Insets(58,28,58,28));
        dashboardPane.setVgap(58);
        dashboardPane.setHgap(28);
        dashboardPane.setStyle("-fx-background-color: #F3F3F3");
        
        Button tombol[] = new Button[12];
        int k = 0;
        //masukkan gambar ke tombol dengan perulangan
        for (int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                String n = String.valueOf((i+1)*(j+1));
                ImageView image = new ImageView(new Image(new FileInputStream("D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\image"+(k+1)+".png")));
                image.setFitHeight(226.36);
                image.setFitWidth(209.36);
                image.setId(n);
                tombol[k] = new Button();
                tombol[k].setStyle("-fx-background-color: transparent");
                tombol[k].setMinSize(226.36,209.36);
                tombol[k].setGraphic(image);
                tombol[k].setCursor(Cursor.HAND);
                dashboardPane.add(tombol[k], j, i);
                k++;
            }
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(dashboardPane);
        scrollPane.setPrefSize(809, 638.36);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        leftPanell = new Pane(scrollPane);
        HBox menuUtama = new HBox(mainBox,leftPanell); 
        Pane paneUtama = new Pane(menuUtama);
        Scene mainScene = new Scene(paneUtama, 1133.85, 638.36);
        primaryStage.setScene(mainScene);
        //action dari tombol
        tombol[0].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                PenyusunAtom(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[1].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                Isoatomik(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[2].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                elekValensi(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[3].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                bilanganKuantum(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[4].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                letakAtom(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[5].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                jumlahMol(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[6].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                Molaritas(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[7].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                Molalitas(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[8].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                FraksiMol(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[9].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                Presentasi(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tombol[10].setOnAction(act->{
            try {
                leftPanell.getChildren().clear();
                GasIdeal(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    static ComboBox<String> conIn;
    static ComboBox<String> conOut;
    static TextField input;
    static Label output;
    //method tampilan tabel periodik
    public static void periodicTable() throws Exception {
        Pane panPeriodik = new Pane();
        Label titlePariodic = new Label("Tabel Periodik");
        titlePariodic.setStyle("-fx-font-size:57pt;-fx-font-family:'Soft Core';");
        HBox titleTable = new HBox(titlePariodic);
        titleTable.setAlignment(Pos.CENTER);
        FileInputStream inputPeriodicTable = new FileInputStream(
                "D:\\COMPUTER-SCIENCE\\JAVA\\CS-SEMESTER-1\\FIRST-JAVAFX\\Silver\\src\\main\\java\\id\\SilverHawk\\resources\\images\\PeriodicTable.png");
        ImageView periodicTable = new ImageView(new Image(inputPeriodicTable));
        periodicTable.setFitHeight(506.4);
        periodicTable.setFitWidth(778.5);
        VBox periodicBox = new VBox(titleTable,periodicTable);
        periodicBox.setPadding(new Insets(15,15,15,15));
        HBox menuPeriodik = new HBox(mainBox,periodicBox);
        panPeriodik.getChildren().addAll(menuPeriodik);
        Scene PeriodikScene = new Scene(panPeriodik, 1133.85, 638.36);
        primaryStage.setScene(PeriodikScene);
    }
    
    //kumpulan method perhitungan dari menu dashboard
    //penyusun atom
    public static void PenyusunAtom()throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        //untuk input no atom
        Label noAtom = new Label("No Atom");
        noAtom.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:1em");
        TextField nAtext = new TextField();
        nAtext.setStyle("-fx-background-color:white;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:0.5em;-fx-border-color: black; -fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext.setPrefSize(80, 68);
        HBox noAtomBox = new HBox(noAtom);
        noAtomBox.setAlignment(Pos.CENTER);
        HBox nABox = new HBox(nAtext);
        nABox.setAlignment(Pos.CENTER);
        VBox noAtomVBox = new VBox(noAtomBox,nABox);
        noAtomVBox.setSpacing(15);
        //untuk input no massa
        Label noMassa = new Label("No Massa");
        noMassa.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 25pt 'Arial';");
        TextField nMText = new TextField();
        nMText.setStyle("-fx-background-color:white;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:0.5em;-fx-border-color: black; -fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nMText.setPrefSize(80, 68);
        HBox noMassaBox = new HBox(noMassa);
        noMassaBox.setAlignment(Pos.CENTER);
        HBox nMBox = new HBox(nMText);
        nMBox.setAlignment(Pos.CENTER);
        VBox noMassaVBox = new VBox(noMassaBox,nMBox);
        noMassaVBox.setSpacing(15);
    
        HBox atom = new HBox(noAtomVBox,noMassaVBox);
        atom.setSpacing(150);
        //tombol submit
        Button submit1 = new Button("Submit");
        submit1.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        submit1.setCursor(Cursor.HAND);
        //massukkan ke layout
        VBox inp1 = new VBox(atom,submit1);
        inp1.setAlignment(Pos.CENTER);
        inp1.setSpacing(23);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setPadding(new Insets(128.5,155,128.5,155));
        bigBox1.setVgap(5);
        bigBox1.add(inp1, 0, 0);
        //rumus
        Label proton = new Label("");
        proton.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox protonC = new HBox(proton);
        protonC.setAlignment(Pos.CENTER_LEFT);
        proton.setPadding(new Insets(0,0,0,30));
        Label neutron = new Label("");
        neutron.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox neutronC = new HBox(neutron);
        neutronC.setAlignment(Pos.CENTER_LEFT);
        neutron.setPadding(new Insets(0,0,0,30));
        Label elektron = new Label("");
        elektron.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox elektronC = new HBox(elektron);
        elektronC.setAlignment(Pos.CENTER_LEFT);
        elektron.setPadding(new Insets(0,0,0,30));
        bigBox1.add(protonC, 0, 5);
        bigBox1.add(neutronC, 0, 6);
        bigBox1.add(elektronC, 0, 7);
        submit1.setOnAction(act->{
            Integer protonS = Integer.parseInt(nAtext.getText());
            Integer neutronS = Integer.parseInt(nMText.getText())-protonS;
            Integer elektronS = protonS;
            proton.setText("Jumlah Proton \t= "+protonS);
            neutron.setText("Jumlah Neutron \t= "+neutronS);
            elektron.setText("Jumlah Elektron \t= "+elektronS);
        });
        bigBox1.setStyle("-fx-background-color: SILVER;");
        leftPanell.getChildren().addAll(bigBox1);
    }
    //Iso atomik
    public static void Isoatomik()throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        //input no atom dan no massa 1
        Label noAtom1 = new Label("No Atom1");
        noAtom1.setStyle("-fx-text-fill:#448943;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#96C744;-fx-text-fill:#448943;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3");
        nAtext1.setPrefSize(65, 56);
        HBox noAtomBox1 = new HBox(noAtom1);
        noAtomBox1.setAlignment(Pos.CENTER);
        HBox nABox1 = new HBox(nAtext1);
        nABox1.setAlignment(Pos.CENTER);
        Label noMassa1 = new Label("No Massa1");
        noMassa1.setStyle("-fx-text-fill:#448943;-fx-font:normal bold 18pt 'Arial';");
        TextField nMText1 = new TextField();
        nMText1.setStyle("-fx-background-color:white;-fx-border-COLOR:#96C744;-fx-text-fill:#448943;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3");
        nMText1.setPrefSize(65, 56);
        HBox noMassaBox1 = new HBox(noMassa1);
        noMassaBox1.setAlignment(Pos.CENTER);
        HBox nMBox1 = new HBox(nMText1);
        nMBox1.setAlignment(Pos.CENTER);
        VBox atom1 = new VBox(noAtomBox1,nABox1,noMassaBox1,nMBox1);
        atom1.setSpacing(15);
        //input no atom dan no massa 2
        Label noAtom2 = new Label("No Atom2");
        noAtom2.setStyle("-fx-text-fill:#EC6921;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#F9BF1D;-fx-text-fill:#EC6921;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3");
        nAtext2.setPrefSize(65,56);
        HBox noAtomBox2 = new HBox(noAtom2);
        noAtomBox2.setAlignment(Pos.CENTER);
        HBox nABox2 = new HBox(nAtext2);
        nABox2.setAlignment(Pos.CENTER);
        Label noMassa2 = new Label("No Massa2");
        noMassa2.setStyle("-fx-text-fill:#EC6921;-fx-font:normal bold 18pt 'Arial';");
        TextField nMText2 = new TextField();
        nMText2.setStyle("-fx-background-color:white;-fx-border-COLOR:#F9BF1D;-fx-text-fill:#EC6921;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3");
        nMText2.setPrefSize(65, 56);
        HBox noMassaBox2 = new HBox(noMassa2);
        noMassaBox2.setAlignment(Pos.CENTER);
        HBox nMBox2 = new HBox(nMText2);
        nMBox2.setAlignment(Pos.CENTER);
        VBox atom2 = new VBox(noAtomBox2,nABox2,noMassaBox2,nMBox2);
        atom2.setSpacing(15);
        //masukkan ke hbox
        HBox atom = new HBox(atom1,atom2);
        atom.setSpacing(180);
        //tombol submit
        Button submit1 = new Button("Submit");
        submit1.setStyle("-fx-text-fill:white;-fx-background-color:#12648C;-fx-font-family:'Arial';-fx-font-size: 24pt;-fx-background-radius:1em;");
        submit1.setCursor(Cursor.HAND);
        Button clear = new Button("Clear");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#12648C;-fx-font-family:'Arial';-fx-font-size: 24pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox buttoner = new HBox(clear, submit1);
        buttoner.setSpacing(30);
        buttoner.setAlignment(Pos.CENTER);
        
        //masukkan ke layout
        VBox inp1 = new VBox(atom,buttoner);
        inp1.setAlignment(Pos.CENTER);
        inp1.setSpacing(23);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setPadding(new Insets(128.5,158,128.5,150));
        bigBox1.add(inp1, 0, 0);
        bigBox1.setVgap(5);
        Label end = new Label("");
        end.setStyle("-fx-text-fill:#AD3034;-fx-font:normal bold 25pt 'Arial'");
        HBox output = new HBox(end);
        output.setAlignment(Pos.CENTER);
        bigBox1.add(output, 0, 3);
        //rumus setelah submit di tekan
        submit1.setOnAction(act->{
            Integer atoms1 = Integer.parseInt(nAtext1.getText());
            Integer massa1 = Integer.parseInt(nMText1.getText());
            Integer atoms2 = Integer.parseInt(nAtext2.getText());
            Integer massa2 = Integer.parseInt(nMText2.getText());
            String ending="";
            if(atoms1==atoms2&&massa1==massa2){
                ending+="ATOM SAMA";
            }
            else if(atoms1==atoms2&&massa1!=massa2){
                ending+="ISOTOP";
            }
            else if(atoms1!=atoms2&&massa1==massa2){
                ending+="ISOBAR";
            }
            else if(atom1!=atom2&&massa1-atoms1==massa2-atoms2){
                ending+="ISOTON";
            }
            else{
                ending+="BUKAN ISOATOMIK";
            }
            end.setText(ending);
        });
        clear.setOnAction(act->{
            nAtext1.clear();
            nAtext2.clear();
            nMText2.clear();
            nMText1.clear();
            end.setText("");
        });
        bigBox1.setStyle("-fx-background-color: #A0D9F6;");
        leftPanell.getChildren().addAll(bigBox1);
    }
    //jumlah Mol 
    public static void jumlahMol() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        bigBox1.setPadding(new Insets(128.5,130,128.5,130));
        //title 
        Label titleMol = new Label("JUMLAH MOL");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);
        //input n
        Label n = new Label("n");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 58pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 58pt 'Arial';");
        //input massa
        Label massa = new Label("massa");
        massa.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        HBox massaBox = new HBox(massa, nAtext2);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(10);
        //input Mr
        Label Mr = new Label("Mr");
        Mr.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        HBox mRBox = new HBox(Mr, nAtext3);
        mRBox.setAlignment(Pos.CENTER);
        mRBox.setSpacing(10);
        //input garis per
        Rectangle garis = new Rectangle();
        garis.setWidth(294);
        garis.setHeight(7);
        //masukkan ke layout
        VBox rumus = new VBox(massaBox,garis,mRBox);
        rumus.setSpacing(10);
        HBox bawah = new HBox(n,nAtext1,eq,rumus);
        bawah.setAlignment(Pos.CENTER);
        bawah.setSpacing(20);
        //button hitung
        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        //button clear
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        clear.setId("style1");
        clear.getStylesheets().add(Atomic.class.getResource("Button.css").toExternalForm());
        //masukkan button ke layout
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill::#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);
        bigBox1.addColumn(0, titleBox, bawah, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        //set text dulu dengan kosong
        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");
        //action dari clear
        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
        });
        //rumus
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext1.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext1.setText(String.valueOf(nilaiMassa/nilaiMr));
                
            }
            else if(nAtext2.getText().equals("")){
                Double nilain = Double.parseDouble(nAtext1.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext2.setText(String.valueOf(nilaiMr*nilain));
            }
            else if(nAtext3.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilain = Double.parseDouble(nAtext1.getText());
                nAtext3.setText(String.valueOf(nilaiMassa/nilain));
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
        bigBox1.setStyle("-fx-background-color: #FBD7A3;");
        leftPanell.getChildren().addAll(bigBox1);
    }
    public static void Molaritas() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        bigBox1.setPadding(new Insets(128.5,130,128.5,130));
        Label titleMol = new Label("MOLARITAS");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);

        Label n = new Label("M");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 58pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 58pt 'Arial';");

        Label massa = new Label("n");
        massa.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        HBox massaBox = new HBox(massa, nAtext2);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(10);

        Label Mr = new Label("V");
        Mr.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        HBox mRBox = new HBox(Mr, nAtext3);
        mRBox.setAlignment(Pos.CENTER);
        mRBox.setSpacing(10);
        
        Rectangle garis = new Rectangle();
        garis.setWidth(294);
        garis.setHeight(7);
        
        VBox rumus = new VBox(massaBox,garis,mRBox);
        rumus.setSpacing(10);

        HBox bawah = new HBox(n,nAtext1,eq,rumus);
        bawah.setAlignment(Pos.CENTER);
        bawah.setSpacing(20);

        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill::#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);

        bigBox1.addColumn(0, titleBox, bawah, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        bigBox1.setStyle("-fx-background-color : #96AED4");
        leftPanell.getChildren().addAll(bigBox1);

        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");

        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
        });
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext1.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext1.setText(String.valueOf(nilaiMassa/nilaiMr));
            }
            else if(nAtext2.getText().equals("")){
                Double nilain = Double.parseDouble(nAtext1.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext2.setText(String.valueOf(nilaiMr*nilain));
            }
            else if(nAtext3.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilain = Double.parseDouble(nAtext1.getText());
                nAtext3.setText(String.valueOf(nilaiMassa/nilain));
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
    }
    public static void Molalitas() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        bigBox1.setPadding(new Insets(128.5,130,128.5,130));
        Label titleMol = new Label("MOLALITAS");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);

        Label n = new Label("m");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 48pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 48pt 'Arial';");

        Label massa = new Label("n");
        massa.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        HBox massaBox = new HBox(massa, nAtext2);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(10);

        Label Mr = new Label("P");
        Mr.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 35pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 24pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        HBox mRBox = new HBox(Mr, nAtext3);
        mRBox.setAlignment(Pos.CENTER);
        mRBox.setSpacing(10);
        
        Rectangle garis = new Rectangle();
        garis.setWidth(294);
        garis.setHeight(7);
        
        VBox rumus = new VBox(massaBox,garis,mRBox);
        rumus.setSpacing(10);

        HBox bawah = new HBox(n,nAtext1,eq,rumus);
        bawah.setAlignment(Pos.CENTER);
        bawah.setSpacing(20);

        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill::#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);

        bigBox1.addColumn(0, titleBox, bawah, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        bigBox1.setStyle("-fx-background-color : #A1AB7B");
        leftPanell.getChildren().addAll(bigBox1);

        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");

        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
        });
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext1.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext1.setText(String.valueOf(nilaiMassa/nilaiMr));
            }
            else if(nAtext2.getText().equals("")){
                Double nilain = Double.parseDouble(nAtext1.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext2.setText(String.valueOf(nilaiMr*nilain));
            }
            else if(nAtext3.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilain = Double.parseDouble(nAtext1.getText());
                nAtext3.setText(String.valueOf(nilaiMassa/nilain));
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
    }
    public static void Presentasi() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        bigBox1.setPadding(new Insets(128,0,128.5,0));
        Label titleMol = new Label("Persentase");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);

        Label n = new Label("%mA");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");

        Label massa = new Label("Massa Unsur");
        massa.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        HBox massaBox = new HBox(massa, nAtext2);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(10);

        Label Mr = new Label("Massa Campuran");
        Mr.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-border-color:#484A50;-fx-background-color:white;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        HBox mRBox = new HBox(Mr, nAtext3);
        mRBox.setAlignment(Pos.CENTER);
        mRBox.setSpacing(10);
        
        Rectangle garis = new Rectangle();
        garis.setWidth(294);
        garis.setHeight(7);
        Label per = new Label("X 100%");
        per.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        VBox sen = new VBox(per);
        sen.setAlignment(Pos.CENTER);
        VBox rumus = new VBox(massaBox,garis,mRBox);
        rumus.setSpacing(10);

        HBox bawah = new HBox(n,nAtext1,eq,rumus,sen);
        bawah.setAlignment(Pos.CENTER);
        bawah.setSpacing(20);

        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill:#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);

        bigBox1.addColumn(0, titleBox, bawah, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        bigBox1.setStyle("-fx-background-color : #F5B193");
        leftPanell.getChildren().addAll(bigBox1);

        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");

        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
        });
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext1.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext1.setText(String.valueOf((nilaiMassa/nilaiMr)*100));
            }
            else if(nAtext2.getText().equals("")){
                Double nilain = Double.parseDouble(nAtext1.getText());
                Double nilaiMr = Double.parseDouble(nAtext3.getText());
                nAtext2.setText(String.valueOf(nilaiMr*nilain/100));
            }
            else if(nAtext3.getText().equals("")){
                Double nilaiMassa = Double.parseDouble(nAtext2.getText());
                Double nilain = Double.parseDouble(nAtext1.getText());
                nAtext3.setText(String.valueOf(nilaiMassa/nilain/100));
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
    }
    public static void GasIdeal() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        Label titleMol = new Label("Persentase");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);

        Label p = new Label("P");
        p.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        VBox p1 = new VBox(p,nAtext1);
        p1.setSpacing(10);
        p1.setAlignment(Pos.CENTER);
        Label v = new Label("V");
        v.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        VBox v1 = new VBox(v,nAtext2);
        v1.setSpacing(10);
        v1.setAlignment(Pos.CENTER);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        VBox eq1 = new VBox(eq);
        eq1.setSpacing(10);
        eq1.setAlignment(Pos.CENTER);
        Label n = new Label("n");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        VBox n1 = new VBox(n,nAtext3);
        n1.setSpacing(10);
        n1.setAlignment(Pos.CENTER);
        Label r = new Label("R");
        r.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext4 = new TextField();
        nAtext4.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext4.setPrefSize(100, 56);
        VBox r1 = new VBox(r,nAtext4);
        r1.setSpacing(10);
        r1.setAlignment(Pos.CENTER);
        Label t = new Label("T");
        t.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';");
        TextField nAtext5 = new TextField();
        nAtext5.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 18pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext5.setPrefSize(100, 56);
        VBox t1 = new VBox(t,nAtext5);
        t1.setSpacing(10);
        t1.setAlignment(Pos.CENTER);
        HBox massaBox = new HBox(p1,v1,eq1,n1,r1,t1);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(15);

        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill:#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);

        bigBox1.addColumn(0, titleBox, massaBox, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        bigBox1.setStyle("-fx-background-color : #F4B5D0");
        leftPanell.getChildren().addAll(bigBox1);

        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");

        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
            nAtext4.clear();
            nAtext5.clear();
        });
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext1.getText().equals("")){
                Double nilai1 = Double.parseDouble(nAtext2.getText());
                Double nilai2 = Double.parseDouble(nAtext3.getText());
                Double nilai3 = Double.parseDouble(nAtext4.getText());
                Double nilai4 = Double.parseDouble(nAtext5.getText());
                nAtext1.setText(String.valueOf((nilai2*nilai3*nilai4)/nilai1));
            }
            else if(nAtext2.getText().equals("")){
                Double nilai1 = Double.parseDouble(nAtext1.getText());
                Double nilai2 = Double.parseDouble(nAtext3.getText());
                Double nilai3 = Double.parseDouble(nAtext4.getText());
                Double nilai4 = Double.parseDouble(nAtext5.getText());
                nAtext2.setText(String.valueOf((nilai2*nilai3*nilai4)/nilai1));
            }
            else if(nAtext3.getText().equals("")){
                Double nilai1 = Double.parseDouble(nAtext1.getText());
                Double nilai2 = Double.parseDouble(nAtext2.getText());
                Double nilai3 = Double.parseDouble(nAtext4.getText());
                Double nilai4 = Double.parseDouble(nAtext5.getText());
                nAtext3.setText(String.valueOf((nilai1*nilai2/nilai3*nilai4)));
            }
            else if(nAtext4.getText().equals("")){
                Double nilai1 = Double.parseDouble(nAtext1.getText());
                Double nilai2 = Double.parseDouble(nAtext2.getText());
                Double nilai3 = Double.parseDouble(nAtext3.getText());
                Double nilai4 = Double.parseDouble(nAtext5.getText());
                nAtext4.setText(String.valueOf((nilai1*nilai2/nilai3*nilai4)));
            }
            else if(nAtext5.getText().equals("")){
                Double nilai1 = Double.parseDouble(nAtext1.getText());
                Double nilai2 = Double.parseDouble(nAtext2.getText());
                Double nilai3 = Double.parseDouble(nAtext3.getText());
                Double nilai4 = Double.parseDouble(nAtext4.getText());
                nAtext5.setText(String.valueOf((nilai1*nilai2/nilai3*nilai4)));
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
    }
    public static void FraksiMol() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        bigBox1.setPadding(new Insets(128.5,110,128.5,110));
        Label titleMol = new Label("FRAKSI MOL");
        titleMol.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 45pt 'Arial';");
        HBox titleBox = new HBox(titleMol);
        titleBox.setAlignment(Pos.CENTER);

        Label n = new Label("xA");
        n.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';");
        TextField nAtext1 = new TextField();
        nAtext1.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext1.setPrefSize(100, 56);
        Label eq = new Label("=");
        eq.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';");

        Label massa = new Label("nA");
        massa.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';");
        TextField nAtext2 = new TextField();
        nAtext2.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext2.setPrefSize(100, 56);
        HBox massaBox = new HBox(massa, nAtext2);
        massaBox.setAlignment(Pos.CENTER);
        massaBox.setSpacing(10);

        Label Mr = new Label("nA");
        Mr.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';");
        TextField nAtext3 = new TextField();
        nAtext3.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext3.setPrefSize(100, 56);
        Label nB = new Label("+ nB");
        nB.setStyle("-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';");
        TextField nAtext4 = new TextField();
        nAtext4.setStyle("-fx-background-color:white;-fx-border-COLOR:#484A50;-fx-text-fill:#484A50;-fx-font:normal bold 20pt 'Arial';-fx-border-width:3;-fx-background-radius:0.5em;-fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext4.setPrefSize(100, 56);
        
        
        
        HBox mRBox = new HBox(Mr, nAtext3,nB,nAtext4);
        mRBox.setAlignment(Pos.CENTER);
        mRBox.setSpacing(10);
        
        Rectangle garis = new Rectangle();
        garis.setWidth(294);
        garis.setHeight(7);
        
        VBox rumus = new VBox(massaBox,garis,mRBox);
        rumus.setSpacing(10);

        HBox bawah = new HBox(n,nAtext1,eq,rumus);
        bawah.setAlignment(Pos.CENTER);
        bawah.setSpacing(20);

        Button hitung = new Button("HITUNG");
        hitung.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        hitung.setCursor(Cursor.HAND);
        Button clear = new Button("CLEAR");
        clear.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        clear.setCursor(Cursor.HAND);
        HBox hitungBox = new HBox(clear,hitung);
        hitungBox.setAlignment(Pos.CENTER);
        hitungBox.setSpacing(20);
        Label again = new Label("");
        again.setStyle("-fx-text-fill:#AD3034;-fx-font:normal bold 18pt 'Arial';");
        HBox againBox = new HBox(again);
        againBox.setAlignment(Pos.CENTER);

        bigBox1.addColumn(0, titleBox, bawah, againBox,hitungBox);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setVgap(40);
        bigBox1.setStyle("-fx-background-color : #F6EC7D");
        leftPanell.getChildren().addAll(bigBox1);

        nAtext1.setText("");
        nAtext2.setText("");
        nAtext3.setText("");
        nAtext4.setText("");

        clear.setOnAction(act->{
            again.setText("");
            nAtext1.clear();
            nAtext2.clear();
            nAtext3.clear();
            nAtext4.clear();
        });
        int maxLength = 3;
        hitung.setOnAction(act->{
            again.setText("");
            if(nAtext2.getText().equals("")){
                if(!nAtext3.getText().equals("")||nAtext3.getText().equals(nAtext2.getText())){
                    nAtext2.setText(nAtext3.getText());
                }
            }
            else if(nAtext3.getText().equals("")){
                if(!nAtext2.getText().equals("")||nAtext2.getText().equals(nAtext3.getText())){
                    nAtext3.setText(nAtext2.getText());
                }
            }
            if(nAtext1.getText().equals("")){
                Double nilaiNa = Double.parseDouble(nAtext2.getText());
                Double nilaiNb = Double.parseDouble(nAtext4.getText());
                if(String.valueOf(nilaiNa/(nilaiNa+nilaiNb)).length()>maxLength){
                    String s = String.valueOf(nilaiNa/(nilaiNa+nilaiNb)).substring(0, maxLength);
                    nAtext1.setText(s);
                }
                else{
                    nAtext1.setText(String.valueOf(nilaiNa/(nilaiNa+nilaiNb)));
                }
            }
            else if(nAtext4.getText().equals("")){
                Double nilaixa = Double.parseDouble(nAtext1.getText());
                Double nilaiNA = Double.parseDouble(nAtext2.getText());
                if(String.valueOf((nilaiNA/nilaixa)-nilaiNA).length()>maxLength){
                    String s = String.valueOf((nilaiNA/nilaixa)-nilaiNA).substring(0, maxLength);
                    nAtext4.setText(s);
                }
                
                else{
                    nAtext4.setText(String.valueOf((nilaiNA/nilaixa)-nilaiNA));
                }
            }
            else if(nAtext2.getText().equals("")||nAtext3.getText().equals("")){
            }
            else if(nAtext2.getText().equals("")&&nAtext3.getText().equals("")){
            }
            else{
                again.setText("Harap Clear Dulu");
            }
        });
    }
    public static String auferbau () throws Exception{
        File dataSumber = new File(ioGol);
        String aufbau = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(dataSumber);
            br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                aufbau += str;
            }
        } finally {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return aufbau;
    } 
    public static String elektronValensiA(String atomer) throws Exception{
        String pembagianAwal []= auferbau().split("#");
        String golongan []= new String[pembagianAwal.length];
        String atomGolongan []= new String[pembagianAwal.length];
        String valensi[] = new String[pembagianAwal.length];
        for(int i=0;i<pembagianAwal.length;i++){
            String spilter [] = pembagianAwal[i].split(":");
            golongan [i] = spilter[0];
            String spilter2 [] = spilter[1].split("!");
            atomGolongan[i] = spilter2[0];
            valensi[i] = spilter2[1];
        }
        for(int i=0;i<golongan.length;i++){
            String atomIni [] = atomGolongan[i].split(";");
            for(int j=0;j<atomIni.length;j++){
                if(atomer.equals(atomIni[j])){
                    return golongan[i];
                }
            }
        }
        return "";
    }
    public static String elektronValensiB(String atomer) throws Exception{
        String pembagianAwal []= auferbau().split("#");
        String golongan []= new String[pembagianAwal.length];
        String atomGolongan []= new String[pembagianAwal.length];
        String valensi[] = new String[pembagianAwal.length];
        for(int i=0;i<pembagianAwal.length;i++){
            String spilter [] = pembagianAwal[i].split(":");
            golongan [i] = spilter[0];
            String spilter2 [] = spilter[1].split("!");
            atomGolongan[i] = spilter2[0];
            valensi[i] = spilter2[1];
        }
        for(int i=0;i<golongan.length;i++){
            String atomIni [] = atomGolongan[i].split(";");
            for(int j=0;j<atomIni.length;j++){
                if(atomer.equals(atomIni[j])){
                    return valensi[i];
                }
            }
        }
        return "";
    }
    public static void letakAtom() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        Label noAtom = new Label("No Atom");
        noAtom.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 35pt 'Arial';-fx-background-radius:1em");
        TextField nAtext = new TextField();
        nAtext.setStyle("-fx-background-color:white;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:0.5em;-fx-border-color: black; -fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext.setMaxSize(68, 68);
        Button submit1 = new Button("Submit");
        submit1.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        submit1.setCursor(Cursor.HAND);
        VBox inp1 = new VBox(noAtom,nAtext,submit1);
        inp1.setAlignment(Pos.CENTER);
        inp1.setSpacing(23);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setPadding(new Insets(128.5,155,128.5,155));
        bigBox1.setVgap(5);
        bigBox1.add(inp1, 0, 0);
        Label output2= new Label("");
        output2.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox utamaC = new HBox(output2);
        utamaC.setAlignment(Pos.CENTER);
        bigBox1.add(utamaC, 0, 5);
        submit1.setOnAction(act->{ 
            try {
                String m = String.valueOf(nAtext.getText());
                if(Integer.valueOf(m)<=103&&Integer.valueOf(m)>=1){
                    output2.setText("Golongan "+elektronValensiA(m));
                }
                else{
                    output2.setText("Golongan Tidak Diketahui");
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        });
        bigBox1.setStyle("-fx-background-color: #D0A9CD;");
        leftPanell.getChildren().addAll(bigBox1);
    }

    public static void elekValensi() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        Label noAtom = new Label("No Atom");
        noAtom.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 35pt 'Arial';-fx-background-radius:1em");
        TextField nAtext = new TextField();
        nAtext.setStyle("-fx-background-color:white;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:0.5em;-fx-border-color: black; -fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext.setMaxSize(68, 68);
        Button submit1 = new Button("Submit");
        submit1.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        submit1.setCursor(Cursor.HAND);
        VBox inp1 = new VBox(noAtom,nAtext,submit1);
        inp1.setAlignment(Pos.CENTER);
        inp1.setSpacing(23);

        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setPadding(new Insets(128.5,155,128.5,155));
        bigBox1.setVgap(5);
        bigBox1.add(inp1, 0, 0);
        Label output2= new Label("");
        output2.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox utamaC = new HBox(output2);
        utamaC.setAlignment(Pos.CENTER);
        bigBox1.add(utamaC, 0, 5);
        submit1.setOnAction(act->{ 
            try {
                String m = String.valueOf(nAtext.getText());
                if(Integer.valueOf(m)<=103&&Integer.valueOf(m)>=1){
                    output2.setText("Elektron Valensi "+elektronValensiB(m));
                }
                else{
                    output2.setText("Elektron Valensi Tidak Diketahui");
                }
            }catch (Exception c){
                c.printStackTrace();
            }
        });
        bigBox1.setStyle("-fx-background-color: #F4B3B3;");
        leftPanell.getChildren().addAll(bigBox1);
    }
    //method bilangan kuantum
    static Label utama;
    static Label azimut;
    static Label magnetik;
    static Label spin;
    public static void bilanganKuantum() throws Exception{
        GridPane bigBox1 = new GridPane();
        bigBox1.setPrefSize(809, 638.36);
        Label noAtom = new Label("No Atom");
        noAtom.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 35pt 'Arial';-fx-background-radius:1em");
        TextField nAtext = new TextField();
        nAtext.setStyle("-fx-background-color:white;-fx-font:normal bold 25pt 'Arial';-fx-background-radius:0.5em;-fx-border-color: black; -fx-border-width: 3; -fx-padding: 5px; -fx-border-radius: 0.5em");
        nAtext.setMaxSize(68, 68);
        Button submit1 = new Button("Submit");
        submit1.setStyle("-fx-text-fill:white;-fx-background-color:#222222;-fx-font-family:'Arial';-fx-font-size: 28pt;-fx-background-radius:1em;");
        submit1.setCursor(Cursor.HAND);
        VBox inp1 = new VBox(noAtom,nAtext,submit1);
        inp1.setAlignment(Pos.CENTER);
        inp1.setSpacing(23);
        bigBox1.setAlignment(Pos.CENTER);
        bigBox1.setPadding(new Insets(128.5,155,128.5,155));
        bigBox1.setVgap(5);
        bigBox1.add(inp1, 0, 0);
        utama = new Label("");
        utama.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox utamaC = new HBox(utama);
        utamaC.setAlignment(Pos.CENTER_LEFT);
        azimut = new Label("");
        azimut.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox azimutC = new HBox(azimut);
        azimutC.setAlignment(Pos.CENTER_LEFT);
        magnetik = new Label("");
        magnetik.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox magnetikC = new HBox(magnetik);
        magnetikC.setAlignment(Pos.CENTER_LEFT);
        spin = new Label("");
        spin.setStyle("-fx-text-fill:#222222;-fx-font:normal bold 20pt 'Arial';");
        HBox spinC = new HBox(spin);
        spinC.setAlignment(Pos.CENTER_LEFT);
        bigBox1.add(utamaC, 0, 5);
        bigBox1.add(azimutC, 0, 6);
        bigBox1.add(magnetikC, 0, 7);
        bigBox1.add(spinC, 0, 8);
        submit1.setOnAction(act->{ 
            try {
                Integer protonS = Integer.parseInt(nAtext.getText());
                rumusKuantum(protonS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        bigBox1.setStyle("-fx-background-color: #B7E3AE;");
        leftPanell.getChildren().addAll(bigBox1);
    }

    //rumus bilngan kuantum
    public static void rumusKuantum(Integer protonS) throws Exception{
        File dataSumber = new File(ioAsasAufbau);
        String aufbau = "";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(dataSumber);
            br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                aufbau += str;
            }
        } finally {
            if (br != null) {
                br.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        String pembagianAwal []= aufbau.split("#");
        Integer elektronAtas []=new Integer[pembagianAwal.length];
        int kulit []=new int[pembagianAwal.length];
        String subKulit []=new String[pembagianAwal.length];
        String bagi2 []=new String[pembagianAwal.length];
        for(int i=0;i<pembagianAwal.length;i++){
            String spilter [] = pembagianAwal[i].split(":");
            bagi2 [i] = spilter[0];
            elektronAtas [i] = Integer.valueOf(spilter[1]);   
        }
        for(int i=0;i<pembagianAwal.length;i++){
            String spilter [] = bagi2[i].split(";");
            kulit [i] = Integer.valueOf(spilter [0]);
            subKulit [i] = spilter [1];
        }
        boolean finish = true;
        int i=0;
        int protonian = protonS;
        int n=protonian;
        //untuk mencari letak elektron  terakhir
        while(finish){
            if(protonian>elektronAtas[i]){
                n = protonian-elektronAtas[i];
                protonian = n;
            }
            else{
                finish = false;
            }
            i++;
        }
        //kulit letak elektron terakhir
        int kulitku = kulit[i-1];
        //subkulit letak elektron terakhir
        String subKulitku = subKulit[i-1];
        int elektronku = n;
        //set kulir
        utama.setText("Utama (n)\t=   "+String.valueOf(kulitku));
        //set subkulit
        int azim = 0;
        if(subKulitku.equals("s")){
            azim = 0;
        }
        else if(subKulitku.equals("p")){
            azim = 1;
        }
        else if(subKulitku.equals("d")){
            azim =2;
        }
        else if(subKulitku.equals("f")){
            azim = 3;
        }
        azimut.setText("Azimut (l)\t=   "+azim);
        //menentukan bilangan kuantum magnetik dari -l sampai l
        int magnet [] = new int [azim+(azim+1)];
        int x = 0;
        for(int j=-azim;j<azim+1;j++){
            magnet[x] = j;
            x++;
        }
        int m = elektronku>magnet.length?elektronku-magnet.length:elektronku;
        magnetik.setText("Magnetik (m)\t=   "+String.valueOf(magnet[m-1]));
        //menentukan bilangan kuantum spin
        String k = elektronku>magnet.length?"-1/2":"1/2";
        spin.setText("Spin (s)\t\t= "+k);
    }
    public static void main(String[] args) {
        //perintah menjalankan aplikasi
        Application.launch(args);
    }
}