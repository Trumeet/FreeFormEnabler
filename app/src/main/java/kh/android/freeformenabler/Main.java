package kh.android.freeformenabler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import eu.chainfire.libsuperuser.Shell;

/**
 * Created by liangyuteng0927 on 16-12-15.
 * Coolapk:http://coolapk.com/u/543424
 */

public class Main extends Activity {
    /*
     * 执行这几个命令：
     * settings put global enable_freeform_support 1
     * reboot
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.text)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Shell.SU.run("settings put global enable_freeform_support 1");
                        Shell.SU.run("reboot");
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                finish();
            }
        }).setNegativeButton("CODE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/liangyuteng0927/FreeFormEnabler")));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).show();
    }
}
