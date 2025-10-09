package DTO;

import java.util.Date;

public class PhieuMuonDTO {
    private String maPhieuMuon;
    private Date ngayMuon;
    private Date ngayTra;
    private String maDocGia;
    private String maNhanVien;
    private String trangThai;

    // --- Constructor mặc định ---
    public PhieuMuonDTO() {}

    // --- Constructor đầy đủ ---
    public PhieuMuonDTO(String maPhieuMuon, Date ngayMuon, Date ngayTra,
                        String maDocGia, String maNhanVien, String trangThai) {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.maDocGia = maDocGia;
        this.maNhanVien = maNhanVien;
        this.trangThai = trangThai;
    }

    // --- Getter và Setter ---
    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuMuonDTO {" +
                "Mã Phiếu = '" + maPhieuMuon + '\'' +
                ", Ngày Mượn = " + ngayMuon +
                ", Ngày Trả = " + ngayTra +
                ", Mã Độc Giả = '" + maDocGia + '\'' +
                ", Mã Nhân Viên = '" + maNhanVien + '\'' +
                ", Trạng Thái = '" + trangThai + '\'' +
                '}';
    }
}
