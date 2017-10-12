package database.google.com.firebaseimage1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<firstclass,ViewHolder> firebaseRecyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView) findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.keepSynced(true);


        /*for(int i=0;i<20;i++){

           firstclass fst= new firstclass("My Boxer","go",null);

            databaseReference.child(databaseReference.push().getKey()).setValue(fst);
        }*/

        firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<firstclass, ViewHolder>(firstclass.class,
                R.layout.custom_row,ViewHolder.class,
                databaseReference.child("MBlog")) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, firstclass model, final int position) {

                viewHolder.tv1.setText(model.getDesc());
                viewHolder.tv2.setText(model.getTitle());
                viewHolder.tv3.setText(model.getTimestamp());
                viewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Okay"+position,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView tv1,tv2,tv3;

        View view;
        public ViewHolder(View itemView){

            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.desc);
            tv2=(TextView)itemView.findViewById(R.id.titlee);
            tv3=(TextView)itemView.findViewById(R.id.idddd);


            view=itemView;
        }
    }
}
