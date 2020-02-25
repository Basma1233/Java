package LoginForm;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import DAO.ConnexionBd;
import Entity.Student;
import Model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {

    public static Stage window;
    public static Scene primaryScene;

    public static User user;
    public static String date;
    public static Student s;// pour stocker l'utilisateur courant

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Login Form Window");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcometxt = new Text("Welcome");
        welcometxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        grid.add(welcometxt, 0, 0);

        Label lblUser = new Label("User name");
        grid.add(lblUser, 0, 1);

        TextField txtUser = new TextField();
        txtUser.setPromptText("username");
        grid.add(txtUser, 1, 1);

        Label lblPassword = new Label("Password");
        grid.add(lblPassword, 0, 2);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("password");
        grid.add(pwBox, 1, 2);

        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 3);

        loginBtn.setOnAction(e -> {

            PreparedStatement ps;
            ResultSet rs;
            String login = txtUser.getText();
            String password = String.valueOf(pwBox.getText());

            String query = "SELECT * FROM `user` WHERE `login`=? AND `password`=?";

            try {
                ps = (PreparedStatement) ConnexionBd.getConnexion().prepareStatement(query);
                ps.setString(1, login);
                ps.setString(2, password);

                rs = ps.executeQuery();

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Yes");
                    // creation de l'objet user
                    user = new User(rs.getString("login"), rs.getInt("id"), rs.getString("type"), rs.getString("password"), rs.getString("email"));

                    String interfaces = null;

                    //tester le type de celui qui se connecte
                    if (user.getType().equals("admin")) {

                        interfaces = "/Vue/FenetrePrincipaleAdmin.fxml";
                    } else if (user.getType().equals("prof")) {

                        interfaces = "/Vue/Prof.fxml";
                        /*
                        * yzid else if lahne
                         */
                    }
                    try {
                        final FXMLLoader fxmlLoader
                                = new FXMLLoader(this.getClass().getResource(interfaces));

                        Parent root1 = (Parent) fxmlLoader.load();
                        window.setScene(new Scene(root1));

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                } else {
                    query = "SELECT * FROM `student` WHERE `login`=? AND `password`=?";

                    try {
                        ps = (PreparedStatement) ConnexionBd.getConnexion().prepareStatement(query);
                        ps.setString(1, login);
                        ps.setString(2, password);

                        rs = ps.executeQuery();

                        if (rs.next()) {
                            //JOptionPane.showMessageDialog(null, "Yes");
                            // creation de l'objet user
                            date = rs.getString("DateOfBirth");
                            s = new Student(rs.getString("class"), rs.getString("mail"), rs.getString("sex"), rs.getString("name"), rs.getString("login"), rs.getString("password"), rs.getString("adress"), rs.getInt("id"));

                            String interfaces = "/Vue/StudentData.fxml";
                            try {
                                final FXMLLoader fxmlLoader
                                        = new FXMLLoader(this.getClass().getResource(interfaces));

                                Parent root1 = (Parent) fxmlLoader.load();
                                window.setScene(new Scene(root1));

                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else {
                              JOptionPane.showMessageDialog(null, "Veuiller entre un login et un password valide");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Veuiller entre un login et un password valide");
                        ex.printStackTrace();
                    }

                }

            } catch (Exception ex) {

                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        Scene scene = new Scene(grid, 500, 500);
        window.setScene(scene);

        primaryScene = primaryStage.getScene();
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
