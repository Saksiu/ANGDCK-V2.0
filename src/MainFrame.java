import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame
{
    private final JFrame mainFrame=new JFrame();
    private final SpringLayout layout=new SpringLayout();
    private final Container conPane=mainFrame.getContentPane();
    private final ScoreBoard scoreBoard=new ScoreBoard();

    public MainFrame(){
        mainFrame.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4
                            ,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4);
        mainFrame.setTitle("ANGDCKS");          //Setting up the main window parameters
        mainFrame.setSize(300 ,400);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setLayout(layout);
        mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED,10));
        mainFrame.getRootPane().setBackground(Color.ORANGE);

        makeMainMenu();

        mainFrame.setVisible(true);
    }

    void makeMainMenu(){            //creating the main Menu using Springs
        JLabel welcomeLabel=new JLabel("WELCOME TO ANGRYDUCKS!");
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,20));
        conPane.add(welcomeLabel);

        JButton scoreButton=new JButton("Score");
        scoreButton.addActionListener(e -> scoreBoard.showBoard());

        JButton quitButton=new JButton("Exit");
        quitButton.addActionListener(e -> System.exit(0));

        JButton playButton=new JButton("Play");
        playButton.addActionListener(e -> {
            mainFrame.setVisible(false);
            scoreBoard.hideBoard();
            new GameFrame(mainFrame,scoreBoard);
        });


        int heightBetweenButtons=40;
        for (JButton button:new JButton[]{playButton,scoreButton,quitButton}) {
            conPane.add(button);
            button.setFont(new Font("Arial",Font.BOLD,15));
            button.setPreferredSize(new Dimension(120,40));
            layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,button,0,SpringLayout.HORIZONTAL_CENTER,conPane);
            layout.putConstraint(SpringLayout.NORTH,button,heightBetweenButtons,SpringLayout.NORTH,conPane);
            heightBetweenButtons+=50;
        }
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,welcomeLabel,0,SpringLayout.HORIZONTAL_CENTER,conPane);
    }


}
