package Interface;

import Logica.Questao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ModeloQuestao extends AbstractTableModel {
    ArrayList<Questao> questao;
    ModeloQuestao(ArrayList<Questao> questao){
        this.questao=questao;
    }
    ModeloQuestao(){
        this.questao=new ArrayList<>();
    }
    public void setListQuestoes(ArrayList<Questao> questao) {
        this.questao = questao;
        fireTableDataChanged();
    }
        @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return questao.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ASSUNTO";
            case 1:
                return "TIPO DE QUESTAO";
            case 2:
                return "PERGUNTA";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Questao registro = questao.get(rowIndex);
        switch (columnIndex) {
            case 1:
                return registro.getTipo();
            case 0:
                return registro.getAssunto().toString();
            case 2:
                return registro.getPergunta();
            default:
                return new Object();
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    public Questao getQuestaoSelected(int i) {
        return questao.get(i);
    }

    public ArrayList<Questao> getQuestao() {
        return questao;
    }
    
}
