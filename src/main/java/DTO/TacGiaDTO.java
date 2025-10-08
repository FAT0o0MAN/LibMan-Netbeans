package DTO;

public class TacGiaDTO {
    private String maTacGia;
    private String tenTacGia;
    private int sdt;
    private String queQuan;

    public TacGiaDTO() {}

    public TacGiaDTO(String maTacGia, String tenTacGia, int sdt, String queQuan) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.sdt = sdt;
        this.queQuan = queQuan;
    }

    public String getMaTacGia() { return maTacGia; }
    public void setMaTacGia(String maTacGia) { this.maTacGia = maTacGia; }

    public String getTenTacGia() { return tenTacGia; }
    public void setTenTacGia(String tenTacGia) { this.tenTacGia = tenTacGia; }

    public int getSdt() { return sdt; }
    public void setSdt(int sdt) { this.sdt = sdt; }

    public String getQueQuan() { return queQuan; }
    public void setQueQuan(String queQuan) { this.queQuan = queQuan; }

    public Object[] toRow() {
        return new Object[] {
                maTacGia, tenTacGia, sdt, queQuan
        };
    }
}
