import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {
    private Game game;
    private BlockPanel blockPanel;
    private JLabel questionLabel;
    private JLabel resultLabel;
    private JButton yesButton;
    private JButton noButton;
    private JButton newGameButton;

    public GameGUI() {
        super("Shape Match Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        game = new Game();
        initializeUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {

        blockPanel = new BlockPanel();
        blockPanel.setBlocks(game.getBlocks());
        add(blockPanel, BorderLayout.CENTER);


        JPanel questionPanel = new JPanel();
        questionLabel = new JLabel("Are these blocks a match?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionPanel.add(questionLabel);
        add(questionPanel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        yesButton = new JButton("Yes, it's a match");
        noButton = new JButton("No, it's not a match");
        newGameButton = new JButton("New Game");

        yesButton.addActionListener(new AnswerListener(true));
        noButton.addActionListener(new AnswerListener(false));
        newGameButton.addActionListener(e -> startNewGame());

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        buttonPanel.add(newGameButton);
        add(buttonPanel, BorderLayout.SOUTH);


        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.EAST);
    }

    private class AnswerListener implements ActionListener {
        private boolean userAnswer;

        public AnswerListener(boolean answer) {
            this.userAnswer = answer;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isCorrect = game.checkAnswer(userAnswer);

            if (isCorrect) {
                resultLabel.setText("<html><div style='text-align: center;'>Correct!<br>" +
                        game.getResultExplanation() + "</div></html>");
            } else {
                resultLabel.setText("<html><div style='text-align: center;'>Incorrect!<br>" +
                        game.getResultExplanation() + "</div></html>");
            }

            yesButton.setEnabled(false);
            noButton.setEnabled(false);
        }
    }

    private void startNewGame() {
        game.newGame();
        blockPanel.setBlocks(game.getBlocks());
        questionLabel.setText("Are these blocks a match?");
        resultLabel.setText("");
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
}