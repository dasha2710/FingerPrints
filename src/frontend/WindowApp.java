package frontend;
import javax.swing.*;

/**
 * Created by Tonya on 02.05.2015.
 */
public class WindowApp extends JFrame {
    private JPanel panel = new JPanel(null);
    private JLabel firstImage = new JLabel("First Image");
    private JLabel firstImageLabel;
    private JLabel secondImage = new JLabel("Second Image");
    private JLabel numberOfEndPoints = new JLabel("Number of End Points: ");
    private JLabel endPointValueForFirstImage;
    private JLabel endPointValueForSecondImage;
    private JLabel numberOfBranchPoints = new JLabel("Number of Branch Points: ");
    private JLabel branchPointValueForFirstImage;
    private JLabel branchPointValueForSecondImage;
    private JLabel percentValue;
    private JLabel percentText = new JLabel("Finger Prints match on ");

    public WindowApp() {
        super("Finger Print Application");
        setBounds(100, 100, 600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void createGUI(String firstImageName, String secondImageName,
                          String branchPointsOfFirstImage, String branchPointsOfSecondImage,
                          String endPointsOfFirstImage, String endPointsOfSecondImage,
                          String percents) {
        panel.setLayout(null);
        //"First Image" label
        firstImage.setLocation(250, 20);
        firstImage.setSize(100, 50);
        panel.add(firstImage);

     //   TODO: Picture view must be added!
        //First Image
        //Why don't you add this image???
        /*
        firstImageLabel = new JLabel(new ImageIcon(firstImageName));
        panel.add(firstImageLabel);*/

        //"Second Image Label
        secondImage.setLocation(450, 20);
        secondImage.setSize(100, 50);
        panel.add(secondImage);

        //numberOfBranchPoints
        numberOfBranchPoints.setLocation(30, 250);
        numberOfBranchPoints.setSize(150, 20);
        panel.add(numberOfBranchPoints);

        //numberOfEndPoints
        numberOfEndPoints.setLocation(30, 300);
        numberOfEndPoints.setSize(150, 20);
        panel.add(numberOfEndPoints);

        //percentText
        percentText.setLocation(30, 350);
        percentText.setSize(150, 20);
        panel.add(percentText);

        //branchPointValueForFirstImage
        branchPointValueForFirstImage = new JLabel(branchPointsOfFirstImage);
        branchPointValueForFirstImage.setLocation(280, 250);
        branchPointValueForFirstImage.setSize(50, 20);
        panel.add(branchPointValueForFirstImage);

        //branchPointValueForSecondImage
        branchPointValueForSecondImage = new JLabel(branchPointsOfSecondImage);
        branchPointValueForSecondImage.setLocation(480, 250);
        branchPointValueForSecondImage.setSize(50, 20);
        panel.add(branchPointValueForSecondImage);

        //endPointValueForFirstImage
        endPointValueForFirstImage = new JLabel(endPointsOfFirstImage);
        endPointValueForFirstImage.setLocation(280, 300);
        endPointValueForFirstImage.setSize(50, 20);
        panel.add(endPointValueForFirstImage);

        //endPointValueForSecondImage
        endPointValueForSecondImage = new JLabel(endPointsOfSecondImage);
        endPointValueForSecondImage.setLocation(480, 300);
        endPointValueForSecondImage.setSize(50, 20);
        panel.add(endPointValueForSecondImage);

        //percentValue
        percentValue = new JLabel(percents+" %");
        percentValue.setLocation(280, 350);
        percentValue.setSize(100, 20);
        panel.add(percentValue);

        getContentPane().add(panel);
    }
}
