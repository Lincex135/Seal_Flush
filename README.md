# ♠️ Seal Flush

Proyecto de Java — Juego de póker Texas Hold'em en consola desarrollado por **Ximena López** y **Adrián**

## 🧾 Descripción

**Seal Flush** es una aplicación de consola en Java que implementa el juego de cartas **Texas Hold'em Poker**. El proyecto cuenta con un menú principal navegable de tres niveles, instrucciones completas del juego, visualización de cartas con arte ASCII en color, jerarquía de manos ilustrada y soporte para partidas de entre 2 y 10 jugadores con nombres personalizados. La mascota del proyecto es una foca dibujada en ASCII que aparece en la pantalla de inicio junto al logo del juego.

## 👩‍💻 Autores

- [Ximena López](https://github.com/Lincex135)
- [Adrián de Armas](https://github.com/Adripan999)

## 🎯 Objetivos del Proyecto

- Implementar la lógica completa de una partida de **Texas Hold'em** en Java.
- Practicar la **Programación Orientada a Objetos**.
- Crear una interfaz de consola atractiva usando **colores ANSI** y arte **ASCII**.

## 🃏 Sistema de Cartas ASCII

Cada carta se representa con una caja de 7 líneas en ASCII, con **fondo amarillo claro** y **borde morado**. El símbolo del palo se dibuja dentro y el color del símbolo varía según el palo:

| objetos.Palo | util.Color símbolo |
|------|---------------|
| ♠ Picas | Negro |
| ♣ Tréboles | Negro |
| ♦ Diamantes | Rojo |
| ♥ Corazones | Rojo |

Las cartas se renderizan **en horizontal** lado a lado, mostrando manos completas de golpe gracias a `Util.pintarCartas()`.

## 🗺️ Navegación por los Menús

El programa cuenta con **3 niveles de menú** anidados:

```
Menú Principal
├── [1] Elegir juego
│    └── [1] Póker
│         ├── [1] Nueva partida  →  pide nº de jugadores (2-10) y sus nombres
│         └── [2] Instrucciones  →  muestra las instrucciones completas del Texas Hold'em
├── [2] Estadísticas
└── [0] Salir
```

## 📖 Instrucciones del juego incluidas

La clase `Instrucciones` contiene los textos completos de las siguientes secciones, accesibles desde el menú:

- **Objetivo** del juego
- **Estructura de una mano** — Pre-Flop, Flop, Turn, River y Showdown
- **Ciegas** — Small Blind y Big Blind
- **acciones disponibles** — Check, Call, Bet, Raise, Fold y All-In
- **Jerarquía de manos** — de Royal Flush a objetos.Carta Alta
- **Desempates** y split pot
- **Variantes** — Fixed-Limit y No-Limit
- **Posiciones en la mesa** — Dealer, SB, BB, Early/Late position


## ⚠️ Warning!

This was us during the proyect btw

<img align="left" alt="focas" width="200" src="https://c.tenor.com/vPMFS9UZx2oAAAAd/tenor.gif" >
