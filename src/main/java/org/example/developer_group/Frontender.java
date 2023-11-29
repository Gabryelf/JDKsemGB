package org.example.developer_group;

public class Frontender extends Developer implements FrontendAction{
        @Override
        public void front() {
            System.out.println("Sleep");
        }
}
