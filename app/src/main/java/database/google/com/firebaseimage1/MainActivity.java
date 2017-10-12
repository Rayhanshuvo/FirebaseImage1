package database.google.com.firebaseimage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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
                android.R.layout.test_list_item,ViewHolder.class,
                databaseReference.child("MBlog")) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, firstclass model, int position) {

viewHolder.txtView.setText( model.getDesc() +"\n"+ model.getTimestamp()+"\n"+ model.getTitle() );
            }
        };

recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView txtView;
        View view;
        public ViewHolder(View itemView){

            super(itemView);
            txtView=(TextView)itemView.findViewById(android.R.id.text1);
            view=itemView;
        }
    }
}
