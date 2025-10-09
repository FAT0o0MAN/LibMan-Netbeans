package BUS;

import DTO.NhaXuatBanDTO;
import java.util.ArrayList;

public class NhaXuatBanBUS {
    private ArrayList<NhaXuatBanDTO> nhaXuatBanList;

    public NhaXuatBanBUS() {
        nhaXuatBanList = new ArrayList<>();
    }

    // Add new 
    public void addNhaXuatBan(NhaXuatBanDTO nhaxuatban) {
        nhaXuatBanList.add(nhaxuatban);
    }

    // Remove by ID
    public boolean removeNhaXuatBan(String maNhaXuatBan) {
        return nhaXuatBanList.removeIf(s -> s.getMaNhaXuatBan().equalsIgnoreCase(maNhaXuatBan));
    }

    // Find a by ID
    public NhaXuatBanDTO findNhaXuatBanById(String maNhaXuatBan) {
        for (NhaXuatBanDTO s : nhaXuatBanList) {
            if (s.getMaNhaXuatBan().equalsIgnoreCase(maNhaXuatBan)) {
                return s;
            }
        }
        return null;
    }

    // Search by name (optional utility)
    public ArrayList<NhaXuatBanDTO> searchByName(String keyword) {
        ArrayList<NhaXuatBanDTO> result = new ArrayList<>();
        for (NhaXuatBanDTO s : nhaXuatBanList) {
            if (s.getTenNhaXuatBan().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    // Update info
    public boolean updateNhaXuatBan(NhaXuatBanDTO updatedNhaXuatBan) {
        for (int i = 0; i < nhaXuatBanList.size(); i++) {
            NhaXuatBanDTO current = nhaXuatBanList.get(i);
            if (current.getMaNhaXuatBan().equalsIgnoreCase(updatedNhaXuatBan.getMaNhaXuatBan())) {
                nhaXuatBanList.set(i, updatedNhaXuatBan);
                return true;
            }
        }
        return false;
    }

    // Return whole list
    public ArrayList<NhaXuatBanDTO> getAll() {
        return nhaXuatBanList;
    }

   /*
    public Object[][] toTableData() {
        Object[][] data = new Object[nhaXuatBanList.size()][];
        for (int i = 0; i < nhaXuatBanList.size(); i++) {
            data[i] = nhaXuatBanList.get(i).toRow();
        }
        return data;
    }
*/
}
