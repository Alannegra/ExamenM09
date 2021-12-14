package com.company;

public class Recursos {

    private boolean lliure;
    private String nombre;

    int NumMaxMangas = 10;
    int NunMaxCuerpos = 10;

    int mangas;
    int cuerpos;
    int jerseis;


    public String getNombre() {
        return nombre;
    }

    public Recursos(String nombre) {
        this.nombre = nombre;
        lliure = true;
    }


    public synchronized void añadirManga() {
        if(NumMaxMangas > mangas) {
            try {
                while (!lliure) wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            mangas++;
            notifyAll();

        }

    }

    public synchronized void añadirCuerpo() {
        if(NunMaxCuerpos > cuerpos){
            try {
                while (!lliure) wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            cuerpos++;
            notifyAll();
        }
    }

    public synchronized void añadirJersei() {
        if(mangas >= 2 && cuerpos >=1) {
            mangas-=2;
            cuerpos--;
            try {
                while (!lliure) wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            jerseis++;
            notifyAll();

        }
    }


    public synchronized void deixa() {
        lliure = true;
        notifyAll();
    }
}
