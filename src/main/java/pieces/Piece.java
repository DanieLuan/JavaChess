package pieces;

public abstract class Piece {

    public enum Type {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public enum Color {
        WHITE, BLACK
    }

    private Color color;
    private Type type;


    //abstract public void move();
    //ver como fazer o movimento da peça seguindo as regras do jogo

    public String getImagePath() {
        String filepath = "/art/pieces_img/";
        switch (type) {
            case PAWN:
                filepath += "pawn_";
                break;
            case KING:
                filepath += "king_";
                break;
            case QUEEN:
                filepath += "queen_";
                break;
            case BISHOP:
                filepath += "bishop_";
                break;
            case ROOK:
                filepath += "rook_";
                break;
            case KNIGHT:
                filepath += "knight_";
                break;
        }

        switch (color) {
            case BLACK:
                filepath += "black";
                break;
            case WHITE:
                filepath += "white";
                break;
        }
        filepath += ".png";
        return filepath;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }


}
