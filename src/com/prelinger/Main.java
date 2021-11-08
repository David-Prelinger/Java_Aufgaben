package com.prelinger;


public class Main {

    // Compute distance between two points
    public static void main(String[] arg) {
        chapter3_9();
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
        int first_day = In.readInt();
        int days_in_february = 29;
        if(year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) {
            days_in_february = 28;
        }
        int week_day = first_day;
        for(int i_month = 1; i_month < month; i_month++) {
            int max_days = 30;
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    max_days = 31;
                case 2:
                    max_days = days_in_february;
            }
            week_day = (week_day + max_days % 7) % 7;
        }
        Out.println(day % 7);
        Out.println(week_day);

        week_day = day % 7 - week_day;
        Out.println(week_day);

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
            case 7:
                Out.println("Sonntag");
                break;
        }
    }
}
