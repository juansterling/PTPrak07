package com.example.p_pt07_2072009;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextController {
    @FXML
    private TextArea txt;
    private Path path;

    public void open(){
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(txt.getScene().getWindow());
        if (f != null) {
            Path p = Paths.get(f.toURI());
            try {
                String jsonString = Files.readString(p);
                txt.setText(jsonString);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void save(){
        if (path!= null) {
            try {
                Files.write(path, txt.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            saveas();
        }
    }
    public void saveas(){
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(txt.getScene().getWindow());
        if (f != null) {
            path = Paths.get(f.toURI());
            try {
                Files.write(path, txt.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}