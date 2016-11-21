package fca.mx.rhapp;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by darkgeat on 6/8/16.
 */
public class SimpleCustomDialog extends Dialog {

    private Button okButton, cancelButton;

    public SimpleCustomDialog(final Context context, @Nullable String Title, String message, final okListener listener) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        setContentView(R.layout.dialog_simple);

        TextView titleLabel = (TextView) findViewById(R.id.textView7);
        TextView messageLabel = (TextView) findViewById(R.id.messageDialog);

        if (Title != null && Title.length() > 0) {
            titleLabel.setText(Title);
        }else {
            titleLabel.setVisibility(View.GONE);
        }
        messageLabel.setText(message);
        okButton = (Button) findViewById(R.id.okDialog);
        cancelButton = (Button) findViewById(R.id.cancelDialog);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnOkSelected();
                dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnCancelSelected();
                dismiss();
            }
        });
    }

    public interface okListener{
        void OnOkSelected();
        void OnCancelSelected();
    }

    public void setOkButtonText(String textButton){
        okButton.setText(textButton);
    }

    public void hideCancelButton(){
        cancelButton.setVisibility(View.GONE);
    }

    public void setYesNoButtons(){
        okButton.setText("Si");
        cancelButton.setText("No");
    }
}
