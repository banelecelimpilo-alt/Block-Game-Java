import java.awt.Color;
import java.util.Random;

public class Block {
    public enum Shape { CIRCLE, SQUARE, TRIANGLE }

    private static final Color[] SHAPE_COLORS = {Color.RED, Color.YELLOW, Color.BLUE};
    private static final Color[] BLOCK_COLORS = {Color.BLACK, Color.WHITE, Color.LIGHT_GRAY};
    private static final Random RANDOM = new Random();

    private Shape shape;
    private Color shapeColor;
    private Color blockColor;

    public Block() {
        this.shape = Shape.values()[RANDOM.nextInt(Shape.values().length)];
        this.shapeColor = SHAPE_COLORS[RANDOM.nextInt(SHAPE_COLORS.length)];
        this.blockColor = BLOCK_COLORS[RANDOM.nextInt(BLOCK_COLORS.length)];
    }

    public Block(Shape shape, Color shapeColor, Color blockColor) {
        this.shape = shape;
        this.shapeColor = shapeColor;
        this.blockColor = blockColor;
    }


    public Shape getShape() { return shape; }
    public Color getShapeColor() { return shapeColor; }
    public Color getBlockColor() { return blockColor; }


    public void setShape(Shape shape) { this.shape = shape; }
    public void setShapeColor(Color shapeColor) { this.shapeColor = shapeColor; }
    public void setBlockColor(Color blockColor) { this.blockColor = blockColor; }

    @Override
    public String toString() {
        return "Block[shape=" + shape + ", shapeColor=" + shapeColor + ", blockColor=" + blockColor + "]";
    }
}