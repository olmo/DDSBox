/*
 * Copyright (c) 2014. Olmo Jiménez Alaminos, Víctor Cabezas Lucena.
 *
 * This file is part of DDSBox.
 *
 * DDSBox is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DDSBox is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with DDSBox.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.ugr.ddsbox.ui.graphic;

import es.ugr.ddsbox.models.SharedFolder;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class FolderTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name", "Owner", "Type", "Subscribed"};
    private ArrayList<SharedFolder> data = new ArrayList<SharedFolder>();

    public FolderTableModel(){

    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = data.get(rowIndex).getName();
                break;
            case 1:
                value = data.get(rowIndex).getOwner();
                break;
            case 2:
                value = (data.get(rowIndex).getType()==SharedFolder.PRIVATE)?"Private":"Public";
                break;
            case 3:
                value = data.get(rowIndex).isSuscribed()?"Yes":"No";
                break;
        }
        return value;
    }

    public SharedFolder getFolder(int rowIndex){
        return data.get(rowIndex);
    }

    public void add(SharedFolder o){
        data.add(o);
        this.fireTableDataChanged();
    }
}
