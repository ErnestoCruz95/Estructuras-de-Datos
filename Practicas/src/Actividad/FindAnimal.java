package Actividad;
import Binary.BinaryNode;

import java.util.Scanner;

/**
 * Created by AntonioRang on 11/17/17.
 */
public class FindAnimal {

    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(4, "Es Mamifero");

        BinaryNode node2 = new BinaryNode(1, "Muerde");

        BinaryNode node1 = new BinaryNode("Perro");
        BinaryNode node3 = new BinaryNode("Gato");

        BinaryNode node5 = new BinaryNode(0, "Tiene escamas");

        //Izquierda
        BinaryNode node7 = new BinaryNode(1, "Respira bajo el agua");
        //Derecha
        BinaryNode node9 = new BinaryNode("Ave");

        BinaryNode node10 = new BinaryNode("Pescado");
        BinaryNode node11 = new BinaryNode("Serpiente");



        //Hijos de Raiz
        root.leftChild = node2;
        root.rightChild = node5;

        //Hijos de Nodo 2
        node2.leftChild = node1;
        node2.rightChild = node3;

        //Hijos de Nodo 5
        node5.leftChild = node7;
        node5.rightChild = node9;


        //Hijos de Nodo 9
        node7.leftChild = node10;
        node7.rightChild = node11;



        pregunta(root);

    }

    public static void pregunta(BinaryNode node){
        if(node.rightChild == null && node.leftChild == null){
            System.out.println("Tu animal es un: " + node.animal);
            return;
        }

        String respond;
        Scanner entrada = new Scanner(System.in);
        System.out.println(node.qs+"?");
        respond = entrada.next();


        if(respond.toUpperCase().equals("SI")){
            pregunta(node.leftChild);
        }else{
            pregunta(node.rightChild);
        }
    }


}
