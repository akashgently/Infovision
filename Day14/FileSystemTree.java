package com.Day14;

import java.util.ArrayList;
import java.util.List;

class FileNode{
    String name;
    List<FileNode> children;
    public FileNode(String name) {
        super();
        this.name = name;
        this.children = new ArrayList<>();
    }
    public void addChild(FileNode child) {
        children.add(child);
    }
    public void print(String prefix) {
        System.out.println(prefix + name);
        for(FileNode child : children) {
            child.print(prefix + " ");
        }
    }

}
public class FileSystemTree {

    public static void main(String[] args) {
        FileNode root = new FileNode("Root");
        FileNode doc = new FileNode("Documents");
        doc.addChild(new FileNode("Core java.docx"));
        doc.addChild(new FileNode("Data structure.docx"));
        doc.addChild(new FileNode("Bank App.java"));

        root.addChild(doc);
        root.print(" ");

    }
}
