package Controller;

import View.Banana_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Banana_Listener implements ActionListener, MouseListener {
    final private Banana_View bananaView;

    public Banana_Listener(Banana_View bananaView) {
        this.bananaView = bananaView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.bananaView.bananaModel.Up(); // khi nút được bấm xuống thì cộng điểm lên
        long counter = this.bananaView.bananaModel.getCounter();
        long highestPoint = this.bananaView.bananaModel.getHighestPoint();
        if (highestPoint < counter){
            this.bananaView.bananaModel.updateHighetPoint();
            this.bananaView.jLabel_highestPoint.setText("The Highest: " + counter);
        }
        if (this.bananaView.bananaModel.choseTheme == 1){
            this.bananaView.bananaModel.choseTheme = 3;
            this.bananaView.resetScreen();
        } else if (this.bananaView.bananaModel.choseTheme == 3){
            this.bananaView.bananaModel.choseTheme = 1;
            this.bananaView.resetScreen();
        }

        this.bananaView.jLabel_score.setText(counter + "");// hiển thị điểm sau khi đã được cộng
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.bananaView.bananaModel.choseTheme == 1){
            this.bananaView.bananaModel.choseTheme = 3;
            this.bananaView.resetScreen();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.bananaView.bananaModel.choseTheme == 3){
            this.bananaView.bananaModel.choseTheme = 1;
            this.bananaView.resetScreen();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
