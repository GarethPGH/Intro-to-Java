import javax.swing.JOptionPane;

public class Geometry{
   //Area of Circle
    public static double areaOfCircle(int radius){
        double area = Math.PI * (radius * radius);
        if(radius < 0){
            JOptionPane.showMessageDialog(null, "Only positive numbers allowed!");
            area = 0;
        }
        return area;
    }
   //Area of Rectangle 
    public static int areaOfRectangle(int length, int width){
        int area = length * width;
        if(length < 0 || width < 0){
            JOptionPane.showMessageDialog(null, "Only positive numbers allowed!");
            area = 0;
        }
        return area;
    }
   //Area of Triangle
    public static double areaOfTriangle(int base, int height){
        double area = 0.5 * (base * height);
        if(height < 0 || base < 0){
            JOptionPane.showMessageDialog(null, "Only positive numbers allowed!");
            area = 0;
        }
        return area;
    }
}