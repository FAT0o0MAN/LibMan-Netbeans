package DTO;

public class NhanVienDTO {
    private String maNhanVien;
    private String tenNhanVien;
    private String gioiTinh;;
    private int namSinh;
    private int sdt;
    private int ngayBatDau;
    private int luong;
    private String diaChi;

    public NhanVienDTO() {}

    public NhanVienDTO(String maNhanVien, String tenNhanVien, String gioiTinh, int namSinh,
                   int sdt, int ngayBatDau, int luong, String diaChi) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.luong = luong;
        this.luong = luong;
        this.diaChi = diaChi;
    }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }

    public String getTenNhanVien() { return tenNhanVien; }
    public void setTenNhanVien(String tenNhanVien) { this.tenNhanVien = tenNhanVien; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public int getNamSinh() { return namSinh; }
    public void setNamSinh(int namSinh) { this.namSinh = namSinh; }

    public int getSdt() { return sdt; }
    public void setSdt(int sdt) { this.sdt = sdt; }

    public int getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(int ngayBatDau) { this.ngayBatDau = ngayBatDau; }

    public int getLuong() { return luong; }
    public void setLuong(int luong) { this.luong = luong; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public Object[] toRow() {
        return new Object[] {
                maNhanVien, tenNhanVien, gioiTinh, namSinh, sdt,
                ngayBatDau, luong, diaChi
        };
    }
}
