package com.company;

public class Costurero extends Thread {

    String nombre;
    Recursos recurso;


    //p.ej.#que#son#dos#constantes#enteras#"NumMaxMangas"#y#"NumMaxCuerpos").

    public Costurero(String nombre, Recursos recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {

        for(;;) {
            //Agafa el comandament


                if(nombre.equals("manga")){
                    recurso.añadirManga();


            }


                if(nombre.equals("cuerpo")){
                    recurso.añadirCuerpo();


            }

            if(true){
                if(nombre.equals("ensamblador")){
                    recurso.añadirJersei();
                    //jersey++;
                }
            }

            /*synchronized (lock){

                try {
                    cubierto1.agafa();
                    Thread.sleep((long) (Math.random()*400)+200);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                cubierto2.agafa();
            }*/


            //System.out.println(nombre + " " + cubierto1.getNombre() + " " + cubierto2.getNombre());
            System.out.println("En el " + recurso.getNombre() + " añade " +nombre + " M" + recurso.mangas + " C" + recurso.cuerpos + " J" + recurso.jerseis);

            try {
                Thread.sleep((long) (Math.random()*800)+200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Deixa el comandament
            recurso.deixa();
            //cubierto2.deixa();
            //System.out.println(nombre + " " + cubierto1.getNombre() + " " + cubierto2.getNombre());

            //Descansa de tanta tele
            try {
                //System.out.println(getName() + " ja no miro la tele");
                //System.out.format("%s %s %n", getName(),resourceBundle.getString("persona.deixar_tv"));
                Thread.sleep((long) (Math.random()*1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}