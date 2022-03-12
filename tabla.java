package Lab8;

import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tabla implements Runnable {

    private boolean iniciar, reanudar;
    private JTable table;
    private JProgressBar bar;
    private int largo;
    private ArrayList<Auto> autos = new ArrayList();

    public tabla() {
    }

    public tabla(JTable table, JProgressBar bar, ArrayList<Auto> autos) {
        this.table = table;
        this.bar = bar;
        iniciar = reanudar = true;
        largo = bar.getMaximum();
        this.autos = autos;
    }

    public boolean isIniciar() {
        return iniciar;
    }

    public void setIniciar(boolean iniciar) {
        this.iniciar = iniciar;
    }

    public boolean isAvanzar() {
        return reanudar;
    }

    public void setAvanzar(boolean avanzar) {
        this.reanudar = avanzar;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JProgressBar getBarra() {
        return bar;
    }

    public void setBarra(JProgressBar bar) {
        this.bar = bar;
    }

    @Override
    public void run() {
        while (iniciar) {
            if (reanudar) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                for (int i = 0; i < table.getRowCount(); i++) {
                    Auto a;
                    String n = (String) table.getValueAt(i, 1);
                    System.out.println("id " + n);
                    for (Auto auto : autos) {
                        if (n.equals(auto.getNombreCorredor())) {
                            int x = auto.distanciaRecorrida();
                            auto.setDistanciaRecorrida(auto.getDistanciaRecorrida() + x);
                            break;
                        }
                    }
                }
                Reanudar();
                bar.setValue(bar.getValue() + 10);
                if (bar.getValue() >= largo) {
                    iniciar = false;
                }
            }
        }
    }

    private void Reanudar() {
        DefaultTableModel m = new DefaultTableModel();
        for (Auto a : autos) {
            System.out.println(a.getNombreCorredor());
            Object[] newRow = {
                a.getNumeroUnico(), a.getNombreCorredor(), a.getDistanciaRecorrida()
            };
            m.addRow(newRow);
        }
        table.setModel(m);
    }

}
