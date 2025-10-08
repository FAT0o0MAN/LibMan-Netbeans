package DTO;

public class NhaXuatBanDTO {
    private String maNhaXuatBan;
    private String tenNhaXuatBan;
    private int sdt;
    private String diaChi;

    public NhaXuatBanDTO() {}

    public NhaXuatBanDTO(String maNhaXuatBan, String tenNhaXuatBan, int sdt, String diaChi) {
        this.maNhaXuatBan = maNhaXuatBan;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaNhaXuatBan() { return maNhaXuatBan; }
    public void setMaNhaXuatBan(String maNhaXuatBan) { this.maNhaXuatBan = maNhaXuatBan; }

    public String getTenNhaXuatBan() { return tenNhaXuatBan; }
    public void setTenNhaXuatBan(String tenNhaXuatBan) { this.tenNhaXuatBan = tenNhaXuatBan; }

    public int getSdt() { return sdt; }
    public void setSdt(int sdt) { this.sdt = sdt; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public Object[] toRow() {
        return new Object[] {
                maNhaXuatBan, tenNhaXuatBan, sdt, diaChi
        };
    }
}
