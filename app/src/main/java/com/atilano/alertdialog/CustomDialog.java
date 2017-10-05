package com.atilano.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jeanina on 5 Oct 2017.
 */

public class CustomDialog extends DialogFragment {
    LayoutInflater inflater;
    View v;
    EditText etUsername, etPassword;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.login_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(v);
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        etUsername = (EditText) v.findViewById(R.id.etUsername);
                        etPassword = (EditText) v.findViewById(R.id.etPassword);
                      String user = etUsername.getText().toString();
                      String pw = etPassword.getText().toString();
                      String msg = "Username is " + user + "" + " Password is " + pw;


              Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
          }
        });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        builder.setTitle("LOGIN");

        Dialog dialog = builder.create();
        return dialog;
    }


    
}
