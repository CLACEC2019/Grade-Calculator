package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {

    Stage window;
    ObservableList<PieChart.Data> pieChartData;
    ObservableList<PieChart.Data> pieChartTestData;
    ArrayList<Double> tempList;

    public String ClassName;
    public int TestScale;
    public int ProjectScale;
    public int AssignmentScale;
    public int QuizeScale;

    public int Test1;
    public int Test2;
    public int Test3;
    public int Test4;
    public int classIndex;
    public double testAverage;

    public String textStyle;
    public String textStyle2;
    public String textStyle3;
    public String buttonStlye;
    public String buttonStlye2;
    public String buttonStlye3;
    public String currentClassObject;
    public String textFieldStlye;
    ClassList classList;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{

    textStyle2 = "-fx-font-size: 20px";
    textStyle = "-fx-font-size: 30px";
    textStyle3 = "-fx-font-size: 18px";
    buttonStlye2 = "-fx-background-color: #228B22; -fx-color: white; -fx-font-size: 15px; -fx-padding: 10px 24px; -fx-border-radius: 15px;";
    buttonStlye = "-fx-background-color: #228B22; -fx-color: white; -fx-font-size: 16px; -fx-padding: 10px 24px; -fx-border-radius: 20px;";
    buttonStlye3 = "-fx-background-color: #228B22; -fx-color: white; -fx-font-size: 12px; -fx-padding: 10px 24px; -fx-border-radius: 20px;";
    textFieldStlye = "-fx-border-color: green; -fx-border-width: 2; -fx-border-radius: 5;-fx-font-size: 18;";

    window = primaryStage;
    mainPage();

    }

    public void mainPage() throws FileNotFoundException{
        classIndex = 0;
        classList = new ClassList() ;
        Label text = new Label(" CLACEC");
        text.setStyle(textStyle);

        Label text2 = new Label("Grade Calculator");
        text2.setStyle(textStyle);
        Button button1 = new Button();
        button1.setText("Press Start to Begin");
        button1.setTextFill(Color.WHITE);
        button1.setStyle(buttonStlye);


        Image img = new Image(new FileInputStream("logo.png"));
        ImageView imgView = new ImageView(img);

        //setting the fit height and width of the image view
        imgView.setFitHeight(350);
        imgView.setFitWidth(400);

        //Setting the preserve ratio of the image view
        imgView.setPreserveRatio(true);


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addClassPage();
            }
        });


        VBox verticalLayout = new VBox();
        verticalLayout.setAlignment(Pos.CENTER);
        verticalLayout.getChildren().addAll( imgView, text, text2, button1);

        Scene scene = new Scene(verticalLayout, 600, 600);

        window.setTitle("Grade Calculator");
        window.setScene(scene);

        window.show();


    }

    public void ClassAveragePage(){

        VBox box = new VBox();
        Group root = new Group();
        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(600, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(8);
        gridPane.setHgap(3);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        Label classNameLabel = new Label(classList.list.get(classIndex).name);
        Label projectScoreLabel = new Label("Project Average ( "+ classList.list.get(classIndex).project+ "% )");
        Label assigmentScoreLabel = new Label("Assignment Average ( "+classList.list.get(classIndex).assignment+"% )");
        Label testScoreLabel = new Label("Test Average ( "+classList.list.get(classIndex).test+"% )");
        Label quizScoreLabel = new Label("Quiz Average ( "+ classList.list.get(classIndex).quiz+"% )");
        Label homeworkScoreLabel = new Label("Homework Average ( "+ classList.list.get(classIndex).homework+"% )");
        Label ClassAverage = new Label("Class Average");

        classNameLabel.setStyle(textStyle);
        classNameLabel.setAlignment(Pos.CENTER);
        projectScoreLabel.setStyle(textStyle3);
        assigmentScoreLabel.setStyle(textStyle3);
        testScoreLabel.setStyle(textStyle3);
        quizScoreLabel.setStyle(textStyle3);
        homeworkScoreLabel.setStyle(textStyle3);
        ClassAverage.setStyle(textStyle2);


        Label projectScoreValue = new Label(classList.list.get(classIndex).getProjectAverage()+"%");
        Label assigmentScoreValue = new Label(classList.list.get(classIndex).getAssignmentAverage()+"%");
        Label textScorValue = new Label(classList.list.get(classIndex).getTestAverage()+"%");
        Label quizScoreValue = new Label(classList.list.get(classIndex).getQuizAverage()+"%");
        Label homeworkScoreValue = new Label(classList.list.get(classIndex).getHomeworkAverage()+"%");
        Label classAverageValue = new Label("Total Average"+classList.list.get(classIndex).getClassAverage()+"%");

        projectScoreValue.setStyle(textStyle3);
        assigmentScoreValue.setStyle(textStyle3);
        textScorValue.setStyle(textStyle3);
        quizScoreValue.setStyle(textStyle3);
        homeworkScoreValue.setStyle(textStyle3);
        classAverageValue.setStyle(textStyle2);

        Button projectEdit = new Button("Edit");
        Button assignmentEdit = new Button("Edit");
        Button testEdit = new Button("Edit");
        Button quizEdit = new Button("Edit");
        Button homeworkEdit = new Button("Edit");
        Button deleteB = new Button("Delete");

        projectEdit.setStyle(buttonStlye3);
        assignmentEdit.setStyle(buttonStlye3);
        testEdit.setStyle(buttonStlye3);
        quizEdit.setStyle(buttonStlye3);
        homeworkEdit.setStyle(buttonStlye3);
        deleteB.setStyle(buttonStlye3);
        deleteB.setTextFill(Color.WHITE);

        projectEdit.setTextFill(Color.WHITE);
        assignmentEdit.setTextFill(Color.WHITE);
        testEdit.setTextFill(Color.WHITE);
        quizEdit.setTextFill(Color.WHITE);
        homeworkEdit.setTextFill(Color.WHITE);



        Button NextButton = new Button();
        NextButton.setText("Back");
        Button graphButton = new Button();
        graphButton.setText("Display PieChart");
        graphButton.setStyle(buttonStlye2);
        graphButton.setTextFill(Color.WHITE);

        assignmentEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPageAssignemnt("Assignment");
            }
        });

        projectEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPageAssignemnt("Project");
            }
        });

        testEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPageAssignemnt("Test");
            }
        });

        quizEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPageAssignemnt("Quiz");
            }
        });

        homeworkEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditPageAssignemnt("Homework");
            }
        });


        NextButton.setStyle(buttonStlye2);
        NextButton.setTextFill(Color.WHITE);
        NextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listViewPage();
            }
        });


        gridPane.add(classNameLabel, 0, 0);
        gridPane.add(projectScoreLabel, 0, 1);
        gridPane.add(assigmentScoreLabel, 0, 2);
        gridPane.add(testScoreLabel, 0, 3);
        gridPane.add(quizScoreLabel, 0, 4);
        gridPane.add(homeworkScoreLabel, 0, 5);
        gridPane.add(ClassAverage, 0, 6);

        gridPane.add(projectScoreValue, 1,1);
        gridPane.add(assigmentScoreValue, 1, 2);
        gridPane.add(textScorValue, 1, 3);
        gridPane.add(quizScoreValue, 1, 4);
        gridPane.add(homeworkScoreValue, 1, 5);
        gridPane.add(classAverageValue, 1, 6);
        gridPane.add(NextButton, 2, 7);

        gridPane.add(projectEdit, 2,1);
        gridPane.add(assignmentEdit, 2, 2);
        gridPane.add(testEdit, 2, 3);
        gridPane.add(quizEdit, 2, 4);
        gridPane.add(homeworkEdit, 2, 5);
        gridPane.add(deleteB, 0,7);

        deleteB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                classList.list.remove(classIndex);
                System.out.println("Length: "+classList.list.size());
                classList.length -=1;
                listViewPage();
            }
        });

        Button editButton = new Button();
        editButton.setText("Edit");
        editButton.setTextFill(Color.WHITE);
        editButton.setStyle(buttonStlye2);



        box.getChildren().addAll(gridPane, root);

        Scene scene = new Scene(box, 600, 600);
        window.setScene(scene);
        window.show();

    }


    public void EditPageAssignemnt(String category){

        //ArrayList<Double> tempList;

        VBox vbox = new VBox();
        HBox hbox = new HBox();

        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);

        Label assingmentLabel = new Label(category);
        Label gradeLabel = new Label("Grade: ");
        TextField grade = new TextField();
        Button enterGradeB = new Button("Enter Grade");
        Button doneButton = new Button("Done");
        doneButton.setAlignment(Pos.CENTER);

        Label averageLabel = new Label();

        if(category.equals("Assignment")){
            tempList = classList.list.get(classIndex).assignmentList;
            averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getAssignmentAverage()));
        }
        else if(category.equals("Project")){
            tempList = classList.list.get(classIndex).projectList;
            averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getProjectAverage()));
        }
        else if(category.equals("Test")){
            tempList = classList.list.get(classIndex).testList;
            averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getTestAverage()));
        }
        else if(category.equals("Quiz")){
            tempList = classList.list.get(classIndex).quizList;
            averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getQuizAverage()));
        }
        else if(category.equals("Homework")){
            tempList = classList.list.get(classIndex).homeworkList;
            averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getHomeworkAverage()));
        }

        hbox.getChildren().addAll(gradeLabel, grade, enterGradeB);

        ListView<String> list = new ListView<>();
        Scene scene = new Scene(vbox, 600, 600);


        for(int i = 0; i < tempList.size(); i++) {
            list.getItems().add("Grade "+(i+1)+": "+tempList.get(i));
        }

        enterGradeB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //ListView<String> list1 = new ListView<>();
                //ArrayList<Double> tempList =  classList.list.get(classIndex).assignmentList;

                tempList.add(Double.parseDouble(grade.getText()));
                list.getItems().clear();

                for(int i = 0; i < tempList.size(); i++) {
                    list.getItems().add("Grade "+(i+1)+": "+tempList.get(i));
                }

                grade.clear();

                if(category.equals("Assignment")){
                    averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getAssignmentAverage()));
                }
                else if(category.equals("Project")){
                    averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getProjectAverage()));
                }
                else if(category.equals("Test")){
                    averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getTestAverage()));
                }
                else if(category.equals("Quiz")){
                    averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getQuizAverage()));
                }
                else if(category.equals("Homework")){
                    averageLabel.setText("Average: "+Double.toString(classList.list.get(classIndex).getHomeworkAverage()));
                }

            }
        });

        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ClassAveragePage();
            }
        });

        vbox.getChildren().addAll(assingmentLabel, hbox, list, averageLabel,doneButton);

        window.setScene(scene);
        window.show();

    }
    public static void main(String[] args) {
        launch(args);
    }


    public void addClassPage(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        //box.setPadding(new Insets(10, 10, 30, 10));

        Button add = new Button("Add Class");
        add.setStyle(buttonStlye2);
        add.setTextFill(Color.WHITE);
        add.setAlignment(Pos.CENTER);

        Label text = new Label("Class Grading Scale");
        text.setAlignment(Pos.CENTER);
        Label className = new Label("Class Name:");
        Label testScoreLabel = new Label("Test:");
        Label assignmentScoreLabel = new Label("Assignment:");
        Label projectscoreLabel = new Label("Project:");
        Label quizesscoreLabel = new Label("Quiz:");
        Label homeworkScoreLabel = new Label("Homework:");


        TextField classNameField = new TextField();
        TextField testScoreField = new TextField();
        TextField assignmentScoreField = new TextField();
        TextField projectScoreField = new TextField();
        TextField quizeScoreField = new TextField();
        TextField homeworkScoreField = new TextField();

        classNameField.setStyle(textFieldStlye);
        testScoreField.setStyle(textFieldStlye);
        assignmentScoreField.setStyle(textFieldStlye);
        projectScoreField.setStyle(textFieldStlye);
        quizeScoreField.setStyle(textFieldStlye);
        homeworkScoreField.setStyle(textFieldStlye);

        text.setStyle(textStyle);
        className.setStyle(textStyle2);
        testScoreLabel.setStyle(textStyle2);
        assignmentScoreLabel.setStyle(textStyle2);
        projectscoreLabel.setStyle(textStyle2);
        quizesscoreLabel.setStyle(textStyle2);
        homeworkScoreLabel.setStyle(textStyle2);
        //classNameField.set

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                addC(classNameField.getText(), Integer.parseInt(projectScoreField.getText()), Integer.parseInt(assignmentScoreField.getText()), Integer.parseInt(testScoreField.getText()), Integer.parseInt(quizeScoreField.getText()), Integer.parseInt(homeworkScoreField.getText()));
                listViewPage();
            }
        });
        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(600, 200);

        //Setting the padding
        gridPane.setPadding(new Insets(20, 10, 20, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(20);
        gridPane.setHgap(8);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //gridPane.add(text, 0, 0);
        gridPane.add(className, 0, 1);
        gridPane.add(testScoreLabel, 0, 2);
        gridPane.add(assignmentScoreLabel, 0, 3);
        gridPane.add(projectscoreLabel, 0, 4);
        gridPane.add(quizesscoreLabel, 0, 5);
        gridPane.add(homeworkScoreLabel, 0, 6);


        gridPane.add(classNameField, 1,1);
        gridPane.add(testScoreField, 1, 2);
        gridPane.add(assignmentScoreField, 1, 3);
        gridPane.add(projectScoreField, 1, 4);
        gridPane.add(quizeScoreField, 1, 5);
        gridPane.add(homeworkScoreField, 1, 6);
        //gridPane.add(add, 1, 7);



        box.getChildren().addAll(text,gridPane,add);
        Scene scene = new Scene(box, 600, 600);
        window.setScene(scene);
        window.show();


    }

    public void listViewPage(){

        Label label = new Label("Classes");
        label.setStyle(textStyle);
        Button button = new Button("Add More Class");


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addClassPage();
            }
        });


        button.setStyle(buttonStlye);
        button.setTextFill(Color.WHITE);

        VBox  box =  new VBox();
        ListView<String> list = new ListView<>();


        for(int i = 0; i < classList.length; i++) {
            list.getItems().add((classList.list.get(i).name)+"     ( "+classList.list.get(i).letterGrade() +" )");
        }

        list.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        String classN = new_val;
                        for(int i = 0; i < classList.length; i++){
                            if(classN.equals((classList.list.get(i).name)+"     ( "+classList.list.get(i).letterGrade() +" )")){
                                classIndex = i;
                            }
                        }
                        ClassAveragePage();
                    }
                });

        box.getChildren().addAll(label, list, button);

        Scene scene = new Scene(box, 600, 600);

        window.setScene(scene);
        window.show();
    }
    //Adds a class to the class list
    public void addC(String name, int project, int assignment, int test, int quiz, int homework ){
        classList.addClass(name, project,assignment,test, quiz,homework);
    }

}






