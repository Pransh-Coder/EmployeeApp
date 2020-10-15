package com.example.employeeapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeeapp.model.Datum;
import com.example.employeeapp.model.QuestionOption;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterQuestionsAnswers extends RecyclerView.Adapter<RecycleAdapterQuestionsAnswers.ViewHolder> {

    Context context;
    List<Datum> questionList = new ArrayList<>();
    List<QuestionOption>questionOptionsList = new ArrayList<>();

    public RecycleAdapterQuestionsAnswers(Context context, List<Datum> questionList, List<QuestionOption> questionOptionsList) {
        this.context = context;
        this.questionList = questionList;
        this.questionOptionsList = questionOptionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ques_ans_list, parent, false);
        return new RecycleAdapterQuestionsAnswers.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.question.setText(questionList.get(position).getQuestionContent());       // for setting questions

        holder.radioButton_1.setEnabled(false);
        holder.radioButton_2.setEnabled(false);
        holder.radioButton_3.setEnabled(false);
        holder.radioButton_4.setEnabled(false);

        holder.checkBoxOption1.setEnabled(false);
        holder.checkBoxOption2.setEnabled(false);
        holder.checkBoxOption3.setEnabled(false);
        holder.checkBoxOption4.setEnabled(false);

        questionOptionsList = questionList.get(position).getQuestionOptions();
        Log.e("QUestionAndOptions",questionList.get(position).getQuestionContent()+"options size: "+questionOptionsList.size());


        int correct_ans_count = 0;
        String optionContent="",it_Selelected="";
        for (int j=0;j<questionOptionsList.size();j++){

            optionContent = questionOptionsList.get(j).getOptionContent();
            it_Selelected = questionOptionsList.get(j).getItSelected();

            if (it_Selelected.equalsIgnoreCase("1")){
                correct_ans_count=correct_ans_count+1;
            }

            Log.e("QUestionAndOptions", ""+j+"   "+optionContent+"  rightAns "+it_Selelected);

            if (j==0){
                //holder.option1.setText(optionContent);
                holder.radioButton_1.setText(optionContent);
                holder.checkBoxOption1.setText(optionContent);
                if (it_Selelected.equalsIgnoreCase("1")){

                    holder.radioButton_1.setChecked(true);
                    holder.checkBoxOption1.setChecked(true);
                   /* holder.radioButton_2.setEnabled(false);
                    holder.radioButton_3.setEnabled(false);
                    holder.radioButton_4.setEnabled(false);*/

                }
                //holder.radioButton_1.setChecked(true);
            }

            if (j==1){
                //holder.option2.setText(optionContent);
                holder.radioButton_2.setText(optionContent);
                holder.checkBoxOption2.setText(optionContent);
                if (it_Selelected.equalsIgnoreCase("1")){

                    holder.radioButton_2.setChecked(true);
                    holder.checkBoxOption2.setChecked(true);
                   /* holder.radioButton_1.setEnabled(false);
                    holder.radioButton_3.setEnabled(false);
                    holder.radioButton_4.setEnabled(false);*/
                }
                //holder.radioButton_2.setChecked(true);
            }

            if (j==2){
                //holder.option3.setText(optionContent);
                holder.radioButton_3.setText(optionContent);
                holder.checkBoxOption3.setText(optionContent);
                if (it_Selelected.equalsIgnoreCase("1")){

                    holder.radioButton_3.setChecked(true);
                    holder.checkBoxOption3.setChecked(true);
                   /* holder.radioButton_1.setEnabled(false);
                    holder.radioButton_2.setEnabled(false);
                    holder.radioButton_4.setEnabled(false);*/
                }
                //holder.radioButton_3.setChecked(true);
            }

            if (j==3){
                //holder.option4.setText(optionContent);
                holder.radioButton_4.setText(optionContent);
                holder.checkBoxOption4.setText(optionContent);
                if (it_Selelected.equalsIgnoreCase("1")){

                    holder.radioButton_4.setChecked(true);
                    holder.checkBoxOption2.setChecked(true);
                    /*holder.radioButton_1.setEnabled(false);
                    holder.radioButton_2.setEnabled(false);
                    holder.radioButton_3.setEnabled(false);*/
                }
                //holder.radioButton_4.setChecked(true);
            }

        }
        Log.e("correctAns", ""+correct_ans_count);

        if (correct_ans_count>1){

            holder.checkBoxConstraint.setVisibility(View.VISIBLE);
            holder.radioConstraint.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView question,option1,option2,option3,option4;
        RadioGroup radioGroup;
        RadioButton radioButton_1,radioButton_2,radioButton_3,radioButton_4;

        CheckBox checkBoxOption1,checkBoxOption2,checkBoxOption3,checkBoxOption4;

        ConstraintLayout checkBoxConstraint,radioConstraint;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            question = itemView.findViewById(R.id.question);
           /* option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);*/

            radioGroup = itemView.findViewById(R.id.radioOptions);
            radioButton_1 = itemView.findViewById(R.id.radioOption1);
            radioButton_2 = itemView.findViewById(R.id.radioOption2);
            radioButton_3 = itemView.findViewById(R.id.radioOption3);
            radioButton_4 = itemView.findViewById(R.id.radioOption4);
            radioConstraint = itemView.findViewById(R.id.radioConstraint);


            checkBoxOption1 = itemView.findViewById(R.id.checkBoxOption1);
            checkBoxOption2 = itemView.findViewById(R.id.checkBoxOption2);
            checkBoxOption3 = itemView.findViewById(R.id.checkBoxOption3);
            checkBoxOption4 = itemView.findViewById(R.id.checkBoxOption4);
            checkBoxConstraint = itemView.findViewById(R.id.checkBoxConstraint);
        }
    }
}
