
package Nigma;
//подключение библиотек
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.List;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
 
//этот класс отвечает за созадание и отрисовку окна с разеультатами вычислений
public class Results extends JPanel
//наследование идет
{
    int w;
    int h;
    List<Double> Y1;//значения у1
    List<Double> Y2;//значения у2
    List<Double> X ;//значения х
    int offset = 0;
    JFrame JF;

    public Results(List<Double> x,List<Double> y1, List<Double> y2) //конструктор
    {
        h = 480;
        w = 350;
        this.Y1 = y1;
        this.Y2 = y2;
        this.X = x;
        this.offset = 0;
        frameopt();
    }
    public void close(){
        JF.dispose();
    }
    public void frameopt()
    {
        JF = new JFrame("Метод Эйлера");
        JF.setBounds(500, 500, w + 6, h + 28);
        JF.setLayout(null);
        JF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JF.setVisible(true);
        JF.setResizable(false);
        this.setSize(w, h);
        JF.add(this);
        this.setBackground(Color.lightGray);

        this.addMouseWheelListener(new MouseWheelListener()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
 
                int r = e.getWheelRotation();
 
                if(r>0){
                    if(X.size()-offset*20 > offset )
                    offset+=1;
                }else
                {
                    if(offset>0)
                        offset-=1;
                }
 
                repaint();
 
            }
        });
    }

    @Override
    public void paintComponent(Graphics g)
    {
        //Отрисовка окна с графиком
        super.paintComponent(g);

 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        //Отрисовка результатов
        Paint(g);
        
 
    }


    public void Paint(Graphics g)
    {
        Font fnt = new Font("default", Font.ITALIC, 16);
        g.setFont(fnt);
        g.setColor(Color.BLACK);
        g.drawString(String.format("%5s %15s %15s %15s","Индекс","x","y1","y2"),10,50);//вывод названия функции
        for(int i = this.offset*20, j = 0; i < Y1.size() && i < (this.offset+1)*20; i++,j++)
        {
            g.drawString(String.format("%5d %15.3f %15.3f %15.3f", i, X.get(i), Math.abs(Y1.get(i).doubleValue()), Math.abs(Y2.get(i).doubleValue())), 10, 70 + j * 20);
//вывод значений
        }
    }


}