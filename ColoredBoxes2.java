import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class ColoredBoxes2 {
 
public static void main(String[] args) {
new ColoredBoxes2();
}
 
public ColoredBoxes2() {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
ex.printStackTrace();
}
 
JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new TestPane());
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);

}
});
}
 
public static class TestPane extends JPanel {
 
    //values to create a square
protected static final int ROWS = 14;
protected static final int COLS = 14;
protected static final int BOX_SIZE = 30;
 
private List<Color> colors;
//********************************Y2D array is created htere******
Color[][] myColor = new Color[ROWS][COLS];
 
public TestPane() {
int length = ROWS * COLS;
colors = new ArrayList<>(length);
 
for (int row = 0; row < ROWS; row++) {
for (int col = 0; col < COLS; col++) {
int c1 = (int) (Math.random() * 255);
int c2 = (int) (Math.random() * 255);
int c3 = (int) (Math.random() * 255);
// generates a random color
myColor[row][col] = new Color(c1, c2, c3);

}}
}
 
@Override
public Dimension getPreferredSize() {
return new Dimension(COLS * BOX_SIZE, ROWS * BOX_SIZE);
}

 
@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2d = (Graphics2D) g.create();
 
int xOffset = (getWidth() - (COLS * BOX_SIZE)) / 2;
int yOffset = (getHeight() - (ROWS * BOX_SIZE)) / 2;
 
 
for (int row = 0; row < ROWS; row++) {
for (int col = 0; col < COLS; col++) {
Color red = new Color (255,0,0);
int index = (row * COLS) + col;
// creates a boarder if the following conditions apply
if (row == 0 || row == 13 || col ==0 || col == 13){
    g2d.setColor(red); 
    g2d.fillRect(xOffset + (col * BOX_SIZE), 
        yOffset + (row * BOX_SIZE), 
        BOX_SIZE, BOX_SIZE);
}

// creates a diagonal line through the drawing
else 
    if ( row == col){
        g2d.setColor(red); 
    g2d.fillRect(xOffset + (col * BOX_SIZE), 
        yOffset + (row * BOX_SIZE), 
        BOX_SIZE, BOX_SIZE);
    }
        

else{
    
g2d.setColor(myColor[row][col]);
g2d.fillRect(xOffset + (col * BOX_SIZE), 
yOffset + (row * BOX_SIZE), 
BOX_SIZE, BOX_SIZE);
}
}
}
g2d.dispose();
}
 
}
 
}
 
 

