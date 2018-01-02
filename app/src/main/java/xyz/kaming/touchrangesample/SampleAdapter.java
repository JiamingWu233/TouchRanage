package xyz.kaming.touchrangesample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xyz.kaming.touchrange.TouchRange;

/**
 * sample adapter
 * <p>
 * Created by kaming on 2017/01/02.
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleHolder> {

    private static final int DEFAULT_LENGTH = 10;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    SampleAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleHolder(mLayoutInflater.inflate(R.layout.item_sample, parent, false));
    }

    @Override
    public int getItemCount() {
        return DEFAULT_LENGTH;
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, int position) {
        TouchRange.let(holder.text, holder.imageView, holder.button)
                // easy to use, like css padding
                .bounds()//default value is 14dp
//                .bounds(24.0f) //left,top,right,bottom=24dp
//                .bounds(24.0f,30.0f) //left,right=24dp top,bottom=30dp
//                .bounds(24.0f,30.0f,24.0f) //left=24dp,top=30dp,right=24dp,bottom=0dp
//                .bounds(24.0f, 30.0f, 24.0f, 30.0f) //left=24dp,top=30dp,right=24dp,bottom=30dp
                .change();
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "TextView was touched", Toast.LENGTH_SHORT).show();
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "ImageView was touched", Toast.LENGTH_SHORT).show();
            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Button was touched", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class SampleHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView imageView;
        Button button;

        SampleHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_touch);
            imageView = itemView.findViewById(R.id.iv_touch);
            button = itemView.findViewById(R.id.btn_touch);
        }
    }


}
