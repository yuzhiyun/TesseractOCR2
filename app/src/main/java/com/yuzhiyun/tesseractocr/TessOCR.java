package com.yuzhiyun.tesseractocr;

import java.io.File;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.googlecode.tesseract.android.TessBaseAPI;

public class TessOCR {
	private TessBaseAPI mTess;
	
	public TessOCR() {
		// TODO Auto-generated constructor stub
		mTess = new TessBaseAPI();
		String datapath = Environment.getExternalStorageDirectory() + "/";

		String language = "eng";
		File dir = new File(datapath + "tessdata/");
		Log.e("datapath",datapath);
		if (!dir.exists()) 
			dir.mkdirs();
		mTess.init(datapath, language);
	}
	
	public String getOCRResult(Bitmap bitmap) {
		
		mTess.setImage(bitmap);
		String result = mTess.getUTF8Text();

		return result;
    }
	
	public void onDestroy() {
		if (mTess != null)
			mTess.end();
	}
	
}
