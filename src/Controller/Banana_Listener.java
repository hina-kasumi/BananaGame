package Controller;

import View.Banana_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Banana_Listener implements ActionListener {
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
        this.bananaView.jLabel_score.setText(counter + "");// hiển thị điểm sau khi đã được cộng
    }
}
