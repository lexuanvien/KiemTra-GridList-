package com.example.kiemtra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<LS> lsArrayList;
    ListView listView;
    List<LS> arrayList= new ArrayList<LS>();
    GridAdapter gridAdapter;
    int idd=-1;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsArrayList= new ArrayList<LS>();
        lsArrayList.add(new LS("VinMart", "Chuỗi siêu thị uy tín, sản phẩm đa dạng",R.drawable.vinmart));
        lsArrayList.add(new LS("Mejii", "Nhãn hiệu bán chạy số 1 tại Nhật Bản",R.drawable.meji));
        lsArrayList.add(new LS("Bác Tôm", "Thực phẩm sạch, đặc sản vùng miền",R.drawable.bactom));
        lsArrayList.add(new LS("F5 Fruit", "Nhà bán lẻ trái cây nhập khẩu uy tín",R.drawable.f5));
        lsArrayList.add(new LS("Nông sản Dũng Hà", "Nông sản sạch cho mọi nhà",R.drawable.dungha));
        lsArrayList.add(new LS("Eat Food", "Quán ăn ngon, rẻ",R.drawable.eatfoof));
        lsArrayList.add(new LS("Healthy Food", "Thực phẩm sạch, ăn uông lành mạnh",R.drawable.healthy));
        lsArrayList.add(new LS("Trader Joe's", "Nhà hàng sang trọng",R.drawable.trader));


        gridView = (GridView) findViewById(R.id.gridview);

        gridAdapter = new GridAdapter(this,R.layout.single_item,lsArrayList);
        gridView.setAdapter(gridAdapter);
        registerForContextMenu(gridView);
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                idd=position;
                return false;
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.xoa){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);
            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Delete",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // get user input and set it to result
                                    // edit text
                                    lsArrayList.remove(idd);
                                    idd=-1;
                                    gridAdapter.notifyDataSetChanged();
                                    Toast.makeText(MainActivity.this,"Delete success",Toast.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
        else{
            return false;
        }
        return true;
    }
}