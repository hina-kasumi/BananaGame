package View;

import Controller.Banana_Listener;
import Controller.Menu_Listener;
import Model.Banana_Model;

import javax.swing.*;
import java.awt.*;


public class Banana_View extends JFrame {
    public final Banana_Model bananaModel = new Banana_Model();
    public JLabel jLabel_score, jLabel_highestPoint;
    private final Theme[] themes = new Theme[3];
    private JButton jButton_Up;
    private final JPanel jPanel = new JPanel(new GridBagLayout());
    private final Font font = new Font("Arial", Font.BOLD, 50); // tạo font chữ

    //Constructor
    public Banana_View() {
        this.init();
    }
    private JMenuBar getjMenuBar() {
        final Font font = new Font("Arial", Font.BOLD, 20); // tạo font chữ
        final Menu_Listener menuListener = new Menu_Listener(this);
        JMenuBar menuBar = new JMenuBar();

        //Option Menu
        JMenu option = new JMenu("Option");
        JMenuItem resetHighestPoint = new JMenuItem("Reset Record");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem quit = new JMenuItem("Quit");

        option.setFont(font);
        reset.setFont(font);
        resetHighestPoint.setFont(font);
        quit.setFont(font);

        reset.addActionListener(menuListener);
        resetHighestPoint.addActionListener(menuListener);
        quit.addActionListener(menuListener);


        option.add(reset);
        option.addSeparator();
        option.add(resetHighestPoint);
        option.addSeparator();
        option.add(quit);
        option.addSeparator();


        //Menu Theme
        JMenu theme = new JMenu("Theme");
        JMenuItem bananaTheme = new JMenuItem("Banana");
        JMenuItem maoMaoTheme = new JMenuItem("Mao Mao");
        JMenuItem happyTheme = new JMenuItem("Avocado");

        theme.setFont(font);
        bananaTheme.setFont(font);
        maoMaoTheme.setFont(font);
        happyTheme.setFont(font);

        bananaTheme.addActionListener(menuListener);
        maoMaoTheme.addActionListener(menuListener);
        happyTheme.addActionListener(menuListener);

        theme.add(bananaTheme);
        theme.addSeparator();
        theme.add(maoMaoTheme);
        theme.addSeparator();
        theme.add(happyTheme);
        theme.addSeparator();

        //add Menu to MenuBar
        menuBar.add(option);
        menuBar.add(theme);

        return menuBar;
    }
    private void init() {
        //cơ bản của một chương tình
        this.setTitle("Banana Game"); // cài đặt tiêu đề cho cửa sổ
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // lấy kích thước màn hình
        setSize(screenSize.width, screenSize.height); // cài đặt cửa sổ toàn màn hình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cài đặt khi thoát cửa sổ tắt chương tình
        this.setLayout(new BorderLayout());//cài đặt layout cho cửa sổ

        //Listener
        final Banana_Listener bananaListener = new Banana_Listener(this); // thêm chức năng

        //MenuBar
        JMenuBar menuBar = getjMenuBar(); // method getjMenuBar return menuBar to use and easy to follow
        this.add(menuBar); // add MenuBar to Frame


        GridBagConstraints constraints = new GridBagConstraints(); // tạo constraints cho GridBagLayout

        //score
        jLabel_score = new JLabel(this.bananaModel.getCounter() + "", JLabel.CENTER); // tạo một label để hiện điểm
        jLabel_score.setFont(font); // chỉnh phông chữ cho điểm
        constraints.gridx = 2;
        jPanel.add(jLabel_score, constraints); // thêm label_score vào panel

        //highest point
        jLabel_highestPoint = new JLabel("The Highest: " + this.bananaModel.getHighestPoint(), JLabel.CENTER);
        jLabel_highestPoint.setFont(font);
        jPanel.add(jLabel_highestPoint, constraints);


        //Button
        jButton_Up = new JButton(); // tạo nút
        jButton_Up.setPreferredSize(new Dimension(200, 100)); // cài đặt kích thước của nút

        jButton_Up.setBorderPainted(false); // fix bug không hiện màu cho nút
        jButton_Up.addActionListener(bananaListener); // thêm chức năng vào khi khi nút được bấm xuống

        themes[0] = new Theme(194, 230, 47, "BananaButton");
        themes[1] = new Theme(26, 186, 90, "maomao");
        themes[2] = new Theme(26, 186, 90, "avocado");

        resetScreen(); // hiển thị theme


        jPanel.add(jButton_Up, constraints); // thêm nút vào màn hình

        this.add(jPanel);


        this.setVisible(true); // hiển thị cửa sổ
    }

    public void resetScreen(){
        Dimension dimension = this.getSize();
        Color background_Color = new Color(
                themes[bananaModel.choseTheme].getRed(),
                themes[bananaModel.choseTheme].getGreen(),
                themes[bananaModel.choseTheme].getBlue()
        );

        jPanel.setBackground(background_Color);//background
        jButton_Up.setBackground(background_Color); // chỉnh nền cho nút

        jButton_Up.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(
                Banana_View.class.getResource("theme\\" +
                        themes[bananaModel.choseTheme].getTheme_Name() + ".png")))
        ); // thêm icon cho nút

        this.pack(); // đóng gói hết những gì liên quan đến giao diện nhưng sẽ thu nhỏ màn hình lại
        this.setSize(dimension);//phải setSize lại để về lại size ban đầu
    }
}

