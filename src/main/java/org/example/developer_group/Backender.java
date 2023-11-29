package org.example.developer_group;

public class Backender extends Developer implements BackenAction{
    @Override
    public void back() {
        System.out.println("Backend working");
    }
}
