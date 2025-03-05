package xyz.kimherala.lwjgltesting;

import graphics.Window;

public class Main {
    public void run() {
        Window window = new Window("lwjgltesting", 720, 720);
        window.update();
        window.terminate();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
