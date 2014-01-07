package com.nightmare.Pew;

//~--- non-JDK imports --------------------------------------------------------

import android.os.Bundle;
import android.view.WindowManager.LayoutParams;

import org.newdawn.slick.SlickActivity;

import com.nightmare.Pew.Main;

public class AndroidLauncher extends SlickActivity {

    /** Called when the activity is first created. */
@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
        start(new Main(), 480, 800);
    }
}



//~ Formatted by Jindent --- http://www.jindent.com
