//package com.em.tigetspike.utils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//
//class MyImageLoader extends AsyncTask<String,Void,Bitmap>{
//
//	public MyImageLoader(){
//		
//	}
//	@Override
//	protected void onPreExecute() {
//		// TODO Auto-generated method stub
//		super.onPreExecute();
//	}
//
//	@Override
//	protected void onPostExecute(Bitmap result) {
//		// TODO Auto-generated method stub
//		super.onPostExecute(result);
//	}
//
//	@Override
//	protected void onProgressUpdate(Void... values) {
//		// TODO Auto-generated method stub
//		super.onProgressUpdate(values);
//	}
//
//	@Override
//	protected Bitmap doInBackground(String... str) {
//		// TODO Auto-generated method stub
//		Bitmap img = getBitmapFromURL(str[0]);
//		
//		return img;
//	}
//	private Bitmap getBitmapFromURL(String imageUrl){
//		
//		try {
//			URL url = new URL(imageUrl);
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setDoInput(true);
//			connection.connect();
//			InputStream input = connection.getInputStream();
//			Bitmap myBitmap = BitmapFactory.decodeStream(input);
//			return myBitmap;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//}