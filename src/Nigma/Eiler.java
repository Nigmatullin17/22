
package Nigma;
//подключение библиотек
import java.util.ArrayList;
import java.util.List;
//этот класс отвечает за вычисление интеграла методом эйлера
public class Eiler
{
    double h = 0.1; // Шаг
    double a = 0; // Параметр 'a'
    List<Double> Y1 = new ArrayList<Double>(); // Значения функции y1
    List<Double> Y2 = new ArrayList<Double>(); // Значения функции y2
    List<Double> X = new ArrayList<Double>(); // Значения аргумента x

    // Конструктор класса
    Eiler(double a, double y20, double x1, double x2)
    {
        this.a = a;
        // Начальные значения y1, y2 и x
        Y1.add(0.0); // Начальное значение y1(x1) = 0
        Y2.add(y20); // Начальное значение y2(x1) = y20
        X.add(x1); // Начальное значение x

        int index = 0;
        // Вычисление значений функций методом Эйлера
        for (double i = x1 + h; i < x2; i += h)
        {
            Y1.add(Y1.get(index) + h * F(h, Y1.get(index), Y2.get(index)));// Вычисление нового значения y1
            Y2.add(Y2.get(index) + h * Y1.get(index)); // Вычисление нового значения y2
            X.add(i); // Добавление нового значения x
            index++;
        }
    }

    // Метод для вычисления значения функции F(x, y1, y2)
    private double F(double x, double y1, double y2)
    {
        return (-a * x * y2 - Math.pow(x, 2) * y1);
    }
}

