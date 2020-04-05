package CTDL.Homework_3;

public class Complex {
    private float real; // phần thực
    private float image; // phần ảo

    public Complex(float r, float i) {
        this.real = r;
        this.image = i;
    }

    public Complex add(Complex c) {
        Complex res = new Complex(0.0f, 0.0f);
        res.real = this.real + c.real;
        res.image = this.image + c.image;
        return res;
    }

    public Complex minus(Complex c) {
        Complex res = new Complex(0.0f, 0.0f);
        res.real = this.real - c.real;
        res.image = this.image - c.image;
        return res;
    }

    public Complex time(Complex c) {
        Complex res = new Complex(0.0f, 0.0f);
        res.real = (this.real * c.real - this.image * c.image);
        res.image = (this.real * c.image + this.image * c.real);
        return res;
    }

    public float realpart() {
        return real;
    }

    public float imagepart() {
        return image;
    }

    @Override
    public String toString() {
        String plus = " + ";
        String minus = " - ";
        if (this.image < 0)
            return this.real + minus + -this.image + "i\n";
        else
            return this.real + plus + this.image + "i\n";
    }
}