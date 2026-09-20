/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw_lab9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

public class AngryBirdsGameGUI extends JFrame{
    private JTextField txtYPos, txtSpeed, txtAngle, txtScore;
    private JLabel lblPig, lblBird;
    private JPanel gamePanel;

    private int score = 0;
    private int pigX, pigY;
    private final int BIRD_START_X = 250;

    public AngryBirdsGameGUI() {
        setTitle("Angry Birds Game");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // --- Top: SCENE 1 & SCORE ---
        JLabel lblScene = new JLabel("SCENE 1: At Tokyo");
        lblScene.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblScene.setBounds(50, 20, 200, 30);
        add(lblScene);

        JLabel lblScoreTitle = new JLabel("SCORE");
        lblScoreTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblScoreTitle.setBounds(400, 20, 70, 30);
        add(lblScoreTitle);

        txtScore = new JTextField("0");
        txtScore.setEditable(false);
        txtScore.setHorizontalAlignment(JTextField.CENTER);
        txtScore.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtScore.setBounds(480, 20, 80, 30);
        add(txtScore);

        // --- Middle: Game Panel ---
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load background image from package
                URL bgURL = getClass().getResource("/hw_lab9/Cosnovia.jpg");
                if (bgURL != null) {
                    Image bg = new ImageIcon(bgURL).getImage();
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
                } else {
                    // Fallback colors
                    g.setColor(new Color(135, 206, 235));
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(new Color(34, 139, 34));
                    g.fillRect(0, getHeight() - 40, getWidth(), 40);
                }
            }
        };
        gamePanel.setBounds(50, 60, 580, 280);
        gamePanel.setLayout(null);
        add(gamePanel);

        // --- Load & Display Bird ---
        URL birdURL = getClass().getResource("/hw_lab9/angrybird1.png");
        if (birdURL != null) {
            Image birdImg = new ImageIcon(birdURL).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            lblBird = new JLabel(new ImageIcon(birdImg));
        } else {
            lblBird = new JLabel("🔴");
            lblBird.setFont(new Font("Serif", Font.PLAIN, 40));
        }
        lblBird.setBounds(50, 180, 50, 50);
        gamePanel.add(lblBird);

        // --- Load & Display Pig ---
        URL pigURL = getClass().getResource("/hw_lab9/pig1.png");
        if (pigURL != null) {
            Image pigImg = new ImageIcon(pigURL).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            lblPig = new JLabel(new ImageIcon(pigImg));
        } else {
            lblPig = new JLabel("🐷");
            lblPig.setFont(new Font("Serif", Font.PLAIN, 40));
        }
        gamePanel.add(lblPig);

        // Randomize Pig Position
        randomPigPosition();

        // --- Bottom: Input Fields ---
        JLabel lblPos = new JLabel("Bird Position in y-axis");
        lblPos.setBounds(50, 360, 150, 25);
        add(lblPos);

        txtYPos = new JTextField("100");
        txtYPos.setBounds(210, 360, 150, 25);
        add(txtYPos);

        JLabel lblPosUnit = new JLabel("m");
        lblPosUnit.setBounds(370, 360, 50, 25);
        add(lblPosUnit);

        JLabel lblSpeed = new JLabel("Shooting speed");
        lblSpeed.setBounds(50, 395, 150, 25);
        add(lblSpeed);

        txtSpeed = new JTextField("50");
        txtSpeed.setBounds(210, 395, 150, 25);
        add(txtSpeed);

        JLabel lblSpeedUnit = new JLabel("m/s");
        lblSpeedUnit.setBounds(370, 395, 50, 25);
        add(lblSpeedUnit);

        JLabel lblAngle = new JLabel("Angle");
        lblAngle.setBounds(50, 430, 150, 25);
        add(lblAngle);

        txtAngle = new JTextField("30");
        txtAngle.setBounds(210, 430, 150, 25);
        add(txtAngle);

        JLabel lblAngleUnit = new JLabel("degree");
        lblAngleUnit.setBounds(370, 430, 50, 25);
        add(lblAngleUnit);

        JButton btnOK = new JButton("OK");
        btnOK.setBounds(240, 470, 80, 30);
        add(btnOK);

        // --- Action Listener ---
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double yPos = Double.parseDouble(txtYPos.getText());
                    double speed = Double.parseDouble(txtSpeed.getText());
                    double angle = Double.parseDouble(txtAngle.getText());

                    AngryBirds bird = new AngryBirds(yPos, speed, angle);
                    double landingSx = bird.calculateLandingX();

                    double finalBirdX = BIRD_START_X + landingSx;

                    if (Math.abs(finalBirdX - pigX) <= 20) {
                        score += 100;
                        txtScore.setText(String.valueOf(score));
                        JOptionPane.showMessageDialog(AngryBirdsGameGUI.this, 
                            "Hit! Bird landing position: " + (int)finalBirdX + "\nScore +100");
                        randomPigPosition();
                    } else {
                        JOptionPane.showMessageDialog(AngryBirdsGameGUI.this, 
                            "Missed! Bird landed at x = " + (int)finalBirdX + " (Pig location: x = " + pigX + ")");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AngryBirdsGameGUI.this, 
                        "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void randomPigPosition() {
        Random rand = new Random();
        pigX = 200 + rand.nextInt(300);
        pigY = 80 + rand.nextInt(100);
        lblPig.setBounds(pigX, pigY, 50, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AngryBirdsGameGUI().setVisible(true);
        });
    }
}
