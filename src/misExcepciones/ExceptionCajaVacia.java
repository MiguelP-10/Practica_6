package misExcepciones;

public class ExceptionCajaVacia extends Exception{
    public ExceptionCajaVacia() {

    }
    @Override
    public String toString(){
        return super.toString() + "Caja vacia";
    }
}


