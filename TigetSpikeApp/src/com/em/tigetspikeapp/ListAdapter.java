package com.em.tigetspikeapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.em.tigetspike.model.Casestudies;
import com.em.tigetspike.model.TigerResult;



public class ListAdapter extends BaseAdapter{

	ImageLoader imgloader;
	private TigerResult list;
	private Context context;
	
	public ListAdapter(Context context,TigerResult list){
		this.context = context;
//		for(int i=0;i<list.size();i++){
//			//list = result.getCasestudies().getName().
//		}
		this.list = list;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.getCasestudies().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.getCasestudies().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	static class ViewHolder{
		TextView tv1;
		ImageView img;
		//TextView tv2;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView == null){
			LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflator.inflate(R.layout.custom_listview, parent,false);
			
			viewHolder = new ViewHolder();
			viewHolder.img = (ImageView) convertView.findViewById(R.id.imageView1);
			viewHolder.tv1 = (TextView) convertView.findViewById(R.id.textView1);
		//	viewHolder.tv2 = (TextView) convertView.findViewById(R.id.google_map_url);
			convertView.setTag(viewHolder);
		}
		else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		//TigerResult caseResult = MyApplication.result;
		//String text = caseResult.getCasestudies().getName();
		String text = list.getCasestudies().get(position).getName();
		viewHolder.tv1.setText(text);
		
		String url = list.getCasestudies().get(position).getIcon();
		
		//String icon = caseResult.getCasestudies().getIcon();
	   
		//String url = caseResult.getCasestudies().getUrl();
		//viewHolder.tv2.setText(url);
		//viewHolder.img = (ImageView) convertView.findViewById(R.id.imageView1);		
		// Get the ImageLoader through your singleton class.
		imgloader = MyApplication.getInstance(context).getImageLoader();
		imgloader.get(url, ImageLoader.getImageListener(viewHolder.img,
		        R.drawable.ic_launcher, R.drawable.ic_launcher));
		
		
		
		return convertView;
	}

}
