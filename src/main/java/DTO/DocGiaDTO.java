package DTO;

public class DocGiaDTO {
    private String maDocGia;
    private String tenDocGia;
    private String diaChi;
    private int sdt;
    private String gioiTinh;

    public DocGiaDTO() {}

    public DocGiaDTO(String maDocGia, String tenDocGia, String diaChi, int sdt, String gioiTinh) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }


    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getTenDocGia() { return tenDocGia; }
    public void setTenDocGia(String tenDocGia) { this.tenDocGia = tenDocGia; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public int getSdt() { return sdt; }
    public void setSdt(int sdt) { this.sdt = sdt; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public Object[] toRow() {
        return new Object[] {
                maDocGia, tenDocGia, diaChi, sdt, gioiTinh
        };
    }
}
