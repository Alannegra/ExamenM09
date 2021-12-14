package com.company;

public class Recursos {

    private boolean lliure;
    private String nombre;

    int NumMaxMangas = 10;
    int NunMaxCuerpos = 10;

    int mangas;
    int cuerpos;
    int jerseis;


    public Recursos(String nombre) {
        this.nombre = nombre;
        lliure = true;
    }

    /*public synchronized void añadirManga() {
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
    }*/
    public synchronized void añadirManga() {

            try {
                while (!lliure && NumMaxMangas > mangas){
                    mangas++;
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;

            notifyAll();


    }

    public synchronized void añadirCuerpo() {

            try {
                while (!lliure && NunMaxCuerpos > cuerpos){
                    cuerpos++;
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            notifyAll();

    }

    public synchronized void añadirJersei() {


            try {
                while (!lliure && mangas >= 2 && cuerpos >=1){
                    mangas-=2;
                    cuerpos--;
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lliure = false;
            jerseis++;
            notifyAll();

    }

    public synchronized void deixa() {
        lliure = true;
        notifyAll();
    }
}
