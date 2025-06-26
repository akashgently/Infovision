package com.Day12;

import java.util.Stack;

public class DocumentVersionHistory {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    String currentVersion = "Initial Version";

    public void saveVersion(String newVersion){
        undoStack.push(currentVersion);
        currentVersion = newVersion;
        redoStack.clear();
        System.out.println("Saved new version: " + currentVersion);
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            redoStack.push(currentVersion);
            currentVersion = undoStack.pop();
            System.out.println("Undo to version " + currentVersion);
        } else {
            System.out.println("No older version to undo to");
        }
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            undoStack.push(currentVersion);
            currentVersion = redoStack.pop();
            System.out.println("Redo to version " + currentVersion);
        } else {
            System.out.println("No newer version to redo to");
        }
    }

    public void showCurrentVersion(){
        System.out.println("Current Document Version " + currentVersion);
    }

    public static void main(String[] args) {
        DocumentVersionHistory history = new DocumentVersionHistory();
        history.saveVersion("Draft 1");
        history.saveVersion("Draft 2");
        history.saveVersion("Final Draft");

        history.undo();
        history.undo();
        history.undo();

        history.redo();
        history.redo();

        history.showCurrentVersion();
    }
}
