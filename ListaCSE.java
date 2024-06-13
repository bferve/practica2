
public class ListaCSE<T>
{
    private NodoSE<T> ini;
    public static void main(String [] args){
        ListaCSE<Integer> lista = new ListaCSE<Integer>();
        
        lista.insertar(7);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(0);
        lista.insertar(2);
        lista.insertar(8);
        
        String listaOriginal = lista.print();
        System.out.println(listaOriginal);
        
        lista.swap(1,6);
        
        String listaConCambio = lista.print();
        System.out.println(listaConCambio);
    }
    
    public ListaCSE(){
        ini = null;
    }
    
    public boolean vacio(){
        return ini == null;
    }
    
    public void insertar(T dato){
        NodoSE<T> nuevoNodo, aux;
        nuevoNodo = new NodoSE<T>(dato);
        if(vacio()){
            ini = nuevoNodo;
            ini.setSuc(ini);
        }else{
            aux = buscar(ini);
            aux.setSuc(nuevoNodo);
            nuevoNodo.setSuc(ini);
        }
    }
    public void swap(int pos1, int pos2){
        NodoSE<T> nodoAux1, nodoAux2, busqueda1, busqueda2;
        nodoAux1 = buscar(ini, pos1);
        nodoAux2 = buscar(ini, pos2);
        if(pos1 <0 || pos2 <0 || pos1 > longitud() || pos2 > longitud()){
            System.out.print("Error en la operación");
        }else{
            T dato1 = nodoAux1.getDato();
            T dato2 = nodoAux2.getDato();
            nodoAux1.setDato(dato2);
            nodoAux2.setDato(dato1);
        }
    }
    public int longitud(){
        int res;
        if(vacio()){
            res = 0;
        }else{
            res = contar(ini);
        }
        return res;
    }
    private int contar(NodoSE<T> nodo){
        int contador =0;
        if(nodo.getSuc() == ini){
            contador = 1;
        }else{
            contador = 1 + contar(nodo.getSuc());
        }
        return contador;
    }
    private NodoSE<T> buscar(NodoSE<T> nodo, int pos){
        NodoSE<T> nodoBuscado;
        if(pos==0){
            nodoBuscado = nodo;
        }else{
            nodoBuscado = buscar(nodo.getSuc(), pos-1);
        }
        return nodoBuscado;
    }
    private NodoSE<T> buscar(NodoSE<T> nodo){
        NodoSE<T> ultimoNodo;
        if(nodo.getSuc() == ini){
            ultimoNodo = nodo;
        }else{
            ultimoNodo = buscar(nodo.getSuc());
        }
        return ultimoNodo;
    }
    public String print(){
        String reporte=" [";
        NodoSE<T> aux = ini;
        reporte += print(aux,ini);
        return reporte;
    }
    private String print(NodoSE<T> nodo,NodoSE<T> ini){
        String reporte="";
        if(vacio()){
            reporte += "]";
        }else{
            if(nodo.getSuc() != ini){
                reporte += nodo.getDato()+", "+print(nodo.getSuc(), ini);
            }else{
                reporte += nodo.getDato()+"]";
            }
        }
        return reporte;
    }
}
