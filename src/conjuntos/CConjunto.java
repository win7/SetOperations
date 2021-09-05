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
public class CConjunto {
    // Atributos
    int conjunto [];
    int tamanio;
    
    // Constructores
    public CConjunto(int tamanio) {
        this.tamanio = tamanio;
        this.conjunto = new int [tamanio];
        
        for (int k = 0; k < tamanio;k++) {
            this.conjunto[k] = -1;
        }        
    }
    public CConjunto() {
        this.conjunto = null;
        this.tamanio = 0;
    }
    
    // Métodos especiales
    public int[] getConjunto() {
        return conjunto;
    }

    public void setConjunto(int[] conjunto) {
        this.conjunto = conjunto;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    // Métodos
    // Pertenencia
    public boolean Pertenece(int elemento) {
        for (int i = 0; i < this.tamanio; i++) {
            if (elemento == this.conjunto[i]) {
                return true;
            }
        }
        return false;
    }
            
    // Unión
    public CConjunto Union(CConjunto conjunto_b) {
        // Obtener tamaño
        int tamanio = this.tamanio;
        for (int k = 0; k < conjunto_b.tamanio; k++) {
            if (!this.Pertenece(conjunto_b.conjunto[k])) {
                tamanio++;
            }
        }
        
        int indice = 0;
        CConjunto union = new CConjunto(tamanio);  
        for (int k = 0; k < this.tamanio; k++) {
            union.conjunto[indice] = this.conjunto[k];
            indice++;
        }
        for (int k = 0; k < conjunto_b.tamanio; k++) {
            if (!union.Pertenece(conjunto_b.conjunto[k])) {
                union.conjunto[indice] = conjunto_b.conjunto[k];
            }
        }
        return union;
    }
    
    // Intersecición
    public CConjunto Interseccion (CConjunto conjunto_b) {
        // Obtener tamaño
        int tamanio = 0;
        for (int k = 0; k < conjunto_b.tamanio; k++) {
            if (this.Pertenece(conjunto_b.conjunto[k])) {
                tamanio++;
            }
        }
        
        int indice = 0;
        CConjunto interseccion = new CConjunto(tamanio);
        for (int k = 0; k < this.tamanio; k++) {
            if (conjunto_b.Pertenece(this.conjunto[k])) {
                interseccion.conjunto[indice] = this.conjunto[k];
                indice++;
            }
        }
        return interseccion;
    }
    
    // Diferencia A-B
    public CConjunto Diferencia (CConjunto conjunto_b) {
        // A = [1, 2, 3]
        // B = [1, 2, 4, 7]
        // A-B = [3]
        // Obtener tamaño
        int tamanio = 0;
        for (int k = 0; k < this.tamanio; k++) {
            if (!conjunto_b.Pertenece(this.conjunto[k])) {
                tamanio++;
            }
        }

        int indice = 0;
        CConjunto diferencia = new CConjunto(tamanio);
        for (int k = 0; k < this.tamanio; k++) {
            if (!conjunto_b.Pertenece(this.conjunto[k])) {
                diferencia.conjunto[indice] = this.conjunto[k];
                indice++;
            }
        }
        return diferencia;
    }
    
    // Differencia simétrica
    public CConjunto DiferenciaSimetrica (CConjunto conjunto_b) {
        // Opción 1
        /* CConjunto diferencia_ab = this.Diferencia(conjunto_b);
        CConjunto diferencia_ba = conjunto_b.Diferencia(this);
        CConjunto diferencia_s = diferencia_ab.Union(diferencia_ba); */
        
        // Opción 2
        CConjunto union_ab = this.Union(conjunto_b);
        CConjunto interseccion_ab = this.Interseccion(conjunto_b);
        CConjunto diferencia_s = union_ab.Diferencia(interseccion_ab);;

        return diferencia_s;
    }
        
    public void Mostrar () {
        for (int k= 0; k < this.tamanio; k++) {
            System.out.print(this.conjunto[k] + " ");
        }
        System.out.println();
    }
}
