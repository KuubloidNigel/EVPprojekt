package com.kubloid.tetris;

import org.junit.Test;
import static org.junit.Assert.*;


public class PieceTest {

    @Test
    public void testPieceInitialization() {
        Piece piece = new Piece();
        assertEquals("Initial shape should be NO_BLOCK", Piece.Pieces.NO_BLOCK, piece.getShape());
    }

    @Test
    public void testSetRandomShape() {
        Piece piece = new Piece();
        piece.setRandomShape();
        assertNotNull("Randomly set shape should not be null", piece.getShape());
    }

    @Test
    public void testRotation() {
        Piece piece = new Piece();
        piece.setShape(Piece.Pieces.T_SHAPE);

        Piece rotatedLeft = piece.rotateLeft();
        assertEquals("Rotating left should not change the shape for T_SHAPE", Piece.Pieces.T_SHAPE, rotatedLeft.getShape());

        Piece rotatedRight = piece.rotateRight();
        assertEquals("Rotating right should not change the shape for T_SHAPE", Piece.Pieces.T_SHAPE, rotatedRight.getShape());
    }
}
