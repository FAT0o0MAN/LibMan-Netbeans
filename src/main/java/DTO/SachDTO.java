package DTO;

public class SachDTO {
    private String maSach;
    private String tenSach;
    private String maLoai;
    private String tacGia;
    private String nhaXuatBan;
    private int namXuatBan;
    private int soLuong;
    private String maKeSach;
    private String hinhAnh;

    public SachDTO() {}

    public SachDTO(String maSach, String tenSach, String maLoai, String tacGia,
                   String nhaXuatBan, int namXuatBan, int soLuong,
                   String maKeSach, String hinhAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maLoai = maLoai;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.maKeSach = maKeSach;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }

    public String getMaLoai() { return maLoai; }
    public void setMaLoai(String maLoai) { this.maLoai = maLoai; }

    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }

    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }

    public int getNamXuatBan() { return namXuatBan; }
    public void setNamXuatBan(int namXuatBan) { this.namXuatBan = namXuatBan; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public String getMaKeSach() { return maKeSach; }
    public void setMaKeSach(String maKeSach) { this.maKeSach = maKeSach; }

    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }

    public Object[] toRow() {
        return new Object[] {
            maSach, tenSach, maLoai, tacGia, nhaXuatBan,
            namXuatBan, soLuong, maKeSach, hinhAnh
        };
    }
}
