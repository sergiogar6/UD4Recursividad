package org.example;

import java.util.Scanner;

public class MenuEjercicios {

    public static Scanner entry = new Scanner(System.in);

    public static char[] chars;

    public static int number;

    public static int count;

    public static String binary;

    public static void bateria() {
        menu();
        int option = askNumber();
        selectOption(option);
        returnMenu();
    }

    public static void menu() {
        System.out.println("*** Batería de ejercicios sobre recursividad ***");
        System.out.println("Selecciona a continuación el modo que quieras ejecutar...");
        System.out.println("    1 - Dígitos");
        System.out.println("    2 - Potencias");
        System.out.println("    3 - Del Revés");
        System.out.println("    4 - Binario");
        System.out.println("    5 - A binario");
        System.out.println("    6 - Orden alfabético");
        System.out.println("    7 - Mostrar suma");
    }

    public static int askNumber() {
        return entry.nextInt();
    }

    public static String askOption() {
        return entry.next();
    }

    public static void selectOption(int option) {
        switch (option) {
            case 1:
                number = askNumber();
                System.out.println(ejercicio1(number));
                break;
            case 2:
                int base = askNumber();
                int exponent = askNumber();
                System.out.println(ejercicio2(base, exponent));
                break;
            case 3:
                System.out.println("Que quieres invertir");
                System.out.println("    1 - Número");
                System.out.println("    2 - Cadena");
                option = askNumber();
                if (option == 1) {
                    ejercicio3int(askNumber());
                } else if (option == 2) {
                    chars = askOption().toCharArray();
                    int count = chars.length-1;
                    ejercicio3char(count);
                }
                break;
            case 4:
                binary = String.valueOf(askNumber());
                count = binary.length()-1;
                if (ejercicio4(count)) {
                    System.out.println("Es binario");
                } else {
                    System.out.println("No es binario");
                }
                break;
            case 5:
                number = askNumber();
                System.out.println(ejercicio5(number));
                break;
            case 6:
                chars = askOption().toCharArray();
                count = chars.length-1;
                if (ejercicio6(count)) {
                    System.out.println("La palabra esta ordenada");
                } else {
                    System.out.println("La palabra no esta ordenada");
                }
                break;
            case 7:
                number = askNumber();
                System.out.println(ejercicio7(number));
                break;
            default:

                break;
        }
    }

    public static void returnMenu() {
        System.out.println("Elige una opción");
        System.out.println("    [M] - Volver al menu principal");
        System.out.println("    [X] - Salir");
        String option = askOption().toUpperCase();
        if (option.equals("M")) {
            bateria();
        }
    }

    public static int ejercicio1(int number) {
        if (number < 10) {
            return 1;
        }
        return 1 + ejercicio1(number/10);

    }

    public static int ejercicio2(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * ejercicio2(base, --exponent);
    }

    public static void ejercicio3int(int number) {
        if (number >= 0 && number < 10 ) {
            System.out.println(number);
        } else {
            System.out.print(number % 10);
            ejercicio3int(number / 10);
        }
    }

    public static void ejercicio3char(int count) {
        if (count == 0) {
            System.out.println(chars[count]);
        } else {
            System.out.print(chars[count]);
            ejercicio3char(count-1);
        }
    }
    public static boolean ejercicio4(int count) {
        if (binary.charAt(count) == '0' || binary.charAt(count) == '1') {
            if (count == binary.length()-1) {
                return true;
            } else {
                return ejercicio4(++count);
            }
        }
        return false;
    }

    public static String ejercicio5(int number) {
        if (number == 0 || number == 1) {
            return String.valueOf(number);
        } else {
            return ejercicio5(number / 2) + number % 2;
        }
    }

    public static boolean ejercicio6(int count) {
        if (count < chars.length - 1) {
            if (chars[count] <= chars[count+1]) {
                return ejercicio6(++count);
            } else {
                return false;
            }
        }
        return true;
    }

    public static String ejercicio7(int number) {
        if (number <= 0) {
            return "El numero debe ser mayor que cero.";
        } else if (number == 1) {
            return "1 = 1";
        }
        String result = ejercicio7(number - 1);
        int sum = Integer.parseInt(result.split(" = ")[1]);
        return result.split(" = ")[0] + "+" + number + " = " + (sum + number);
    }

    public static void main(String[] args) {
        bateria();
    }
}
