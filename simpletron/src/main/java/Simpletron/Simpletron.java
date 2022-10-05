/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simpletron;


import java.util.Scanner;
/**
 *
 * @author gabri
 */
public class Simpletron extends SimpletronOperationsCode {
    private int[] memory = new int[100];
    private int accumulator;
    private int instructionCounter;
    private int instructionRegister;
    private int operationCode;
    private int operand;
    private boolean run = true;

    public Simpletron() {
    }

    public void run() {
        this.welcomeMessage();
        this.execute();
    }

    private void welcomeMessage() {
        System.out.println("***            Bienvenido a Simpletron!           ***");
        System.out.println("***            Ingrese una instruccion            ***");
        System.out.println("***      Para ejecutar use la instruccion +44000     ***");
    }

    private void execute() {
        Scanner codeInputter = new Scanner(System.in);
        int instructionInput;
        int memoryPointer = 0;

        //int instructionInput;
        do {
            System.out.printf("%02d ? ", memoryPointer);
            instructionInput = codeInputter.nextInt();
            this.memory[memoryPointer] = instructionInput;
            ++memoryPointer;
            System.out.println("" + instructionInput + "<-");
        } while(instructionInput != -99999);

        System.out.printf("\n%s\n%s\n\n", "***  Program loading complete ***", "*** Program excution begins ***");

        while(this.run) {
            this.loadCode();
            this.operations(this.operationCode, this.operand);
        }

        System.exit(0);
    }

    private void loadCode() {
        this.instructionRegister = this.memory[this.instructionCounter];
        this.operationCode = this.instructionRegister / 1000;
        this.operand = this.instructionRegister % 1000;
        this.instructionRegister = this.memory[this.instructionCounter];
        this.operationCode = this.instructionRegister / 1000;
        this.operand = this.instructionRegister % 1000;
    }

    private void operations(int operationCode, int operand) {
        boolean branching = false;
        switch (operationCode) {
            case 10:
                Scanner read = new Scanner(System.in);
                System.out.print("Enter a number: ");
                int number = read.nextInt();
                this.memory[operand] = number;
                break;
            case 11:
                System.out.println(this.memory[operand]);
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 36:
            case 37:
            case 38:
            case 39:
            default:
                break;
            case 20:
                this.accumulator = this.memory[operand];
                break;
            case 21:
                this.memory[operand] = this.accumulator;
                break;
            case 30:
                System.out.println("Si suma");
                this.accumulator += this.memory[operand];
                break;
            case 31:
                this.accumulator -= this.memory[operand];
                break;
            case 33:
                if (this.memory[operand] != 0) {
                    this.accumulator /= this.memory[operand];
                    break;
                } else {
                    System.out.printf("\n%s\n%s\n", "*** CANNOT DIVIDE BY ZERO ***", "*** EXITING NOW ***");
                    System.exit(-1);
                }
            case 32:
                this.accumulator *= this.memory[operand];
                break;
            case 34:
                this.accumulator %= this.memory[operand];
                break;
            case 35:
                this.accumulator = (int)Math.pow((double)this.memory[operand], (double)this.memory[operand]);
                break;
            case 40:
                this.instructionCounter = operand;
                branching = true;
                break;
            case 41:
                if (this.accumulator < 0) {
                    this.instructionCounter = operand;
                    branching = true;
                }
                break;
            case 42:
                if (this.accumulator == 0) {
                    this.instructionCounter = operand;
                    branching = true;
                }
                break;
            case 43:
                if (this.accumulator > 0) {
                    this.instructionCounter = operand;
                    branching = true;
                }
                break;
            case 44:
                System.out.println("Processing complete...");
                this.run = false;
                this.memoryDump();
        }

        if (!branching) {
            ++this.instructionCounter;
        }

    }

    private void memoryDump() {
        System.out.printf("\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\t%02d\n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for(int tens = 0; tens < 100; tens += 10) {
            System.out.printf("%02d\t", tens);

            for(int ones = 0; ones < 10; ++ones) {
                System.out.printf("%04d\t", this.memory[tens + ones]);
            }

            System.out.println();
        }

    }
}

