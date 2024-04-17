
package Nigma;

import java.util.ArrayList;
import java.util.List;

public class Eiler {    
    double h = 0.1;//шаг
    double a = 0;//параметр а
    List<Double> Y1 = new ArrayList<Double>();//значения у1
    List<Double> Y2 = new ArrayList<Double>();//значения у2
    List<Double> X = new ArrayList<Double>();//значения х

    Eiler(double a, double y20, double x1, double x2){//вычисление значений функций
        this.a = a;
        //задаем начальные значения
        Y1.add(0.0);
        Y2.add(y20);
        X.add(x1);
        int index = 0;
        for(double i = x1+h; i < x2; i+=h){
            Y1.add(Y1.get(index) + h*F(h, Y1.get(index), Y2.get(index)));//вычисление y1
            Y2.add(Y2.get(index) + h*Y1.get(index));//вычисление y2
            X.add(i);
            index++;
        }
    }

    private double F(double x, double y1, double y2){//f(x,y1,y2)
        return (-a*x*y2 - Math.pow(x,2)*y1); // функция по варианту 22
    }
    
}
