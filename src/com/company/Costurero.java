package com.company;

public class Costurero extends Thread {

    String nombre;
    Recursos recurso;

    public Costurero(String nombre, Recursos recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {

        for(;;) {

                if(nombre.equals("manga")){
                    recurso.añadirManga();
            }


                if(nombre.equals("cuerpo")){
                    recurso.añadirCuerpo();
            }


                if(nombre.equals("ensamblador")){
                    recurso.añadirJersei();
            }


            System.out.println("En el " + "cesto" + " añade " +nombre + " M" + recurso.mangas + " C" + recurso.cuerpos + " J" + recurso.jerseis);

            try {
                Thread.sleep((long) (Math.random()*800)+200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            recurso.deixa();

            try {
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}