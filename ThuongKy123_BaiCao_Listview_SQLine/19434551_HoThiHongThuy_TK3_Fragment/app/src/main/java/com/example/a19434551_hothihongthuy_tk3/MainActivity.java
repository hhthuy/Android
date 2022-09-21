package com.example.a19434551_hothihongthuy_tk3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnFragmentManager,OnBackClickListener  {
    private List<SanPham> sanPhamList;
    private GridView gridView;
    private SanPhamAdapter sanPhamAdapter;
    private  Configuration config;
    private  FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private  FrameLayout frameLayoutOne;
    private  FrameLayout frameLayoutTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.config = getResources().getConfiguration();
        this.frameLayoutOne =findViewById(R.id.fragment1);
         this.frameLayoutTwo =findViewById(R.id.fragment2);
        this.fragmentManager=getSupportFragmentManager();
        this.fragmentTransaction=fragmentManager.beginTransaction();
        if ( this.config.orientation == Configuration.ORIENTATION_LANDSCAPE) {


            frameLayoutTwo.setVisibility(View.VISIBLE);
            frameLayoutOne.setVisibility(View.VISIBLE);

            Fragment1 fragment1 = new Fragment1();
            fragment1 = Fragment1.getInstance();
            Fragment2 fragment2 = new Fragment2();
            fragment2 = Fragment2.getInstance();

            fragmentManager.beginTransaction().replace(R.id.fragment1, fragment1, "fragmentone").commit();
            fragmentManager.beginTransaction().replace(R.id.fragment2, fragment2, "fragmenttwo").commit();
            fragmentTransaction.commit();

        }
        if ( this.config.orientation == Configuration.ORIENTATION_PORTRAIT) {

            frameLayoutTwo.setVisibility(View.GONE);
            Fragment1 fragment1 = new Fragment1();
            fragment1 = Fragment1.getInstance();
            fragmentManager.beginTransaction().replace(R.id.fragment1, fragment1, "fragmentone").commit();


        }
    }


    @Override
    public void onDataSelected(String tenSp, String motaSp, double giaSp, int image) {

        if(this.config.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Fragment2 fragment2 = new Fragment2();
            Bundle bundl = new Bundle();
            bundl.putString("name", "nghia");
            bundl.putString("tenSp",tenSp);
            bundl.putString("motaSp",motaSp);
            bundl.putDouble("giaSp",giaSp);
            bundl.putInt("image",image);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment2 = Fragment2.getInstance();
            fragment2.setArguments(bundl);

            fragmentManager.beginTransaction().replace(R.id.fragment2, fragment2, "fragmenttwo").commit();
            fragmentTransaction.commit();
        }
        if(this.config.orientation==Configuration.ORIENTATION_PORTRAIT){
            Fragment2 fragment2 = new Fragment2();
            Bundle bundl = new Bundle();
            bundl.putString("name", "nghia");
            bundl.putString("tenSp",tenSp);
            bundl.putString("motaSp",motaSp);
            bundl.putDouble("giaSp",giaSp);
            bundl.putInt("image",image);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment2 = Fragment2.getInstance();
            fragment2.setArguments(bundl);
            frameLayoutTwo.setVisibility(View.VISIBLE);
            frameLayoutOne.setVisibility(View.GONE);
            fragmentManager.beginTransaction().replace(R.id.fragment2, fragment2, "fragmenttwo").commit();
            fragmentTransaction.commit();
        }


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
        sanPhams.add(new SanPham("Laptop Apple","Thương hiệu: Apple\n" +
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
        sanPhams.add(new SanPham("Lap Lenovo","Thương hiệu: Lenovo\n" +
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
        sanPhams.add(new SanPham("Laptop Microsoft","Thương hiệu: Microsoft\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Bạc\n" +
                "12.3 inch, 2736 x 1824 Pixels, IPS Glossy, 60 Hz, 395 nits\n" +
                "Intel, Core i5, 1035G4\n" +
                "8 GB, LPDDR4X, 3733 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",24499000,R.drawable.laptopmicrosoft));
        sanPhams.add(new SanPham("Laptop Gigabyte","Thương hiệu: Gigabyte\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Den\n" +
                "13.3 inch, 1920 x 1080 Pixels, 400 nits, Anti-glare LED-backlit\n" +
                "Intel, Core i5, 1135G7\n" +
                "8 GB, LPDDR4X, 4266 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",25999000,R.drawable.laptopgigabyte));
        sanPhams.add(new SanPham("Laptop Fujitsu","Thương hiệu: Fujitsu\n" +
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

        sanPhams.add(new SanPham("Laptop Masstel","Thương hiệu: Masstel\n" +
                "Sản xuất tại: Trung Quốc\n" +
                "Màu sắc: Xám\n" +
                "14.0 inch Chính:, 1366 x 768 Pixels, IPS, 60 Hz, 250 nits, LCD Chính:\n" +
                "Intel, Celeron, N4120\n" +
                "4 GB, DDR4, 2400 MHz\n" +
                "Thời gian bảo hành (tháng): 12\n",79990000,R.drawable.laptopmasstel));
        return sanPhams;
    }


    @Override
    public void onBackClick() {

        fragmentManager.beginTransaction().replace( R.id.fragment1, new Fragment1() ).addToBackStack( "fragmentone" ).commit();
        frameLayoutTwo.setVisibility(View.GONE);
        frameLayoutOne.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {

        fragmentManager.beginTransaction().replace( R.id.fragment1, new Fragment1() ).addToBackStack( "fragmentone" ).commit();
        frameLayoutTwo.setVisibility(View.GONE);
        frameLayoutOne.setVisibility(View.VISIBLE);
    }
}