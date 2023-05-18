package misExcepciones;

public class ExceptionNoNumero extends Exception {

    public ExceptionNoNumero(){

    }
    @Override
    public String toString(){
        return super.toString() + "El operador no es un numero";
    }
}

