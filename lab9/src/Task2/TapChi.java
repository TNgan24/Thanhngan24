package Task2;

public class TapChi extends AnPham{
	private String ten;

	/**
	 * @param tieuDe
	 * @param soTrang
	 * @param namXuatBan
	 * @param tacGia
	 * @param gia
	 * @param ten
	 */
	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int gia, String ten) {
		super(tieuDe, soTrang, namXuatBan, tacGia, gia);
		this.ten = ten;
	}
	
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String loaiAnPham() {
		return "Tap chi" ;
	}
	public boolean isTapChi() {
		return true;
	}

	@Override
	public String toString() {
		return "TapChi [ten=" + ten + ", tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan
				+ ", tacGia=" + tacGia + ", gia=" + gia
				+ "]";
	}

}
