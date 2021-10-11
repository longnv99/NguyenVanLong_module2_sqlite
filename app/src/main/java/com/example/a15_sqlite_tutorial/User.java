package com.example.a15_sqlite_tutorial;

import java.io.Serializable;

public
class User implements Serializable {
    private int id;
    private String maSinhVien;
    private String hoTen;
    private String lop;
    private String gioiTinh;
    private String diemToan;
    private String diemLy;
    private String diemHoa;

    public
    User(String maSinhVien, String hoTen, String lop, String gioiTinh, String diemToan, String diemLy, String diemHoa) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.lop = lop;
        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }

    public
    String getMaSinhVien() {
        return maSinhVien;
    }

    public
    void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public
    String getHoTen() {
        return hoTen;
    }

    public
    void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public
    String getLop() {
        return lop;
    }

    public
    void setLop(String lop) {
        this.lop = lop;
    }

    public
    String getGioiTinh() {
        return gioiTinh;
    }

    public
    void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public
    String getDiemToan() {
        return diemToan;
    }

    public
    void setDiemToan(String diemToan) {
        this.diemToan = diemToan;
    }

    public
    String getDiemLy() {
        return diemLy;
    }

    public
    void setDiemLy(String diemLy) {
        this.diemLy = diemLy;
    }

    public
    String getDiemHoa() {
        return diemHoa;
    }

    public
    void setDiemHoa(String diemHoa) {
        this.diemHoa = diemHoa;
    }
}
