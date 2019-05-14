package sample;

import javafx.scene.control.ListView;

import java.util.ArrayList;


public class ClassList {

    ArrayList<classNode> list;
    int length;

    public ClassList(){
        this.list = new ArrayList<>();
        this.length = 0;

    }


    class classNode{

        String name;
        int project;
        int assignment;
        int test;
        int quiz;
        int homework;

        Double projectAverage;
        Double assignmentAverage;
        Double testAverage;
        Double quizAverage;
        Double homeworkAverage;
        Double classAverage;

        ArrayList<Double> projectList;
        ArrayList<Double> assignmentList;
        ArrayList<Double> testList;
        ArrayList<Double> quizList;
        ArrayList<Double> homeworkList;


        public classNode(String name, int project, int assignment, int test, int quiz, int homework  ){
            this.project = project;
            this.name  = name;
            this.assignment = assignment;
            this.quiz = quiz;
            this.test = test;
            this.homework = homework;

            this.projectAverage = 0.0;
            this.assignmentAverage = 0.0;
            this.testAverage = 0.0;
            this.quizAverage = 0.0;
            this.homeworkAverage = 0.0;

            projectList = new ArrayList<>();
            assignmentList = new ArrayList<>();
            testList = new ArrayList<>();
            quizList = new ArrayList<>();
            homeworkList = new ArrayList<>();
            this.classAverage = 0.0;

        }


        public Double getProjectAverage(){
            //projectAverage = average(projectList);
            return average(projectList);
        }

        public Double getAssignmentAverage(){
            //assignmentAverage = average(assignmentList);
            return average(assignmentList);
        }

        public Double getTestAverage(){
            //testAverage = average(testList);
            return average(testList);
        }

        public Double getQuizAverage(){
            //quizAverage = average(quizList);
            return average(quizList);
        }

        public Double getHomeworkAverage(){
            //homeworkAverage = average(homeworkList);
            return average(homeworkList);
        }

        public Double getClassAverage(){
            Double average = 0.0;
            int sum = 0;
            Double totalSum = 0.0;

            ArrayList<Double> averageList = new ArrayList<>();

            if(getQuizAverage()!= 0.0){
                sum+=quiz;
                averageList.add((quiz/100.0)*getQuizAverage());
            }
            if(getAssignmentAverage()!=0.0){
                sum+=assignment;
                averageList.add((assignment/100.0)*getAssignmentAverage());
            }
            if(getProjectAverage() != 0.0){
                sum+=project;
                averageList.add((project/100.0)*getProjectAverage());
            }
            if(getHomeworkAverage() != 0.0){
                sum+=homework;
                averageList.add((homework/100.0)*getHomeworkAverage());
            }
            if(getTestAverage() != 0.0){
                sum+=test;
                averageList.add((test/100.0)*getTestAverage());

            }

            for(int i  = 0; i < averageList.size(); i++){
                totalSum+= averageList.get(i);
            }

            average = ((totalSum/sum)*100);

            if(averageList.size()==0){
                return 0.0;
            }
            return average;
        }


        public Double average(ArrayList<Double> list){
            double average = 0;
            double sum = 0;

            if(list.size() == 0){
                return 0.0;
            }
            for(int i = 0; i < list.size(); i++){
                sum+= list.get(i);
            }

            average = sum/list.size();


            return average;
        }

        public String letterGrade(){

            double numericalAverage = this.getClassAverage();

            if(numericalAverage < 1.0){
                return "A";
            }
            else if(numericalAverage < 70.0){
                return "F";
            }
            else if(numericalAverage < 80.0){
                return "C";
            }
            else if(numericalAverage < 90.0){
                return "B";
            }
            else if(numericalAverage < 101.0){
                return "A";
            }
            return "A";
        }
    }

    public void addClass(String name, int project, int assignment, int test, int quiz, int homework  ){

        classNode node = new classNode(name,project, assignment, test, quiz, homework  );
        list.add(node);
        this.length += 1;
    }

    public ListView<String> displayList(){
        ListView<String> listView= new ListView<>();

        for(int i = 0; i < list.size(); i++){

            listView.getItems().add(list.get(i).name);
        }

        return listView;
    }

}
