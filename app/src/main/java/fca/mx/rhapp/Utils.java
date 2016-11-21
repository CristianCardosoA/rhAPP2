package fca.mx.rhapp;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnectedOrConnecting()){
            return (info.isConnected() && info.isAvailable());
        }else {
            return false;
        }
    }

    public static void hideKeyboard(Activity context){
        View view = context.getCurrentFocus();
        if (view != null){
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    public static void showSimpleMessage(Context context, @Nullable String tittle, String message){
        SimpleCustomDialog dialog = new SimpleCustomDialog(context, tittle, message, new SimpleCustomDialog.okListener() {
            @Override
            public void OnOkSelected() {

            }

            @Override
            public void OnCancelSelected() {

            }
        });
        dialog.hideCancelButton();
        dialog.show();
    }
}
