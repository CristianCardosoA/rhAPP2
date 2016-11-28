package fca.mx.rhapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Simple activity adapter
 *
 * This adapter is used to display an basic information of an activity including Title, Hour, Category and color.
 *
 * @author Cristian Cardoso A.
 * @author iTexico.
 * @version 2016.01
 * @since 1.0
 */

public class ActivitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    /**
     * Main list of object that display all infomation.
     */
    private List<Perfil> mDataset;

    /**
     * Context.
     */
    private Context mContext;

    /**
     * View type blank activity
     */
    private final int VIEW_TYPE_BLANK = 0;

    /**
     * View type normal activity..
     */
    private final int VIEW_TYPE_NORMAL = 1;

    /**
     * This internal class provide the normal view activity.
     */
     private static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Project title
         */
        TextView txvProject;

        /**
         * Category text.
         */
        TextView txvCategory;

        /**
         * Hours of activity.
         */
        TextView txvHours;

        /**
         * Date number.
         */
        TextView txvDayNumber;

        /**
         * Day expressed on text. Ex. Mon, Tue, Sun.
         */
        TextView txvDayText;

        /**
         * Total hours if the object is general information.
         */
        TextView txvTotalHours;

        /**
         * Left container - information about day, day number, hours.
         */
        RelativeLayout generalsLayout;

        /**
         * Right container . information about title, project, category.
         */
        RelativeLayout activity_container;

        /**
         * Main container.
         */
        final View uniqueView;
        final ImageView img;


        ViewHolder(View v) {
            super(v);
            uniqueView = v;
            txvProject = (TextView) v.findViewById(R.id.txv_nombre_puesto);
            txvDayNumber = (TextView) v.findViewById(R.id.txv_fecha);
            img = (ImageView) v.findViewById(R.id.img);

        }
    }

    /**
     * Class constructor.
     *
     * @param  myDataset  list of activities including blank types.
     * @param  context context
     * @return  the image at the specified URL
     * @see     Object
     */
    public ActivitiesAdapter(List<Perfil> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Log.e("view type", "" + viewType);
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_perfil, viewGroup,false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        //pos its the current position of adapter.

        // If holder is instance of normal type view activities.
        if (holder instanceof ViewHolder) {
            final Perfil perfil = mDataset.get(position);
            ((ViewHolder) holder).txvProject.setText(perfil.getTitulo());
            ((ViewHolder) holder).txvDayNumber.setText("Última fecha de actualización\n" + perfil.getFecha());
            Picasso.with(mContext).load("https://unsplash.it/200/300?image=" + position).into(((ViewHolder) holder).img);
            Picasso.with(mContext).invalidate("https://unsplash.it/200/300/?random");
            ((ViewHolder) holder).uniqueView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,DetailActivity.class);
                    intent.putExtra("perfil",perfil);
                    mContext.startActivity(intent);
                }
            });

        }
   }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void swap(List<Perfil> mDataset){
        this.mDataset.clear();
        this.mDataset.addAll(mDataset);
        this.notifyDataSetChanged();
    }
}

