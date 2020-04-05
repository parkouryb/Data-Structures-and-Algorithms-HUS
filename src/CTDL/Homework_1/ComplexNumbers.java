package CTDL.Homework_1;

public class ComplexNumbers{
    private double realValue = 0.0;
    private double fakeValue = 0.0;
    
    public ComplexNumbers() {

    }
    public ComplexNumbers(double realValue, double fakeValue) {
        this.realValue = realValue;
        this.fakeValue = fakeValue;
    }

    public ComplexNumbers plus(ComplexNumbers x) {
        ComplexNumbers res = new ComplexNumbers(0.0, 0.0);
        res.realValue = this.realValue + x.realValue;
        res.fakeValue = this.fakeValue + x.fakeValue;
        return res;
    }
    
    public ComplexNumbers minus(ComplexNumbers x) {
        ComplexNumbers res = new ComplexNumbers(0.0, 0.0);
        res.realValue = this.realValue - x.realValue;
        res.fakeValue = this.fakeValue - x.fakeValue;
        return res;
    }

    public ComplexNumbers multi(ComplexNumbers x) {
        ComplexNumbers res = new ComplexNumbers(0.0, 0.0);
        res.realValue = (this.realValue * x.realValue - this.fakeValue * x.fakeValue);
        res.fakeValue = (this.realValue * x.fakeValue + this.fakeValue * x.realValue);
        return res;
    }

    @Override
    public String toString() {
        String plus = " + ";
        String minus = " - ";
        if (this.fakeValue < 0) return this.realValue + minus + -this.fakeValue + "i\n";
        else return this.realValue + plus + this.fakeValue + "i\n";
    }


}