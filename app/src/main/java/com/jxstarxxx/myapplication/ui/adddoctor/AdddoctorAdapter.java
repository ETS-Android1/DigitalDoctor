package com.jxstarxxx.myapplication.ui.adddoctor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jxstarxxx.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdddoctorAdapter extends RecyclerView.Adapter<AdddoctorAdapter.SearchViewHolder> {
    private final Context context;


    List<addDoctorModel> addDoctorModels;

    public class SearchViewHolder extends RecyclerView.ViewHolder {


        TextView full_name, clinic_name, department_name;
        ImageView profile_pic;
        Button add_button;

        public SearchViewHolder(View itemView) {
            super(itemView);

            this.full_name = (TextView) itemView.findViewById(R.id.add_doctor_fullname);
            this.clinic_name = (TextView) itemView.findViewById(R.id.add_doctor_clinic);
            this.department_name = (TextView) itemView.findViewById(R.id.add_doctor_depart);
            this.profile_pic = (ImageView) itemView.findViewById(R.id.add_doctor_image);
            this.add_button = (Button) itemView.findViewById(R.id.add_doctor_button);
        }
    }


    public AdddoctorAdapter(Context context, List<addDoctorModel> addDoctorModels) {
        this.context = context;
        this.addDoctorModels = addDoctorModels;
    }

    @NonNull
    @Override
    public AdddoctorAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_doctor_cardview, parent, false);
        return new AdddoctorAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdddoctorAdapter.SearchViewHolder holder, int position) {

        addDoctorModel addDoctor = addDoctorModels.get(position);

        holder.full_name.setText(addDoctor.getFull_name());
        holder.clinic_name.setText(addDoctor.getClinic_name());
        holder.department_name.setText(addDoctor.getDepartment_name());
        if(!addDoctor.getImg_url().isEmpty()){
            Picasso.get().load(addDoctor.getImg_url()).into(holder.profile_pic);
        }

        holder.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Add doctor", "onClick: ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return addDoctorModels.size();
    }
}