package DTO;

import java.util.Date;
import java.util.List;

public class PhieuNhapDTO {
    private String maPhieuNhap;
    private Date ngayNhap;
    private String nhaCungCap;
    private String nhanVienNhap;
    private double tongTien;
    private List<ChiTietPhieuNhapDTO> chiTietPhieuNhapList;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String maPhieuNhap, Date ngayNhap, String nhaCungCap, String nhanVienNhap, double tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.nhaCungCap = nhaCungCap;
        this.nhanVienNhap = nhanVienNhap;
        this.tongTien = tongTien;
    }

    // --- Getter và Setter ---
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getNhanVienNhap() {
        return nhanVienNhap;
    }

    public void setNhanVienNhap(String nhanVienNhap) {
        this.nhanVienNhap = nhanVienNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietPhieuNhapDTO> getChiTietPhieuNhapList() {
        return chiTietPhieuNhapList;
    }

    public void setChiTietPhieuNhapList(List<ChiTietPhieuNhapDTO> chiTietPhieuNhapList) {
        this.chiTietPhieuNhapList = chiTietPhieuNhapList;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" +
                "maPhieuNhap='" + maPhieuNhap + '\'' +
                ", ngayNhap=" + ngayNhap +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                ", nhanVienNhap='" + nhanVienNhap + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}

