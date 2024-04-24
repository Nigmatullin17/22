
package Nigma;
//поделючение библиотек
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 //этот класс отвечает за создание окна ввода и считыванеи из них данных
public class main extends JFrame
//вызывает основное окно которое отвечает за окно ввода
{

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
 
    main()
    {
        //создание окна с настройками и полей ввода
        JayFrame = new JFrame();
        JayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JayPlane = new JPanel();
        JayFrame.add(JayPlane);
        JayPlane.setBackground(Color.lightGray);
        JayPlane.setLayout(null);
        button = new JButton("Выполнить");
        JayFrame.setSize(320, 300);
        JayFrame.setLocation(900, 150); // Устанавливает позицию окна на экране по координатам (100, 100)
        

        //создание надписей и текстовых полей 
        TextField Ta = new TextField("3", 40);
        TextField Ty20 = new TextField("3", 40);
        TextField Tx1 = new TextField("0", 40);
        TextField Tx2 = new TextField("10", 40);
     
        JLabel func = new JLabel("F(x,y1,y2)=-axy2-x^2y1");
        JLabel La = new JLabel("a [-1; 10]:");
        JLabel Ly20 = new JLabel("y2(0) [-10; 10]:");
        JLabel Lx1 = new JLabel("x1 [0; 20]:");
        JLabel Lx2 = new JLabel("x2 [0; 20]:");



        //задание координат для текстовых полей и кнопок
        //позиция и размер надписи функции
        func.setLocation(10, 10);
        func.setSize(160, 20);
        //аоциция а
        Ta.setLocation(70, 40);
        Ty20.setLocation(90, 80);
        Ta.setSize(50, 20);
        Ty20.setSize(70, 20);
        Tx1.setLocation(70, 120);
        Tx2.setLocation(70, 160);
        Tx1.setSize(50, 20);
        Tx2.setSize(50, 20);
        // ширина и длина поля ввода
        Ta.setSize(200, 20);
        Ty20.setSize(180, 20);
        Tx1.setSize(200, 20);
        Tx2.setSize(200, 20);

        // Добавление компонентов на панель JayPlane
        JayPlane.add(func); // Добавление надписи func
        JayPlane.add(Ta); // Добавление текстового поля для параметра a
        JayPlane.add(Ty20);
        JayPlane.add(Tx1);
        JayPlane.add(Tx2);
        La.setLocation(10, 40); // Задание расположения надписи a
        La.setSize(70, 20); // Задание размеров надписи a
        JayPlane.add(La); // Добавление надписи a

        Ly20.setLocation(10, 80);
        Ly20.setSize(80, 20);
        JayPlane.add(Ly20);

        Lx1.setLocation(10, 120);
        Lx1.setSize(70, 20);
        JayPlane.add(Lx1);

        Lx2.setLocation(10, 160);
        Lx2.setSize(70, 20);
        JayPlane.add(Lx2);

        button.setLocation(20, 200); // Задание расположения кнопки button
        button.setSize(120, 30); // Задание размеров кнопки button
        JayPlane.add(button); // Добавление кнопки button

// Создание метки для вывода сообщений об ошибках
        error = new JLabel("");
        error.setLocation(10, 150); // Задание расположения метки error
        error.setSize(330, 20);
        JayPlane.add(error); // Добавление метки error

// Отображение окна и запрет изменения его размеров
        JayFrame.setVisible(true); // Делает окно видимым
        JayFrame.setResizable(false); // Запрещает изменение размеров окна
 
 
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    //считывание значений из полей
                    a = Double.valueOf(Ta.getText());
                    y20 = Double.valueOf(Ty20.getText());
                    x = Double.valueOf(Tx1.getText());
                    xx = Double.valueOf(Tx2.getText());
                    if (x < xx && x >= 0 && xx <= 20)
                    { //ограничения по х
                        if(Math.abs(y20) <= 10)
                        { //ограничение у20
                            if(a >= -1 && a <= 10)
                            {
                                try
                                {
                                    //создание окна и отрисовка
                                    new Graph(x, xx, y, yy, a, y20);
                                   JOptionPane.showMessageDialog(null, "Все данные верны");
                                } catch (Exception w3)
                                {
                                    set("Ошибка");
                                    System.out.println(w3);
                                }
                            }else
                            {
                               
                                 JOptionPane.showMessageDialog(null, "Некорректное значение а. a = [-1; 10]");
                            }
                            
                        }else{

                            JOptionPane.showMessageDialog(null, "Некорректное значение y2(0). Введите значения из [-10; 10]");
                            
                        }
                        
                    } else
                    {
     JOptionPane.showMessageDialog(null, "Некорректный интервал x. Введите значения из [0; 20] и x2 должно быть больше x1");

                    }                 
                }catch(Exception e1)
                {
   JOptionPane.showMessageDialog(null, "Некорректное значения");

                }
            }
        });
    }
 
    public void set(String s) {
        error.setText(s);
    }

}
