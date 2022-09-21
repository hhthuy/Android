package com.example.a19434551_hothihongthuy_tk3;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements OnFragmentManager{
    GridView gridView;
    SanPhamAdapter sanPhamAdapter;
    List<SanPham> listItem = new ArrayList<>();
    OnFragmentManager listener;

    String tenSp;
    String moTaSp;
    double giaSp;
    int image;

    public static Fragment1 getInstance(){
        return new Fragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, container, false);
        gridView= v.findViewById(R.id.gridViewFrag1);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        listItem=initListSanPham();
        sanPhamAdapter=new SanPhamAdapter(getContext(),listItem);
        gridView.setAdapter(sanPhamAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sanPham= listItem.get(i);
                tenSp=sanPham.getNameCake();
                moTaSp=sanPham.getDescriptionCake();
                giaSp=sanPham.getPriceCake();
                image=sanPham.getImageCake();
                onDataSelected(tenSp,moTaSp,giaSp,image);

            }
        });
        return v;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentManager ){
            listener = (OnFragmentManager) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }

    @Override
    public void onDataSelected(String tenSp, String motaSp, double giaSp, int image) {
        listener.onDataSelected(tenSp,motaSp,giaSp,image);
    }


    public List<SanPham> initListSanPham(){
        List<SanPham> sanPhams=new ArrayList<>();
        sanPhams=new ArrayList<>();
        sanPhams.add(new SanPham("Laptop HP","\"Thương hiệu : HP\n" +
                "Xuất xứ: Trung Quốc\n" +
                "Màu sắc: Xam\n" +
                "14.0 inch, SVA, 60 Hz, 250 nits, Anti-glare LED-backlit \n" +
                "Intel, Core i3, 1005G1\n" +
                "8 GB, DDR4, 3200 MHz\n" +
                "SSD 512 GB\n" +
                "Intel UHD Graphics 600\n" +
                "Thời gian bảo hành (tháng): 12",12999000,R.drawable.laptophp));
        sanPhams.add(new SanPham("Laptop Apple (MacBook)","Thương hiệu: Apple\n" +
                "Sản xuất tại: Việt Nam\n" +
                "Màu sắc: Vang\n" +
                "14.2 inch, 3024 x 1964 Pixels\n" +
                "Apple, M1 Pro\n" +
                "SSD 512 GB\n" +
                "Thời gian bảo hành (tháng): 12\n",61490000,R.drawable.laptopapple));
        sanPhams.add(new SanPham("Laptop Asus","Thương hiệu: Asus\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Đen\n" +
                "15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, Anti-glare LED-backlit\n" +
                "Intel, Core i5, 10300H\n" +
                "8 GB, DDR4, 2933 MHz\n" +
                "SSD 512 GB\n" +
                "Thời gian bảo hành (tháng): 12\n",19799000,R.drawable.laptopasus));
        sanPhams.add(new SanPham("Laptop Acer","Thương hiệu: Acer\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Đen\n" +
                "15.6 inch, 1920 x 1080 Pixels, IPS, 144 Hz, Acer ComfyView Anti-glare LED-backlit\n" +
                "AMD, Ryzen 5, 5500U\n" +
                "8 GB, DDR4, 3200 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",19799000,R.drawable.laptopacer));
        sanPhams.add(new SanPham("Laptop Lenovo","Thương hiệu: Lenovo\n" +
                "Sản xuất tại: Trung Quốc" +
                "Màu sắc: Đen\n" +
                "15.6 inch, 1920 x 1080 Pixels, IPS, 60 Hz, 300 nits, IPS LCD LED Backlit, True Tone\n" +
                "Intel, Core i5, 1135G7\n" +
                "8 GB, DDR4, 3200 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",16800000,R.drawable.laptoplenovo));
        sanPhams.add(new SanPham("Laptop Dell","Thương hiệu: Dell\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Đen\n" +
                "14.2 inch, 3024 x 1964 Pixels\n" +
                "Apple, M1 Pro\n" +
                "SSD 512 GB\n" +
                "Thời gian bảo hành (tháng): 12\n",61490000,R.drawable.laptopdell));
        sanPhams.add(new SanPham(" Lap Microsoft","Thương hiệu Microsoft\n" +
                "Sản xuất tại: Việt Nam\n" +
                "Loại nước: nước giải khát có gas\n" +
                "Hương vị: vị lúa mạch\n" +
                "Thành phần: Nước bão hòa CO2, chiết xuất lúa mạch, chất xơ hòa tan, hỗn hợp hương lúa mạch tổng hợp và giống tự nhiên, chất điều chỉnh độ axit, màu tự nhiên, Sodium Chloride, chất chuống oxi hóa, chất xuất hoa houblon, chất tạo ngọt tổng hợp\n" +
                "Lượng ga: Có ga\n" +
                "Lượng đường: Không đường\n" +
                "Thể tích: 330ml\n" +
                "Số lượng: Lốc 6 lon\n"

                ,29000,R.drawable.laptopmicrosoft));
        sanPhams.add(new SanPham("Lap Gigabyte","Thương hiệu: Gigabyte\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Den\n" +
                "13.3 inch, 1920 x 1080 Pixels, 400 nits, Anti-glare LED-backlit\n" +
                "Intel, Core i5, 1135G7\n" +
                "8 GB, LPDDR4X, 4266 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",25999000,R.drawable.laptopgigabyte));
        sanPhams.add(new SanPham("Lap Fujitsu","Thương hiệu: Fujitsu\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Nâu\n" +
                "14.2 inch, 3024 x 1964 Pixels\n" +
                "Apple, M1 Pro\n" +
                "SSD 512 GB\n" +
                "Thời gian bảo hành (tháng): 12\n",21999000,R.drawable.laptopfujitsu));
        sanPhams.add(new SanPham("Laptop Chuwi","Thương hiệu: Chuwi\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Vàng\n" +
                "13.3 inch, 1920 x 1080 Pixels, IPS, 60 Hz, 300 nits, IPS LCD LED Backlit, True Tone\n" +
                "Intel, Celeron, N4120\n" +
                "S8 GB, LPDDR4\n" +
                "Thời gian bảo hành (tháng): 12\n",8369000,R.drawable.laptopchuwi));
        sanPhams.add(new SanPham("Laptop Avita","Thương hiệu: Avita\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Vàng\n" +
                "14.0 inch, 1920 x 1080 Pixels, IPS, 60 Hz, 220 nits\n" +
                "AMD, Ryzen 5, 4500U\n" +
                "8 GB, LPDDR4X, 3200 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",17999000,R.drawable.laptopavita));

        sanPhams.add(new SanPham("Lap Masstel","Thương hiệu: Masstel\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Xám\n" +
                "14.0 inch Chính:, 1366 x 768 Pixels, IPS, 60 Hz, 250 nits, LCD Chính:\n" +
                "Intel, Celeron, N4120\n" +
                "4 GB, DDR4, 2400 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",79990000,R.drawable.laptopmasstel));
        return sanPhams;
    }


}