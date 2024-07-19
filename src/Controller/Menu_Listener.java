package Controller;

import View.Banana_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Listener implements ActionListener {
    private final Banana_View bananaView;
    public Menu_Listener(Banana_View bananaView) {
        this.bananaView = bananaView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();
        switch (string) {
            case ("Reset Record"):
                bananaView.bananaModel.resetHighestPoint();
                bananaView.jLabel_highestPoint.setText("The Highest: " + bananaView.bananaModel.getHighestPoint());
            case ("Reset"):
                bananaView.bananaModel.reset();
                bananaView.jLabel_score.setText(bananaView.bananaModel.getCounter() + "");
                break;
            case "Quit":
                System.exit(0);
                break;
            case "Banana" :
                bananaView.bananaModel.choseTheme = 0;
                bananaView.resetScreen();
                break;
            case "Mao Mao" :
                bananaView.bananaModel.choseTheme = 1;
                bananaView.resetScreen();
                break;
            case "Avocado" :
                bananaView.bananaModel.choseTheme = 2;
                bananaView.resetScreen();
                break;
        }
    }
}
