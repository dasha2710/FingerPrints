package binarization;

import frontend.WindowApp;
import matchingPoints.MatcherHelper;
import skeletonization.TemplatesMethod;
import specialPoints.CheckingHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dasha on 22.03.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        File original_f = new File("Image7b.png");
        String firstImageName = original_f.getName();
        File original_f1 = new File("Image7a.png");
        String secondImageName = original_f1.getName();

        //Binarization
        BufferedImage original = ImageIO.read(original_f);
        BufferedImage grayscale = Util.toGray(original);
        BufferedImage binarized = Util.binarize(grayscale);
        Util.writeImage("Image7_bin1", binarized);

        BufferedImage binarized1 = Util.binarize(Util.toGray(ImageIO.read(original_f1)));

        //Skeletonization
        BufferedImage skeletonized = TemplatesMethod.makeSkeletonization(binarized);
        Util.writeImage("Image7_skelet", skeletonized);

        BufferedImage skeletonized1 = TemplatesMethod.makeSkeletonization(binarized1);

        //Special points
        CheckingHelper helper = new CheckingHelper(skeletonized);
        helper.pointsToClasses();
        java.util.Set<Point> endPoints = helper.getEndPoints();
        java.util.Set<Point> branchPoints = helper.getBranchPoints();

        CheckingHelper helper1 = new CheckingHelper(skeletonized1);
        helper1.pointsToClasses();

        java.util.Set<Point> endPoints2 = helper1.getEndPoints();
        java.util.Set<Point> branchPoints2 = helper1.getBranchPoints();

        //Matching points
        MatcherHelper matcherHelper = new MatcherHelper();
        int matchedPoints = matcherHelper.calculateMatchedPoints(endPoints, endPoints2) +
                matcherHelper.calculateMatchedPoints(branchPoints, branchPoints2);
        double percents = matchedPoints * 100 /(endPoints.size() + branchPoints.size());
        System.out.println(String.format("Finger prints match on %d percents",
                matchedPoints * 100 / (endPoints.size() + branchPoints.size())));

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            WindowApp.createGUI(firstImageName, secondImageName,
                    String.valueOf(branchPoints.size()), String.valueOf(branchPoints2.size()),
                    String.valueOf(endPoints.size()), String.valueOf(endPoints2.size()),
                    String.valueOf(percents));
        });
    }

}
