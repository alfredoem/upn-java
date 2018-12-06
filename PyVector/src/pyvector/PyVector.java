package pyvector;

import java.util.Scanner;

public class PyVector {
static Scanner leer;
    public static void main(String[] args) {
    leer=new Scanner(System.in);
    int n,edad[],may,men;
    n=leerentero("Cantidad de edades");
    edad=leervector(n,"edad");
    may=edad[0];
    men=edad[0];
    for(int i=0;i<n;i++)
    {
        if(edad[i]>may)
            may=edad[i];
        if(edad[i]<men)
            men=edad[i];
        /*
        may=compara(edad[i],may,1);
        men=compara(men,edad[i],2);
        */
    }
    mostrar(n,edad);
    System.out.println("Edad más alta: "+may);
    System.out.println("Edad más baja: "+men);    
    }
    /*
    public static int compara(int x,inty, int caso)
    {
     int z;
     if(x>y && caso==1)
     z= x;
     else
     z=y;
     if(x>y && caso==2)
     z=y; 
     else
     z=x;
    */
    
    public static void mostrar(int n,int edad[])
    {
        String t="";
        for(int aux:edad)
        {
            t+=aux+"\t\t";
        }
        System.out.println("Vector leído: "+t);
    }
public static int leerentero(String texto)
{
 int x;
    System.out.println("Ingrese "+texto);
    x=leer.nextInt();
    while(x<0)
    {
     System.out.println("Error, Ingrese "+texto);
     x=leer.nextInt();   
    }
    return x;
}
public static int[] leervector(int n,String t)
{
 int lista[];//declaro vector
 lista=new int[n];//creo vector
 for(int i=0;i<n;i++)   
 {
  lista[i]=leerentero(t+" "+(i+1)+": ");
 }
 return lista;
}
}
