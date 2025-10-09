package BUS;

import DTO.TacGiaDTO;
import java.util.ArrayList;

public class TacGiaBUS {
    private ArrayList<TacGiaDTO> tacGiaList;

    public TacGiaBUS() {
        tacGiaList = new ArrayList<>();
    }

    // Add new 
    public void addTacGia(TacGiaDTO tacgia) {
        tacGiaList.add(tacgia);
    }

    //️ Remove by ID
    public boolean removeTacGia(String maTacGia) {
        return tacGiaList.removeIf(s -> s.getMaTacGia().equalsIgnoreCase(maTacGia));
    }

    // Find by ID
    public TacGiaDTO findTacGiaById(String maTacGia) {
        for (TacGiaDTO s : tacGiaList) {
            if (s.getMaTacGia().equalsIgnoreCase(maTacGia)) {
                return s;
            }
        }
        return null;
    }

    // Search by name (optional utility)
    public ArrayList<TacGiaDTO> searchByName(String keyword) {
        ArrayList<TacGiaDTO> result = new ArrayList<>();
        for (TacGiaDTO s : tacGiaList) {
            if (s.getTenTacGia().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Update info
    public boolean updateTacGia(TacGiaDTO updatedTacGia) {
        for (int i = 0; i < tacGiaList.size(); i++) {
            TacGiaDTO current = tacGiaList.get(i);
            if (current.getMaTacGia().equalsIgnoreCase(updatedTacGia.getMaTacGia())) {
                tacGiaList.set(i, updatedTacGia);
                return true;
            }
        }
        return false;
    }

    // Return whole list
    public ArrayList<TacGiaDTO> getAll() {
        return tacGiaList;
    }

    /*
    public Object[][] toTableData() {
        Object[][] data = new Object[tacGiaList.size()][];
        for (int i = 0; i < tacGiaList.size(); i++) {
            data[i] = tacGiaList.get(i).toRow();
        }
        return data;
    }
    */
}
