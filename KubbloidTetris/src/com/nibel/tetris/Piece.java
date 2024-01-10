package com.nibel.tetris;

import java.util.Random;

public class Piece {
    enum Pieces {
        NO_BLOCK, Z_SHAPE, S_SHAPE, I_SHAPE, T_SHAPE, O_SHAPE, L_SHAPE, J_SHAPE
    }

    ;

    private Pieces pieces;
    private int coords[][];             
    private int table[][][];

    public Piece() {
        coords = new int[4][2];
        table = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},        // NO_BLOCK
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},    // Z_SHAPE
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},    // S_SHAPE
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},    // I_SHAPE
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},    // T_SHAPE
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},    // O_SHAPE
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},    // L_SHAPE
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}    // J_SHAPE
        };

        setShape(Pieces.NO_BLOCK);
    }

    // set tetromino shape
    public void setShape(Pieces tetromino) {

        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                coords[i][j] = table[tetromino.ordinal()][i][j];
            }
        }

        pieces = tetromino;
    }

    public void setRandomShape() {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        setShape(Pieces.values()[x]);
    }

    public Pieces getShape() {
        return pieces;
    }

    // coordinate transform functions
    public void setX(int idx, int x) {
        coords[idx][0] = x;
    }

    public void setY(int idx, int y) {
        coords[idx][1] = y;
    }

    public int getX(int idx) {
        return coords[idx][0];
    }

    public int getY(int idx) {
        return coords[idx][1];
    }

    public int minX() {
        int ret = 0;
        for (int i = 0; i < coords.length; i++) {
            ret = Math.min(ret, coords[i][0]);
        }
        return ret;
    }

    public int minY() {
        int ret = 0;
        for (int i = 0; i < coords.length; i++) {
            ret = Math.min(ret, coords[i][1]);
        }
        return ret;
    }

    // rotate a piece
    public Piece rotateLeft() {
        if (pieces == Pieces.O_SHAPE) {
            return this;
        }

        Piece ret = new Piece();
        ret.pieces = pieces;

        for (int i = 0; i < coords.length; i++) {
            ret.setX(i, getY(i));
            ret.setY(i, -getX(i));
        }

        return ret;
    }

    public Piece rotateRight() {
        if (pieces == Pieces.O_SHAPE) {
            return this;
        }

        Piece ret = new Piece();
        ret.pieces = pieces;

        for (int i = 0; i < coords.length; i++) {
            ret.setX(i, -getY(i));
            ret.setY(i, getX(i));
        }

        return ret;
    }
}
