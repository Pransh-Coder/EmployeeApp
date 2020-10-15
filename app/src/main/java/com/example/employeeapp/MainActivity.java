package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.employeeapp.model.Datum;
import com.example.employeeapp.model.Example;
import com.example.employeeapp.model.QuestionOption;
import com.example.employeeapp.networkingStructure.ApiInterface;
import com.example.employeeapp.networkingStructure.RetrofitClient;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Datum> questionList = new ArrayList<>();
    List<QuestionOption>questionOptionsList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecycleAdapterQuestionsAnswers recycleAdapterQuestionsAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getLocations();
    }

    public void getLocations(){

        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage(Html.fromHtml("<font color='#be0002'>Please Wait!</font>"));
        dialog.setTitle(Html.fromHtml("<font color='#be0002'>Loading Questions...</font>"));
        dialog.show();

        JsonObject jsonBody = new JsonObject();
        JsonObject jsonObject = new JsonObject();
        try {
            jsonBody.addProperty("result_id","113");
            jsonObject.add("emp",jsonBody);

        } catch (JsonIOException e) {
            e.printStackTrace();
        }

        Log.e("JSONBODY",""+jsonObject );

        apiInterface.getAllOptions(jsonObject).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                dialog.dismiss();

                questionList = response.body().getEmp().getData();

                Log.e("questionListSize", ""+ questionList.size());

                String ques="";
                for (int i = 0; i <questionList.size(); i++) {

                    ques = questionList.get(i).getQuestionContent();

                    Log.e("quesValue",ques);

                    questionOptionsList = response.body().getEmp().getData().get(i).getQuestionOptions();

                    for (int j=0;j<questionOptionsList.size();j++){

                        String it_Selelected = questionOptionsList.get(j).getItSelected();
                        String optionContent = questionOptionsList.get(j).getOptionContent();

                        int status  = questionOptionsList.get(j).getStatus();

                        Log.e("it_Selelected",it_Selelected);

                        Log.e("optionContent",optionContent);

                        //Log.e("status",""+status);
                    }
                }
                Log.e("quesValue",ques);
                Log.e("questionOptionsListSize", ""+questionOptionsList.size());
                recycleAdapterQuestionsAnswers = new RecycleAdapterQuestionsAnswers(MainActivity.this,questionList,questionOptionsList);
                recyclerView.setAdapter(recycleAdapterQuestionsAnswers);

                /*for (int j=0;j<questionOptionsList.size();j++){

                    String it_Selelected = questionOptionsList.get(j).getItSelected();
                    String optionContent = questionOptionsList.get(j).getOptionContent();

                    int status  = questionOptionsList.get(j).getStatus();

                    Log.e("it_Selelected",it_Selelected);

                    Log.e("optionContent",optionContent);

                    //Log.e("status",""+status);
                }*/

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Failure In Getting Options!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}