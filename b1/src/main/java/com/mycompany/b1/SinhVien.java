package com.mycompany.b1;

public class SinhVien {
	private String maSinhVien;	
	private String tenSinhVien;
	private int tuoi;
	private String lop;
	
	public SinhVien() {
		
	}
	
	public SinhVien(String maSinhVien, String tenSinhVien, int tuoi, String lop) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.tuoi = tuoi;
		this.lop = lop;
	}
	
	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public void hienThiThongTin() {
		System.out.println("----- Thông tin sinh viên -----");
		System.out.println("Mã SV: " + maSinhVien);
		System.out.println("Tên SV: " + tenSinhVien);
		System.out.println("Tuổi: " + tuoi);
		System.out.println("Lớp: " + lop);
	}
}

