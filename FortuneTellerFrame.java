import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.GraphicsEnvironment;
public class FortuneTellerFrame extends JFrame {
    /*a.	Top panel:

A JLabel with text “Fortune Teller” (or something similar!) and an ImageIcon.
 Find an appropriate non-commercial Fortune Teller image for your ImageIcon.
  (The JLabel has a constructor that takes a String and the ImageIcon.
  Figure out from the Swing API or the content in Canvas how to display the text either
   above or below the ImageIcon.) Select a font face that works with your image and set the
    size to a larger value (try 36 and 48).  Note that you have to add the image file to your IntelliJ
    project directory.
*/
    JPanel mainPnl;
    JPanel topPnl;  // Top
    JPanel middlePnl; // Center
    JPanel bottomPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;


    JButton quitBtn;
    JButton fortuneBtn;
    Random rnd = new Random();

    int fortuneCnt = -1;
    int fortuneNew = 0;
    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createIconPanel() {
        topPnl = new JPanel();
        icon = new ImageIcon("src/MoonGoddess.png");

        titleLbl = new JLabel("Dare to have your fortune told", icon, JLabel.CENTER);
        // align text to icon
        titleLbl.setFont(new Font("Arial", Font.PLAIN,36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(titleLbl);
        topPnl.setBackground(new Color(180, 206, 237));
    }

    private void createMiddlePanel() {
        middlePnl = new JPanel();
        displayTA = new JTextArea(15, 35);
        displayTA.setFont(new Font("Century Gothic", Font.PLAIN,14));
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);
        middlePnl.setBackground(new Color(180, 206, 237));
    }


    private void createBottomPanel() {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));


        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Century Gothic", Font.PLAIN,20));
        quitBtn.setBackground(new Color(146, 145, 168));
        fortuneBtn = new JButton("Read my fortune!");
        fortuneBtn.setFont(new Font("Century Gothic", Font.PLAIN,20));
        fortuneBtn.setBackground(new Color(146, 145, 168));
        fortuneBtn.addActionListener((ActionEvent ae) -> {
            //give a fortune
            ArrayList<String> fortune = new ArrayList<String>();
            fortune.add("A dubious friend may be an enemy in camouflage");
            fortune.add("Accept something that you cannot change, and you will feel better");
            fortune.add("Don’t worry; prosperity will knock on your door soon");
            fortune.add("Failure is the path of lease persistence");
            fortune.add("Follow the middle path. Neither extreme will make you happy");
            fortune.add("Get your mind set – confidence will lead you on");
            fortune.add("Go for the gold today! You’ll be the champion of whatever");
            fortune.add("Happy life is just in front of you");
            fortune.add("He who expects no gratitude shall never be disappointed");
            fortune.add("In this world of contradiction, It’s better to be merry than wise");
            fortune.add("It takes courage to admit fault");
            fortune.add("Man is born to live and not prepared to live");

            do {
                fortuneNew = rnd.nextInt(0, 12);

            }
            while ((fortuneNew == fortuneCnt));
            fortuneCnt = fortuneNew;
            displayTA.append(fortune.get(fortuneCnt) + "\n");

        });

        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);

    }
}
