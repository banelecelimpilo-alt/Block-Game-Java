public class Game {

    private Block[] blocks;

    private boolean isMatch;



    public Game() {

        blocks = new Block[3];

        newGame();

    }



    public void newGame() {

        for (int i = 0; i < 3; i++) {

            blocks[i] = new Block();

        }

        checkMatch();

    }



    private void checkMatch() {

        boolean shapesMatch = checkAllSame(blocks, "shape") || checkAllDifferent(blocks, "shape");

        boolean shapeColorsMatch = checkAllSame(blocks, "shapeColor") || checkAllDifferent(blocks, "shapeColor");

        boolean blockColorsMatch = checkAllSame(blocks, "blockColor") || checkAllDifferent(blocks, "blockColor");



        isMatch = shapesMatch && shapeColorsMatch && blockColorsMatch;

    }



    private boolean checkAllSame(Block[] blocks, String property) {

        switch (property) {

            case "shape":

                return blocks[0].getShape() == blocks[1].getShape() &&

                        blocks[1].getShape() == blocks[2].getShape();



            case "shapeColor":

                return blocks[0].getShapeColor().equals(blocks[1].getShapeColor()) &&

                        blocks[1].getShapeColor().equals(blocks[2].getShapeColor());



            case "blockColor":

                return blocks[0].getBlockColor().equals(blocks[1].getBlockColor()) &&

                        blocks[1].getBlockColor().equals(blocks[2].getBlockColor());



            default:

                return false;

        }

    }



    private boolean checkAllDifferent(Block[] blocks, String property) {

        switch (property) {

            case "shape":

                return blocks[0].getShape() != blocks[1].getShape() &&

                        blocks[1].getShape() != blocks[2].getShape() &&

                        blocks[0].getShape() != blocks[2].getShape();



            case "shapeColor":

                return !blocks[0].getShapeColor().equals(blocks[1].getShapeColor()) &&

                        !blocks[1].getShapeColor().equals(blocks[2].getShapeColor()) &&

                        !blocks[0].getShapeColor().equals(blocks[2].getShapeColor());



            case "blockColor":

                return !blocks[0].getBlockColor().equals(blocks[1].getBlockColor()) &&

                        !blocks[1].getBlockColor().equals(blocks[2].getBlockColor()) &&

                        !blocks[0].getBlockColor().equals(blocks[2].getBlockColor());



            default:

                return false;

        }

    }



    public boolean checkAnswer(boolean userAnswer) {

        return userAnswer == isMatch;

    }



    public String getResultExplanation() {

        StringBuilder explanation = new StringBuilder();



        // --- Shape ---

        explanation.append("Shape: ");

        if (checkAllSame(blocks, "shape"))

            explanation.append("All the same. <br>");

        else if (checkAllDifferent(blocks, "shape"))

            explanation.append("All different. <br>");

        else

            explanation.append("Two are the same and one is different. <br>");



        // --- Shape Color ---

        explanation.append("Shape Color: ");

        if (checkAllSame(blocks, "shapeColor"))

            explanation.append("All the same. <br>");

        else if (checkAllDifferent(blocks, "shapeColor"))

            explanation.append("All different. <br>");

        else

            explanation.append("Two are the same and one is different. <br>");



        // --- Block Color ---

        explanation.append("Block Color: ");

        if (checkAllSame(blocks, "blockColor"))

            explanation.append("All the same. <br>");

        else if (checkAllDifferent(blocks, "blockColor"))

            explanation.append("All different. <br>" );

        else

            explanation.append("Two are the same and one is different. <br>");



        return explanation.toString();

    }



    public Block[] getBlocks() {

        return blocks;

    }



    public boolean isMatch() {

        return isMatch;

    }

}
