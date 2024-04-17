
package Nigma;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class main extends JFrame {

    //создание переменных
    double x = -5;
    double xx = 5;
    double y = -5;
    double yy = 5;
    double a = 0;
    double y20 = 0;
    //создание окна
    JFrame JayFrame;
    JPanel JayPlane;
    JButton button;
    JLabel error;
 
    main() {
        //создание окна с настройками и полей ввода
        JayFrame = new JFrame();
        JayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JayPlane = new JPanel();
        JayFrame.add(JayPlane);
        //поменять на любой
        JayPlane.setBackground(Color.lightGray);
        JayPlane.setLayout(null);
        button = new JButton("Выполнить");
        JayFrame.setSize(170, 300);
        

        //создание надписей и текстовых полей 
        TextField Ta = new TextField("3", 40);
        TextField Ty20 = new TextField("3", 40);
        TextField Tx1 = new TextField("0", 40);
        TextField Tx2 = new TextField("10", 40);
     
        JLabel func = new JLabel("F(x,y1,y2)=-axy2-x^2y1");
        JLabel La = new JLabel("a:");
        JLabel Ly20 = new JLabel("y2(0):");
        JLabel Lx1 = new JLabel("x1:");
        JLabel Lx2 = new JLabel("x2:");



        //задание координат для текстовых полей и кнопок
      
        func.setLocation(10, 10);
        func.setSize(160, 20);
        Ta.setLocation(40, 40);
        Ty20.setLocation(40, 80);
        Ta.setSize(50, 20);
        Ty20.setSize(50, 20);
        Tx1.setLocation(40, 120);
        Tx2.setLocation(40, 160);
        Tx1.setSize(50, 20);
        Tx2.setSize(50, 20);
        
        JayPlane.add(func);
        JayPlane.add(Ta);
        JayPlane.add(Ty20);
        JayPlane.add(Tx1);
        JayPlane.add(Tx2);

        La.setLocation(10, 40);
        La.setSize(40, 20);
        JayPlane.add(La);
 
        Ly20.setLocation(10, 80);
        Ly20.setSize(40, 20);
        JayPlane.add(Ly20);

        Lx1.setLocation(10, 120);
        Lx1.setSize(40, 20);
        JayPlane.add(Lx1);
        
        Lx2.setLocation(10, 160);
        Lx2.setSize(40, 20);
        JayPlane.add(Lx2);

        
 
        button.setLocation(20, 200);
        button.setSize(120, 30);
        JayPlane.add(button);

 
 
        error = new JLabel("");
        error.setLocation(10, 150);
        error.setSize(330, 20);
        JayPlane.add(error);
 
        JayFrame.setVisible(true);
        JayFrame.setResizable(false);
 
 
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                try{
                    //считывание значений из полей
                    a = Double.valueOf(Ta.getText());
                    y20 = Double.valueOf(Ty20.getText());
                    x = Double.valueOf(Tx1.getText());
                    xx = Double.valueOf(Tx2.getText());
                    if (x < xx && x >= 0 && xx <= 20) { //ограничения по х
                        if(Math.abs(y20) <= 10){ //ограничение у20
                            if(Math.abs(a)<=10){
                                try {
                                    //создание окна и отрисовка
                                    new Graph(x, xx, y, yy, a, y20);
                                   JOptionPane.showMessageDialog(null, "Все данные верны");
                                } catch (Exception w3) {
                                    set("Ошибка");
                                    System.out.println(w3);
                                }
                            }else{
                               
                                 JOptionPane.showMessageDialog(null, "Некорректное значение а. a = [-5; 5]");
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Некорректное значение y2(0). Введите значения из [-5; 5]");
                            
                        }
                        
                    } else {
     JOptionPane.showMessageDialog(null, "Некорректный интервал x. Введите значения из [0; 20] и x2 должно быть больше x1");

                    }                 
                }catch(Exception e1){
   JOptionPane.showMessageDialog(null, "Некорректное значения");

                }
            }
        });
    }
 
    public void set(String s) {
        error.setText(s);
    }

}
