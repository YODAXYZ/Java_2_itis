package Homework_2;

public class ComplexNumber implements  Number<ComplexNumber>{

    //for real and imaginary parts of complex numbers
    private double real;
    private double img;


    //constructor to initialize the complex number
    ComplexNumber(double r, double i) {
        this.real = r;
        this.img = i;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImg() {
        return img;
    }

    public void setImg(double img) {
        this.img = img;
    }

    @Override
    public ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber temp = new ComplexNumber(0, 0);

        temp.real = c1.real + c2.real;
        temp.img = c1.img + c2.img;

        return temp;
    }

    @Override
    public ComplexNumber dif(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber temp = new ComplexNumber(0, 0);

        temp.real = c1.real - c2.real;
        temp.img = c1.img - c2.img;

        return temp;
    }

    public ComplexNumber mult(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber temp = new ComplexNumber(0, 0);

        temp.real = c1.real * c2.real - c1.img * c2.img;
        temp.img = c1.img * c2.real + c2.img * c1.real;

        return temp;
    }
}
