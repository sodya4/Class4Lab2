/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author scottodya
 */
public class Calculators implements ICircleCalculator, IRectangleCalculator, ITriangleCalculator{
    
    
    @Override
    public double calculateCircleArea(String radius){
        double dRadius = Double.parseDouble(radius);
        double PI = 3.14;
        double value;
        value = PI * dRadius * dRadius;
        return value;
    }
    
    @Override
    public double calculateRectangleArea(String length, String width){
        double dLength = Double.parseDouble(length);
        double dWidth = Double.parseDouble(width);
        double value;
        value = dLength * dWidth;
        return value;
    }
    
    @Override
    public double calculateTriangleSide(String side_a, String side_b, String side_c){
        double value = 0;

        if ((side_a != "") && (side_b != "") && (side_c == "")) {
            double d_side_a = Double.parseDouble(side_a); 
            double d_side_b = Double.parseDouble(side_b);
            calculateHypotenuse(d_side_a, d_side_b);
        }

        if ((side_a != "") && (side_b == "") && (side_c != "")) {
            double d_side_a = Double.parseDouble(side_a);
            double d_side_c = Double.parseDouble(side_c);
            value = calculateSide(d_side_a, d_side_c);
        }
        
        if ((side_a == "") && (side_b != "") && (side_c != "")) {
            double d_side_b = Double.parseDouble(side_b);
            double d_side_c = Double.parseDouble(side_c);
            value = calculateSide(d_side_b, d_side_c);
        }
        
        return value;
}
    
    
    private double calculateHypotenuse(double d_side_a, double d_side_b) {
        double value = 0;
        value = Math.sqrt((d_side_a)*(d_side_a) + (d_side_b)*(d_side_b));
        return value;
    }

    private double calculateSide(double d_side_a, double d_side_c) {
        //Note: Although this takes side A and the hypotenuse, 
        //side B can be passed in as side A with the same result.
        //Therefore a separate method for side B is not needed.
        double value = 0;
        value = Math.sqrt((d_side_c)*(d_side_c) - (d_side_a)*(d_side_a));
        return value;   
    }
}
