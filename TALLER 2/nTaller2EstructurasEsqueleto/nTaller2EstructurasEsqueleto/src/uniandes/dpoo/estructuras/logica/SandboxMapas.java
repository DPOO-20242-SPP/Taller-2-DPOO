package uniandes.dpoo.estructuras.logica;
import java.util.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. 
 * La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        ArrayList<String> valores = new ArrayList<>(mapaCadenas.values());
        valores.sort(String::compareTo);
        return valores;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        ArrayList<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        llaves.sort(Collections.reverseOrder()); // ✅ corrección: de mayor a menor
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        return mapaCadenas.isEmpty() ? null : Collections.min(mapaCadenas.keySet());
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        return mapaCadenas.isEmpty() ? null : Collections.max(mapaCadenas.values()); // ✅ corrección
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        Set<String> mayusculas = new HashSet<>();
        for (String m : mapaCadenas.keySet()) { // ✅ corrección: antes usaba values()
            mayusculas.add(m.toUpperCase());
        }
        return mayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        return new HashSet<>(mapaCadenas.values()).size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, 
     * y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        if (cadena == null) return;

        StringBuilder llaveInvertida = new StringBuilder(cadena).reverse();
        mapaCadenas.put(llaveInvertida.toString(), cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param llave La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        if (llave == null) return;
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param valor El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
        if (valor == null) return;

        StringBuilder llaveReversa = new StringBuilder(valor).reverse();
        mapaCadenas.remove(llaveReversa.toString());
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings 
     * de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param objetos Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();

        if (objetos == null) return;

        for (Object o : objetos) {
            String valor = (o == null) ? "null" : o.toString();
            StringBuilder llaveInvertida = new StringBuilder(valor).reverse();
            mapaCadenas.put(llaveInvertida.toString(), valor);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora 
     * todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> nuevo = new HashMap<>();

        for (Map.Entry<String, String> e : mapaCadenas.entrySet()) {
            String llaveOriginal = e.getKey();
            String valor = e.getValue();
            String llaveMayus = (llaveOriginal == null) ? null : llaveOriginal.toUpperCase();
            nuevo.put(llaveMayus, valor);
        }

        mapaCadenas.clear();
        mapaCadenas.putAll(nuevo);
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro 
     * hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        if (otroArreglo == null) return true;
        Collection<String> valores = mapaCadenas.values();
        for (String s : otroArreglo) {
            if (!valores.contains(s)) return false;
        }
        return true;
    }
}

