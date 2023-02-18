package com.example.bottom_navigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.adapter.MessgeAdapter;
import com.example.bottom_navigation.model.Message;

import java.util.ArrayList;
import java.util.List;

public class FragmentNotification extends Fragment {
    MessgeAdapter messgeAdapter;
    RecyclerView recyclerView;

    List<Message>list;

    public FragmentNotification() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noti, container,false);
        list = new ArrayList<>();
        list.add(new Message(R.drawable.img, "Hung","Hung, Ngu thoi!!", "23:00"));
        list.add(new Message(R.drawable.img_1, "Hung1","Hung, Day thoi!!","7:00"));
        list.add(new Message(R.drawable.img_2, "Hung2","Hung, Di hoc thoi!!","8:00"));
        list.add(new Message(R.drawable.img_3, "Hung3","Hung, Di an thoi!!","12:00"));
        list.add(new Message(R.drawable.img_4, "Hung4","Hung, Di choi thoi!!","16:00"));


        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        messgeAdapter = new MessgeAdapter(view.getContext(), list);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messgeAdapter);
        return view;

    }
}
