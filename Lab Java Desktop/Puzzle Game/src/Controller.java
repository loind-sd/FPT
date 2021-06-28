
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class Controller {

    public PuzzleGame p;
    private int size = 3, move = 0, timer = 0;
    private Timer t;
    private JButton[][] matrix;
    public boolean check = false;

    public Controller(PuzzleGame p) {
        this.p = p;
        addButton();
    }

    public void countTime() {
        p.getLblCount().setText("0");
        p.getLblTime().setText("0 sec");
        t = new Timer(1000, new ActionListener() {
            int second = 0;

            @Override
            public void actionPerformed(ActionEvent ae) {
                second++;
                p.getLblTime().setText(second + " secs");
            }
        });
        t.start();

    }

    public void newGame() {
        addButton();
    }

    public void addButton() {
//        p.getCboSize().setSelectedIndex(2);
        size = p.getCboSize().getSelectedIndex() + 3;
        p.getPnLayout().removeAll();
        p.getPnLayout().setLayout(new GridLayout(size, size, 10, 10));
        p.getPnLayout().setPreferredSize(new Dimension(size * 60, size * 60));
        matrix = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton btn = new JButton(i * size + j + 1 + "");
                matrix[i][j] = btn;
                p.getPnLayout().add(btn);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (checkMove(btn)) {
                            moveButton(btn);
                            if (isWin()) {
                                JOptionPane.showMessageDialog(p, "WIN");
                            }
                        }
                    }
                });
            }
        }
        matrix[size - 1][size - 1].setText("");
        mixButton();
        p.pack();
    }

    public Point getEmptyPoint() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].getText().equals("")) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void mixButton() {
        for (int k = 0; k < 1000; k++) {
            Point p = getEmptyPoint();
            int i = p.x;
            int j = p.y;
            Random r = new Random();
            int choice = r.nextInt(4);
            switch (choice) {
                case 0: //up
                    if (i > 0) {
                        String txt = matrix[i - 1][j].getText();
                        matrix[i][j].setText(txt);
                        matrix[i - 1][j].setText("");
                    }
                    break;
                case 1: //down
                    if (i < size - 1) {
                        String txt = matrix[i + 1][j].getText();
                        matrix[i][j].setText(txt);
                        matrix[i + 1][j].setText("");
                    }
                    break;
                case 2: //left
                    if (j > 0) {
                        String txt = matrix[i][j - 1].getText();
                        matrix[i][j].setText(txt);
                        matrix[i][j - 1].setText("");
                    }
                    break;
                case 3: //right
                    if (j < size - 1) {
                        String txt = matrix[i][j + 1].getText();
                        matrix[i][j].setText(txt);
                        matrix[i][j + 1].setText("");
                    }
                    break;
            }
        }
    }

    public boolean checkMove(JButton btn) {
        Point p = getEmptyPoint();
        int a = 0;
        int b = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (btn.getText().equals(matrix[i][j].getText())) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        int i = p.x;
        int j = p.y;
        if (i == a && Math.abs(j - b) == 1) {
            return true;
        }
        if (j == b && Math.abs(i - a) == 1) {
            return true;
        }
        return false;
    }

    public void moveButton(JButton btn) {
        Point p1 = getEmptyPoint();
        String txt = btn.getText();
        matrix[p1.x][p1.y].setText(txt);
        btn.setText("");
        move++;
        p.getLblCount().setText(String.valueOf(move));
    }

    public boolean isWin() {
        if (matrix[size - 1][size - 1].getText().equals("")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == size - 1 && j == size - 1) {
                        return true;
                    }
                    if (!matrix[i][j].getText().equals(i * size + j + 1 + "")) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
