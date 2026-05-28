## 🦭 Seal Flush ♠️

Proyecto de Java — Juego de póker Texas Hold'em No-Limit en consola

## 👩‍💻 Autores

- [Ximena López](https://github.com/Lincex135)
- [Adrián de Armas](https://github.com/Adripan999)

## 🧾 Descripción

**Seal Flush** es una aplicación de consola en Java que implementa el juego de cartas **Texas Hold'em Poker**. El
proyecto cuenta con un menú principal navegable de tres niveles, instrucciones completas del juego, visualización de
cartas con arte ASCII en color, jerarquía de manos ilustrada y soporte para partidas de entre 2 y 10 jugadores con
nombres personalizados. La mascota del proyecto es una foca dibujada en ASCII que aparece en la pantalla de inicio junto
al logo del juego.

## ⚠️ Eventos especiales

**Seal Flush** es un juego de cartas por consola basado en las reglas del Texas Hold'em, con mecánicas originales
inspiradas en los *flushes* (color). Cada partida enfrenta a entre 2 y 6 jugadores por turnos, con apuestas, ciegas,
fases de ronda y un evaluador de manos completo.

El juego incluye **eventos especiales** exclusivos que se activan en función de las manos conseguidas:

| Evento           | Descripción                                                         |
|------------------|---------------------------------------------------------------------|
| 🥇 Sello Dorado  | Ganar con flush otorga un bono del 10% en la siguiente victoria     |
| 🌑 Sello Oscuro  | Perder con flush aplica una penalización del 10% la siguiente ronda |
| ♠ Palo Dominante | Al inicio se revela un palo que vale 50% más si hay flush           |

Las partidas y el Hall of Fame se guardan automáticamente en un archivo XML.

---

## 🎮 Cómo jugar

Al ejecutar el programa, el menú principal permite:

1. **Nueva partida** — se elige número de jugadores, nombre de cada uno y modo de juego
2. **Ver estadísticas** — muestra el historial de partidas y el Hall of Fame
3. **Ver instrucciones** — explica las reglas y la jerarquía de manos
4. **Salir**

**Modos de juego:**

- **Rondas limitadas** — se juega un número fijo de rondas; gana quien tenga más fichas al terminar
- **Sin límite** — se juega hasta que solo queda un jugador con fichas

**Fases de cada ronda:** Pre-flop → Flop (3 cartas) → Turn (4 cartas) → River (5 cartas) → Showdown

**Fichas iniciales:** 500 por jugador · Ciega pequeña: 5 · Ciega grande: 10

---

## 🗂️ Organización del código

```
src/
├── Main.java                        # Bucle principal del juego
│
├── objetos/
│   ├── Carta.java                   # Representa una carta (rango + palo)
│   ├── Mano.java                    # Combina las 2 cartas del jugador con las 5 del tablero
│   ├── Mazo.java                    # Mazo de 52 cartas (Singleton)
│   ├── Tablero.java                 # Cartas comunitarias y apuesta de ronda (Singleton)
│   ├── Bote.java                    # Fichas acumuladas en la ronda (Singleton)
│   ├── Jugador.java                 # Estado, fichas y acciones de un jugador
│   └── Estado.java                  # Enum: ACTIVO, RETIRADO, ALL_IN, ELIMINADO
│
├── util/
│   ├── Util.java                    # Lógica principal: turnos, ciegas, showdown, reordenado
│   ├── EvaluadorMano.java           # Evalúa y puntúa la mejor mano de 5 entre 7 cartas
│   ├── TipoMano.java                # Enum con valor numérico: PAREJA → ESCALERA_REAL
│   ├── EventoEspecial.java          # Estado de los eventos especiales activos
│   ├── UtilEventosEspeciales.java   # Lógica de activación de eventos especiales
│   ├── Instrucciones.java           # Texto de instrucciones y jerarquía de manos
│   ├── Ascii.java                   # Arte ASCII para la pantalla de inicio
│   ├── JerarquiaDeManos.java        # Visualización de la jerarquía de manos
│   └── Color.java                   # Constantes de color ANSI para la consola
│
└── estadisticas/
    ├── EstadisticasPartida.java     # Datos de una partida (ganador, fichas, rondas...)
    ├── EstadisticasJugador.java     # Datos de un jugador dentro de una partida
    └── GestorEstadisticas.java      # Lectura y escritura del XML con NIO
```

---

## 📊 Diagrama de clases UML

### Objetos del juego

```
┌─────────────────────────────┐
│          Jugador             │
├─────────────────────────────┤
│ - numJugador: int            │
│ - nomJugador: String         │
│ - mano: Carta[]              │
│ - fichas: int                │
│ - estado: Estado             │
│ - apuestaActual: int         │
│ + esDealerActual: boolean    │
│ + tieneSelloDorado: boolean  │
│ + tieneSelloOscuro: boolean  │
├─────────────────────────────┤
│ + apostar(int): boolean      │
│ + reiniciarRonda(): void     │
│ + recibirCarta(Carta): void  │
│ + estaActivo(): boolean      │
│ + estaAllIn(): boolean       │
│ + estaEliminado(): boolean   │
└──────────────┬──────────────┘
               │ tiene
               ▼
┌──────────────────────────┐        ┌────────────────────────┐
│          Carta            │        │         Estado          │
├──────────────────────────┤        ├────────────────────────┤
│ - rango: int (final)      │        │ <<enum>>               │
│ - palo: int (final)       │        │ ACTIVO                 │
│ - vuelta: boolean         │        │ RETIRADO               │
├──────────────────────────┤        │ ALL_IN                 │
│ + getRango(): int         │        │ ELIMINADO              │
│ + getPalo(): int          │        └────────────────────────┘
│ + toString(): String      │
│ + hashCode(): int         │
│ + equals(Object): boolean │
└──────────────────────────┘

┌─────────────────────────────┐     ┌──────────────────────────┐
│        Mazo «Singleton»      │     │     Tablero «Singleton»   │
├─────────────────────────────┤     ├──────────────────────────┤
│ - cartas: Carta[]            │     │ - cartas: Carta[]         │
│ - indiceSiguienteCarta: int  │     │ - jugadores: ArrayList    │
│ - random: Random             │     │ - apuestaRonda: int       │
│ - instancia: Mazo (static)   │     │ - instancia: Tablero      │
├─────────────────────────────┤     ├──────────────────────────┤
│ + getInstancia(): Mazo       │     │ + getInstancia(): Tablero │
│ + barajar(): void            │     │ + toString(): String      │
│ + repartirCarta(): Carta     │     └──────────────────────────┘
└─────────────────────────────┘
                                     ┌──────────────────────────┐
                                     │      Bote «Singleton»     │
                                     ├──────────────────────────┤
                                     │ - cantidad: int           │
                                     │ - instancia: Bote         │
                                     ├──────────────────────────┤
                                     │ + getInstancia(): Bote    │
                                     │ + actualizarCantidad(int) │
                                     └──────────────────────────┘

┌──────────────────────────────┐
│            Mano               │
├──────────────────────────────┤
│ - cartas: Carta[] (final)     │  ← combina mano del Jugador + cartas del Tablero
├──────────────────────────────┤
│ + Mano(Jugador, Tablero)      │
│ + getCartas(): Carta[]        │
└──────────────────────────────┘
```

### Evaluación y eventos

```
┌──────────────────────────────────┐
│         EvaluadorMano             │
├──────────────────────────────────┤
│ - tipoMano: TipoMano              │
│ - valorNumerico: int              │
│ - cartasOrdenadas: Carta[]        │
│ - cartasPorRango: int[]           │
│ - cartasPorPalo: int[]            │
│ - paloDeLaEscaleraDeColor: int    │
├──────────────────────────────────┤
│ + EvaluadorMano(Mano)             │
│ + getTipo(): TipoMano             │
│ + getValor(): int                 │
│ + getPaloDelColor(): int          │
└──────────────────────────────────┘

┌────────────────────────────────┐
│          TipoMano               │
├────────────────────────────────┤
│ <<enum con atributos>>          │
│ CARTA_ALTA(0) .. ESCALERA_REAL(9)│
│ - descripcion: String (final)   │
│ - valor: int (final)            │
├────────────────────────────────┤
│ + getDescripcion(): String      │
│ + getValue(): int               │
│ + toString(): String            │
└────────────────────────────────┘

┌────────────────────────────────┐      ┌────────────────────────────┐
│        EventoEspecial           │      │   UtilEventosEspeciales     │
├────────────────────────────────┤      ├────────────────────────────┤
│ - selloDorado: boolean          │      │ «clase utilitaria»          │
│ - selloOscuro: boolean          │      ├────────────────────────────┤
│ - paloDominante: int            │      │ + comprobarSelloDorado()    │
│ - jugadorGoldenSeal: Jugador    │      │ + comprobarSelloOscuro()    │
│ - jugadoresDarkSeal: ArrayList  │      │ + establecerPaloDominante() │
│ - instancia: EventoEspecial     │      │ + esFlush(TipoMano)         │
├────────────────────────────────┤      │ + esFlushDominante()        │
│ + getInstancia(): EventoEspecial│      │ + calcularPorcentaje()      │
└────────────────────────────────┘      └────────────────────────────┘
```

### Estadísticas

```
┌─────────────────────────────────┐
│       GestorEstadisticas         │
├─────────────────────────────────┤
│ «clase utilitaria estática»      │
│ - RUTA_XML: Path (static final)  │
├─────────────────────────────────┤
│ + guardarPartida(EstPartida)     │
│ + mostrarEstadisticas()          │
│ - leerPartidas(): ArrayList      │
│ - escribirXml(ArrayList)         │
│ - escribirHallFama(...)          │
│ - ordenarPorFichas(...)          │
└──────────────┬──────────────────┘
               │ gestiona
               ▼
┌──────────────────────────────┐
│      EstadisticasPartida      │
├──────────────────────────────┤
│ - id: int                     │
│ - fechaHora: String           │
│ - ganador: String             │
│ - fichasGanador: int          │
│ - rondasJugadas: int          │
│ - boteMaximo: int             │
│ - numJugadores: int           │
│ - jugadores: ArrayList        │
└──────────────┬───────────────┘
               │ contiene
               ▼
┌──────────────────────────────┐
│     EstadisticasJugador       │
├──────────────────────────────┤
│ - nombre: String              │
│ - fichasFinales: int          │
│ - estadoFinal: String         │
└──────────────────────────────┘
```

---

## 🔬 Investigación de funcionalidades

Funcionalidades usadas en el proyecto que van más allá del contenido visto en clase:

### 1. `clone()` en arrays

El método `clone()` se usa en `EvaluadorMano.java` para copiar el array de cartas antes de ordenarlas con el algoritmo
burbuja, protegiendo el array original.

```java
Carta[] cartasCopiadas = cartasOriginales.clone();
```

Crea un nuevo array del mismo tipo y tamaño, copiando las **referencias** a los objetos (copia superficial o *shallow
copy*), no los objetos en sí. Es seguro aquí porque la ordenación solo intercambia posiciones, sin modificar el
contenido de las cartas.

---

### 2. `SecureRandom`

`SecureRandom` es una subclase de `Random` que usa fuentes de entropía del sistema operativo para generar números
impredecibles. Se usa en `Mazo.java` para el barajado.

```java
private Random random = new SecureRandom();
```

Con `Random` estándar, alguien con acceso al código podría reproducir la secuencia si conoce la semilla. `SecureRandom`
hace esto imposible. Al declarar la variable como `Random` y asignar `SecureRandom`, se aprovecha el polimorfismo: el
resto del código usa los métodos de `Random` sin saber qué implementación hay por debajo.

---

### 3. `StringBuilder`

Permite construir cadenas de texto de forma eficiente en bucles, sin crear objetos `String` intermedios (que en Java son
inmutables).

```java
StringBuilder sb = new StringBuilder();
sb.append(todasLinea[fila]);
sb.append("  ");
System.out.println(sb);
```

Se usa en `Util.java` y `Tablero.java` para montar la representación visual de las cartas línea a línea. Usar
`String +=` en un bucle crearía un objeto nuevo en cada iteración; `StringBuilder` reutiliza el mismo buffer interno
hasta llamar a `toString()`.

---

### 4. Algoritmo de Fisher-Yates

Algoritmo de barajado que garantiza que todas las permutaciones posibles tienen la misma probabilidad. Implementado en
`Mazo.java`, método `barajar()`.

```java
for(int i = 0; i < NUM_DE_CARTAS; i++) {
    int j = random.nextInt(NUM_DE_CARTAS);
    Carta temp = cartas[i];
    cartas[i]=cartas[j];
    cartas[j]=temp;
}
```

En cada iteración se intercambia la carta actual con una posición aleatoria del mazo completo. El intercambio usa la
variable temporal `temp`, patrón clásico de *swap* en Java al no existir operador directo.

---

### 5. Algoritmo de ordenación burbuja (*Bubble Sort*)

Implementado en `EvaluadorMano.java` para ordenar las 7 cartas de mayor a menor rango antes de evaluar la mano.

```java
for(int vuelta = 0; vuelta < cartas.length -1; vuelta++){
    for(int pos = 0; pos < cartas.length -1 -vuelta; pos++){
        if(cartas[pos].getRango() <cartas[pos +1].getRango()){
            Carta temp = cartas[pos];
            cartas[pos]=cartas[pos +1];
            cartas[pos +1]=temp;
        }
    }
}
```

Con cada pasada completa el elemento mayor queda colocado al final; el límite interior se reduce en uno cada vuelta
porque esa parte ya está ordenada. Para 7 cartas la complejidad O(n²) es completamente irrelevante en rendimiento.

---

### 6. `ProcessBuilder`

Permite lanzar procesos del sistema operativo desde Java. Se usa en `Util.java` para limpiar la consola entre turnos.

```java
new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
```

- `inheritIO()` conecta la entrada/salida del proceso hijo con la de Java, para que el resultado aparezca en la misma
  consola
- `waitFor()` bloquea Java hasta que el proceso termina
- El método detecta el sistema operativo con `System.getProperty("os.name")` para usar `cls` en Windows o `clear` en
  Linux/macOS. Si falla, usa el código de escape ANSI `\033[H\033[2J` como alternativa

---

### 7. NIO (`java.nio.file`) para lectura y escritura de XML

El paquete `java.nio.file` (New I/O) ofrece una API moderna para trabajar con archivos. Se usa en
`GestorEstadisticas.java` para persistir las estadísticas.

```java
Path ruta = Paths.get("../datos", "estadisticas.xml");
Files.createDirectories(ruta.getParent());
Files.writeString(ruta, contenidoXml, StandardOpenOption.CREATE,
                  StandardOpenOption.TRUNCATE_EXISTING);

String contenido = Files.readString(ruta);
```

- `Paths.get()` construye la ruta de forma independiente al sistema operativo
- `Files.createDirectories()` crea la carpeta si no existe
- `Files.writeString()` y `Files.readString()` trabajan directamente con `String`, sin necesidad de gestionar streams
  manualmente

El archivo XML se escribe y lee manualmente como texto usando `StringBuilder` y búsqueda de etiquetas, sin librerías
externas de parseo XML.

---

### 8. `enum` con atributos y métodos

`TipoMano` es un enumerado avanzado: cada constante tiene su propia descripción en español y un valor numérico que
permite comparar manos directamente.

```java
public enum TipoMano {
    CARTA_ALTA("Carta alta", 0),
    ESCALERA_REAL("Escalera real", 9);

    private final String descripcion;
    private final int valor;

    TipoMano(String descripcion, int valor) { ...}

    @Override
    public String toString() {
        return descripcion;
    }
}
```

Al sobreescribir `toString()`, al imprimir un `TipoMano` aparece `"Escalera real"` en vez de `"ESCALERA_REAL"`. El valor
numérico permite determinar la mano ganadora sin `switch` ni cadenas de `if-else`.

---

## 📁 Formato del archivo XML

Las estadísticas se guardan en `datos/estadisticas.xml` con esta estructura:

```xml

<sealFlush>

    <hallOfFama>
        <entrada posicion="1" ganador="alberto" fichas="830" rondas="8" fecha="2026-05-26 18:32:10"/>
    </hallOfFama>

    <partidas>
        <partida id="1" fecha="2026-05-26 18:32:10" ganador="alberto"
                 fichasGanador="830" rondasJugadas="8" boteMaximo="120" numJugadores="3">
            <jugadores>
                <jugador nombre="alberto" fichasFinales="830" estadoFinal="ACTIVO"/>
                <jugador nombre="marta" fichasFinales="0" estadoFinal="ELIMINADO"/>
            </jugadores>
        </partida>
    </partidas>

</sealFlush>
```

---

## 🗣️ Disclaimer

This was us during the proyect btw

<img align="center" alt="focas" width="200" src="https://c.tenor.com/vPMFS9UZx2oAAAAd/tenor.gif" >

## 📚 Bibliografía

- [API Java 21 — Oracle](https://docs.oracle.com/en/java/se/21/docs/api/)
- [SecureRandom — Java Docs](https://docs.oracle.com/en/java/se/21/docs/api/java.base/java/security/SecureRandom.html)
- [Algoritmo Fisher-Yates — Wikipedia](https://es.wikipedia.org/wiki/Algoritmo_de_Fisher-Yates)
- [java.nio.file — Oracle Docs](https://docs.oracle.com/en/java/se/21/docs/api/java.base/java/nio/file/package-summary.html)
- [ProcessBuilder — Java Docs](https://docs.oracle.com/en/java/se/21/docs/api/java.base/lang/ProcessBuilder.html)
- Apuntes de Programación — Alberto Ruiz, 1º DAM
