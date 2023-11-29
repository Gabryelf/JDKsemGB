package org.example.developer_group;

public class Main {
    public static void main(String[] args) {
        Developer dev = new Frontender();
        if(dev instanceof Frontender) ((FrontendAction) dev).front();
    }
}
