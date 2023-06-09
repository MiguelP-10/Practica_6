package PaqCalc;

import misExcepciones.ExceptionCajaVacia;
import misExcepciones.ExceptionNoNumero;
import misExcepciones.Exceptionresultadoindefinido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// MANEJO DE EVENTOS EN UNA GUI EN JAVA.

public class Calculadora implements KeyListener, ActionListener  {

    private final JTextField t=new JTextField();
    private final JButton[] botones={new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),
            new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),
            new JButton("9"),new JButton("0"),new JButton("."),new JButton("+"),
            new JButton("-"),new JButton("*"),new JButton("/"),new JButton("=")
    };
    private final JButton bdel=new JButton("Delete");
    private final JButton bclr=new JButton("Clear");
    private final JCheckBox Pi = new JCheckBox("Mas Operaciones");
    private double a;
    private double b;
    private double resultado;
    private int operador;

    JButton PI = new JButton("PI");
    JButton Coseno = new JButton("Coseno");




    public Calculadora() {

        a = b = resultado = operador = 0;

        JFrame f = new JFrame("Calculadora");
        t.setBounds(30, 40, 320, 30);
        f.add(t);
        int indice = 0;
        for (int x = 40; x <= 300; x = x + 86) {
            for (int y = 100; y <= 360; y = y + 70) {
                botones[indice].setBounds(x, y, 50, 40);
                f.add(botones[indice]);
                indice++;
            }
        }

        bdel.setBounds(40, 380, 100, 40);
        bclr.setBounds(250, 380, 100, 40);
        Pi.setBounds(140,420,100,40);
        PI.setBounds(40, 380, 0, 0);
        Coseno.setBounds(250, 420, 0, 0);
        f.add(bdel);
        f.add(bclr);
        f.add(Pi);
        f.add(PI);
        f.add(Coseno);



        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400, 520);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Por defecto se usa HIDE_ON_CLOSE y el programa sigue activo en memoria
        f.setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        f.setIconImage(icon);
        f.setLocationRelativeTo(null); //se posiciona en el centro de la pantalla

        Pi.addActionListener(this);
        bclr.addActionListener(this);
        bdel.addActionListener(this);

        for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(this);
        }




        t.addKeyListener(this);


// APARTADO 1. HACER QUE EL PROGRAMA RESPONDA ANTE TODOS LOS POSIBLES EVENTOS PROVOCADOS POR
// EL RATÓN EN EL MANEJO DE LA CALCULADORA

        // NOMBRE DE MÉTODO ADECUADO PARA PROCESAR LOS EVENTOS {

       /*
          1. COMPONER EL NÚMERO PARA QUE APAREZCA EN LA CAJA DE TEXTO

          2. SI SE HA PULSADO EL BOTÓN + CONVERTIR A DOBLE EL TEXTO DE LA CAJA Y PONERLA VACÍA.
             FIJAR EL VALOR DE LA VARIABLE OPERADOR

          3. HACER ALGO SIMILAR CON EL RESTO DE OPERADORES

          4. SI SE PULSA EL BOTÓN  =  LLAMAR AL MÉTODO Operar

          5. SI SE PULSA EL BOTÓN Clear BORRAR LA CAJA DE TEXTO

          6. SI SE PULSA EL BOTÓN Delete USAR UN StringBuilder PARA ELIMINAR UN CARÁCTER DE LA SECUENCIA

        */


    }



    private void Operar() throws  Exceptionresultadoindefinido, ExceptionNoNumero{

        b = Double.parseDouble(t.getText());
        if(operador==1){
            this.resultado = a+b;
            t.setText(String.valueOf(resultado));
        }
        else if(operador==2){
            this.resultado = a-b;
            t.setText(String.valueOf(resultado));
        }
        else if(operador ==3){
            this.resultado = a*b;
            t.setText(String.valueOf(resultado));
        }
        else if(operador==4){
            this.resultado = a/b;
            t.setText(String.valueOf(resultado));
        }
        else if (Double.isNaN(resultado)) {
            throw new Exceptionresultadoindefinido();
        }
        else if (b != 0 || b != 1  || b != 2 || b != 3 || b != 4 || b != 5 || b != 6 || b != 7 || b != 8 || b != 9) {
            throw new ExceptionNoNumero();
        }
        // REALIZAR LA OPERACIÓN OPORTUNA EN FUNCIÓN DEL VALOR DE LA VARIABLE operador
        // Y MOSTRAR EL VALOR DE LA VARIABLE EN LA CAJA DE TEXTO

    }

    @Override
    public void actionPerformed(ActionEvent e){


        if(e.getActionCommand()=="Delete"){
            String texto = t.getText();
            if (texto.length() > 0) {
                texto = texto.substring(0, texto.length() - 1);
                t.setText(texto);
            }
            else if(texto==null){

            }
        }
        if(e.getActionCommand()=="Clear"){
            a=0;
            b=0;
            operador = 0;
            t.setText(null);
        }

        if(e.getActionCommand()=="0"){
            t.setText(t.getText() + "0");
        }
        if(e.getActionCommand()=="1") {
            t.setText(t.getText() + "1");
        }
        if(e.getActionCommand()=="2"){
            t.setText(t.getText()+"2");
        }
        if(e.getActionCommand()=="3"){
            t.setText(t.getText()+"3");;
        }
        if(e.getActionCommand()=="4"){
            t.setText(t.getText()+"4");
        }
        if(e.getActionCommand()=="5"){
            t.setText(t.getText()+ "5");
        }
        if(e.getActionCommand()=="6"){
            t.setText(t.getText()+"6");

        }
        if(e.getActionCommand()=="7"){
            t.setText(t.getText()+"7");

        }
        if(e.getActionCommand()=="8"){
            t.setText(t.getText()+"8");

        }
        if(e.getActionCommand()=="9"){
            t.setText(t.getText()+"9");

        }
        if(e.getActionCommand()=="+"){
            a = Double.parseDouble(t.getText());
            t.setText(null);
            this.operador = 1;
        }
        if(e.getActionCommand()=="-"){
            a = Double.parseDouble(t.getText());
            if(a != 0 || a != 1  || a != 2 || a != 3 || a != 4 || a != 5 || a != 6 || a != 7 || a != 8 || a != 9){
                //throw new ExceptionNoNumero();
            }
            else{
                t.setText(null);
                this.operador = 2;
            }

        }
        if(e.getActionCommand()=="*"){
            a = Double.parseDouble(t.getText());
            t.setText(null);
            this.operador = 3;
        }
        if(e.getActionCommand()=="/"){
            a = Double.parseDouble(t.getText());
            t.setText(null);
            this.operador = 4;
        }
        if(e.getActionCommand()=="=") {
            try {
                this.Operar();
            } catch (Exceptionresultadoindefinido ex) {
                throw new RuntimeException(ex);
            } catch (ExceptionNoNumero ex) {
                throw new RuntimeException(ex);
            }
        }

            if(Pi.isSelected()){
                PI.setBounds(40, 420, 100, 40);
                Coseno.setBounds(250, 420, 100, 40);
            }
            if(!Pi.isSelected()){
                PI.setBounds(40, 420, 0, 0);
                Coseno.setBounds(250, 420, 0, 0);
            }


        t.requestFocus(); // Sitúo el foco de nuevo en la caja de texto.

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                this.Operar();
            } catch (Exceptionresultadoindefinido ex) {
                throw new RuntimeException(ex);
            } catch (ExceptionNoNumero ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


// APARTADO 2. HACER QUE CUANDO SE PULSE LA TECLA Intro SE REALICE EL CÁLCULO USANDO LA INTERFACE KeyListener

// APARTADO 3. HACER QUE AL PULSAR EL "Aspa" SITUADA EN LA PARTE SUPERIOR DERECHA DE LA VENTANA
//