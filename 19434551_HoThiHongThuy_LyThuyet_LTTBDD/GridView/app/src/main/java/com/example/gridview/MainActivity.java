package com.example.gridview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    ArrayList<SanPham> sanPhams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv_traicay = findViewById(R.id.gridview_traicay);
        sanPhams = new ArrayList<>();
        addSanPham();
        MyArrayAdapter adapter = new MyArrayAdapter(this, R.layout.custom_gridview, sanPhams);

        gv_traicay.setAdapter(adapter);
        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, sanPhams.get(i)+"", Toast.LENGTH_SHORT).show();
                SanPham sanPham =   sanPhams.get(i);
                int hinh  = sanPham.getHinhAnh();
                double gia = sanPham.getGiaSanPham();
                String ten = sanPham.getTenSanPham();
                String mota = sanPham.getThongTinChiTiet();

                Intent intent = new Intent(MainActivity.this, Activity2.class);

                intent.putExtra("hinh", hinh);
                intent.putExtra("ten", ten);
                intent.putExtra("gia", gia);
                intent.putExtra("mota", mota);
                startActivity(intent);
            }
        });
    }

    private void addSanPham(){
        sanPhams.add(new SanPham(1,"Sữa cô gái hà lan", R.drawable.suahalan, 7000,
                "Thương hiệu: " + "Dutch Lady\n" +
                "Xuất xứ: " + "Việt Nam\n" +
                "Hạn sử dụng: " + "6 tháng\n" +
                "Thể tích: " + "220ml\n" +
                "Kho hàng: " + "150\n" +
                "Gửi từ: " + "Quận Bình Thạnh, TP.HCM\n"+
                "Lắc đều trước khi uống, Ngon hơn khi uống lạnh.\n" +
                "Sản phẩm sử dụng cho 1 lần uống.\n" +
                "Bảo quản nơi khô ráo, thoáng mát.́\n"));
        sanPhams.add(new SanPham(2,"Aquafina", R.drawable.nuocsuoi, 5000,
                "Thương hiêu : AQUAFINA\n" +
                "Xuất xứ : Việt Nam\n" + "Hạn sử dụng: " + "23 tháng\n" +
                "Dung tích: 355 ml/chai"+
                "Thành phần và công dụng: " + "Nước tinh khiết\n" +
                "Hướng dẫn sử dụng: Dùng trực tiếp, ngon hơn khi uống lạnh.\n" +
                "Bảo quản: Để nơi khô ráo, thoáng mát, tránh ánh năng trực tiếp"));
        sanPhams.add(new SanPham(3,"Nước Cam ép Vfresh", R.drawable.nuoccam, 7000,"Thương hiệu: LaVie\n" +
                "Loại nước: Nước cam\n" +
                "Xuất xứ: Việt Nam\n" +
                "Kho: 498\n" +
                "Hạn sử dụng: 12 tháng\n" +
                "Ngày hết hạn: 20-04-2022\n" +
                "Thể tích: 1L\n" +
                "Thành phần: nước\n"+
                "Nước trái câu được ép từ nguồn trái cây tươi ngon tụ nhiên, hoàn toàn không chưa chất bảo quản.\n"));

        sanPhams.add(new SanPham(4,"Nước dừa", R.drawable.nuocdua, 9000,"Xuất xứ: Việt Nam\n" +
                "Thương hiệu: COCOXIM\n" +
                "Thể tích: 1L\n" +
                "Xuất xứ: Việt Nam\n" +
                "Hạn sử dụng: 12 tháng\n" +
                "100% dừa tươi nguyên chất.\n" +
                "Tiệt trùng bằng công nghệ hiện đại.\n" +
                "Không bảo quản, không chất tạo màu.\n" +
                "Có 2 mùi vị lựa chọn: Xiêm Xanh và Xiêm sen.\n"
                ));
        sanPhams.add(new SanPham(5,"Nước COCACOLA", R.drawable.nuoccocola, 139000,"Dung tích: 320ml\n" +
                "Thương hiệu: COCACOLA\n" +
                "Xuất xứ: Việt Nam\n" +
                "Hạn sử dụng: 12 tháng\n" +
                "Nước ngọt Coca Cola được sản xuất trên dây truyền công nghệ hiện đại của Nhật Bản, đảm bảo tuyệt đối về mặt chất lượng.\n" + "\n" +
                "Sản phẩm giúp bạn nhanh chóng xua tan cơn khát, giúp bù nước trong các hoạt động hàng nagyf."));
        sanPhams.add(new SanPham(6,"Bia Sài Gòn", R.drawable.nuocbayup, 11900,"Thương hiệu: BIA SAIGON\n" +
                "Thương hiệu: 7up\n" +
                "Xuất xứ: Việt Nam\n" +
                "Hạn sử dụng: 12 tháng\n"+
                "Nước ngọt có gas 7 Up giúp bù đắp lượng nước bị mất đi do vận động, chơi thể thao, với hương vị đặc trưng, không chỉ giải khát, mà còn giúp bạn lấy lại năng lượng cho hoạt động hàng ngày.\n" +
                "Với thiết kế chai tiện dụng, sản phẩm có thể mang theo trong những buổi tập thể thao hay những chuyến vui chơi, dã ngoại ngoài trời đều phù hợp.\n"+
                "Hướng dẫn bảo quản:\n" +
                "\t+ Dùng trực tiếp, ngon hơn khi ướp lạnh\n" +
                "\t+ Bảo quản nơi khô ráo, thoáng mát"));
        sanPhams.add(new SanPham(7, "Bánh quy cà phê",R.drawable.banhquybo, 7000,
                "hương hiệu: Coffee Joy \n" +
                "Xuất xứ: Indonesia\n" +
                "Hương vị: Cà phê\n" +
                "Năng lượng 120kcal /24g\n"+
                "Thành phần Bột lúa mì, dầu thực vật\n"+
                "Thể tích: 350ml\n" +
                "Hạn sử dụng: 8 tháng\n"+
                "Bảo quản: Để nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp\n" ));
        sanPhams.add(new SanPham(8, "Bánh bông lan",R.drawable.banhbonglantuoi ,46000,
                "Thương hiệu Kinh Đô (Việt Nam)\n" +
                "Loại sản phẩm Bánh bông lan tươi vị cam\n" +
                "Quy cách: 900ml/Chai\n" +
                "Thành phần Trứng gà (34%), bột mì, đường, dầu thực vật (dầu cọ), chất giữ ẩm (422), chất nhũ hoá, bột bắp, sữa tươi (1%),...\n" +
                "Cách sử dụng: Dùng ngay. Có thể dùng kèm 1 ly sữa hoặc nước trái cây cho buổi sáng đủ chất\n" +
                "\n" +
                "Bảo quản nơi khô ráo, thoáng mát. Tránh ánh nắng trực tiếp"));
        sanPhams.add(new SanPham(9,"Bánh quy Arita nhân socola", R.drawable.banharita, 1694000, "Nhà cung cấp: Csfood\n" +
                "Thương hiệu Arita (Việt Nam)\n" +
                "Loại Bánh quy nhân socola\n" +
                "Khối lượng 320g\n" +
                "Bảo quản Để nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp\n" +
                "Bánh quy là món ăn phù hợp cho cả gia đình từ trẻ em đến người lớn\n" +
                "Bánh quy Arita thơm ngon với lớp vỏ bánh cực kỳ chất lượng, giòn rụm thơm ngon."));
        sanPhams.add(new SanPham(9,"Bánh quy bơ Danisa ", R.drawable.banhdanisa, 17400,
                "Thương hiệu Danisa (Đan Mạch)\n"+
                "Nơi sản xuất Indonesia\n" +
                "Loại Bánh quy ngọt (bánh rắc đường, dừa sấy và nho khô)n" +
                "Năng lượng 508 kcal/100g\n" +
                "Sử dụng: dùng chế biến món ăn\n" +
                "Thành phần Bột lúa mì, đường, bơ (18.67%), dầu thực vật,glucose syrup, trứng, dừa sấy, nho kho, bột sữa \n"+
                "Bảo quản Để nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp"));
        sanPhams.add(new SanPham(10, "Kẹo mút", R.drawable.keocake,80000,"Xuất xứ: Công Ty TNHH Thực Phẩm Kim Hùng\n" +
                "Đơn vị tính: cây\n" +
                "Sử dụng: Ăn trực tiếp\n" +
                "Bảo quản: Bảo quản nơi khô ráo, thoáng mát, sạch sẽ, tránh ánh nắng trực tiếp"));
    }
}