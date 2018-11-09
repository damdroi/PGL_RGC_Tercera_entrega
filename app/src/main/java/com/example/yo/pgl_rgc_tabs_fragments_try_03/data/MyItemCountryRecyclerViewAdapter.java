package com.example.yo.pgl_rgc_tabs_fragments_try_03.data;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yo.pgl_rgc_tabs_fragments_try_03.R;
import com.example.yo.pgl_rgc_tabs_fragments_try_03.deal.DealContract;

public class MyItemCountryRecyclerViewAdapter extends RecyclerView.Adapter<MyItemCountryRecyclerViewAdapter.ViewHolder> {

    Cursor cursor;
    Context contexto;

    public MyItemCountryRecyclerViewAdapter(Context contexto) {
        this.contexto = contexto;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_itemcountry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.mId.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DealContract._ID))));
        holder.mDescription.setText(cursor.getString(cursor.getColumnIndex(DealContract.DESCRIPTION)));
        holder.mView.setTag(String.valueOf(position));
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cursor.moveToPosition(Integer.parseInt((String) view.getTag()));
                Intent intent = new Intent(contexto, EditCountryActivity.class);
                intent.putExtra("id", Integer.parseInt(holder.mId.getText().toString()));
                intent.putExtra("description", holder.mDescription.getText().toString());
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mId;
        public final TextView mDescription;
        public final Button mButton;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mId = view.findViewById(R.id.textViewID);
            mDescription = view.findViewById(R.id.textViewDescription);
            mButton = view.findViewById(R.id.buttonItem);
        }
    }
}
