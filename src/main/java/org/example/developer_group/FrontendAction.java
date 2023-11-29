package org.example.developer_group;

public interface FrontendAction {
        void front();
        default void cofee() {
            System.out.println("Drink");
        };
}
