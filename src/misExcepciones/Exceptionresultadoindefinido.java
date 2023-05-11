package misExcepciones;

public class Exceptionresultadoindefinido extends Exception {
    public Exceptionresultadoindefinido() {

    }
    @Override
    public String toString(){
        return super.toString() + "Resultado indefinido";
    }
}
