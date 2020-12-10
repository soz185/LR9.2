package lr9;

import java.util.Scanner;

import java.lang.Math.*;
//import lr5.Radius;

public class Vector {
	private double X;
	private double Y;
	private	double Z;
	private	Radius cylinderRadius;
	public static int countOfVectors = 0;
	
	public Vector() {
		this.X = 0.0;
		this.Y = 0.0;
		this.Z = 0.0;
		Radius rad = new Radius(0.0);
		this.cylinderRadius = rad;
		countOfVectors++;
	}
	public Vector(double x, double y, double z, Radius rad) {
		X = x;
		Y = y;
		Z = z;
		cylinderRadius = rad;
		countOfVectors++;
	}
	public Vector(int n)
	{
		this.X = n;
		this.Y = n;
		this.Z = n;
		Radius rad = new Radius(n);
		this.cylinderRadius = rad;
		countOfVectors++;
	}

	protected void finalize()
	{
		if (countOfVectors > 0)
			countOfVectors--;
	}
	public void read() {
		Scanner input = new Scanner(System.in);
		X = input.nextDouble();
		Y = input.nextDouble();
		Z = input.nextDouble();
		cylinderRadius.readRadius();
	}
	public void display() {
		System.out.print(X + "; " + Y + "; " + Z);
		System.out.print(", radius = ");
		cylinderRadius.displayRadius();
	}
	public static int GetCountOfVector()
	{
		return countOfVectors;
	}
	public Vector add(Vector vector) {
		Vector c = new Vector();
		c.X = this.X + vector.X;
		c.Y = this.Y + vector.Y;
		c.Z = this.Z + vector.Z;
		c.cylinderRadius.addRadius(this.cylinderRadius, vector.cylinderRadius);
		return c;
	}
	public double length() {
		double length = Math.sqrt(X * X + Y * Y + Z * Z);
		return length;
	}
	public double scalar(Vector vector) {
		double scalar = X * vector.X + Y * vector.Y + Z * vector.Z;
		return scalar;
	}
	public double cylinderVolume() {
		double volume = cylinderRadius.returnRadius() * cylinderRadius.returnRadius() * length() * 3.14;
		return volume;
	}
}
