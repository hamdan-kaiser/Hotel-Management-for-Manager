package com.example.virus.hotelmanagementsystem.BookingAndRatingDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.virus.hotelmanagementsystem.DatabaseModel.AddGuestDetailModel;
import com.example.virus.hotelmanagementsystem.R;

import java.util.ArrayList;

public class ViewUserIntelAdapter extends ArrayAdapter<AddGuestDetailModel> {

    public ArrayList<AddGuestDetailModel> guestDetails;
    private Context context;
    private ViewHolder viewHolder;

    public ViewUserIntelAdapter(@NonNull Context ctx, ArrayList<AddGuestDetailModel> guest_details) {
        super(ctx, R.layout.single_booking_adapter, guest_details);

        context = ctx;
        guestDetails = guest_details;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {

        if (guestDetails.size() > 0) {
            return guestDetails.size();
        } else {
            return 1;
        }

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View view, @NonNull ViewGroup parent) {

        if (view == null) {
            //view = LayoutInflater.from(getContext()).inflate(R.layout.single_booking_adapter,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.amountPay = view.findViewById(R.id.amountToPay);
            viewHolder.checkIn = view.findViewById(R.id.checkIn);
            viewHolder.checkOut = view.findViewById(R.id.checkOut);
            viewHolder.contact = view.findViewById(R.id.contact);
            viewHolder.discount = view.findViewById(R.id.discount);
            viewHolder.guest_name = view.findViewById(R.id.guest_name);
            viewHolder.payStatus = view.findViewById(R.id.paidyn);
            viewHolder.rating = view.findViewById(R.id.rating);
            viewHolder.review = view.findViewById(R.id.review);
            viewHolder.roomNo = view.findViewById(R.id.room_No);
            viewHolder.roomType = view.findViewById(R.id.room_Type);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        return super.getView(position, view, parent);
    }


    public class ViewHolder {
        TextView amountPay, checkIn, checkOut,
                contact, discount, guest_name, payStatus,
                rating, review, roomNo, roomType;
    }


}
