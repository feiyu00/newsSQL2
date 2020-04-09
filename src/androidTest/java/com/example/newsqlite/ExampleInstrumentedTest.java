package com.example.newsqlite;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testCreate(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper =new DatabaseHelper(appContext);
        helper.getWritableDatabase();
    }
    @Test
    public void testInsert(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(appContext);
        dao.insert();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.newsqlite", appContext.getPackageName());
    }
}
