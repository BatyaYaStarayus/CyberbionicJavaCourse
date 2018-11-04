package sample;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;

public class Controller extends Window {
    public Button copyButton;
    private File copyFromFile;
    private File copyToFile;
    private InputStream inputStream;
    private OutputStream outputStream;

    public File openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(Message.chooseFileMessage);
        return fileChooser.showOpenDialog(this);
        }

    public void getFromFile() {
        copyFromFile = openFileChooser();
        changeEnabledProperty(copyButton);
    }

    public void getToFile() {
        copyToFile = openFileChooser();
        changeEnabledProperty(copyButton);
    }

    public void copyFile() {
        try {
            inputStream = new FileInputStream(copyFromFile);
            outputStream = new FileOutputStream(copyToFile);

            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0 ,bytesRead);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeWindow();
    }

    private boolean areAllPathsPresent() {
        return ((copyFromFile != null) && (copyToFile != null));
    }

    private void changeEnabledProperty(Button button) {
        if(areAllPathsPresent()) {
            button.setDisable(false);
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) copyButton.getScene().getWindow();
        stage.close();
    }


}
