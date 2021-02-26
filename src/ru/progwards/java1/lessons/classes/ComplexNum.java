package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    //  (a + bi) + (c + di) = (a + c) + (b + d)i
    public ComplexNum add(ComplexNum num) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        this.a += num.a;
        this.b += num.b;
        return this;
    }

    //  (a + bi) - (c + di) = (a - c) + (b - d)i
    public ComplexNum sub(ComplexNum num) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        this.a -= num.a;
        this.b -= num.b;
        return this;
    }

    //  (a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
    public ComplexNum mul(ComplexNum num) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int resultA = (this.a * num.a) - (this.b * num.b);
        int resultB = (this.b * num.a) + (this.a * num.b);
        this.a = resultA;
        this.b = resultB;
        return this;
    }

    //  (a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
    public ComplexNum div(ComplexNum num) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int resultA = (this.a * num.a + this.b * num.b) / (num.a * num.a + num.b * num.b);
        int resultB = (this.b * num.a - this.a * num.b) / (num.a * num.a + num.b * num.b);
        this.a = resultA;
        this.b = resultB;
        return this;
    }

    static void myTesting() {
        ComplexNum result = new ComplexNum(1, 56);
        System.out.println(result);
        System.out.println(result.add(new ComplexNum(7, 4)).toString());
        System.out.println(result.sub(new ComplexNum(7, 4)).toString());
        System.out.println(result.mul(new ComplexNum(99, 99)).toString());
        System.out.println(result.div(new ComplexNum(100, 100)).toString());
    }

    public static void main(String[] args) {
        myTesting();
    }
}
