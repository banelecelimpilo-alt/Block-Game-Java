import javax.swing.*;
import java.awt.*;

public class BlockPanel extends JPanel {
    private Block[] blocks;

    public BlockPanel() {
        setPreferredSize(new Dimension(600, 200));
        setBackground(Color.WHITE);
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (blocks == null) return;

        int blockSize = 100;
        int spacing = 50;
        int startX = (getWidth() - (3 * blockSize + 2 * spacing)) / 2;
        int y = (getHeight() - blockSize) / 2;

        for (int i = 0; i < blocks.length; i++) {
            int x = startX + i * (blockSize + spacing);


            g2d.setColor(blocks[i].getBlockColor());
            g2d.fillRect(x, y, blockSize, blockSize);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, blockSize, blockSize);


            g2d.setColor(blocks[i].getShapeColor());
            switch (blocks[i].getShape()) {
                case CIRCLE:
                    g2d.fillOval(x + 10, y + 10, blockSize - 20, blockSize - 20);
                    break;
                case SQUARE:
                    g2d.fillRect(x + 10, y + 10, blockSize - 20, blockSize - 20);
                    break;
                case TRIANGLE:
                    int[] xPoints = {x + blockSize/2, x + 10, x + blockSize - 10};
                    int[] yPoints = {y + 10, y + blockSize - 10, y + blockSize - 10};
                    g2d.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    }
}