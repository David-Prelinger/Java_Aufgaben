package com.prelinger;


public class Main {

    // Compute distance between two points
    public static void main(String[] arg) {
        chapter5_2_a();
    }

    static void chapter3_1() {
        In.open("input.txt");
        int x = In.readInt();
        int y = In.readInt();
        int z = In.readInt();
        In.close();
        if(!(x == y && x == z)) {
            Out.println("not all the same");
        } if (x != y && x != z && y != z) {
            Out.println("all different");
        } if (x == y || x == z || y == z) {
            Out.println("at least two the same");
        }
    }

    static void chapter3_2() {
        In.open("input.txt");
        int a = In.readInt();
        int b = In.readInt();
        int c = In.readInt();
        if(a == b && a == c) {
            Out.println("Gleichseitig");
        }
        if (a == b || a == c || b == c) {
            Out.println("Gleichschenklig");
        }
        if((a + b) <= c || (a+c) <= b || (c+b) <= a) {
            Out.println("ungültig");
        } if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a ) {
            Out.println("Rechtwinkleig");
        }
        else {
            Out.println("gültig");
        }
    }

    static void chapter3_7() {
        In.open("input.txt");
        int a = In.readInt();
        int b = In.readInt();
        int c = In.readInt();
        int z = 0;
        if(a>b) {
            z = a;
            a = b;
            b = z;
        }
        assert a<b;
        if (b>c) {
            z = b;
            b = c;
            c = z;
        }
        //b und c können getauscht sein
        assert b<c;
        if(a>b) {
            z = a;
            a = b;
            b = z;
        }
        assert a<b && b<c;
        Out.println(a + " " + b + " " + c);
    }

    static void chapter3_8() {
        In.open("input.txt");
        int day = In.readInt();
        int month = In.readInt();
        int year = In.readInt();
        int days_in_february = 29;
        In.close();
        if(day <= 0) {
            Out.println("ungültig");
        }
        if(year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
            days_in_february = 28;
        }
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if(day <= 31) {
                Out.println("gültig");
            } else {
                Out.println("ungültig");
            }
        } else if (month == 2) {
            if(day <= days_in_february) {
                Out.println("gültig");
            } else {
                Out.println("ungültig");
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if(day <= 30)  {
                Out.println("gültig");
            } else {
                Out.println("ungültig");
            }
        } else {
            Out.println("ungültig");
        }
    }

    static void chapter3_9() {
        In.open("input.txt");
        int day = In.readInt();
        int month = In.readInt();
        int year = In.readInt();
        int first_day = In.readInt() - 1;
        int days_in_february = 28;
        if(year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
            days_in_february = 29;
            Out.println("Schaltjahr");
        }
        int week_day = 0;
        for(int i_month = 1; i_month < month; i_month++) {
            int max_days = 30;
            switch (i_month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    week_day += 31;
                    break;
                case 2:
                    week_day += days_in_february;
                    break;
                default:
                    week_day += 30;
                    break;
            }
            Out.println(week_day);
        }
        week_day = (week_day + day + first_day) % 7;
        switch (week_day) {
            case 1:
                Out.println("Montag");
                break;
            case 2:
                Out.println("Dienstag");
                break;
            case 3:
                Out.println("Mittwoch");
                break;
            case 4:
                Out.println("Donnerstag");
                break;
            case 5:
                Out.println("Freitag");
                break;
            case 6:
                Out.println("Samstag");
                break;
            case 0:
                Out.println("Sonntag");
                break;
        }
    }

    static void chapter3_10() {
        In.open("input.txt");
        int a = In.readInt();
        int b = In.readInt();
        int c =a + b;
        if(a>0 && b>0 && c<0) {
                Out.println("Überlauf");
        } else if(a<0 && b<0 && c>0) {
                Out.println("Überlauf");

        } else {
            Out.println("Kein Überlauf");
        }
        In.close();
        Out.println(c);
    }

    static void chapter3_11() {
        In.open("input.txt");
        if (In.readInt() == 1) {
            int xa1 = In.readInt();
            int ya1 = In.readInt();
            int xa2 = In.readInt();
            int ya2 = In.readInt();

            int xb1 = In.readInt();
            int yb1 = In.readInt();
            int xb2 = In.readInt();
            int yb2 = In.readInt();
            Out.print("[("+xa1+","+ya1+"),("+xa2+","+ya2+")] schneidet ");
            Out.print("[("+xb1+","+yb1+"),("+xb2+","+yb2+")] ");
            In.close();

            if ((xa1 == xa2 || ya1 == ya2) && (xb1 == xb2 || yb1 == yb2)) {
                if ((xa1 >= xb1 && xa1 <= xb2) || (xa1 <= xb1 && xa1 >= xb2) || (xa2 >= xb1 && xa2 <= xb2) || (xa2 <= xb1 && xa2 >= xb2)) {
                    Out.println("Wahr");
                    if ((ya1 >= yb1 && ya1 <= yb2) || (ya1 <= yb1 && ya1 >= yb2) || (ya2 >= yb1 && ya2 <= yb2) || (ya2 <= yb1 && ya2 >= yb2)
                            || (yb1 >= ya1 && yb1 <= ya2) || (yb1 <= ya1 && yb1 >= ya2) || (yb2 >= ya1 && yb2 <= ya2) || (yb2 <= ya1 && yb2 >= ya2)) {
                        Out.println("Schnittpunkt");
                    }
                }
            }
        } else {
            int ax1 = In.readInt();  // line a: [(ax1,ay1), (ax2,ay2)]
            int ay1 = In.readInt();
            int ax2 = In.readInt();
            int ay2 = In.readInt();
            int bx1 = In.readInt();  // line b: [(bx1,by1), (bx2,by2)]
            int by1 = In.readInt();
            int bx2 = In.readInt();
            int by2 = In.readInt();
            In.close();


            // check for valid input data
            if (ax1 != ax2 && ay1 != ay2) Out.println("a muss horizontal oder vertikal sein");
            else if (bx1 != bx2 && by1 != by2) Out.println("b muss horizontal oder vertikal sein");
            else {

                // normalize so that x1 <= x2 and y1 <= y2
                int h;
                if (ax1 > ax2) {h = ax1; ax1 = ax2; ax2 = h;} // ay1 == ay2
                if (ay1 > ay2) {h = ay1; ay1 = ay2; ay2 = h;} // ax1 == ay1

                // check if a and b intersect
                Out.print("[("+ax1+","+ay1+"),("+ax2+","+ay2+")] schneidet ");
                Out.print("[("+bx1+","+by1+"),("+bx2+","+by2+")] ");
                if (bx1 > ax2 || bx2 < ax1 || by1 > ay2 || by2 < ay1)
                    Out.println("nicht");
                else
                    Out.println();

            }
        }
    }

    static void chapter3_12() {

    }

    static void chapter5_1() {
        double pi = 0;
        boolean isNegative = false;
        for(double i=1; i<=800000; i+=2) {
            if(isNegative) {
               pi -= 1/i;
            } else {
                pi += 1/i;
            }
            isNegative = !isNegative;
        }
        pi = pi * 4;
        Out.println(pi);
    }

    static void chapter5_2() {
        In.open("input.txt");
        double x = In.readDouble();
        Out.println("Input:" + x);
        double formula = x;
        double result = x;
        for(double i=1; i < 100; i++) {
            formula *= (x * x * (2 * i - 1) * (2 * i - 1)) / (2 * i * ( 2 * i + 1));
            result += formula;
        }
        Out.println("Output in rad:" + result);
    }

    static void chapter5_2_a() {
        In.open("input.txt");
        double x = In.readDouble();
        double arcsin = 0;
        for(int i=0; i<=0; i++) {
            double fak2i = 1;
            for(double j=i*2;j>=1;j--) {
                fak2i *= j;
            }
            double faki = 0;
            for(double k=i;k>=1;k--) {
                fak2i *= k;
            }
            double power2i = 1;
            for (int l=0;l<=2*i;l++) {
                power2i *= 2;
            }
            double xpower2iplus1 = 1;
            for (int s=0;s<=2*i+1;s++) {
                xpower2iplus1 *= x;
            }
            double result = (fak2i * xpower2iplus1) / (power2i * faki * (2*i+1));
            arcsin += result;
        }
        Out.println(arcsin);
    }

    static void chapter5_3() {
        In.open("input.txt");
        double capital = In.readDouble();
        double interest = In.readDouble();
        double years = In.readDouble();
        In.close();
        Out.println("YEAR | CAPITAL");
        for(int i = 0; i<=years; i++) {
            Out.println(i + "   " + capital);
            capital *= interest;
        }
    }
}
