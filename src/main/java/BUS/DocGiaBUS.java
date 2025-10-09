package BUS;

import DTO.DocGiaDTO;
import java.util.ArrayList;

public class DocGiaBUS {
    private ArrayList<DocGiaDTO> docGiaList;

    public DocGiaBUS() {
        docGiaList = new ArrayList<>();
    }

    // Add new 
    public void addDocGia(DocGiaDTO docgia) {
        docGiaList.add(docgia);
    }

    //️ Remove by ID
    public boolean removeDocGia(String maDocGia) {
        return docGiaList.removeIf(s -> s.getMaDocGia().equalsIgnoreCase(maDocGia));
    }

    // Find by ID
    public DocGiaDTO findDocGiaById(String maDocGia) {
        for (DocGiaDTO s : docGiaList) {
            if (s.getMaDocGia().equalsIgnoreCase(maDocGia)) {
                return s;
            }
        }
        return null;
    }

    // Search by name (optional utility)
    public ArrayList<DocGiaDTO> searchByName(String keyword) {
        ArrayList<DocGiaDTO> result = new ArrayList<>();
        for (DocGiaDTO s : docGiaList) {
            if (s.getTenDocGia().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Update info
    public boolean updateDocGia(DocGiaDTO updatedDocGia) {
        for (int i = 0; i < docGiaList.size(); i++) {
            DocGiaDTO current = docGiaList.get(i);
            if (current.getMaDocGia().equalsIgnoreCase(updatedDocGia.getMaDocGia())) {
                docGiaList.set(i, updatedDocGia);
                return true;
            }
        }
        return false;
    }

    // Return whole list
    public ArrayList<DocGiaDTO> getAll() {
        return docGiaList;
    }

    /*
    public Object[][] toTableData() {
        Object[][] data = new Object[docGiaList.size()][];
        for (int i = 0; i < docGiaList.size(); i++) {
            data[i] = docGiaList.get(i).toRow();
        }
        return data;
    }
    */
}
