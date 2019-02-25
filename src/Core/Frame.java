package Core;

import javax.swing.*;




public class Frame extends JFrame {
    Frame(){
        setTitle("VN_Engine");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel p = new Panel();
        this.add(p);
        p.timer_start();
    }


}
