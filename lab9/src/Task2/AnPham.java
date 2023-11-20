package Task2;

import java.time.LocalDate;

public class AnPham implements Comparable<AnPham>{
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int gia;

	
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.gia = gia;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String loaiAnPham() {
		return "Khong xac dinh";
	}
	public boolean kiemTraXuatBanVaLaTapChi() {
		if (this instanceof TapChi) {
			int nam = LocalDate.now().getYear();
			return (nam - getNamXuatBan() >= 10);

		}
		return false;

	}
	public boolean kiemTraCungLoaiCungTacGia(AnPham khac) {
		return this.loaiAnPham().equals(khac.loaiAnPham()) && this.tacGia.equals(khac.tacGia);
	}

	@Override
	public int compareTo(AnPham o) {
		// xếp tăng dần theo tieu đề
		int xepTieuDe = this.tieuDe.compareTo(o.tieuDe);
		if(xepTieuDe != 0) {
			return xepTieuDe;
		}
		// xếp giảm dần theo năm xuất bản
		return Integer.compare(o.namXuatBan, this.namXuatBan);
	}
	

}
