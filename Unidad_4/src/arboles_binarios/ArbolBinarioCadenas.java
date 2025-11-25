/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles_binarios;

/**
 * Programa que crea un arbol binario que almacena cadenas
 * Premite agrgar, buscar y mostrar recorridos 
 * @author Romero
 */
import java.util.Scanner;
public class ArbolBinarioCadenas {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Nodo raiz= null;
        int opcion=0;
        
        while(opcion!=6){
            System.out.println("1 Agregar");
            System.out.println("2 Buscar");
            System.out.println("3 Preorden");
            System.out.println("4 Inorden");
            System.out.println("5 Postorden");
            System.out.println("6 Salir");
            opcion=Integer.parseInt(sc.nextLine());
            
            switch(opcion){
                //Permite agregar una cadena para que vaya formando parte del arbol
                case 1:
                    System.out.println("Cadena: ");
                    Nodo n= new Nodo();
                    n.dato=sc.nextLine();
                    if(raiz==null)raiz= n;
                    else Agregar(raiz,n);
                    break; 
                /**
                 * Permite buscar cualquier cadena dentro del arbol y nos dice 
                 * por que modo fue mas rapido
                 */           
                case 2:
                    System.out.println("Buscar: ");
                    String b= sc.nextLine();
                    
                    boolean pre=buscarPreorden(raiz,b);
                    boolean ino=buscarInorden(raiz, b);
                    boolean pos=buscarPostorden(raiz, b);
                    
                    if(!pre && !ino && !pos){
                        System.out.println("No se encontro");
                    }else {
                        System.out.println("Si se encontro. El recorrido mas "
                                + "rapido fue: ");
                    
                    if(pre)
                        System.out.println("Preorden");
                   
                    else if(ino)
                        System.out.println("Inorden");
                   
                    else 
                        System.out.println("Postorden");
                    }
                    break;
                /**
                 * Permite ver el arbol en forma de preorden
                 */
                case 3:
                    Preorden(raiz);
                    break;
                /**
                 * Permite ver el arbol en forma de inorden
                 */
                case 4:
                    Inorden(raiz);
                    break;
                /**
                 * Permite ver el arbol de forma de postorden
                 */
                case 5:
                    Postorden(raiz);
                    break;
            }
        }
        
        
    }
    //Metodo que sirve para agregar una cadena al arbol 
    public static void Agregar(Nodo raiz, Nodo nuevo){
        if(nuevo.dato.compareToIgnoreCase(raiz.dato)> 0){
            //Va hacia la derecha 
            if(raiz.hijoDerecho==null)
                raiz.hijoDerecho= nuevo;
            else 
                Agregar(raiz.hijoDerecho,  nuevo);
        }else{
            //Va hacia la izquierda 
            if(raiz.hijoIzquierdo==null)
                raiz.hijoIzquierdo= nuevo;
            else 
                Agregar(raiz.hijoIzquierdo, nuevo);
        }
    }
    //Metodo para ver el arbol en forma de preorden
    public static void Preorden(Nodo n){
        if(n != null){
            System.out.println(n.dato);
            Preorden(n.hijoIzquierdo);
            Preorden(n.hijoDerecho);
        }
    }
    //Metodo que sirve para ver el arbol en froma de inorden
    public static void Inorden(Nodo n){
        if(n != null){
            Inorden(n.hijoIzquierdo);
            System.out.println(n.dato);
            Inorden(n.hijoDerecho);
        }
    }
    //Metodo que sirve para ver el arbol en forma de postorden 
    public static void Postorden(Nodo n){
        if(n != null){
            Postorden(n.hijoIzquierdo);
            Postorden(n.hijoDerecho);
            System.out.println(n.dato);
        }
    }
    //Metodo que sirve para buscar la cadena 
    public static boolean Buscar(Nodo n, String x){
        if(n==null)return false;
        if(n.dato.equalsIgnoreCase(x))return true;
        return Buscar(n.hijoIzquierdo,x)||Buscar(n.hijoDerecho,x);
    }
    //Sirve para buscar en modo de preorden
    public static boolean buscarPreorden(Nodo n, String valor) {
        if(n == null) return false;
        if(n.dato.equalsIgnoreCase(valor)) return true;
        return buscarPreorden(n.hijoIzquierdo, valor) || buscarPreorden(n.hijoDerecho, valor);
}
    //Sirve ´para buscar en modo de inorden
    public static boolean buscarInorden(Nodo n, String valor) {
        if(n == null) return false;
        if(buscarInorden(n.hijoIzquierdo, valor)) return true;
        if(n.dato.equalsIgnoreCase(valor)) return true;
        return buscarInorden(n.hijoDerecho, valor);
}
    //Sirven para buscar en modo de postorden
    public static boolean buscarPostorden(Nodo n, String valor) {
       if(n == null) return false;
       if(buscarPostorden(n.hijoIzquierdo, valor)) return true;
       if(buscarPostorden(n.hijoDerecho, valor)) return true;
       return n.dato.equalsIgnoreCase(valor);
}


    
    
    
}
