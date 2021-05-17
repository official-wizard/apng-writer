package ork.sevenstates.apng;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class ScreenshotsMain {

    final File fileName;
    final Robot robot;

    ScreenshotsMain(File fileName,Robot robot) {
        this.fileName = fileName;
        this.robot = robot;
    }

    public static void main(String[] args) throws Exception {
        File fileName = new File("screenshot.png");

        new ScreenshotsMain(fileName,new Robot()).writeScreenshots();
    }

    private APNGSeqWriter newWriter() throws IOException {
        return new APNGSeqWriter(fileName, 0);
    }

    private void writeImage(APNGSeqWriter writer) throws IOException {
        writer.writeImage(screenshot());
    }

    private BufferedImage screenshot() {
        return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    private void writeScreenshots() throws IOException {
        APNGSeqWriter writer = newWriter();
        for (int i = 0; i < 10; i++) {
            writeImage(writer);
            System.out.println(i);
            sleep();
        }
        writer.close();
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("???");
        }
    }
}
