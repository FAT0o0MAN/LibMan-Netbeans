package BUS;

import DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVienDTO> nhanVienList;

    public NhanVienBUS() {
        nhanVienList = new ArrayList<>();
    }

    // Add new 
    public void addNhanVien(NhanVienDTO nhanvien) {
        nhanVienList.add(nhanvien);
    }

    //️ Remove by ID
    public boolean removeNhanVien(String maNhanVien) {
        return nhanVienList.removeIf(s -> s.getMaNhanVien().equalsIgnoreCase(maNhanVien));
    }

    // Find by ID
    public NhanVienDTO findNhanVienById(String maNhanVien) {
        for (NhanVienDTO s : nhanVienList) {
            if (s.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                return s;
            }
        }
        return null;
    }

    // Search by name (optional utility)
    public ArrayList<NhanVienDTO> searchByName(String keyword) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        for (NhanVienDTO s : nhanVienList) {
            if (s.getTenNhanVien().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Update info
    public boolean updateNhanVien(NhanVienDTO updatedNhanVien) {
        for (int i = 0; i < nhanVienList.size(); i++) {
            NhanVienDTO current = nhanVienList.get(i);
            if (current.getMaNhanVien().equalsIgnoreCase(updatedNhanVien.getMaNhanVien())) {
                nhanVienList.set(i, updatedNhanVien);
                return true;
            }
        }
        return false;
    }

    // Return whole list
    public ArrayList<NhanVienDTO> getAll() {
        return nhanVienList;
    }

    /*
    public Object[][] toTableData() {
        Object[][] data = new Object[nhanVienList.size()][];
        for (int i = 0; i < nhanVienList.size(); i++) {
            data[i] = nhanVienList.get(i).toRow();
        }
        return data;
    }
    */
}
