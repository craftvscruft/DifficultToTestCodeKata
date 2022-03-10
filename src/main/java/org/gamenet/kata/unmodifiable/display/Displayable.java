package org.gamenet.kata.unmodifiable.display;

public interface Displayable {
    enum Color {
        RED,
        GREEN,
        BLUE
    }

    void display();
}
