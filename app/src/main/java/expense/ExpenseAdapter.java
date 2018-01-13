package expense;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mannermakethman.vkd.ourtreasure.R;

import java.util.ArrayList;

import database.ExpenseTableDTO;

/**
 * Created by nguyentviet3513 on 1/12/2018.
 */

public class ExpenseAdapter extends ArrayAdapter<ExpenseTableDTO> {
    private Context context;
    private ArrayList<ExpenseTableDTO> listExpenseData;


    public ExpenseAdapter(@NonNull Context context, ArrayList<ExpenseTableDTO> listExpenseData) {
        super(context, R.layout.listview_expense_row, listExpenseData);
        this.listExpenseData = listExpenseData;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;
        ExpenseTableDTO expenseItem = getItem(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.listview_expense_row, parent, false);
            viewHolder.expenseNameText = (TextView) convertView.findViewById(R.id.expense_name_text);
            viewHolder.expenseTypeText = (TextView) convertView.findViewById(R.id.expense_type_name_text);
            viewHolder.expensePriceText = (TextView) convertView.findViewById(R.id.expense_price_text);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.expenseNameText.setText(expenseItem.getExpenseName());
        viewHolder.expensePriceText.setText(expenseItem.getExpenseTypeName());
        viewHolder.expenseTypeText.setText(expenseItem.getExpensePrice() + "");

        return result;
    }

    private static class ViewHolder {
        TextView expenseNameText;
        TextView expenseTypeText;
        TextView expensePriceText;
    }
}
