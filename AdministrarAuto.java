package Lab8;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdministrarAuto {

    private ArrayList<Auto> autos = new ArrayList();
    File file = null;

    public AdministrarAuto(String path) {
        file = new File(path);
    }

    public AdministrarAuto() {
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setAuto(Auto a) {
        autos.add(a);
    }

    public void LeerArchivo() throws ClassNotFoundException {
        FileInputStream f = null;
        ObjectInputStream o = null;

        try {
            if (file.exists()) {
                autos = new ArrayList();
                Auto aute;
                f = new FileInputStream(file);
                o = new ObjectInputStream(f);
                try {
                    while ((aute = (Auto) o.readObject()) != null && NumeroUnico(aute.getNumeroUnico())) {
                        autos.add(aute);
                    }
                } catch (EOFException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        try {
            o.close();
            f.close();
        } catch (Exception e) {

        }
    }

    public void escribir() {
        FileOutputStream f = null;
        ObjectOutputStream o = null;
        try {
            f = new FileOutputStream(file);
            o = new ObjectOutputStream(f);
            for (Auto auto : autos) {
                o.writeObject(auto);
            }
            o.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            o.close();
            f.close();
        } catch (Exception e) {
        }
    }

    private boolean NumeroUnico(int numeroUnico) {
        for (Auto auto : autos) {
            if (auto.getNumeroUnico() == numeroUnico) {
                return true;
            }
        }
        return false;
    }
}
