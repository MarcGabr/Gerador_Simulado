/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
    private final ArrayList<Assunto> assuntos;
    public ModeloTabela(ArrayList<Assunto> assuntos) {
        this.assuntos=assuntos;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return assuntos.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "NOME";
            case 1:
                return "QUANTIDADE";
            case 2:
                return "DATA DE CRIAÇÃO";
            case 3:
                return "ESTADO";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Assunto registro = assuntos.get(rowIndex);
        switch (columnIndex) {
            case 1:
                return registro.getQuantidade();
            case 2:
                return registro.getData();
            case 3:
                return registro.getAtivo() ? "Ativo" : "Excluido";
            case 0:
                return registro.getNome();
            default:
                return new Object();
        }
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    protected Assunto getAssunto(int i){
        return assuntos.get(i);
    }
    protected ArrayList<Assunto> getAssuntos(){
        return assuntos;
    }
}
