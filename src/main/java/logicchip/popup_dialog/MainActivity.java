package logicchip.popup_dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CoordinatorLayout coordinatorLayoutMain;
    FloatingActionButton fab;
    View view;
    LayoutInflater inflater;
    CheckBox checkBox1,checkBox2,checkBox2v,checkBox2n,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7;
    Button buttonDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coordinatorLayoutMain=(CoordinatorLayout)findViewById(R.id.coordinatorLayoutMain);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        buttonDialog=(Button)findViewById(R.id.buttonDialog);
        fab.setOnClickListener(this);
        buttonDialog.setOnClickListener(this);

        //inflater for the dialogbox
        inflater = this.getLayoutInflater();
        view=inflater.inflate(R.layout.dialog, null);
        //check box for alertdialogbox START
        checkBox1=(CheckBox)view.findViewById(R.id.checkbox_1);
        checkBox2=(CheckBox)view.findViewById(R.id.checkbox_2);
        checkBox2v=(CheckBox)view.findViewById(R.id.checkbox_2v);
        checkBox2n=(CheckBox)view.findViewById(R.id.checkbox_2n);
        checkBox3=(CheckBox)view.findViewById(R.id.checkbox_3);
        checkBox4=(CheckBox)view.findViewById(R.id.checkbox_4);
        checkBox5=(CheckBox)view.findViewById(R.id.checkbox_5);
        checkBox6=(CheckBox)view.findViewById(R.id.checkbox_6);
        checkBox7=(CheckBox)view.findViewById(R.id.checkbox_7);
        //check box for alertdialogbox  END

    }

    // for viewng snack bar messages
    public void SnackMessage(String message){
        Snackbar.make(coordinatorLayoutMain,message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    //handling clicks
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:SnackMessage("fab click");break;
            case R.id.buttonDialog:onCreateDialog();break;
        }
    }


    // method for dialogbox view
    public void onCreateDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // do something here
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do something here
                    }
                }).setNeutralButton(R.string.report,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // do something here
            }
        });

        builder.create().show();
    }


    //handling clicks from inside dialog box
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_1:
                if (checked){
                    SnackMessage("event management checked");
                } else{
                    SnackMessage("event management unchecked");
                }
                break;
            case R.id.checkbox_2:
                if (checked){
                    SnackMessage("catering checked");
                    checkBox2v.setVisibility(View.VISIBLE);
                    checkBox2n.setVisibility(View.VISIBLE);
                }else{
                    SnackMessage("catering unchecked");
                    checkBox2v.setVisibility(View.GONE);
                    checkBox2n.setVisibility(View.GONE);
                }break;
            case R.id.checkbox_2n:
                if (checked){
                    SnackMessage("non-veg checked");
                }else{
                    SnackMessage("non-veg unchecked");
                }
                break;
            case R.id.checkbox_2v:
                if (checked){
                    SnackMessage("veg checked");
                }else{
                    SnackMessage("veg unchecked");
                }
                break;

            case R.id.checkbox_3:
                if (checked){
                    SnackMessage("video checked");
                }else{
                    SnackMessage("video unchecked");
                }
                break;
            case R.id.checkbox_4:
                if (checked){
                    SnackMessage("photography checked");
                }else{
                    SnackMessage("photography unchecked");
                }
                break;
            case R.id.checkbox_5:
                if (checked){
                    SnackMessage("travel checked");
                } else{
                    SnackMessage("travel unchecked");
                }
                break;
            case R.id.checkbox_6:
                if (checked){
                    SnackMessage("decoration checked");
                } else{
                    SnackMessage("decoration unchecked");
                }
                break;
            case R.id.checkbox_7:
                if (checked){
                    SnackMessage("light and sound checked");
                } else{
                    SnackMessage("light and sound unchecked");
                }
                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
