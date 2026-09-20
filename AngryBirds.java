/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw_lab9;


public class AngryBirds {
    private double yPosition; 
    private double speed;     
    private double angle;     
    private static final double G = -10.0; 

    public AngryBirds(double yPosition, double speed, double angle) {
        this.yPosition = yPosition;
        this.speed = speed;
        this.angle = angle;
    }
    //S(x)
    public double calculateLandingX() {
        double rad = Math.toRadians(angle);
        double ux = speed * Math.cos(rad);
        double uy = speed * Math.sin(rad);

        
        double a = 0.5 * G;
        double b = uy;
        double c = yPosition;

        double discriminant = (b * b) - (4 * a * c);
        if (discriminant < 0) return 0; 

        double t = (-b - Math.sqrt(discriminant)) / (2 * a);

        double sx = ux * t;
        return sx;
    }
}
