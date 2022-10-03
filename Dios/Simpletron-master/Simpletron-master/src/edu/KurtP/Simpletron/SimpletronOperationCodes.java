 package edu.KurtP.Simpletron;

/**
 * @author William Alfaro
 *         2022437996
 * y
 * Angel Vargas
 * @version 1.0.0.0108201
 */
public abstract class SimpletronOperationCodes {
    //Read and write operations

    protected static final int var = 00;
    protected static final int Leer = 10;
    protected static final int Escribir = 11;

    //Load and store operations
    protected static final int Cargar = 20;
    protected static final int Almacenar = 21;

    //Arithemetic operations
    protected static final int Suma = 30;
    protected static final int Resta = 31;
    protected static final int Multiplicar = 32;
    protected static final int Dividir = 33;


    protected static final int Modulo = 34;

    protected static final int Exponenciacion = 35;

    //Transfer of controle operations
    protected static final int Bifurca = 40;
    protected static final int Bifurca_Negativo = 41;
    protected static final int Bifurca_Zero = 42;

    protected static final int Bifurca_Positivo = 43;
    protected static final int Parar = 44;

    //Locical operations
    protected static final int AND = 50;
    protected static final int OR = 51;
    protected static final int XOR = 52;
}
