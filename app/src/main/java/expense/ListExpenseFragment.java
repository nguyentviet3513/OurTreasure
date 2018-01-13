package expense;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mannermakethman.vkd.ourtreasure.R;

import java.util.ArrayList;

import base.FragmentBase;
import database.ExpenseTableDAO;
import database.ExpenseTableDTO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ListExpenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListExpenseFragment extends FragmentBase {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    View rootView;

    public ListExpenseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListExpenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListExpenseFragment newInstance(String param1, String param2) {
        return new ListExpenseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list_expense, container, false);
        ListView listViewExpense = (ListView) rootView.findViewById(R.id.expense_listview);
        ExpenseTableDAO expenseTableDAO = new ExpenseTableDAO();
        ArrayList<ExpenseTableDTO> listExpense = expenseTableDAO.getExpenseListView(applicationContext);
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(applicationContext, listExpense);
        listViewExpense.setAdapter(expenseAdapter);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
