package sample;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller extends Window {
    public Button textFileButton;
    public Button getStatsButton;
    private File textFile;

    public File openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(this);
        }

    public void getTextFile() {
        textFile = openFileChooser();
        changeEnabledProperty(getStatsButton);
    }

    public ArrayList<String[]> getTextFromTrafficFile() {
        ArrayList<String[]> trafficDataList = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(Paths.get(textFile.getAbsolutePath()));
            stream.map(line -> line.replaceAll("(\\s)+", " "))
                    .map(line -> line.split(" "))
                    .forEach(trafficDataList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficDataList.stream()
                .forEach(System.out::println);

        return trafficDataList;
    }

    private File createEmptyFile(String path) {
        File file = new File(path);

        return file;
    }

    private void writeInFile(File file, String content) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void formStatsFile() {

//        TextEditor textEditor = new TextEditor();
//        StringStatistics statistics = new StringStatistics();
//        if(ignoreFile != null) {
//            statistics.setWordsToIgnore(readTextFromFile(ignoreFile.getAbsolutePath()).split(" "));
//        }
//
//        String editedText = textEditor.getScenarioCharactersWords(readTextFromFile(textFile.getAbsolutePath()));
//        String statisticsFromText = statistics.getTextStatistics(editedText);
//
//        File statFile = createEmptyFile(Desktop.PATH_TO_DESKTOP + "statistic.txt");
//        writeInFile(statFile, statisticsFromText);


        closeWindow();
    }

    private String readTextFromFile(String filePath) {
        String fileText = "";

        try {
            fileText = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileText;
    }

    private boolean isTextFileChosen() {
        return (textFile != null);
    }

    private void changeEnabledProperty(Button button) {
        if(isTextFileChosen()) {
            button.setDisable(false);
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) getStatsButton.getScene().getWindow();
        stage.close();
    }


}
