package automatos;

import javax.swing.*;
import java.util.Scanner;


public class Automatos {
    public int count;
    public char[] palavra;
    
    public static void main(String[] args) {
        Automatos automato = new Automatos();
        String teste;
        Scanner scan = new Scanner(System.in);

        boolean continuar =true;
        while(continuar){

            String op;
            op = JOptionPane.showInputDialog( "1: testar autômato \n" + "2: Sair \n" );

            switch (op)
            {
                case "1":
                    teste= JOptionPane.showInputDialog("Digite a palavra: ");
                    automato.palavra= teste.toCharArray();
                    automato.Iniciar();
                    break;

                case "2":
                    continuar = false;
                    break;
            }
        }
    }
    public void Iniciar(){
        count = 0;
        q0();
    }
    public void q0() {
        if (palavra.length > count) {
            if (palavra[count] == 'a') {

                count++;
                System.out.println("O autômato recebeu a Letra A: Estado anterior : Q0 " +
                        "Estado atual: Q1");
                q1();

            } else if ('b' == palavra[count]) {
                count++;
                System.out.println("O autômato recebeu a Letra B: Estado anterior : Q0 " +
                        "Estado atual: Q2");
                q2();

            } else if (palavra[count] == '$') {
                count++;

            } else qErro();

        }
    }

    public void q1() {
        if (palavra.length > count) {

            if(palavra[count] == 'a')
            {
                count++;
                System.out.println("O autômato recebeu a Letra A: estado atual Q1");
                q1();
            }
            else if ('b' == palavra[count])
            {
                count++;
                System.out.println("O autômato recebeu a Letra B: Estado anterior : Q1 " +
                        "Estado atual: Q1");
                q1();
            }

            else if ('$' == palavra[count])
            {
                count++;
                System.out.println("O autômato recebeu a Letra $: Estado anterior : Q1 " +
                        "Estado atual: Q3");
                q3();


            }
            else
            {
                qErro();
            }
        }
    }
    public void q2() {
        if (palavra.length > count) {
            if ('b' == palavra[count]) {
                count++;
                System.out.println("O autômato recebeu a Letra B: Estado anterior : Q2 " +
                        "Estado atual: Q1");
                q1();
            }
            else {
                qErro();
            }


        }
    }
    public void q3()
    {

        JOptionPane.showInputDialog("Chegou ao estado final");

        System.out.println("Palavra aceita");


    }
    public void qErro()
    {
        if(palavra[count] < palavra.length)
        {
            count++;
        }


         else {
        JOptionPane.showInputDialog("Palavra não aceita");
        }

    }
}