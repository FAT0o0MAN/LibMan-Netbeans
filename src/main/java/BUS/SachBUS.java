package BUS;

import DTO.SachDTO;
import java.util.ArrayList;

public class SachBUS {
    private ArrayList<SachDTO> sachList;

    public SachBUS() {
        sachList = new ArrayList<>();
    }

    // Add new book
    public void addSach(SachDTO sach) {
        sachList.add(sach);
    }

    //️ Remove book by ID
    public boolean removeSach(String maSach) {
        return sachList.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
    }

    // Find a book by ID
    public SachDTO findSachById(String maSach) {
        for (SachDTO s : sachList) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    // Search by name (optional utility)
    public ArrayList<SachDTO> searchByName(String keyword) {
        ArrayList<SachDTO> result = new ArrayList<>();
        for (SachDTO s : sachList) {
            if (s.getTenSach().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Update info
    public boolean updateSach(SachDTO updatedSach) {
        for (int i = 0; i < sachList.size(); i++) {
            SachDTO current = sachList.get(i);
            if (current.getMaSach().equalsIgnoreCase(updatedSach.getMaSach())) {
                sachList.set(i, updatedSach);
                return true;
            }
        }
        return false;
    }

    // Return all books
    public ArrayList<SachDTO> getAll() {
        return sachList;
    }

    /*
    public Object[][] toTableData() {
        Object[][] data = new Object[sachList.size()][];
        for (int i = 0; i < sachList.size(); i++) {
            data[i] = sachList.get(i).toRow();
        }
        return data;
    }
    */
}
