package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		List<AnPham> ap = new ArrayList<>();
		
		List<ChuongSach> a = new ArrayList<>();
		a.add(new ChuongSach("Tuoi hoc tro", 140));
		a.add(new ChuongSach("Hoa hong nho", 280));
		
		TapChi t1 = new TapChi("Muc tim", 30, 2014, "Lan Rua", 20, "Tuoi hoc tro");
		TapChi t2 = new TapChi("Muc tim", 35, 1979, "Lan Rua", 20, "Tuoi hoc tro");
		TapChi t3 = new TapChi("Muc tim", 30, 2016, "Lan Rua", 20, "Tuoi hoc tro");
		ap.add(t1);
		ap.add(t2);
		ap.add(t3);
		
		
		SachThamKhao s1 = new SachThamKhao("Duong len dinh Olympic", 350, 2021, "Huynh Van A", 250, "giao duc", a);
		SachThamKhao s2 = new SachThamKhao("Boi loi", 120, 2019, "Nguyen Thi D", 65, "the thao", a);
		SachThamKhao s3 = new SachThamKhao("Nghe thuat trong cay", 75, 2015, "To Anh A", 90, "nghe thuat", a);
		ap.add(s1);
		ap.add(s2);
		ap.add(s3);
		
// Kiểm tra loại ấn phẩm
		String loaiAnPham1 = s1.loaiAnPham();
		String loaiAnPham2 = t1.loaiAnPham();
		System.out.println("Loại ấn phẩm: " + loaiAnPham1);
		System.out.println("Loại ấn phẩm: " + loaiAnPham2);
		
//  ấn phẩm tạp chí và xuất bản cách đây 10 năm
		boolean b1 = t2.kiemTraXuatBanVaLaTapChi();
		boolean b2 = s3.kiemTraXuatBanVaLaTapChi();
		System.out.println("Là tạp chí và xuất bản cách 10 năm: " + b2);
		System.out.println("Là tạp chí và xuất bản cách 10 năm: " + b1);
		
// Ấn phẩm có cùng loại và tác giả
		boolean cungLoaiVaTacGia = t1.kiemTraCungLoaiCungTacGia(t2);
		boolean cungLoaiVaTacGia2 = s1.kiemTraCungLoaiCungTacGia(s3);
		System.out.println("Ấn phẩm có cùng loại và tác giả: " + cungLoaiVaTacGia);
		System.out.println("Ấn phẩm có cùng loại và tác giả: " + cungLoaiVaTacGia2);
		
// Tổng tiền
		DanhMucAnPham apham = new DanhMucAnPham(ap);
		int tongTien = apham.tinhTongTien();
		System.out.println("Tổng tiền các ấn phẩm trong nhà sách: "+ tongTien);
		
// Tạp chí có tên cho trước
		SachThamKhao soTrangLonNhat = apham.getNhieuTrangNhat();
		System.out.println("Quyển sách tham khảo có chương sách nhiều trang nhất:" + soTrangLonNhat);
		

		boolean coTenChoTruoc = apham.coTapChi("Tuoi hoc tro");
		boolean coTenChoTruoc1 = apham.coTapChi("Da bong so 1");
		System.out.println("Ấn phẩm có chứa tạp chí có tên cho trước ko: "+ coTenChoTruoc);
		System.out.println("Ấn phẩm có chứa tạp chí có tên cho trước ko: "+ coTenChoTruoc1);


		int namChoTruoc = 2014;
		List<AnPham> tapChi = apham.xuatBan1NamTrc(namChoTruoc);
		System.out.println("Danh sách tạp chí đc xuất bản từ năm cho trước: " + Arrays.toString(tapChi.toArray()));

		Collections.sort(ap);
		System.out.println("Danh sách các ấn phẩm đã được sắp xếp: " + Arrays.toString(ap.toArray()));
		

		System.out.println("Thống kê ấn phâm theo năm:");
		Map<Integer, Integer> thongKe = apham.anPhamTheoNam();
		
		
	}

}
