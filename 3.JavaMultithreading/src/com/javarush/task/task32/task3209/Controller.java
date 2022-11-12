package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
    View viewObj=new View();
    Controller controller = new Controller(viewObj);

    viewObj.setController(controller);
    viewObj.init();
    controller.init();
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader,document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile=null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
                currentFile=jFileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());
                try (FileReader fileReader = new FileReader(currentFile)) {
                    new HTMLEditorKit().read(fileReader, document, 0);
                    view.resetUndo();
                } catch (IOException | BadLocationException e) {
                    ExceptionHandler.log(e);
            }
        }
    }


    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile == null)
            saveDocumentAs();
        else {
            try {
                view.setTitle(currentFile.getName());
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                currentFile=jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());
                try (FileWriter fileWriter = new FileWriter(currentFile)){
                    new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
                    fileWriter.flush();
                } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
