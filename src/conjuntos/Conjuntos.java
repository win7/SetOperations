/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

/**
 *
 * @author win7
 */
public class Conjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CConjunto a = new CConjunto(5);
        a.conjunto[0] = 1;
        a.conjunto[1] = 2;
        a.conjunto[2] = 3;
        a.conjunto[3] = 4;
        a.conjunto[4] = 5;
        
        CConjunto b = new CConjunto(5);
        b.conjunto[0] = 2;
        b.conjunto[1] = 3;
        b.conjunto[2] = 4;
        b.conjunto[3] = 5;
        b.conjunto[4] = 6;
        
        CConjunto c = a.Union(b);
        c.Mostrar();
        
        c = a.Interseccion(b);
        c.Mostrar();
        
        c = a.Diferencia(b);
        c.Mostrar();
        
        c = b.Diferencia(a);
        c.Mostrar();
        
        c = a.DiferenciaSimetrica(b);
        c.Mostrar();
    }
}
