package Task2;

import java.util.List;

public class SachThamKhao extends AnPham{
	private String linhVuc;
	private List<ChuongSach> dsChuong;
	/**
	 * @param tieuDe
	 * @param soTrang
	 * @param namXuatBan
	 * @param tacGia
	 * @param gia
	 * @param linhVuc
	 * @param dsChuong
	 */
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia, String linhVuc,
			List<ChuongSach> dsChuong) {
		super(tieuDe, soTrang, namXuatBan, tacGia, gia);
		this.linhVuc = linhVuc;
		this.dsChuong = dsChuong;
	}
	public String loaiAnPham() {
		return "Sach tham khao";
	}
	public int getChuongTrangMax() {
		int soChuongTrangMax = -1;
		for(ChuongSach chuongSach : dsChuong) {
			if(chuongSach.getSoTrang() > soChuongTrangMax) {
				soChuongTrangMax = chuongSach.getSoTrang();
			}
		}
		return soChuongTrangMax;
	}
	@Override
	public String toString() {
		return "SachThamKhao [linhVuc=" + linhVuc + ", dsChuong=" + dsChuong + "]";
	}
	
}
