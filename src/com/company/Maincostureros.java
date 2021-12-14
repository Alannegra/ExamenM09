package com.company;

public class Maincostureros {
    public static void main(String[] args) {


        Recursos cesto = new Recursos("cesto");

        Costurero mangas = new Costurero("manga", cesto);
        Costurero cuerpos = new Costurero("cuerpo", cesto);
        Costurero ensamblador = new Costurero("ensamblador", cesto);

        mangas.start();
        cuerpos.start();
        ensamblador.start();


    }
}
