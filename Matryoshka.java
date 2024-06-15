import java.util.ArrayList;

public class Matryoshka
{
    public static void main(String [] args){
        Matryoshka par = new Matryoshka();
        String[] cadena = {"a","b","c","a","c","a","b"};
        ArrayList<ArrayList<String>> listas = par.ordenar(cadena);
    }
    
    public ArrayList<ArrayList<String>> ordenar (String [] s){
        ArrayList<ArrayList<String>> listas= new ArrayList<ArrayList<String>>();
        ordenar(s, listas, 0, 0, new ArrayList<>());
        ordenarLexi(listas, 0,0);
        System.out.print(imprimir(listas));
        return listas;
    }
    
    private void ordenarLexi(ArrayList<ArrayList<String>> listas, int pos, int it){
        ArrayList<String> lista = listas.get(pos);
        if(it<lista.size()-1){
            String dato1 = lista.get(it);
            String dato2 = lista.get(it+1);
            int indiceDato1 = lista.indexOf(dato1);
            int indiceDato2 = lista.indexOf(dato2);
            String aux;
            if(dato1.compareTo(dato2)>0){
                aux = dato1;
                lista.set(indiceDato1, dato2);
                lista.set(indiceDato2, aux);
                ordenarLexi(listas, pos, it+1);
            }else{
                ordenarLexi(listas, pos, it+1);
            }
            ordenarLexi(listas, pos+1, 0);
        }
    }
    
    private void ordenar(String [] s, ArrayList<ArrayList<String>> listas, int pos, 
                        int pos2,ArrayList<String> grupo){
        if(pos<s.length){
            String dato = s[pos];
            if(dato.equals("a")){
                grupo = new ArrayList<String>();
                grupo.add(dato);
                listas.add(grupo);
                ordenar(s, listas, pos+1, pos2, grupo);
            }else{
                anadir(grupo, dato, listas, 0);
                ordenar(s, listas, pos+1, pos2, grupo);
            }
        }
    }
    
    private void anadir(ArrayList<String> grupo, String dato, 
                       ArrayList<ArrayList<String>> listas, int pos){
        if(pos<listas.size()){
            ArrayList<String> lista = listas.get(pos);
            if(iterar(dato, lista,  0)){
                anadir(grupo, dato,listas, pos+1);
            }else{
                lista.add(dato);
            }
        }
    }
    
    private boolean iterar(String dato,ArrayList<String> lista, int pos ){
        boolean res = false;
        if(pos < lista.size()){
            if(lista.get(pos).equals(dato)){
                res = true;
            }else{
                res = iterar(dato, lista, pos+1);
            }
        }
        return res;
    }
    
    private String imprimir(ArrayList<ArrayList<String>> listas){
        String res = "[";
        for(int i = 0; i<listas.size() ; i++){
            ArrayList<String> array = listas.get(i);
            res += "[";
            for(int j = 0; j< array.size();j++){
                res += array.get(j);
            }
            res += "]";
        }
        return res+="]";
    }
}
