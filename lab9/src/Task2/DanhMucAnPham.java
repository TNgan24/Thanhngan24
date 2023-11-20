package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	List<AnPham> dsAnPham;

	/**
	 * @param dsAnPham
	 */
	public DanhMucAnPham(List<AnPham> dsAnPham) {
		this.dsAnPham = dsAnPham;
	}
	public int tinhTongTien() {
		int tongTien = 0;
		for(AnPham anPham : dsAnPham) {
			tongTien += anPham.getGia();
		}
		return tongTien;
	}
	
	public SachThamKhao getNhieuTrangNhat () {
		SachThamKhao nhieuTrangNhat = null;
		int maxSoTrang = -1;
		
		for(AnPham apham : dsAnPham) {
			if(apham instanceof SachThamKhao) {
				SachThamKhao sach = (SachThamKhao) apham;
				int soChuongTrangMax = sach.getChuongTrangMax();
				
				if(soChuongTrangMax > maxSoTrang) {
					maxSoTrang = soChuongTrangMax;
					nhieuTrangNhat = sach;
				}
			}
		}
		return nhieuTrangNhat;
		
	}
	public boolean coTapChi(String tenTapChi) {
		for (AnPham apham: dsAnPham) {
			if(apham instanceof TapChi) {
				TapChi tapChi = (TapChi) apham;
				if(tapChi.getTen().equals(tenTapChi)) {
					return true;
				}
			}
		}
		return false;
	}
	public List<AnPham> xuatBan1NamTrc(int nam){
		List<AnPham> result = new ArrayList<>();
		if(dsAnPham != null) {
			for(AnPham apham : dsAnPham) {
				if( apham instanceof TapChi) {
					TapChi tapChi = (TapChi) apham;
					if(tapChi.getNamXuatBan() == nam) {
						result.add(tapChi);
					}
				}
			}
		}
		return result;
		
	}
	public Map<Integer, Integer> anPhamTheoNam() {
		Map<Integer, Integer> thongKe = new HashMap<>();
		for(AnPham apham : dsAnPham) {
			int namXuatBan = apham.getNamXuatBan();
			thongKe.put(namXuatBan, thongKe.getOrDefault(namXuatBan, 0) +1);
			
		}
		for( Map.Entry<Integer, Integer> entry : thongKe.entrySet()) {
			System.out.println("Năm" +entry.getKey()+": " + entry.getValue()+ " ấn phẩm");
		}
		return thongKe;
	}
	@Override
	public String toString() {
		return "DanhMucAnPham [dsAnPham=" + dsAnPham + "]";
	}

}
