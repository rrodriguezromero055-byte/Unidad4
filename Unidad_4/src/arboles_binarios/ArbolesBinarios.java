/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_binarios;

/**
 *
 * @author Romero
 */
import java.util.Scanner;
public class ArbolesBinarios {
      /**
     * Metodo que me permite agregar un nuevo nodo a la 
     * estructura de un arbol
     * @param raiz nodo a evaluar
     * @param nuevo nuevo nodo 
     */
    public static void AgregarNuevoNodo(Nodo raiz, Nodo nuevo){
        if(raiz.numero < nuevo.numero){
            /// que me voy a la derecha
            if(raiz.hijoDerecho == null)
                raiz.hijoDerecho = nuevo;
            else 
                AgregarNuevoNodo(raiz.hijoDerecho, nuevo);
        }else {
            /// me voy a la izquierda
            if(raiz.hijoIzquierdo == null){
                raiz.hijoIzquierdo = nuevo;  // esta libre 
            } else {
                AgregarNuevoNodo(raiz.hijoIzquierdo, nuevo);
            }
        }
    }
    public static void preorden(Nodo inicia){
        if(inicia !=null){
            System.out.println("Valor: "+ inicia.numero); //R
            preorden(inicia.hijoIzquierdo);
            preorden(inicia.hijoDerecho);
        }
    }
    
    public static void inorden(Nodo inicia){
        if(inicia!=null){
            inorden(inicia.hijoIzquierdo);
            System.out.println("Valor: "+ inicia.numero);
            inorden(inicia.hijoIzquierdo);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int op=0;
        System.out.println("Programa de arbol");
        Nodo raiz = null; //Para saber donde iniciar el arbol
        while(op!=5){
            
            System.out.println("1...Agregar");
            System.out.println("2...Preorden");
            System.out.println("3...Inorden");
            System.out.println("4...Postorden");
            System.out.println("5...Salir");
            op = Integer.parseInt(sc.nextLine());
            
            switch(op){
                
                case 1:
                    System.out.println("Dame un numero: ");
                    int valor = Integer.parseInt(sc.nextLine());
                    Nodo nuevo = new Nodo();
                    nuevo.numero = valor;
                    if(raiz == null)//Validpo que sea el primer numero
                        raiz = nuevo;
                    else
                        AgregarNuevoNodo(raiz,nuevo);
                    break;
                case 2: 
                    System.out.println("Preorden");
                    preorden(raiz);
                    break;
                case 3: 
                    System.out.println("Inorden");
                    inorden(raiz);
                    break;
                
            }
            
        }

    }
}
