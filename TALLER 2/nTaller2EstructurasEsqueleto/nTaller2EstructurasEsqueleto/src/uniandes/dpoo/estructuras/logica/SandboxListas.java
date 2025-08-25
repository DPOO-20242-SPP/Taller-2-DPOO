package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
        return new ArrayList<Integer>( listaEnteros );
    }

    /**
     * Retorna una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
        return new ArrayList<String>( listaCadenas );
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
        int[] copia = new int[ listaEnteros.size( ) ];
        for( int i = 0; i < listaEnteros.size( ); i++ )
        {
            copia[ i ] = listaEnteros.get( i );
        }
        return copia;
    }

    public int getCantidadEnteros( )
    {
        return listaEnteros.size( );
    }

    public int getCantidadCadenas( )
    {
        return listaCadenas.size( );
    }

    public void agregarEntero( int entero )
    {
        listaEnteros.add( entero );
    }

    public void agregarCadena( String cadena )
    {
        listaCadenas.add( cadena );
    }

    public void eliminarEntero( int valor )
    {
        // ✅ corrección: no hace falta verificar null porque listaEnteros no debería tener nulls
        listaEnteros.removeIf( v -> v == valor );
    }

    public void eliminarCadena( String cadena )
    {
        listaCadenas.removeIf( v -> ( v == null && cadena == null ) || 
                                    ( v != null && v.equals( cadena ) ) );
    }

    public void insertarEntero( int entero, int posicion )
    {
        int posicionNormalizada;
        if (posicion < 0) {
            posicionNormalizada = 0;
        } else if (posicion > listaEnteros.size()) {
            posicionNormalizada = listaEnteros.size();
        } else {
            posicionNormalizada = posicion;
        }
        listaEnteros.add(posicionNormalizada, entero);
    }

    public void eliminarEnteroPorPosicion( int posicion )
    {
        if( posicion >= 0 && posicion < listaEnteros.size( ) )
        {
            listaEnteros.remove( posicion );
        }
    }

    public void reiniciarArregloEnteros( double[] valores )
    {
        listaEnteros.clear( );
        if( valores == null ) return;
        for( double d : valores )
        {
            listaEnteros.add( (int)d );
        }
    }

    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear( );
        if( objetos == null ) return;

        for( Object o : objetos ) {
            listaCadenas.add( String.valueOf(o) ); // ✅ maneja nulls también
        }
    }

    public void volverPositivos( )
    {
        for (int i = 0; i < listaEnteros.size(); i++)
        {
            Integer v = listaEnteros.get(i);
            if (v != null && v < 0) {
                listaEnteros.set(i, -v);
            }
        }
    }

    public void organizarEnteros( )
    {
        // ✅ corrección: orden de mayor a menor
        listaEnteros.sort(Collections.reverseOrder());
    }

    public void organizarCadenas( )
    {
        Collections.sort(listaCadenas);
    }

    public int contarApariciones( int valor )
    {
        int c = 0;
        for( Integer v : listaEnteros )
        {
            if( v != null && v == valor ) c++;
        }
        return c;
    }

    public int contarApariciones( String cadena )
    {
        int c = 0;
        for( String s : listaCadenas )
        {
            // ✅ corrección: comparación case-insensitive
            if( ( s == null && cadena == null ) || 
                ( s != null && cadena != null && s.equalsIgnoreCase( cadena ) ) )
                c++;
        }
        return c;
    }

    public int contarEnterosRepetidos( )
    {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Integer v : listaEnteros)
        {
            if (v == null) continue;
            conteo.put(v, conteo.getOrDefault(v, 0) + 1);
        }

        int repetidos = 0;
        for (Integer freq : conteo.values())
        {
            if (freq >= 2) repetidos++;
        }
        return repetidos;
    }

    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if( otroArreglo == null ) return false;
        if( listaEnteros.size( ) != otroArreglo.length ) return false;

        for( int i = 0; i < otroArreglo.length; i++ )
        {
            if( !listaEnteros.get( i ).equals(otroArreglo[ i ]) ) return false;
        }
        return true;
    }

    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        listaEnteros.clear( );
        if( cantidad <= 0 ) return;

        int a = minimo;
        int b = maximo;
        if( a > b )
        {
            int tmp = a; a = b; b = tmp;
        }
        int rango = b - a + 1;
        for( int i = 0; i < cantidad; i++ )
        {
            int v = a + (int)( Math.random( ) * rango );
            listaEnteros.add( v );
        }
    } 
}

