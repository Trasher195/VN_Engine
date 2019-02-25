package Core;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;


public class Panel extends JPanel {
    private int numimage = 1;       //TODO Должно загружаться из сейва

    private Image image;

    private Timer timer;

    public  void timer_start(){
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("time!");
                repaint();
            }
        });
        timer.start();
    }


    String getImageID(){
        String path_to_file = "/backimage/";
        String addon = ".jpg";                                  //расширение
        String path = path_to_file+numimage+addon;              //путь
        return path;
    }

    Panel(){
        setLayout(null);
        setSize(800,600);
        JTextArea jta = new JTextArea();
        jta.setBounds(110,460,590,90);
        jta.setFont(new Font("Arial", Font.PLAIN, 15));
        jta.setDisabledTextColor(Color.BLACK);
        jta.setLineWrap(true);
        jta.setEnabled(false);
        jta.setBackground(null);
        jta.setOpaque(false);
        jta.setText("Это тест движка\nИ это тоже");

        add(jta);

    }

    //ПАЛИТРА
    Color Brown = new Color(128, 77, 0);
    Color DarkBrown = new Color(128, 47, 0);
    Color Text = new Color(0, 0, 0);
    BasicStroke pen1 = new BasicStroke(8);
    BasicStroke pen2 = new BasicStroke(3);






    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D)gr;

        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        try{
            InputStream in = getClass().getResourceAsStream(getImageID());
            image = ImageIO.read(in);
        }catch (Exception ex){

        }

        g.drawImage(image,0,0,null);
        g.setColor(Brown);
        g.fillRoundRect(100,450,600,100, 20,20);

        g.setStroke(pen1);
        g.setColor(DarkBrown);
        g.drawRoundRect(100,450,600,100, 20,20);
        g.drawRoundRect(100,450,600,100, 20,20);

        


    }

}
