public class Circle{
    private double radius;
    
    public Circle(double r){
        radius = r;
    }
    
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    public double getRadius(){
         return radius;
    }
    
    public String toString(){
         double area = getArea();
         String circleInfo = String.format("Area of the circle: " + area + " Radius: " + radius);
         return circleInfo; 
    }
    
    public boolean equals(Circle circ){
        boolean isTrue = false;
        if(circ.radius == this.radius){
            isTrue = true;
        }
        return isTrue;
    }
    
    public boolean greaterThan(Circle circ){
        double circleArea = circ.getArea();
        double thisArea = this.getArea();
        boolean isTrue = false;
        if(circleArea > thisArea){
            isTrue = true;
        }
        return isTrue;
    }
}